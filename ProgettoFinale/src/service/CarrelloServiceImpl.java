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
		
		IndirizzoOrdine indOrd = new IndirizzoOrdine(d.getIndOrd().getIdIndOrdine(),
				d.getIndOrd().getVia(), d.getIndOrd().getComune(), d.getIndOrd().getCap(),
				d.getIndOrd().getProvincia(), d.getIndOrd().getNazione());
		daoIndOrd.insert(indOrd);
		
		
		double costo = 0;
		double speseSped = 0;
		for (Prodotto p: d.getProdotti()) {
			costo += p.getPrezzoUni()*p.getDisponibilita();
			speseSped += p.getCostoSped();
		}
		 
		double costoTot = costo;
		
		if (costo<20){
			costoTot += speseSped;
		} else if (costo>=20 && costo<100) {
			costoTot += 10;
		}
		
		Ordine ordine = new Ordine(daoOrd.contaNumOrdini()+1+"",
				d.getUsername(), new Date(new java.util.Date().getTime()), costoTot,
				d.getIndOrd().getIdIndOrdine(), d.getModPag().getIdMod());
		daoOrd.insert(ordine);
		
		for (Prodotto p: d.getProdotti()) {
			ComposizioneOrdini compOrd = new ComposizioneOrdini(p.getDisponibilita(), p.getIdProdotto(), ordine.getCodOrdine());
			daoComp.insert(compOrd);
		}
		
//		if (d.getModPag().getIdMod().equals("5")) {
//			DatiRateOrdine datiRatOrd = new DatiRateOrdine(ordine.getCodOrdine(), daoRateDef.getTan,
//					daoRateDef.getMaxTaeg, daoRateDef.getNRate);
//			daoRateOrd.insert(datiRatOrd);
		}

}
