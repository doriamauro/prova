package bean;

public class IndirizzoOrdine {
	
	private int idIndOrdine;
	private String via;
	private String comune;
	private String cap;
	private String provincia;
	private String nazione;
	
	public IndirizzoOrdine() {}

	public IndirizzoOrdine(int idIndOrdine, String via, String comune, String cap, String provincia,
			String nazione) {
		this.idIndOrdine = idIndOrdine;
		this.via = via;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
		this.nazione = nazione;
	}

	public int getIdIndOrdine() {
		return idIndOrdine;
	}

	public void setIdIndOrdine(int idIndOrdine) {
		this.idIndOrdine = idIndOrdine;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	@Override
	public String toString() {
		return "IndirizzoOrdine [idIndOrdine=" + idIndOrdine + ", via=" + via + ", comune=" + comune + ", cap=" + cap
				+ ", provincia=" + provincia + ", nazione=" + nazione + "]";
	}
	
}
