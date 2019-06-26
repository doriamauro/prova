package bean;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Validated
public class Prodotto {
	
@NotEmpty
	private int idProdotto;
@NotEmpty
	private String descrizione;
@NotEmpty
	private String marca;
	private String codiceEAN;
	@NotEmpty
	private double prezzoUni;
	@NotEmpty
	private int disponibilita;
	
	private String linkProduttore;
	@NotEmpty
	private double costoSped;
	@NotEmpty
	private int tempoConsegna;
	@NotEmpty
	private String immaginePrimaria;
	
	private String immagineSec;
	@NotEmpty
	private int idCategoria;
	private int sconto;
	
	public Prodotto() {}
	
	

	public Prodotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public Prodotto(int idProdotto, String descrizione, String marca, String codiceEAN, double prezzoUni,
			int disponibilita, String linkProduttore, double costoSped, int tempoConsegna, String immaginePrimaria,
			String immagineSec, int idCategoria, int sconto) {
		this.idProdotto = idProdotto;
		this.descrizione = descrizione;
		this.marca = marca;
		this.codiceEAN = codiceEAN;
		this.prezzoUni = prezzoUni;
		this.disponibilita = disponibilita;
		this.linkProduttore = linkProduttore;
		this.costoSped = costoSped;
		this.tempoConsegna = tempoConsegna;
		this.immaginePrimaria = immaginePrimaria;
		this.immagineSec = immagineSec;
		this.idCategoria = idCategoria;
		this.sconto = sconto;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodiceEAN() {
		return codiceEAN;
	}

	public void setCodiceEAN(String codiceEAN) {
		this.codiceEAN = codiceEAN;
	}

	public double getPrezzoUni() {
		return prezzoUni;
	}

	public void setPrezzoUni(double prezzoUni) {
		this.prezzoUni = prezzoUni;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	public String getLinkProduttore() {
		return linkProduttore;
	}

	public void setLinkProduttore(String linkProduttore) {
		this.linkProduttore = linkProduttore;
	}

	public double getCostoSped() {
		return costoSped;
	}

	public void setCostoSped(double costoSped) {
		this.costoSped = costoSped;
	}

	public int getTempoConsegna() {
		return tempoConsegna;
	}

	public void setTempoConsegna(int tempoConsegna) {
		this.tempoConsegna = tempoConsegna;
	}

	public String getImmaginePrimaria() {
		return immaginePrimaria;
	}

	public void setImmaginePrimaria(String immaginePrimaria) {
		this.immaginePrimaria = immaginePrimaria;
	}

	public String getImmagineSec() {
		return immagineSec;
	}

	public void setImmagineSec(String immagineSec) {
		this.immagineSec = immagineSec;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	@Override
	public String toString() {
		return "Prodotto [idProdotto=" + idProdotto + ", descrizione=" + descrizione + ", marca=" + marca
				+ ", codiceEAN=" + codiceEAN + ", prezzoUni=" + prezzoUni + ", disponibilita=" + disponibilita
				+ ", linkProduttore=" + linkProduttore + ", costoSped=" + costoSped + ", tempoConsegna=" + tempoConsegna
				+ ", immaginePrimaria=" + immaginePrimaria + ", immagineSec=" + immagineSec + ", idCategoria="
				+ idCategoria + ", sconto=" + sconto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProdotto;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (idProdotto != other.idProdotto)
			return false;
		return true;
	}	
}
