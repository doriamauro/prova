package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class OrdineMapper implements RowMapper<Ordine>{

	@Override
	public Ordine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ordine ordine = new Ordine();

		ordine.setCodOrdine(rs.getString("codOrdine"));
		ordine.setUsOrdine(rs.getString("usOrdine"));
		ordine.setDataOrdine(rs.getDate("dataOrdine"));
		ordine.setPrezzoFinale(rs.getDouble("prezzoFinale"));
		ordine.setIdIndOrd(rs.getString("idIndOrd"));
		ordine.setIdModPag(rs.getString("idModPag"));

		return ordine;

	}

}

