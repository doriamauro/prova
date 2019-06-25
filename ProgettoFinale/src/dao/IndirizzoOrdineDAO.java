package dao;

import java.util.List;

import bean.IndirizzoOrdine;

public interface IndirizzoOrdineDAO {

	public void insert(IndirizzoOrdine indord);
	public boolean delete(String idIndOrdine);
	public IndirizzoOrdine select(String idIndOrdine);

	public List<IndirizzoOrdine> selectAllDatiRate();
	public List<IndirizzoOrdine> selectAllDatiRate(String where);

	public void update(IndirizzoOrdine indord);
}