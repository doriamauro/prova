package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Affidabile;
import bean.Cliente;
import bean.Ordine;
import dao.UtenteDAO;
//
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteDAO dao;

	@Override
	public List<Cliente> visualizzaClienti() {
		return dao.selectAll();
	}

	@Override
	public List<Cliente> visualizzaClientiInaffidabili() {
		return dao.selectInaffidabili();
	}

	@Override
	public List<Cliente> visualizzaClientiAffidabili() {
		return dao.selectAffidabili();
	}

	@Override
	public Cliente visualizzaDatiCliente(String username) {
		return dao.select(username);
	}

	@Override
	public boolean modificaDatiCliente(Cliente c) {
		if(dao.select(c.getUsername())==null)
			return false;
		dao.update(c);
		return true;
	}

	@Override
	public boolean marcaInaffidabile(String username) {
		Cliente c = dao.select(username);
		if(dao.select(username)==null)
			return false;
		c.setAffidabile(Affidabile.NO);
		return true;
	}

	@Override
	public boolean marcaAffidabile(String username) {
		Cliente c = dao.select(username);
		if(dao.select(username)==null)
			return false;
		c.setAffidabile(Affidabile.SI);
		return true;
	}

	@Override
	public List<Ordine> visualizzaTuttiGliOrdini() {
		return dao.selectOrdini();
	}



}
