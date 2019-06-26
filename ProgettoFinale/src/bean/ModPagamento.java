package bean;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;


public class ModPagamento {
	@NotEmpty
	private int idMod;
	@NotEmpty
	private String modalita;
	
	public ModPagamento() {
	}

	public ModPagamento(int idMod, String modalita) {
		this.idMod = idMod;
		this.modalita = modalita;
	}

	public int getIdMod() {
		return idMod;
	}

	public void setIdMod(int idMod) {
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
