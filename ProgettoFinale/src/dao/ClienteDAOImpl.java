package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Admin;
import bean.Affidabile;
import bean.Attivo;
import bean.Cliente;
import bean.Ordine;
import bean.Tipologia;


@Repository
@Transactional
public class ClienteDAOImpl implements ClienteDAO {

	@Autowired
	private JdbcTemplate template;


	@Override
	public void insert(Cliente c) {

		template.update("insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", c.getUsername(),
				c.getNome(),
				c.getCognome(),
				c.getTipologia(),
				c.getPartitaIva(),
				c.getCodiceFiscale(),
				c.getCellulare(),
				c.getTelefonoFisso(),
				c.getEmail(),
				c.getPassword(),
				c.getAttivo(),
				c.getAdmin(),
				c.getAffidabile(),
				c.getVia(),
				c.getCap(),
				c.getComune(),
				c.getProvincia(),
				c.getNazione());
	}

	@Override
	public Cliente select(String username) {

		Cliente c = template.queryForObject("select * from cliente where username = ?", new ClienteMapper(), username);

		return c;

	}

	@Override
	public void update(Cliente c) {

		template.update("update cliente set nome = ?, cognome = ?,  "
				+ " tipologia = ?, "
				+ " partitaIva = ?, "
				+ " codiceFiscale = ?, "
				+ "cellulare = ?, "
				+ "telefonoFisso = ?, "
				+ "email = ?, "
				+ "password = ?, "
				+ "attivo = ?, "
				+ "admin = ?, "
				+ "affidabile = ?, "
				+ "via = ?, "
				+ "cap = ?, "
				+ "comune = ?, "
				+ "provincia = ?, "
				+ "nazione = ?  where username = ?",
				c.getNome(),
				c.getCognome(),
				c.getTipologia(),
				c.getPartitaIva(),
				c.getCodiceFiscale(),
				c.getCellulare(),
				c.getTelefonoFisso(),
				c.getEmail(),
				c.getPassword(),
				c.getAttivo(),
				c.getAdmin(),
				c.getAffidabile(),
				c.getVia(),
				c.getCap(),
				c.getComune(),
				c.getProvincia(),
				c.getNazione(),
				c.getUsername());
	}

	@Override
	public List<Ordine> selectAll(String username) {
		return template.query("select o.* from cliente c, ordine o where c.username = o.usOrdine and c.username = ?", 
				new OrdineMapper(), username);
	}

}

class ClienteMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {

		Cliente c = new Cliente();
		c.setUsername(rs.getString("username"));
		c.setNome(rs.getString("nome"));
		c.setCognome(rs.getString("cognome"));

		int tipologia = rs.getInt("tipologia");
		if (tipologia == 0) {
			c.setTipologia(Tipologia.PRIVATO);
		}
		else {
			c.setTipologia(Tipologia.AZIENDA);
		}

		c.setPartitaIva(rs.getString("partitaIva"));
		c.setCodiceFiscale(rs.getString("codiceFiscale"));
		c.setCellulare(rs.getString("cellulare"));
		c.setTelefonoFisso(rs.getString("telefonoFisso"));
		c.setEmail(rs.getString("email"));
		c.setPassword(rs.getString("password"));

		int attivo = rs.getInt("attivo");
		if (attivo == 0) {
			c.setAttivo(Attivo.NO);
		}
		else {
			c.setAttivo(Attivo.SI);
		}

		int admin = rs.getInt("admin");
		if (admin == 0) {
			c.setAdmin(Admin.NO);
		}
		else {
			c.setAdmin(Admin.SI);
		}

		int affidabile = rs.getInt("affidabile");
		if (affidabile == 0) {
			c.setAffidabile(Affidabile.NO);
		}
		else {
			c.setAffidabile(Affidabile.SI);
		}

		c.setVia(rs.getString("via"));
		c.setCap(rs.getString("cap"));
		c.setComune(rs.getString("comune"));
		c.setProvincia(rs.getString("provincia"));
		c.setNazione(rs.getString("nazione"));			

		return c;
	}
}

class OrdineMapper implements RowMapper<Ordine> {

	@Override
	public Ordine mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ordine o = new Ordine();

		o.setCodOrdine(rs.getString("codOrdine"));
		o.setUsOrdine(rs.getString("usOrdine"));
		o.setDataOrdine(rs.getDate("dataOrdine"));
		o.setPrezzoFinale(rs.getDouble("prezzoFinale"));
		o.setIdIndOrd(rs.getString("idIndOrd"));
		o.setIdModPag(rs.getString("idModPag"));

		return o;
	}
}
