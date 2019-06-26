package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Categoria;
import bean.DatiRate;
import bean.Prodotto;
import dao.CatalogoDAO;
import dao.DatiRateDAO;
import exception.CategoriaException;
import prove.CatalogoService;
//
@Service
@Transactional(propagation= Propagation.REQUIRES_NEW)	
public class CatalogoServiceImpl implements CatalogoService{

	@Autowired
	private CatalogoDAO dao;
	
	@Autowired
	private DatiRateDAO dao1;
	
	@Override
	// trattare l'errore DuplicateKeyException nel controller! Oppure genereazione automatica
	public void creaCategoria(Categoria c) {
		dao.insert(c);
	}
	
	@Override
	public boolean eliminaCategoria (int idCategoria) {
		this.svuotaCategoria(idCategoria);
		return dao.delete(idCategoria);
	}
	
	@Override
	public boolean modificaNomeCategoria (int idCategoria, String nome) {
		 
		return dao.updateCat(idCategoria, nome);
		
	}
	@Override
	public List<Categoria> getCategorie(){
		return dao.selectAll();
	}
	
	@Override
	public void addProdottoCategoria(int idCategoria, Prodotto p) throws CategoriaException {
	
        try {
		if(dao.select(idCategoria)!= null)
		{
		dao.insertProdCat(idCategoria, p);;}
		else
		throw new CategoriaException("Categoria inesistente");}
        catch (DuplicateKeyException e) {
        	throw new CategoriaException("Prodotto già inserito"); // servirebbe prodotto exception
        }
	}

	@Override
	public boolean svuotaCategoria(int idCategoria) {
		Categoria c = dao.select(idCategoria);
		return dao.deleteAllProdInCat(idCategoria);
	}
	
	@Override
	public void modificaDatiRateizzazione(DatiRate dr) {
		dao1.updateRate(dr);
		}

	@Override
	public boolean eliminaProdotto(int idProdotto) {
		return dao.deleteProd(idProdotto);
		
	}

	@Override
	public boolean modificaSchedaProdotto(Prodotto p) {
		return dao.updateProd(p);
	}


		
	
}
