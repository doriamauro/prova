package dao;

import java.util.List;

import bean.Categoria;


public interface CategoriaDAO {

	public void insert(Categoria c);
	public boolean delete(int idCategoria);
	public Categoria select(int idCategoria);
	public List<Categoria> selectAllCategorie();
	public List<Categoria> selectAllCategorie(String where);
	public void update(Categoria c);
	
}
