package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Categoria;
import bean.Prodotto;

@Repository
@Transactional
public class ProdottoDAOImpl implements ProdottoDAO {
	
	@Autowired
	private JdbcTemplate ptemplate;

	@Override
	public void insert(Prodotto p) {
		ptemplate.update("insert into prodotto values(?,?,?,?,?,?,?,?,?,?,?,?,?)", p.getIdProdotto(),p.getDescrizione(),
				p.getMarca(),p.getCodiceEAN(),p.getPrezzoUni(),
				p.getDisponibilita(),p.getLinkProduttore(),
				p.getCostoSped(),p.getTempoConsegna(),p.getImmaginePrimaria(),p.getImmagineSec(),p.getIdCategoria(),p.getSconto());

	} 

	@Override
	public boolean delete(int idProdotto) {
		int p = ptemplate.update("delete from prodotto where idProdotto = ? ", idProdotto);
		if (p==0) return false; 		
		else return true;
	}

	@Override
	public boolean update(Prodotto p) {
		int n = ptemplate.update("update prodotto set descrizione=?,marca=?,codiceEAN=?,prezzoUni=?,disponibilita=?,linkProduttore=?,costoSped=?,tempoConsegna=?,immaginePrimaria=?,immagineSec=?,categoria=?,sconto=? where idProdotto = ? ) ",
				p.getDescrizione(),p.getMarca(),p.getCodiceEAN(),p.getPrezzoUni(),
				p.getDisponibilita(),p.getLinkProduttore(),p.getCostoSped(),
				p.getTempoConsegna(),p.getImmaginePrimaria(),
				p.getImmagineSec(),p.getIdCategoria(), p.getSconto(), p.getIdProdotto());
		return n==1;
	}

	@Override
	public Prodotto select(int idProdotto) {
		Prodotto p = ptemplate.queryForObject("select * from prodotto where idProdotto = ? ", new ProdottoMapper(), idProdotto);
		return p;
		
	}

	@Override
	public List<Prodotto> selectAllProdotti() {
		return 	ptemplate.query("select * from prodotto", new ProdottoMapper());
	}

	@Override
	public List<Prodotto> selectAll(String where) {
		if (where == null || where == " ")
			return this.selectAllProdotti();
		return ptemplate.query("select * from prodotto " + where, new ProdottoMapper());
	}

}
class ProdottoMapper implements RowMapper<Prodotto>{

	@Override
	public Prodotto mapRow(ResultSet rs, int rowNum) throws SQLException {

		Prodotto p = new Prodotto();
		p.setIdProdotto(rs.getInt("idProdotto"));
		p.setDescrizione(rs.getString("descrizione"));
		p.setMarca(rs.getString("marca"));
		p.setCodiceEAN(rs.getString("marca"));
		p.setPrezzoUni(rs.getDouble("prezzoUni"));
		p.setDisponibilita(rs.getInt("disponibilita"));
		p.setLinkProduttore(rs.getString("linkProduttore"));
		p.setCostoSped(rs.getDouble("costoSpedizione"));
		p.setTempoConsegna(rs.getInt("tempoConsegna"));
		p.setImmaginePrimaria(rs.getString("immaginePrimaria"));
		p.setImmagineSec(rs.getString("immagineSec"));
		p.setIdCategoria(rs.getInt("idCategoria"));
		p.setSconto(rs.getInt("sconto"));
		
		return p;
	} 

}
