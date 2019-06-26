package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.DatiRate;
import dao.DatiRateMapper;
////
@Repository
@Transactional
public class DatiRateDAOImpl implements DatiRateDAO {
 
	
	@Autowired
	private JdbcTemplate template;


	public DatiRate selectRate() {
		List<DatiRate> dr =  template.query("select * from datiRate",new DatiRateMapper());
        if(dr.size()==0)
        	return null;
        return dr.get(0);
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

