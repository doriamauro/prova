package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.base.Data;

import bean.ComposizioneOrdini;
import bean.DatiOrdine;
import bean.DatiRate;
import bean.DatiRateOrdine;
import bean.IndirizzoOrdine; 
import bean.ModPagamento;
import bean.Ordine;
import bean.Prodotto;
import dao.ComposizioneOrdiniDAO;
import dao.DatiRateDAO;
import dao.DatiRateOrdineDAO;
import dao.IndirizzoOrdineDAO;
import dao.ModPagamentoDAO;
import dao.OrdineDAO;

@Service
@Transactional
public class CarrelloServiceImpl implements CarrelloService {

	@Autowired
	private ComposizioneOrdiniDAO daoComp; 
	@Autowired
	private OrdineDAO daoOrd;
	@Autowired
	private DatiRateOrdineDAO daoRateOrd;
	@Autowired
	private IndirizzoOrdineDAO daoIndOrd;
	@Autowired
	private DatiRateDAO daoRateDef;
	@Autowired
	private ModPagamentoDAO daoModPag;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void finalizzaAcquisto(DatiOrdine d) {

		//inserisce in indirizzoOrdine l'indirizzo
		IndirizzoOrdine indOrd = d.getIndOrd();
		indOrd.setIdIndOrdine(daoIndOrd.getProxID());
		daoIndOrd.insert(indOrd);


		//Calcolo il costo totale comprensivo di spese di spedizione
		double costo = 0;
		double speseSped = 0;
		double costoTot = 0;
		for (Prodotto p: d.getProdotti()) {
			costo = p.getPrezzoUni() - (p.getPrezzoUni()*(p.getSconto()/100));
			costoTot += costo*p.getDisponibilita();
			speseSped += p.getCostoSped();
		}

		if (costoTot<20){
			costoTot += speseSped;
		} else if (costoTot>=20 && costoTot<100) {
			costoTot += 10;
		}

		//inserisco l'ordine nella tabella ordini
		Ordine ordine = new Ordine(daoOrd.contaNumOrdini()+1,
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
		if (d.getModPag().getIdMod()==5) {
			DatiRateOrdine datiRatOrd = new DatiRateOrdine(ordine.getCodOrdine(),
					daoRateDef.selectRate().getTan(),
					daoRateDef.selectRate().getMaxTaeg(),
					daoRateDef.selectRate().getnRate());
			daoRateOrd.insert(datiRatOrd);}
	}

	@Override
	public List<ModPagamento> getAllModPagamento() {
		return daoModPag.selectAllModalita();
	}



	@Override
	public DatiRate getDatiRate() {
		return daoRateDef.selectRate();
	}

	@Override
	public ModPagamento getModPagamento(int idMod) {
		return daoModPag.select(idMod);
	}


}

