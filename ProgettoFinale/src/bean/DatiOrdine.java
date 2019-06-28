package bean;

import java.util.ArrayList;
import java.util.List;

import service.ProdottoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import service.ProdottoService;

public class DatiOrdine {
 
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
	private String username;
	private ModPagamento modPag;
	private IndirizzoOrdine indOrd;
	private String numCarta;
	
	public DatiOrdine() {}

	

	
	public DatiOrdine(ArrayList<Prodotto> prodotti, String username, ModPagamento modPag, IndirizzoOrdine indOrd,
			String numCarta) {
		this.prodotti = prodotti;
		this.username = username;
		this.modPag = modPag;
		this.indOrd = indOrd;
		this.numCarta = numCarta;
	}




	public String getNumCarta() {
		return numCarta;
	}




	public void setNumCarta(String numCarta) {
		this.numCarta = numCarta;
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
				this.variaQuantita(p.getIdProdotto(),p.getDisponibilita());
				return;
			}
		}
		this.prodotti.add(p);
	}
	
	public Prodotto removeProdotto(int idProdotto) {
		
		int index = this.prodotti.indexOf(new Prodotto(idProdotto));
		return this.prodotti.remove(index);
	}  

	public double calcolaTotale() {
		double costoSing = 0;
		double costoTot = 0;
		double speseSped = 0;

		for (Prodotto p: prodotti) {

			costoSing = p.getPrezzoUni() - (p.getPrezzoUni()*(p.getSconto()/100.0));
			costoTot += costoSing*p.getDisponibilita();
			speseSped += p.getCostoSped();
		}
		if (costoTot<20){
			costoTot += speseSped;
		} else if (costoTot>=20 && costoTot<100) {
			costoTot += 10;
		}
		return costoTot;
	}
	
	public double calcoloPrezzoSingolo(Prodotto p) {
		double costoSing = p.getPrezzoUni() - (p.getPrezzoUni()*(p.getSconto()/100.0));
		double costoTot = costoSing*p.getDisponibilita();
		return costoTot;
	}
	
	public void variaQuantita(int idProdotto, int quantita) {
		int index = this.prodotti.indexOf(new Prodotto(idProdotto));
		if (index != -1) {
			this.prodotti.get(index).setDisponibilita(this.prodotti.get(index).getDisponibilita() + quantita);

			if (this.prodotti.get(index).getDisponibilita()<=0) {
				this.prodotti.remove(index);
			}
		}
	}




	@Override
	public String toString() {
		return "DatiOrdine [prodotti=" + prodotti + ", username=" + username + ", modPag=" + modPag + ", indOrd="
				+ indOrd + ", numCarta=" + numCarta + "]";
	}

	



}
