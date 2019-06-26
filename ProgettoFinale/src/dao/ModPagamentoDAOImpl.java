package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import bean.ModPagamento;

@Repository
public class ModPagamentoDAOImpl implements ModPagamentoDAO {

	@Autowired
	private JdbcTemplate template;

	@Override
	public void insert(ModPagamento modpag) {
		template.update("insert into modpagamento values(?,?)", modpag.getIdMod(),modpag.getModalita());
	}

	@Override
	public boolean delete(int idMod) {
		int n = template.update("delete from modpagamento where idmod = ?", idMod);
		return n==1;
	}

	@Override
	public ModPagamento select(int idMod) {
		ModPagamentoMapper modPag = new ModPagamentoMapper();

		return template.queryForObject("select * from modpagamento where idmod = ?", modPag, idMod);
	}

	@Override
	public List<ModPagamento> selectAllDatiRate() {
		return template.query("select * from modpagamento", new ModPagamentoMapper());
	}

	@Override
	public List<ModPagamento> selectAllDatiRate(String where) {
		if (where==null || where==" ")
			return this.selectAllDatiRate();
		return template.query("select * from modpagamento " + where, new ModPagamentoMapper());
	}

	@Override
	public void update(ModPagamento modpag) {
		template.update("update prodotto set modalita = ? where  idmod = ?", modpag.getModalita(),modpag.getIdMod());

	}

}

class ModPagamentoMapper implements RowMapper<ModPagamento>{

	@Override
	public ModPagamento mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModPagamento mod = new ModPagamento();

		mod.setIdMod(rs.getInt("idmod"));
		mod.setModalita(rs.getString("modalita"));

		return mod;

	}

}

