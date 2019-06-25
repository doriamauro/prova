package bean;

import java.sql.Date;

public class Ordine {
	 
	private String codOrdine;
	private String usOrdine; //username cliente nell'ordine
	private Date dataOrdine;
	private double prezzoFinale;
	private String idIndOrd; //indirizzo ordine
	private String idModPag;
	
	public Ordine() {}

	public Ordine(String codOrdine, String usOrdine, Date dataOrdine, double prezzoFinale, String idIndOrd,
			String idModPag) {
		this.codOrdine = codOrdine;
		this.usOrdine = usOrdine;
		this.dataOrdine = dataOrdine;
		this.prezzoFinale = prezzoFinale;
		this.idIndOrd = idIndOrd;
		this.idModPag = idModPag;
	}

	public String getCodOrdine() {
		return codOrdine;
	}

	public void setCodOrdine(String codOrdine) {
		this.codOrdine = codOrdine;
	}

	public String getUsOrdine() {
		return usOrdine;
	}

	public void setUsOrdine(String usOrdine) {
		this.usOrdine = usOrdine;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public double getPrezzoFinale() {
		return prezzoFinale;
	}

	public void setPrezzoFinale(double prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}

	public String getIdIndOrd() {
		return idIndOrd;
	}

	public void setIdIndOrd(String idIndOrd) {
		this.idIndOrd = idIndOrd;
	}

	public String getIdModPag() {
		return idModPag;
	}

	public void setIdModPag(String idModPag) {
		this.idModPag = idModPag;
	}

	@Override
	public String toString() {
		return "Ordine [codOrdine=" + codOrdine + ", usOrdine=" + usOrdine + ", dataOrdine=" + dataOrdine
				+ ", prezzoFinale=" + prezzoFinale + ", idIndOrd=" + idIndOrd + ", idModPag=" + idModPag + "]";
	}
	
}
