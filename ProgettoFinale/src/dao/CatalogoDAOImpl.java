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
		template.update("insert into prodotto values (?,?,?,?,?,?,?,?,?,?,?,?,?)", 
				p.getIdProdotto(),
				p.getDescrizione(),
				p.getMarca(),
				p.getCodiceEAN(),
				p.getPrezzoUni(),
				p.getDisponibilita(),
				p.getLinkProduttore(),
				p.getCostoSped(),
			 p.getTempoConsegna(),
				p.getImmaginePrimaria(),
				p.getImmagineSec(),
				idCategoria,
				p.getSconto() );
	}
	
	@Override
	//MySQLIntegrityConstraintViolationException
	public boolean delete(int idCategoria) {
		int n= template.update("delete from categoria where idCategoria=?", idCategoria); 		
		if(n==0) return false;	
		else return true;
	}
	
	@Override
	public boolean deleteAllProdInCat(int idCategoria) {
		int n= template.update("delete from prodotto where categoria=?", idCategoria); 		
		if(n==0) return false;	
		else return true;
	}
	
	

	@Override
	public boolean updateCat(int idCategoria, String nome) {
			if(select(idCategoria)!=null) {
			template.update("update categoria set nome=? where idCategoria=?", 
					nome, idCategoria);
			return true;
		}
		return false;
	}
	
	@Override
	public Categoria select(int idCategoria) {
		List<Categoria> c= template.query("select * from categoria where idCategoria=?",		
				new CategoriaMapper2(), idCategoria);
		if(c.size()==0)
			return null;
		return c.get(0);
		}
			
	
	
	@Override
	public List<Categoria> selectAll() {
		List<Categoria> categorie = template.query("select * from categoria", new CategoriaMapper2());
		return categorie;
	}
	
	


	@Override
	public boolean deleteProd(int idProdotto) {
		int p = template.update("delete from prodotto where idProdotto = ? ", idProdotto);
		if (p==0) return false; 		
		else return true;
	}

	@Override
	public boolean updateProd(Prodotto p) {
		int n = template.update("update prodotto set descrizione=?, marca=?, codiceEAN=?, prezzoUni=?, disponibilita=?, linkProduttore=?, costoSped=?, tempoConsegna=?, immaginePrimaria=?, immagineSec=?, categoria=?, sconto=? where idProdotto = ?",
				p.getDescrizione(),p.getMarca(),p.getCodiceEAN(),p.getPrezzoUni(),
				p.getDisponibilita(),p.getLinkProduttore(),p.getCostoSped(),
				p.getTempoConsegna(),p.getImmaginePrimaria(),
				p.getImmagineSec(),p.getIdCategoria(), p.getSconto(), p.getIdProdotto());
		return n==1;
	}

	@Override
	public void updateRate(DatiRate dr) {
		template.update("update datiRate set tan=?, maxTaeg=?, nRate=?", 
				dr.getTan(), dr.getMaxTaeg(), dr.getnRate());
		
	}
	
	@Override
	public DatiRate selectRate() {
		 List<DatiRate> dd = template.query("select * from datiRate",new DatiRateMapper());
		 if(dd.size()==0)
			 return null;
		 return dd.get(0);
		
	}
}


class CategoriaMapper2 implements RowMapper<Categoria>{	


	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria c= new Categoria();  
		c.setIdCategoria(rs.getInt("idCategoria"));
		c.setNomeCategoria(rs.getString("nome"));

		return c;
	}

}

class DatiRateMapper implements RowMapper<DatiRate>{	
	
	
@Override
public DatiRate mapRow(ResultSet rs, int rowNum) throws SQLException {
	DatiRate dr= new DatiRate();  
	dr.setTan(rs.getDouble("Tan"));
	dr.setMaxTaeg(rs.getDouble("maxTaeg"));
	dr.setnRate(rs.getInt("nRate"));
	return dr;
}


	
	

}

