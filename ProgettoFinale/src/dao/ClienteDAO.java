package dao;

import bean.Cliente;

public interface ClienteDAO {

	public void insert(Cliente c);
	public Cliente select(String username);
	public void update(Cliente c);
	
}
