package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.DatiOrdine;
import bean.Prodotto;
import service.CarrelloService;

@Controller
@SessionAttributes("datiordine")
@RequestMapping("/carrello")
public class CarrelloController {

	private CarrelloService service;
	
	@RequestMapping("/add")
	@ResponseBody
//	public List<Prodotto> inserisciProdotto(@ModelAttribute("datiordine") DatiOrdine datOrd, int idProdotto, int quantita) {
//		datOrd.
//	}
	
//	public String annullaPagamento(@ModelAttribute("datiordine") DatiOrdine datOrd) {
//		
//	}
	
	@ModelAttribute("datiordine")
	public DatiOrdine getDatiOrdine(ModelMap map) {
		if (map.containsKey("datiordine"))
			return (DatiOrdine)map.get("datiordine");
		return new DatiOrdine();
	}
}
