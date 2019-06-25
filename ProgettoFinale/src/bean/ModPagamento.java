package bean;

public class ModPagamento {
	
	private String idMod;
	private String modalita;
	 
	public ModPagamento() {
	}

	public ModPagamento(String idMod, String modalita) {
		this.idMod = idMod;
		this.modalita = modalita;
	}

	public String getIdMod() {
		return idMod;
	}

	public void setIdMod(String idMod) {
		this.idMod = idMod;
	}

	public String getModalita() {
		return modalita;
	}

	public void setModalita(String modalita) {
		this.modalita = modalita;
	}

	@Override
	public String toString() {
		return "ModPagamento [idMod=" + idMod + ", modalita=" + modalita + "]";
	}
		
}
