package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.DatiRate;

public class DatiRateDAOImpl implements DatiRateDAO {
 
	
	@Autowired
	private JdbcTemplate template;


	public DatiRate selectRate() {
		return template.queryForObject("select * from datiRate",new DatiRateMapper());

	}


	public void updateRate(DatiRate dr) {
		template.update("update datiRate set tan=?, maxTaeg=?, nRate=?", 
				dr.getTan(), dr.getMaxTaeg(), dr.getnRate());

	}


}


class DatiRateMapper implements RowMapper<DatiRate>{	

	@Override
	public DatiRate mapRow(ResultSet rs, int rowNum) throws SQLException {
		DatiRate dr= new DatiRate();  
		dr.setTan(rs.getDouble("Tan"));
		dr.setMaxTaeg(rs.getDouble("maxTaeg"));
		dr.setnRate(rs.getInt("nRate"));
		return dr;
	}

}

