package service;

import org.springframework.stereotype.Service;

import bean.DatiOrdine;
import dao.ComposizioneOrdiniDAO;
import dao.DatiRateOrdineDAO;
import dao.OrdineDAO;

@Service
public class CarrelloServiceImpl implements CarrelloService {

	
	private ComposizioneOrdiniDAO daoComp;
	private OrdineDAO daoOrd;
	private DatiRateOrdineDAO daoRateOrd;
//	private DatiRateDAO daoRateDef;
		
	
	@Override
	public void finalizzaAcquisto(DatiOrdine d) {
		
		

	}

}
