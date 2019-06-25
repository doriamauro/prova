package dao;

import java.util.List;

import bean.Cliente;
import bean.Ordine;

public interface ClienteDAO {

	public void insert(Cliente c);
	public Cliente select(String username);
	public void update(Cliente c);
	public List<Ordine> selectAll(String username);
	
}
