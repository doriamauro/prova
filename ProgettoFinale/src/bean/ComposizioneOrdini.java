package bean;

public class ComposizioneOrdini {
	
	private int quantita;
	private String idProdotto;
	private String idOrdine;
	
	public ComposizioneOrdini() {}

	public ComposizioneOrdini(int quantita, String idProdotto, String idOrdine) {
		this.quantita = quantita;
		this.idProdotto = idProdotto;
		this.idOrdine = idOrdine;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(String idOrdine) {
		this.idOrdine = idOrdine;
	}

	@Override
	public String toString() {
		return "ComposizioneOrdini [quantita=" + quantita + ", idProdotto=" + idProdotto + ", idOrdine=" + idOrdine
				+ "]";
	}
	
}
