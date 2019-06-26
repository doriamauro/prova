package service;

import java.util.List;

import bean.DatiOrdine;
import bean.DatiRate;
import bean.ModPagamento;

public interface CarrelloService {
	
	public List<ModPagamento> getAllModPagamento();
	public ModPagamento getModPagamento(String idMod);
	public DatiRate getDatiRate();
	public void finalizzaAcquisto(DatiOrdine d);
	
	
}
