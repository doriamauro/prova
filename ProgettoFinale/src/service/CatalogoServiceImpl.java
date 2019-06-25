package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Categoria;
import bean.DatiRate;
import bean.Prodotto;
import dao.CatalogoDAO;
import exception.CategoriaException;

@Service
@Transactional(propagation= Propagation.REQUIRES_NEW)	
public class CatalogoServiceImpl implements CatalogoService{

	@Autowired
	private CatalogoDAO dao;
	
	@Override
	public void creaCategoria(Categoria c) {
		dao.insert(c);
	}
	
	@Override
	public boolean eliminaCategoria (int idCategoria) {
		return dao.deleteAllProdInCat(idCategoria);
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
		if(dao.select(idCategoria)!= null) {
		p.setIdCategoria(idCategoria);
		dao.updateProd(p);
		}
	}catch(Exception e) {
		throw new CategoriaException("Categoria inesistente");
	}
	}

	@Override
	public boolean svuotaCategoria(int idCategoria) {
		Categoria c= dao.select(idCategoria);	
		return dao.deleteAllProdInCat(idCategoria);
	}
	
	@Override
	public void modificaDatiRateizzazione(DatiRate dr) {
		dao.updateRate(dr);
		}

	@Override
	public boolean eliminaProdotto(int idProdotto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaSchedaProdotto(Prodotto p) {
		// TODO Auto-generated method stub
		return false;
	}


		
	
}
