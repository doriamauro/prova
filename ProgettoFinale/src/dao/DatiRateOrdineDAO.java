package dao;

import java.util.List;

import bean.DatiRateOrdine;

public interface DatiRateOrdineDAO {
	
	public void insert(DatiRateOrdine dro);
	public boolean delete(String idOrd);
	public DatiRateOrdine select(String idOrd);
	
	public List<DatiRateOrdine> selectAllDatiRate();
	public List<DatiRateOrdine> selectAllDatiRate(String where);
	
	public void update(DatiRateOrdine dro);
	
}
