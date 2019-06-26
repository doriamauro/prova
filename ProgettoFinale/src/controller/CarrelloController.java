package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bean.DatiOrdine;
import bean.IndirizzoOrdine;
import bean.Prodotto;
import exception.ProdottoNonTrovatoException;
import service.CarrelloService;
import service.ProdottoService;

@Controller
@SessionAttributes("datiordine")
@RequestMapping("/carrello")
public class CarrelloController {

	@Autowired
	private CarrelloService serviceCarrello;
	@Autowired
	private ProdottoService serviceProdotto;

	@GetMapping("/add")
	@ResponseBody
	public void inserisciProdotto(@ModelAttribute("datiordine") DatiOrdine datOrd, int idProdotto, int quantita) throws ProdottoNonTrovatoException {

		Prodotto p = serviceProdotto.getSchedaProdotto(idProdotto);

		p.setDisponibilita(quantita);
		datOrd.addProdotto(p);		
	}

	@GetMapping("/varia")
	@ResponseBody
	public boolean variaQuantita(@ModelAttribute("datiordine") DatiOrdine datOrd, int idProdotto, int quantita) throws ProdottoNonTrovatoException {

		datOrd.variaQuantita(idProdotto, quantita);
		return true;		
	}


	// questo metodo sarà lo stesso ad essere invocato quando si annulla il pagamento!
	@RequestMapping("/all")
	public ModelAndView getCarrello(@ModelAttribute("datiordine") DatiOrdine datOrd, ModelMap model) {
		System.out.println(datOrd);

		return new ModelAndView("carrello", "lista", datOrd.getProdotti());
	}

	@GetMapping("/remove")
	@ResponseBody
	public boolean rimuoviProdotto(@ModelAttribute("datiordine") DatiOrdine datOrd, int idProdotto) throws ProdottoNonTrovatoException {

		datOrd.removeProdotto(idProdotto);
		return true;
	}  

	@GetMapping("/modalita")
	public ModelAndView getModPagamento(@ModelAttribute("datiordine") DatiOrdine datOrd, ModelMap model, HttpSession session) {
		
		if ((Integer)session.getAttribute("affidabile")==0) {
			return new ModelAndView("erroreGenerico", "msg", "Impossibile procedere all'acquisto. Utente non affidabile!");
		}
		
		String username = (String)session.getAttribute("login");
		datOrd.setUsername(username);
		return new ModelAndView("informazioniPagamento", "modpagamento", serviceCarrello.getAllModPagamento());
	}
	
	@GetMapping("/scelta")
	public ModelAndView sceltaPagamento(@ModelAttribute("datiordine") DatiOrdine datOrd, int idMod) {
		
		datOrd.setModPag(serviceCarrello.getModPagamento(idMod));
		
		if (datOrd.getModPag().getIdMod()==5) {
			return new ModelAndView("rateizzazione", "rata", serviceCarrello.getDatiRate());
		} else if (datOrd.getModPag().getIdMod()==3) {
			return new ModelAndView("cartaDiCredito");	
		} else if (datOrd.getModPag().getIdMod()==1) {
			return new ModelAndView("riepilogo", "recap", datOrd);
		} else {
			return new ModelAndView("indirizzoSpedizione");
		}
		
	}
	
	// metodo che parte dopo che ho inserito i dati della carta 
	@GetMapping("/posta")
	public ModelAndView getCarta(HttpSession session, String numCarta) {
		
		session.setAttribute("numCarta", numCarta);
		return new ModelAndView("indirizzoSpedizione");
	} 
	
	@GetMapping("/riepilogo")
	public ModelAndView getRiepilogo(@ModelAttribute("datiordine") DatiOrdine datOrd,
			String via, String comune, String cap, String provincia, String nazione) {
		
		IndirizzoOrdine indirizzo = new IndirizzoOrdine(0, via, comune, cap, provincia, nazione);
		datOrd.setIndOrd(indirizzo);
		return new ModelAndView("riepilogo", "dati", datOrd);
		
	}

	@GetMapping("finalizza")
	
	public ModelAndView acquista(@ModelAttribute("datiordine") DatiOrdine datOrd) {
		
		serviceCarrello.finalizzaAcquisto(datOrd);
		return new ModelAndView("grazie");
				
	}

	@ModelAttribute("datiordine")
	public DatiOrdine getDatiOrdine(ModelMap map) {
		if (map.containsKey("datiordine"))
			return (DatiOrdine)map.get("datiordine");
		return new DatiOrdine();
	}
}
