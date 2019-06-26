package dao;

import java.util.List;

import bean.IndirizzoOrdine;

public interface IndirizzoOrdineDAO {
//
	public void insert(IndirizzoOrdine indord);
	public boolean delete(String idIndOrdine);
	public IndirizzoOrdine select(String idIndOrdine);
<<<<<<< HEAD
	public int contaNumeroIndOrd();
=======
	//public int getProxID();  idIndOrd è string! Come fare?
>>>>>>> branch 'master' of https://github.com/doriamauro/prova.git
	public List<IndirizzoOrdine> selectAllIndirizzi();
	public List<IndirizzoOrdine> selectAllIndirizzi(String where); 
	public void update(IndirizzoOrdine indord);
}  
