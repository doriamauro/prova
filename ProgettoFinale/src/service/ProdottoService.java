package service;

import java.util.List;

import bean.Categoria;
import bean.Prodotto;

public interface ProdottoService {
	
	public List<Categoria> getCategorie();
	public List<Prodotto> getProdotti(int idCat);
	public Prodotto getSchedaProdotto(int idProdotto) throws ProdottoException;
	public List<Prodotto> ricercaProdotti(String ricerca);
	public List <Prodotto> ricercaProdottiPerMarca (String marca);
	public List <Prodotto> ricercaProdottiPerPrezzoUnitario (double min, double max);
	public List <Prodotto> ricercaProdottiScontati ();

	

}
