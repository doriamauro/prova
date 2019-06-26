package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Data;

import bean.ComposizioneOrdini;
import bean.DatiOrdine;
import bean.DatiRateOrdine;
import bean.IndirizzoOrdine;
import bean.Ordine;
import bean.Prodotto;
import dao.ComposizioneOrdiniDAO;
import dao.DatiRateDAO;
import dao.DatiRateOrdineDAO;
import dao.IndirizzoOrdineDAO;
import dao.OrdineDAO;

@Service
public class CarrelloServiceImpl implements CarrelloService {

	
	private ComposizioneOrdiniDAO daoComp; 
	private OrdineDAO daoOrd;
	private DatiRateOrdineDAO daoRateOrd;
	private IndirizzoOrdineDAO daoIndOrd;
	private DatiRateDAO daoRateDef;
	
	
	@Override
	public void finalizzaAcquisto(DatiOrdine d) {
		
		//inserisce in indirizzoOrdine l'indirizzo
		IndirizzoOrdine indOrd = d.getIndOrd();
		indOrd.setIdIndOrdine(daoIndOrd.contaNumeroIndOrd()+1+"");
		daoIndOrd.insert(indOrd);
		
		
		//Calcolo il costo totale comprensivo di spese di spedizione
		double costo = 0;
		double speseSped = 0;
		for (Prodotto p: d.getProdotti()) {
			costo += p.getPrezzoUni()*p.getDisponibilita();
			speseSped += p.getCostoSped();
		}
		 
		double costoTot = costo;
		
		if (Integer.parseInt(d.getModPag().getIdMod())!=1) {
			if (costo<20){
				costoTot += speseSped;
			} else if (costo>=20 && costo<100) {
				costoTot += 10;
			}
		}
		
		
		//inserisco l'ordine nella tabella ordini
		Ordine ordine = new Ordine(daoOrd.contaNumOrdini()+1+"",
				 				   d.getUsername(),
				 				   new Date(new java.util.Date().getTime()),
				 				   costoTot,
				 				   d.getIndOrd().getIdIndOrdine(),
				 				   d.getModPag().getIdMod());
		daoOrd.insert(ordine);
		
		
		//inserimento nella tabella composizioneOrdini
		for (Prodotto p: d.getProdotti()) {
			ComposizioneOrdini compOrd = new ComposizioneOrdini(p.getDisponibilita(), p.getIdProdotto(), ordine.getCodOrdine());
			daoComp.insert(compOrd);
		}
		
		
		//inserimento nella tabella datiRateOrdini
		if (Integer.parseInt(d.getModPag().getIdMod())==5) {
			DatiRateOrdine datiRatOrd = new DatiRateOrdine(ordine.getCodOrdine(),
														   daoRateDef.selectRate().getTan(),
														   daoRateDef.selectRate().getMaxTaeg(),
														   daoRateDef.selectRate().getnRate());
			daoRateOrd.insert(datiRatOrd);
	}

}
}
