package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Attivo;
import bean.Cliente;
import bean.Ordine;
import dao.ClienteDAO;
import exception.ClienteException;


@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {
// ciao
	@Autowired
	private ClienteDAO dao;

	@Override
	public void registraCliente(Cliente c) throws ClienteException {
		try {
			dao.insert(c);
		} catch (Exception e) {
			throw new ClienteException("Il cliente con username "+ c.getUsername() +" non è stato registrato");
		}
	}

	@Override
	public void checkCredenziali(String username, String password) throws ClienteException {
		Cliente c = dao.select(username);
		if(c!=null || c.getPassword().equals(password))
			throw new ClienteException("Sei già registrato");
	}

	@Override
	public Cliente getCliente(String username) {
		return dao.select(username);
	}

	@Override
	public void updateCliente(Cliente c) throws ClienteException {
		try {
			dao.update(c);
		} catch (Exception e) {
			throw new ClienteException("Impossibile effettuare la modifica");
		}
	}

	@Override
	public List<Ordine> getOrdini(String username) {
		return dao.selectAll(username);
	}

	@Override
	public void disabilitaCliente(String username) throws ClienteException {
		try {
			Cliente c =  dao.select(username);
			if (c.getAttivo().equals(Attivo.SI)) {
				c.setAttivo(Attivo.NO);
				dao.update(c);
			}
		} catch (Exception e) {
			throw new ClienteException("Impossibile disattivare il profilo");
		}
	}

	@Override
	public void riabilitaCliente(String username, String password) throws ClienteException {
		try {
			Cliente c =  dao.select(username);
			if (c.getPassword().equals(password) && c.getAttivo().equals(Attivo.NO)) {
				c.setAttivo(Attivo.SI);
				dao.update(c);
			}
		} catch (Exception e) {
			throw new ClienteException("Operazione fallita");
		}
	}

}
