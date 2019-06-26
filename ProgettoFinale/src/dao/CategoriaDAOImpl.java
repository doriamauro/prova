package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bean.Categoria;
import bean.Prodotto;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	private JdbcTemplate template;
	
	 
	@Override
	public void insert(Categoria c) {
		template.update("insert into categoria values(?,?)",c.getIdCategoria(),
															c.getNomeCategoria());

	}

	@Override
	public boolean delete(int idCategoria) {
		int n = template.update("delete from categoria where idCategoria=?", idCategoria);
		return n==1;
		
	}

	@Override
	public Categoria select(int idCategoria) {
		List<Categoria> c = template.query("select * from categoria where idCategoria=?", new CategoriaMapper(), idCategoria);
		if(c.size()==0)
			return null;
		return c.get(0);
	}

	@Override
	public List<Categoria> selectAllCategorie() {
		List<Categoria> listaCategorie = template.query("select * from categoria", new CategoriaMapper());
		return listaCategorie;
	}

	@Override
	public List<Categoria> selectAllCategorie(String where) {
		List<Categoria> listaCategorie = template.query("select * from categoria"+where, new CategoriaMapper());
		return listaCategorie;
	}

	@Override
	public void update(Categoria c) {
		template.update("update categoria set nomeCategoria=? where idCategoria=?",c.getNomeCategoria(),c.getIdCategoria());
	}

}


class CategoriaMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Categoria c = new Categoria();
		
		c.setIdCategoria(rs.getInt("idCategoria"));
		c.setNomeCategoria(rs.getString("nomeCategoria"));
				
		return c;
	}
}
