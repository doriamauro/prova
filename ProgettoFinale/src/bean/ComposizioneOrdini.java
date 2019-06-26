package bean;

public class ComposizioneOrdini {
	//
	private int quantita;
	private int idProdotto;
	private int idOrdine;
	
	public ComposizioneOrdini() {}

	public ComposizioneOrdini(int quantita, int idProdotto, int idOrdine) {
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

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	@Override
	public String toString() {
		return "ComposizioneOrdini [quantita=" + quantita + ", idProdotto=" + idProdotto + ", idOrdine=" + idOrdine
				+ "]";
	}
	
}
