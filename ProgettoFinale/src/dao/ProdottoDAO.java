package dao;

import java.util.List;

import bean.Categoria;
import bean.Prodotto;

public interface ProdottoDAO {

	// Amministratore
	public void insert(Prodotto p);
	public boolean delete(String idProdotto);
	public void update(Prodotto p);
	
	// Utente
	public Prodotto select(String idProdotto);
	public List<Prodotto> selectAllProdotti();
	public List<Prodotto> selectAll(String where);
	public List<Categoria> selectAllCategorie();

}
