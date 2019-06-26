package bean;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;
@Validated
public class Ordine {
	@NotEmpty
	private int codOrdine;
	@NotEmpty
	private String usOrdine; //username cliente nell'ordine
	@NotEmpty
	private Date dataOrdine;
	@NotEmpty
	private double prezzoFinale;
	@NotEmpty
	private int idIndOrd; //indirizzo ordine
	@NotEmpty
	private int idModPag;
	
	public Ordine() {}

	public Ordine( int codOrdine, String usOrdine, Date dataOrdine, double prezzoFinale,  int idIndOrd,
			 int idModPag) {
		this.codOrdine = codOrdine;
		this.usOrdine = usOrdine;
		this.dataOrdine = dataOrdine;
		this.prezzoFinale = prezzoFinale;
		this.idIndOrd = idIndOrd;
		this.idModPag = idModPag;
	}

	public  int getCodOrdine() {
		return codOrdine;
	}

	public void setCodOrdine( int codOrdine) {
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

	public int getIdIndOrd() {
		return idIndOrd;
	}

	public void setIdIndOrd(int idIndOrd) {
		this.idIndOrd = idIndOrd;
	}

	public  int getIdModPag() {
		return idModPag;
	}

	public void setIdModPag( int idModPag) {
		this.idModPag = idModPag;
	}

	@Override
	public String toString() {
		return "Ordine [codOrdine=" + codOrdine + ", usOrdine=" + usOrdine + ", dataOrdine=" + dataOrdine
				+ ", prezzoFinale=" + prezzoFinale + ", idIndOrd=" + idIndOrd + ", idModPag=" + idModPag + "]";
	}
	
}
