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
import exception.ProdottoNonTrovatoException;
import service.CatalogoService;
import service.ProdottoService;
import service.UtenteService;

@Controller
@RequestMapping("/prod")
public class ProdottoController {
//
	@Autowired 
	private ProdottoService service;
	
	@RequestMapping("/list")
	public ModelAndView visualizzaProdotti(int idCategoria) {
		List<Prodotto> prodotti= service.getProdotti(idCategoria);
		return new ModelAndView("listaProdotti", "prodotti", prodotti);
	}
	
	@RequestMapping("/search")
	public ModelAndView ricercaProdotti(String ricerca) {
		List<Prodotto> prodotti= service.ricercaProdotti(ricerca);
		return new ModelAndView("listaProdotti", "prodotti", prodotti);
	}
	
	@RequestMapping("/searchMarca")
	public ModelAndView ricercaProdottiPerMarca(String marca) {
		List<Prodotto> prodotti= service.ricercaProdottiPerMarca(marca);
		return new ModelAndView("listaProdotti", "prodotti", prodotti);
	}
	
	@RequestMapping("/searchPrice")
	public ModelAndView ricercaProdottiPerPrezzo(double min, double max) {
		List<Prodotto> prodotti= service.ricercaProdottiPerPrezzoUnitario(min, max);
		return new ModelAndView("listaProdotti", "prodotti", prodotti);
	}
	
	@RequestMapping("/search")
	public ModelAndView ricercaProdottiScontati() {
		List<Prodotto> prodotti= service.ricercaProdottiScontati();
		return new ModelAndView("listaProdotti", "prodotti", prodotti);
	}
	
	@RequestMapping("/scheda")
	public ModelAndView schedaProdotto(int idProdotto) {
		Prodotto p;
		try {
			p = service.getSchedaProdotto(idProdotto);
			return new ModelAndView("dettagliProdotto", "prodotto", p);
		} catch (ProdottoNonTrovatoException e) {
			return new ModelAndView("erroreGenerico", "msg", e);
		}
	}
	
	@RequestMapping("/eraseProd")
	public ModelAndView eliminaProdotto(int idProdotto, ModelMap model) {
		List<Prodotto> prodotti= service.ricercaProdottiScontati();
		boolean b=service.eliminaProdotto(idProdotto);
		if(b==false) {
			model.addAttribute("msg", "Prodotto non eliminato");
			return new ModelAndView("erroreGenerico");
		}
		else return new ModelAndView("listaProdotti", "prodotti", prodotti);
	}
	
	@RequestMapping("/editProd")
	public ModelAndView modificaProd(Prodotto p, ModelMap model) {
		boolean b= service.modificaSchedaProdotto(p);
		if(b==false) {
			model.addAttribute("msg", "Prodotto non modificato");
			return new ModelAndView("erroreGenerico");
		}
		else return new ModelAndView("dettagliProdotto", "prodotto", p);
	}
	
}
