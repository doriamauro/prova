package dao;

import java.util.List;

import bean.IndirizzoOrdine;

public interface IndirizzoOrdineDAO {
//
	public void insert(IndirizzoOrdine indord);
	public boolean delete(String idIndOrdine);
	public IndirizzoOrdine select(String idIndOrdine);
	public int getProxID(); //
	public int contaNumeroIndOrd();
	public List<IndirizzoOrdine> selectAllIndirizzi();
	public List<IndirizzoOrdine> selectAllIndirizzi(String where); 
	public void update(IndirizzoOrdine indord);
}  
