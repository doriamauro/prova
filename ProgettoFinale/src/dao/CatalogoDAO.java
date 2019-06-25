package dao;

import java.util.List;

import bean.DatiRate;
import bean.Prodotto;
import bean.Categoria;

public interface CatalogoDAO {
	
	public void insert(Categoria c);
	public boolean delete(int idCategoria);
	public List<Categoria> selectAll();
	public Categoria select(int idCategoria);
	public void insertProdCat(int idCategoria, Prodotto p);
	public boolean deleteAllProdInCat(int idCategoria);
	public boolean deleteProd(int idProdotto);
	public boolean updateProd(Prodotto p);
	public boolean updateCat(int idCategoria, String nome);
	public void updateRate(DatiRate dr);

}
