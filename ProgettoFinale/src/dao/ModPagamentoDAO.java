package dao;
////
import java.util.List;

import bean.ModPagamento;

public interface ModPagamentoDAO {

	public void insert(ModPagamento modpag);
	public boolean delete(int idMod);
	public ModPagamento select(int idMod);

	public List<ModPagamento> selectAllModalita();
	public List<ModPagamento> selectAllModalita(String where);

	public void update(ModPagamento modpag);
}
