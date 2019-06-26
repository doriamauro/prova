package service;

import java.util.ArrayList;
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
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	private ProdottoDAO dao;
	@Autowired
	private CategoriaDAO daoCat;
	
	@Override
	public List<Categoria> getCategorie() {
		return daoCat.selectAllCategorie();
	}

	@Override
	public List<Prodotto> getProdotti(int idCat) {
		return dao.selectAll(" where idCategoria = " + idCat);
	}

	@Override
	public List<Prodotto> ricercaProdotti(String ricerca) {
		return dao.selectAll(ricerca);
	}

	@Override
	public List<Prodotto> ricercaProdottiPerMarca(String marca) {
		return dao.selectAll(" where marca = " + marca);
	}

	@Override
	public List<Prodotto> ricercaProdottiPerPrezzoUnitario(double min, double max) {
		return dao.selectAll(" where prezzouni < " + max + " and prezzouni > " + min);
	}

	@Override
	public List<Prodotto> ricercaProdottiScontati() {
		
		return dao.selectAll("where sconto > 0");
	}

	@Override
	public Prodotto getSchedaProdotto(int idProdotto) throws ProdottoNonTrovatoException {
		
		try {
			return dao.select(idProdotto);
		} catch (Exception e) {
			throw new ProdottoNonTrovatoException("Chiave n°" + idProdotto + " non trovata!\n" + e.getMessage());
		}
	
	}
	@Override
	public boolean eliminaProdotto(int idProdotto) {
		return dao.delete(idProdotto);
		
	}

	@Override
	public boolean modificaSchedaProdotto(Prodotto p) {
		return dao.update(p);
	}
	
	@Override
	public List<String> getMarche() {
		List<Prodotto> lista = dao.selectAllProdotti();
		List<String> marche = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			if(!marche.contains(lista.get(i).getMarca())) {
				String marca= lista.get(i).getMarca();
				marche.add(marca);
			}
		}
		return marche;
	}
}
