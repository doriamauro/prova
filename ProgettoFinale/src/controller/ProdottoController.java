package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Categoria;
import bean.DatiRate;
import bean.Prodotto;
import exception.CategoriaException;
import service.CatalogoService;
import service.ProdottoService;
import service.UtenteService;

@Controller
@RequestMapping("/prod")
public class ProdottoController {

	@Autowired
	private ProdottoService service;
	
	@RequestMapping("/eraseProd")
	public String eliminaProdotto(int idProdotto, ModelMap model) {
		boolean b=service.eliminaProdotto(idProdotto);
		if(b==false) {
			model.addAttribute("msg", "Prodotto non eliminato");
			return "erroreGenerico";
		}
		else return "listaProdotti";
	}
	
	@RequestMapping("/editProd")
	public String modificaProd(Prodotto p, ModelMap model) {
		boolean b= service.modificaSchedaProdotto(p);
		if(b==false) {
			model.addAttribute("msg", "Prodotto non modificato");
			return "erroreGenerico";
		}
		else return "dettagliProdotto";
	}
}
