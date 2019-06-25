package dao;

import java.util.List;

import bean.ComposizioneOrdini;

public interface ComposizioneOrdiniDAO {
	
	public void insert(ComposizioneOrdini com);
	public boolean delete(String idOrdine, String idProdotto);
	public ComposizioneOrdini select(String idOrdine, String idProdotto);
	public List<ComposizioneOrdini> selectAllOrdini();
	public List<ComposizioneOrdini> selectAllOrdini(String where);
	public void update(ComposizioneOrdini com);
	
}
