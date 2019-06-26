package dao;

import java.util.List;

import bean.Ordine;

public interface OrdineDAO {
	
	public void insert(Ordine o);
	public boolean delete(int codOrdine);
	public Ordine select(int codOrdine);
	
	public List<Ordine> selectAllOrdini();
	public List<Ordine> selectAllOrdini(String where);
	 
	public void update(Ordine o);
	
	public int contaNumOrdini();
	
}
