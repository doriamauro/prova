package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.ModPagamento;
import bean.Ordine;
import bean.OrdineMapper;

@Repository
@Transactional
public class OrdineDAOImpl implements OrdineDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void insert(Ordine o) {
		template.update("insert into ordine values(?,?,?,?,?,?)", o.getCodOrdine(),o.getUsOrdine(),o.getDataOrdine(),o.getPrezzoFinale(),
				o.getIdIndOrd(),o.getIdModPag());

	}

	@Override
	public boolean delete(int codOrdine) {
		int n = template.update("delete from ordine where codordine = ?", codOrdine);
		return n==1;
	}

	@Override
	public Ordine select(int codOrdine) {
		return template.queryForObject("select * from ordine where codordine = ?", new OrdineMapper(), codOrdine);
	}

 
	@Override
	public List<Ordine> selectAllOrdini() {
		return template.query("select * from ordine", new OrdineMapper());
	}

	@Override
	public List<Ordine> selectAllOrdini(String where) {
		if (where==null || where==" ")
			return this.selectAllOrdini();
		return template.query("select * from ordine " + where, new OrdineMapper());
	}
	
	@Override
	public int contaNumOrdini() {
		return template.queryForObject("select max(codOrdine) from ordine", Integer.class) ;
	}
	
	@Override
	public void update(Ordine o) {

		template.update("update ordine set usordine = ?, dataordine = ?, prezzofinale = ?, idindordine = ?, idmodpag = ? where  codordine = ?", 
				o.getUsOrdine(),o.getDataOrdine(),o.getPrezzoFinale(),o.getIdIndOrd(),o.getIdModPag(),o.getCodOrdine());

	}




}