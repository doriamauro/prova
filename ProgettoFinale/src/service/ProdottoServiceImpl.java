package service;

import java.util.List;

import bean.Categoria;
import bean.Prodotto;
import dao.ProdottoDAO;
import exception.ProdottoNonTrovatoException;

public class ProdottoServiceImpl implements ProdottoService {

	private ProdottoDAO dao;
	
	@Override
	public List<Categoria> getCategorie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> getProdotti(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> ricercaProdotti(String ricerca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> ricercaProdottiPerMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> ricercaProdottiPerPrezzoUnitario(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> ricercaProdottiScontati() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodotto getSchedaProdotto(int idProdotto) throws ProdottoNonTrovatoException {
		
		try {
			return dao.select(idProdotto);
		} catch (Exception e) {
			
			throw new ProdottoNonTrovatoException("La chiave " + idProdotto + " non trovata!");
		}
		
	}

}
