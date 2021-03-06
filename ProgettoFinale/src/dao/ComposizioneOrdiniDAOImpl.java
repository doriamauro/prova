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
import bean.ComposizioneOrdini;
////
@Repository
@Transactional
public class ComposizioneOrdiniDAOImpl implements ComposizioneOrdiniDAO{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insert(ComposizioneOrdini com) {
		template.update("insert into composizioneOrdini values(?,?,?)",com.getQuantita(),com.getIdOrdine(),com.getIdProdotto());
	}

	@Override
	public boolean delete(int idOrdine, int idProdotto) {
		int n = template.update("delete from composizioneOrdini where idOrdine=? and idProdotto=?", idOrdine,idProdotto);
		return n==1;
		
	}

	@Override
	public ComposizioneOrdini select(int idOrdine, int idProdotto) {
		ComposizioneOrdini com = template.queryForObject("select * from composizioneOrdini where idOrdine=? and idProdotto=?", new ComposizioneOrdiniMapper(), idOrdine, idProdotto);
		return com;
	}

	@Override
	public List<ComposizioneOrdini> selectAllOrdini() {
		List<ComposizioneOrdini> listaOrdini= template.query("select * from composizioneOrdini", new ComposizioneOrdiniMapper());
		return listaOrdini;
	}

	@Override
	public List<ComposizioneOrdini> selectAllOrdini(String where) {
		List<ComposizioneOrdini> listaOrdini= template.query("select * from composizioneOrdini "+where, new ComposizioneOrdiniMapper());
		return listaOrdini;
	}

	@Override
	public void update(ComposizioneOrdini com) {
		template.update("update ComposizioneOrdini set quantita=? where idOrdine=? and idProdotto=?",com.getQuantita(),
																			  				         com.getIdOrdine(),
																			  				         com.getIdProdotto());
		
	}

}




class ComposizioneOrdiniMapper implements RowMapper<ComposizioneOrdini> {

	@Override
	public ComposizioneOrdini mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ComposizioneOrdini com = new ComposizioneOrdini();
		
		com.setIdOrdine(rs.getInt("idOrdine"));
		com.setIdProdotto(rs.getInt("idProdotto"));
		com.setQuantita(rs.getInt("quantita"));
				
		return com;
	}
}
