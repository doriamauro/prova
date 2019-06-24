package service;

public interface CatalogoService {
	
	public void creaCategoria(Categoria c);
	public boolean eliminaCategoria (int idCategoria);
	public boolean modificaNomeCategoria (int idCategoria, String nome);
	public List<Categoria> getCategorie();
	public void addProdottoCategoria(int idCategoria, Prodotto p)throws CategoriaException;
	public boolean svuotaCategoria(int idCategoria);
	public boolean eliminaProdotto(int idProdotto);
	public boolean modificaSchedaProdotto (Prodotto p);
	public void modificaDatiRateizzazione(DatiRate dr);
	
	
	
	
}
