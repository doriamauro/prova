package bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import service.ProdottoService;

public class DatiOrdine {
	
	private ArrayList<Prodotto> prodotti;
	private String username;
	private ModPagamento modPag;
	private IndirizzoOrdine indOrd;
	private String scelta;
	 
	@Autowired
	private ProdottoService serviceP;
	

	
	public DatiOrdine() {}

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
	
	public void addProdotto(Prodotto p) {
		for (Prodotto pList : this.prodotti) {
			if (p.getIdProdotto()==pList.getIdProdotto()) {
				pList.setDisponibilita(pList.getDisponibilita()+p.getDisponibilita());
				return;
			}
		}
		this.prodotti.add(p);
	}
	
	public Prodotto removeProdotto(Prodotto p) {
		for (Prodotto pList : this.prodotti) {
			if (p.getIdProdotto()==pList.getIdProdotto()) {
				this.prodotti.remove(p);
				return p;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "DatiOrdine [prodotti=" + prodotti + ", username=" + username + ", modPag=" + modPag + ", indOrd="
				+ indOrd + "]";
	}
		
}
