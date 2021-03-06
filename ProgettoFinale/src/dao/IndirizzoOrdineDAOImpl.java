package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.IndirizzoOrdine;
import bean.Prodotto;

@Repository
@Transactional
public class IndirizzoOrdineDAOImpl implements IndirizzoOrdineDAO {
	
	@Autowired
	private JdbcTemplate ioTemplate;
	
	

	@Override
	public void insert(IndirizzoOrdine indord) {
		ioTemplate.update("insert into IndirizzoOrdine values(?,?,?,?,?,?)", indord.getIdIndOrdine(),indord.getVia(),indord.getComune(),indord.getCap(),indord.getProvincia(),indord.getNazione());

	}

	@Override
	public boolean delete(int idIndOrdine) {
		int p = ioTemplate.update("delete from IndirizzoOrdine where idIndOrdine = ? ", idIndOrdine);
		if(p==0) return false;
		else return true;
	}

	@Override
	public IndirizzoOrdine select(int idIndOrdine) {
		return ioTemplate.queryForObject("select * from indirizzoOrdine where idIndOrdine = ?", new IndirizzoOrdineMapper(),idIndOrdine);
		
	}

	@Override
	public List<IndirizzoOrdine> selectAllIndirizzi() {
		return 	ioTemplate.query("select * from indirizzoOrdine", new IndirizzoOrdineMapper());
	}

	@Override
	public List<IndirizzoOrdine> selectAllIndirizzi(String where) {
		if (where == null || where == " ")
			return this.selectAllIndirizzi();
		return ioTemplate.query("select * from indirizzoOrdine " + where, new IndirizzoOrdineMapper());
	}

	@Override
	public void update(IndirizzoOrdine indord) {
		ioTemplate.update("update IndirizzoOrdine set via = ?,comune = ?,cap = ?, provincia = ?, nazione = ? where idIndOrdine = ?", 
				indord.getVia(),indord.getComune(),indord.getCap(),indord.getProvincia(),indord.getNazione(),indord.getIdIndOrdine());

	}
 
	@Override
	public int getProxID() {
		int id = ioTemplate.queryForObject("select max(idIndOrdine) from indirizzoOrdine", Integer.class);
		return id+1;
	}

}

class IndirizzoOrdineMapper implements RowMapper<IndirizzoOrdine>{

	@Override
	public IndirizzoOrdine mapRow(ResultSet rs, int rowNum) throws SQLException {
        IndirizzoOrdine io = new IndirizzoOrdine();
		
        io.setIdIndOrdine(rs.getInt("idIndOrdine"));
        io.setVia(rs.getString("via"));
        io.setComune(rs.getString("comune"));
        io.setCap(rs.getString("cap"));
        io.setProvincia(rs.getString("provincia"));
        io.setNazione(rs.getString("nazione"));

		
		return io;
	}

}



