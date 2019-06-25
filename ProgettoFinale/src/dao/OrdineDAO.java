package dao;

import java.util.List;

import bean.Ordine;

public interface OrdineDAO {
	
	public void insert(Ordine o);
	public boolean delete(String codOrdine);
	public Ordine select(String codOrdine);
	
	public List<Ordine> selectAllOrdini();
	public List<Ordine> selectAllOrdini(String where);
	
	public void update(Ordine o);
	
}
