package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Attivo;
import bean.Cliente;
import bean.Ordine;
import dao.ClienteDAO;
import exception.ClienteException;


@Service
@Transactional
//
public class ClienteServiceImpl implements ClienteService {
// ciao
	@Autowired
	private ClienteDAO dao;

	@Override
	public void registraCliente(Cliente c) throws ClienteException {
//		try {
			dao.insert(c);
//		} catch (DuplicateKeyException e) {
//			throw new ClienteException("Il cliente con username "+ c.getUsername() +" è già registrato");
//		}
	}

	@Override
	
	public boolean checkCredenziali(String username, String password) {// throws ClienteException {
		Cliente c = dao.select(username);
		if(c==null || !c.getPassword().equals(password))
			return false;
		return true;
		
		

	}

	@Override
	public Cliente getCliente(String username) {
				return dao.select(username);
	}

	@Override
	public void updateCliente(Cliente c) throws ClienteException {
dao.update(c);

	}

	@Override
	public List<Ordine> getOrdini(String username) {
		return dao.selectAll(username);
	}

	@Override
	public void disabilitaCliente(String username) throws ClienteException {
			Cliente c =  dao.select(username);
			if (c.getAttivo().equals(Attivo.SI)) {
				c.setAttivo(Attivo.NO);
				dao.update(c);
			}
	}

	@Override
	public void riabilitaCliente(String username, String password) throws ClienteException {
			Cliente c =  dao.select(username);
			if (c.getPassword().equals(password) && c.getAttivo().equals(Attivo.NO)) {
				c.setAttivo(Attivo.SI);
				dao.update(c);}
	}

}
