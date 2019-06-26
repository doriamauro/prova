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

import bean.DatiOrdine;
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
	public List<Prodotto> inserisciProdotto(@ModelAttribute("datiordine") DatiOrdine datOrd, int idProdotto, int quantita) throws ProdottoNonTrovatoException {

		Prodotto p = serviceProdotto.getSchedaProdotto(idProdotto);

		p.setDisponibilita(quantita);
		datOrd.addProdotto(p);
		return datOrd.getProdotti();		
	}

	// questo metodo sarà lo stesso ad essere invocato quando si annulla il pagamento!
	@RequestMapping("/all")
	public String getCarrello(@ModelAttribute("datiordine") DatiOrdine datOrd, ModelMap model) {

		model.addAttribute("listaInCarrello", datOrd.getProdotti());
		return "Carrello";
	}

	@GetMapping("/remove")
	@ResponseBody
	public List<Prodotto> rimuoviProdotto(@ModelAttribute("datiordine") DatiOrdine datOrd, int idProdotto) throws ProdottoNonTrovatoException {

		datOrd.removeProdotto(idProdotto);
		return datOrd.getProdotti();

	}  

	





	@ModelAttribute("datiordine")
	public DatiOrdine getDatiOrdine(ModelMap map) {
		if (map.containsKey("datiordine"))
			return (DatiOrdine)map.get("datiordine");
		return new DatiOrdine();
	}
}
