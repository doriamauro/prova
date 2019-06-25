package bean;

public class Cliente {

	private String username; 
	private String password; 
	private String ragioneSociale;
	private Tipologia tipologia;
	private String partitaIva;
	private String codiceFiscale;
	private String nazione; 
	private String via; 
	private String cap; 
	private String comune; 
	private String provincia; 
	private String telefonoFisso; 
	private String cellulare; 
	private String email;
	private String indirizzoDiSpedizione; 
	private Attivo attivo; 
	private Admin admin; 
	private Affidabile affidabile;


	//prova Maurofh
//>>>>>>> branch 'master' of https://github.com/doriamauro/prova.git
	public Cliente() {
	}

	public Cliente(String username, String password, String email, String codiceFiscale, String partitaIva,
			Tipologia tipologia, String ragioneSociale, String cellulare, String telefonoFisso,
			String indirizzoDiSpedizione, String nazione, String via, String cap, String comune, String provincia,
			Attivo attivo, Admin admin, Affidabile affidabile) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.codiceFiscale = codiceFiscale;
		this.partitaIva = partitaIva;
		this.tipologia = tipologia;
		this.ragioneSociale = ragioneSociale;
		this.cellulare = cellulare;
		this.telefonoFisso = telefonoFisso;
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
		this.nazione = nazione;
		this.via = via;
		this.cap = cap;
		this.comune = comune;
		this.provincia = provincia;
		this.attivo = attivo;
		this.admin = admin;
		this.affidabile = affidabile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getTelefonoFisso() {
		return telefonoFisso;
	}

	public void setTelefonoFisso(String telefonoFisso) {
		this.telefonoFisso = telefonoFisso;
	}

	public String getIndirizzoDiSpedizione() {
		return indirizzoDiSpedizione;
	}

	public void setIndirizzoDiSpedizione(String indirizzoDiSpedizione) {
		this.indirizzoDiSpedizione = indirizzoDiSpedizione;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Attivo getAttivo() {
		return attivo;
	}

	public void setAttivo(Attivo attivo) {
		this.attivo = attivo;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Affidabile getAffidabile() {
		return affidabile;
	}

	public void setAffidabile(Affidabile affidabile) {
		this.affidabile = affidabile;
	}

	@Override
	public String toString() {
		return "Cliente [username=" + username + ", password=" + password + ", email=" + email + ", codiceFiscale="
				+ codiceFiscale + ", partitaIva=" + partitaIva + ", tipologia=" + tipologia + ", ragioneSociale="
				+ ragioneSociale + ", cellulare=" + cellulare + ", telefonoFisso=" + telefonoFisso
				+ ", indirizzoDiSpedizione=" + indirizzoDiSpedizione + ", nazione=" + nazione + ", via=" + via
				+ ", cap=" + cap + ", comune=" + comune + ", provincia=" + provincia + ", attivo=" + attivo + ", admin="
				+ admin + ", affidabile=" + affidabile + "]";
	}


}

enum Tipologia {

	PRIVATO,AZIENDA;

}

enum Admin {
	NO,SI;

}

enum Affidabile {
	NO,SI;

}

enum Attivo {
	NO,SI;

}




