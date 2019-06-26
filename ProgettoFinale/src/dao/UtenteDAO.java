package dao;

import java.util.List;

import bean.Cliente;
import bean.Ordine;
//
public interface UtenteDAO {
	
	public void insert(Cliente c);
	public boolean delete(String username);
	public Cliente select(String username);
	public List<Cliente> selectAll();
	public List<Cliente> selectInaffidabili();
	public List<Cliente> selectAffidabili();
	public void update(Cliente c);
	public List<Ordine> selectOrdini();

}
