package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.DatiRateOrdine;
import bean.Prodotto;

public class DatiRateOrdineDAOImpl implements DatiRateOrdineDAO {
	
	private JdbcTemplate droTemplate;

	@Override
	public void insert(DatiRateOrdine dro) {
		droTemplate.update("insert into datiRateOrdine values(?,?,?,?)", dro.getIdOrd(),dro.getTan(),dro.getMaxTaeg(),dro.getnRate());
			}

	@Override
	public boolean delete(int idOrd) {
		 int dt = droTemplate.update("delete from datiRateOrdine where idOrd = ? ", idOrd);
		if(dt==0) return false;
		else return true;
	}

	@Override
	public DatiRateOrdine select(int idOrd) {
		DatiRateOrdine dro = droTemplate.queryForObject("select * from datiRateOrdine where idOrd = ? ", new DatiRateOrdineMapper(), idOrd);
		return dro;
	}

	@Override
	public List<DatiRateOrdine> selectAllDatiRate() {
		return 	droTemplate.query("select * from datiRateOrdine", new DatiRateOrdineMapper());
		
	}

	@Override
	public List<DatiRateOrdine> selectAllDatiRate(String where) {
		if (where == null || where == " ")
			return this.selectAllDatiRate();
		return droTemplate.query("select * from datiRateOrdine" + where, new DatiRateOrdineMapper());
	}

	@Override
	public void update(DatiRateOrdine dro) {
		droTemplate.update("update datiRateOrdine set(tan=?,maxTaeg=?,nRate=?   where idOrd = ? )",dro.getTan(),dro.getMaxTaeg(),dro.getnRate(),dro.getIdOrd());
		
	}

}


class DatiRateOrdineMapper implements RowMapper<DatiRateOrdine>{

@Override
public DatiRateOrdine mapRow(ResultSet rs, int rowNum) throws SQLException {

	DatiRateOrdine dro = new DatiRateOrdine();
	dro.setIdOrd(rs.getInt("idOrd"));
	dro.setTan(rs.getDouble("tan"));
	dro.setMaxTaeg(rs.getDouble("maxTaeg"));
	dro.setnRate(rs.getInt("nRate"));

	return dro;
}

}



