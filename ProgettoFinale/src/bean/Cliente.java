package bean;

public class Cliente {
	
	private String username; 
	private String nome;
	private String cognome;
	private Tipologia tipologia;
	private String partitaIva;
	private String codiceFiscale;
	private String cellulare; 
	private String telefonoFisso; 
	private String email;
	private String password; 
	private Attivo attivo; 
	private Admin admin; 
	private Affidabile affidabile;
	private String via; 
	private String cap; 
	private String comune; 
	private String provincia; 
	private String nazione; 
	
	public Cliente() {}
 //dsdfsfds
	public Cliente(String username, String nome, String cognome, Tipologia tipologia, String partitaIva,
			String codiceFiscale, String cellulare, String telefonoFisso, String email, String password, Attivo attivo,
			Admin admin, Affidabile affidabile, String via, String cap, String comune, String provincia,
			String nazione) {
		
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.tipologia = tipologia;
		this.partitaIva = partitaIva;
		this.codiceFiscale = codiceFiscale;
		this.cellulare = cellulare;
		this.telefonoFisso = telefonoFisso;
		this.email = email;
		this.password = password;
		this.attivo = attivo;
		this.admin = admin;
		this.affidabile = affidabile;
		this.via = via;
		this.cap = cap;
		this.comune = comune;
		this.provincia = provincia;
		this.nazione = nazione;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	@Override
	public String toString() {
		return "Cliente [username=" + username + ", nome=" + nome + ", cognome=" + cognome + ", tipologia=" + tipologia
				+ ", partitaIva=" + partitaIva + ", codiceFiscale=" + codiceFiscale + ", cellulare=" + cellulare
				+ ", telefonoFisso=" + telefonoFisso + ", email=" + email + ", password=" + password + ", attivo="
				+ attivo + ", admin=" + admin + ", affidabile=" + affidabile + ", via=" + via + ", cap=" + cap
				+ ", comune=" + comune + ", provincia=" + provincia + ", nazione=" + nazione + "]";
	}

}
