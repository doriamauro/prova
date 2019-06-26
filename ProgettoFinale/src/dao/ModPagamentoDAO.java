package dao;

import java.util.List;

import bean.ModPagamento;

public interface ModPagamentoDAO {

	public void insert(ModPagamento modpag);
	public boolean delete(String idMod);
	public ModPagamento select(String idMod);

	public List<ModPagamento> selectAllModalita();

	public void update(ModPagamento modpag);
}
