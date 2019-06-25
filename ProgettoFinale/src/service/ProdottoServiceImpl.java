package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Upstream, based on branch 'master' of https://github.com/doriamauro/prova.git
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
		return dao.selectAllProdotti();
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
			throw new ProdottoNonTrovatoException("La chiave " + idProdotto + " non trovata! " + e.getMessage());
		}
		
=======

import bean.Categoria;
import bean.Prodotto;
import dao.CategoriaDAO;
import dao.ProdottoDAO;

public class ProdottoServiceImpl implements ProdottoService {

	@Autowired
	private ProdottoDAO daoP;
	private CategoriaDAO daoC;
		
	@Override
	public List<Categoria> getCategorie() {
		List<Categoria> lista= daoC.selectAllCategorie();
		return lista;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodotto getSchedaProdotto(int idProdotto) throws ProdottoException {
		// TODO Auto-generated method stub
		return null;
>>>>>>> 95fae8a ProdottoServiceImpl
	}

}
