package bean;

import java.util.ArrayList;

public class Carrello {
	
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
	private int quantita;
	 
	public Carrello() {
	}

	public Carrello(ArrayList<Prodotto> prodotti, int quantita) {
		this.prodotti = prodotti;
		this.quantita = quantita;
	}

	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Carrello [prodotti=" + prodotti + ", quantita=" + quantita + "]";
	}
	
}
