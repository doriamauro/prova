
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import bean.Categoria;
import bean.Prodotto;
import dao.CategoriaDAO;
import dao.ProdottoDAO;
import exception.ProdottoNonTrovatoException;


@Service
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	private ProdottoDAO daoP;
	@Autowired
	private CategoriaDAO daoC;
		
	@Override
	public List<Categoria> getCategorie() {
		List<Categoria> lista= daoC.selectAllCategorie();
		return lista;
	}


	@Override
	public List<Prodotto> getProdotti(int idCat) {
		return dao.selectAllProdotti();
	}

	@Override
	public List<Prodotto> ricercaProdotti(String ricerca) {
		return dao.selectAll(ricerca);
	}

	@Override
	public List<Prodotto> ricercaProdottiPerMarca(String marca) {
		String where = "where marca="+marca;
		return daoP.selectAll(where);
	}

	@Override
	public List<Prodotto> ricercaProdottiPerPrezzoUnitario(double min, double max) {
		String where = "where prezzo<"+max+" and prezzo>"+min;
		return daoP.selectAll(where);
	}

	@Override
	public List<Prodotto> ricercaProdottiScontati() {
		return daoP.selectAll("where sconto > 0");
	}

	@Override
	public Prodotto getSchedaProdotto(int idProdotto) throws ProdottoNonTrovatoException {
		try {
			return daoP.select(idProdotto);
		} catch (Exception e) {
			throw new ProdottoNonTrovatoException("La chiave " + idProdotto + " non trovata! " + e.getMessage());
	}

}
}
