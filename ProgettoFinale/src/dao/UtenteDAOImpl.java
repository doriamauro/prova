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

import bean.Affidabile;
import bean.Attivo;
import bean.Cliente;
import bean.Tipologia;
//
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UtenteDAOImpl implements UtenteDAO {
	
	@Autowired
	private JdbcTemplate template;

	@Override
	public void insert(Cliente c) {
		template.update("insert into cliente values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", c.getUsername(), c.getNome(), 
				c.getCognome(), c.getTipologia(), c.getPartitaIva(), c.getCodiceFiscale(), c.getCellulare(), c.getTelefonoFisso(),
				c.getEmail(), c.getPassword(), c.getAttivo(), c.getAdmin(), 
				c.getAffidabile(), c.getVia(), c.getCap(),
				c.getComune(), c.getProvincia(),  c.getNazione());
	}

	@Override
	public boolean delete(String username) {
		int n = template.update("delete from cliente where username = ?", username);
		if(n==0) return false;
		else return true;
	}

	@Override
	public Cliente select(String username) {
		Cliente c = template.queryForObject("select * from cliente where username = ?", 
				new ClienteMapper(), username);
		return c;
	}

	@Override
	public List<Cliente> selectAll() {
		List<Cliente> clienti = template.query("select * from cliente", new ClienteMapper());
		return clienti;
	}

	@Override
	public List<Cliente> selectInaffidabili() {
		List<Cliente> c = template.query("select * from cliente where affidabile = 0", new ClienteMapper());
		return c;
	}

	@Override
	public List<Cliente> selectAffidabili() {
		List<Cliente> c = template.query("select * from cliente where affidabile = 1", new ClienteMapper());
		return c;
	}

	@Override
	public void update(Cliente c) {
		template.update("update cliente set nome=?, cognome=?, tipologia=?, partitaIva=?, codiceFiscale=?, cellulare=?, telefonoFisso=?, email=?, password=?, attivo=?, affidabile=?, via=?, cap=?, comune=?, provincia=?, nazione=? where username=?",
		c.getNome(), c.getCognome(), c.getTipologia(), c.getPartitaIva(), c.getCodiceFiscale(), c.getCellulare(), c.getTelefonoFisso(),
				c.getEmail(), c.getPassword(), c.getAttivo(), c.getAffidabile(), c.getVia(), c.getCap(),
				c.getComune(), c.getProvincia(),  c.getNazione(),c.getUsername());
	}
	
	class ClienteMapper implements RowMapper<Cliente> {

		
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Cliente c = new Cliente();
			
			c.setUsername(rs.getString("username"));
			c.setNome(rs.getString("nome"));
			c.setCognome(rs.getString("cognome"));
			c.setTipologia(Tipologia.values()[rs.getInt("tipologia")]);
			c.setPartitaIva(rs.getString("partitaIva"));
			c.setCodiceFiscale(rs.getString("codiceFiscale"));
			c.setCellulare(rs.getString("cellulare"));
			c.setTelefonoFisso(rs.getString("telefonoFisso"));
			c.setEmail(rs.getString("email"));
			c.setPassword(rs.getString("password"));
			c.setAttivo(Attivo.values()[rs.getInt("attivo")]);
			c.setAffidabile(Affidabile.values()[rs.getInt("affidabile")]);
			c.setVia(rs.getString("via"));
			c.setCap(rs.getString("cap"));
			c.setComune(rs.getString("comune"));
			c.setProvincia(rs.getString("provincia"));
			c.setNazione(rs.getString("nazione"));
			
			return c;
		}

}
}
