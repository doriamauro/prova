package dao;

import java.util.List;

import bean.DatiRateOrdine;

public interface DatiRateOrdineDAO {
	
	public void insert(DatiRateOrdine dro);
	public boolean delete(int idOrd);
	public DatiRateOrdine select(int idOrd);
	
	public List<DatiRateOrdine> selectAllDatiRate();
	public List<DatiRateOrdine> selectAllDatiRate(String where);
	
	public void update(DatiRateOrdine dro);
	
}
