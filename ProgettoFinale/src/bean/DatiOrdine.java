package bean;

import java.util.ArrayList;

public class DatiOrdine {
	
	private ArrayList<Prodotto> prodotti;
	private String username;
	private ModPagamento modPag;
	private IndirizzoOrdine indOrd;
	
	public DatiOrdine() {
	}

	public DatiOrdine(ArrayList<Prodotto> prodotti, String username, ModPagamento modPag, IndirizzoOrdine indOrd) {
		this.prodotti = prodotti;
		this.username = username;
		this.modPag = modPag;
		this.indOrd = indOrd;
	}

	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ModPagamento getModPag() {
		return modPag;
	}

	public void setModPag(ModPagamento modPag) {
		this.modPag = modPag;
	}

	public IndirizzoOrdine getIndOrd() {
		return indOrd;
	}

	public void setIndOrd(IndirizzoOrdine indOrd) {
		this.indOrd = indOrd;
	}

	@Override
	public String toString() {
		return "DatiOrdine [prodotti=" + prodotti + ", username=" + username + ", modPag=" + modPag + ", indOrd="
				+ indOrd + "]";
	}
		
}
