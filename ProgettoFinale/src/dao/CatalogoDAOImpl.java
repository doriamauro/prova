package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Categoria;
import bean.DatiRate;
import bean.Prodotto;


@Repository
@Transactional	
public class CatalogoDAOImpl implements CatalogoDAO{

	@Autowired
	private JdbcTemplate template;
	

	@Override
	public void insert(Categoria c) {
		template.update("insert into categoria values(?,?)", c.getIdCategoria(), c.getNomeCategoria());
				
	}
	
	@Override
	public void insertProdCat(int idCategoria, Prodotto p) {
		template.update("insert into prodotto values (?,?,?,?,?,?,?,?,?,?,?)", 
				p.getIdProdotto(), p.getDescrizione(), p.getMarca(), p.getCodiceEAN(), p.getPrezzoUni(), p.getDisponibilita(), p.getLinkProduttore(), p.getCostoSped(), p.getTempoConsegna(), p.getImmaginePrimaria(), p.getImmagineSec(), idCategoria );
	}
	
	@Override
	public boolean delete(int idCategoria) {
		int n= template.update("delete from categoria where idCategoria=?", idCategoria); 		
		if(n==0) return false;	
		else return true;
	}
	
	@Override
	public boolean deleteAllProdInCat(int idCategoria) {
		int n= template.update("delete from prodotto where idCategoria=?", idCategoria); 		
		if(n==0) return false;	
		else return true;
	}
	
	

	@Override
	public boolean updateCat(int idCategoria, String nome) {
		if(select(idCategoria)!=null) {
			template.update("update categoria set nomeCategoria=? where idCategoria=?", 
					nome, idCategoria);
			return true;
		}
		return false;
	}
	
	@Override
	public Categoria select(int idCategoria) {
		Categoria c= template.queryForObject("select * from categoria where idCategoria=?",		
				new CategoriaMapper(), idCategoria);
		return c;
		}
			
	
	
	@Override
	public List<Categoria> selectAll() {
		List<Categoria> categorie = template.query("select * from categoria", new CategoriaMapper());	
		return categorie;
	}
	
	
	class CategoriaMapper implements RowMapper<Categoria>{	
		
	
	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria c= new Categoria();  
		c.setIdCategoria(rs.getInt("idCategoria"));
		c.setNomeCategoria(rs.getString("nome"));

		return c;
	}

}


	@Override
	public boolean deleteProd(int idProdotto) {
		int p = template.update("delete from prodotto where idProdotto = ? ", idProdotto);
		if (p==0) return false; 		
		else return true;
	}

	@Override
	public boolean updateProd(Prodotto p) {
		int n = template.update("update prodotto set(descrizione=?,marca=?,codiceEAN=?,prezzoUni=?,disponibilita=?,linkProduttore=?,costoSped=?,tempoConsegna=?,immaginePrimaria=?,immagineSec=?,idCategoria=? where idProdotto = ? ) ",
				p.getDescrizione(),p.getMarca(),p.getCodiceEAN(),p.getPrezzoUni(),
				p.getDisponibilita(),p.getLinkProduttore(),p.getCostoSped(),
				p.getTempoConsegna(),p.getImmaginePrimaria(),
				p.getImmagineSec(),p.getIdCategoria(), p.getIdProdotto());
		return n==1;
	}

	@Override
	public void updateRate(DatiRate dr) {
		template.update("update datiRate set tan=?, maxTaeg=?, nRate=?", 
				dr.getTan(), dr.getMaxTaeg(), dr.getnRate());
		
	}
}
