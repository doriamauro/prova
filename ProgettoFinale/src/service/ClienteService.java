package service;

import java.util.List;

import bean.Cliente;
import bean.Ordine;
import exception.ClienteException;

public interface ClienteService {
	// ciao
	//
	public void registraCliente(Cliente c) throws ClienteException;
	public boolean checkCredenziali(String username, String password) throws ClienteException;
	public Cliente getCliente (String username);
	public boolean updateCliente(Cliente c) throws ClienteException; 
	public List<Ordine> getOrdini(String username);
	public void disabilitaCliente(String username) throws ClienteException; 
	public void riabilitaCliente(String username, String password) throws ClienteException;  
	
}
