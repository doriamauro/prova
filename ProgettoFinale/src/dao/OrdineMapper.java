package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import bean.Ordine;

public class OrdineMapper implements RowMapper<Ordine> {

	@Override
	public Ordine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ordine o = new Ordine();

		o.setCodOrdine(rs.getInt("codOrdine"));
		o.setUsOrdine(rs.getString("usOrdine"));
		o.setDataOrdine(rs.getDate("dataOrdine"));
		o.setPrezzoFinale(rs.getDouble("prezzoFinale"));
		o.setIdIndOrd(rs.getInt("idIndOrd"));
		o.setIdModPag(rs.getInt("idModPag"));

		return o;
	}
}
