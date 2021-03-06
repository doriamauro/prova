package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	//@RequestMapping(value="/list/{idCategoria}", method = RequestMethod.GET)// params = "categorie= {idCategoria}")
@RequestMapping(value="/list", method = RequestMethod.GET)
	//@ResponseBody
	//public @ResponseBody ModelAndView visualizzaProdotti(@PathVariable(value = "idCategoria") int idCategoria) {
	public ModelAndView visualizzaProdotti(@RequestParam(value = "menuCategorie") int idCategoria) {
		List<Prodotto> prodotti= service.getProdotti(idCategoria);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}//
	//
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public ModelAndView ricercaProdotti(@RequestParam(value="cerca") String ricerca) {
		List<Prodotto> prodotti= service.ricercaSpecificaProdotti(ricerca);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	@RequestMapping(value = "/searchMarca", method = RequestMethod.GET)
	public ModelAndView ricercaProdottiPerMarca(@RequestParam(value = "marca") String marca) {
		List<Prodotto> prodotti= service.ricercaProdottiPerMarca(marca);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	
	@RequestMapping(value ="/searchPrice/menuCategorie",method = RequestMethod.POST)
	public ModelAndView ricercaProdottiPerPrezzo_Categorie(double min, double max, @RequestParam(value="menuCategorie") int menuCategorie) {
		List<Prodotto> prodotti1= service.ricercaProdottiPerPrezzoUnitario(min, max);
		List<Prodotto> prodotti3= service.ricercaProdotti("");
		prodotti3.removeAll(prodotti1);
		List<Prodotto> prodotti= service.getProdotti(menuCategorie);
		prodotti.removeAll(prodotti3);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	
	@RequestMapping(value ="/searchPrice/*/menuCategorie",method = RequestMethod.POST)
	public ModelAndView ricercaProdottiPerPrezzo_Categorie2(double min, double max, @RequestParam(value="menuCategorie") int menuCategorie) {
		List<Prodotto> prodotti1= service.ricercaProdottiPerPrezzoUnitario(min, max);
		List<Prodotto> prodotti3= service.ricercaProdotti("");
		prodotti3.removeAll(prodotti1);
		List<Prodotto> prodotti= service.getProdotti(menuCategorie);
		prodotti.removeAll(prodotti3);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	@RequestMapping(value ="/searchPrice/*/cerca",method = RequestMethod.POST)
	public ModelAndView ricercaProdottiPerPrezzo_cerca(double min, double max, @RequestParam(value="cerca") String cerca) {
List<Prodotto> prodotti1= service.ricercaProdottiPerPrezzoUnitario(min, max);
	List<Prodotto> prodotti3= service.ricercaProdotti("");
	prodotti3.removeAll(prodotti1);
	List<Prodotto> prodotti= service.ricercaSpecificaProdotti(cerca);
	prodotti.removeAll(prodotti3);
		return new ModelAndView("listaProdotti", "lista", prodotti);}
	
	@RequestMapping(value ="/searchPrice/cerca",method = RequestMethod.POST)
	public ModelAndView ricercaProdottiPerPrezzo_cerca2(double min, double max, @RequestParam(value="cerca") String cerca) {
List<Prodotto> prodotti1= service.ricercaProdottiPerPrezzoUnitario(min, max);
	List<Prodotto> prodotti3= service.ricercaProdotti("");
	prodotti3.removeAll(prodotti1);
	List<Prodotto> prodotti= service.ricercaSpecificaProdotti(cerca);
	prodotti.removeAll(prodotti3);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	@RequestMapping(value="/searchPrice/marca", method = RequestMethod.POST)
	public ModelAndView ricercaProdottiPerPrezzo_Marca(double min, double max, @RequestParam(value="marca") String marca) {
List<Prodotto> prodotti1= service.ricercaProdottiPerPrezzoUnitario(min, max);
	List<Prodotto> prodotti3= service.ricercaProdotti("");
	prodotti3.removeAll(prodotti1);
	List<Prodotto> prodotti= service.ricercaProdottiPerMarca(marca);
	prodotti.removeAll(prodotti3);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	@RequestMapping(value="/searchPrice/*/marca", method = RequestMethod.POST)
	public ModelAndView ricercaProdottiPerPrezzo_Marca2(double min, double max, @RequestParam(value="marca") String marca) {
List<Prodotto> prodotti1= service.ricercaProdottiPerPrezzoUnitario(min, max);
	List<Prodotto> prodotti3= service.ricercaProdotti("");
	prodotti3.removeAll(prodotti1);
	List<Prodotto> prodotti= service.ricercaProdottiPerMarca(marca);
	prodotti.removeAll(prodotti3);
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	
	@RequestMapping("/searchSconto")
	public ModelAndView ricercaProdottiScontati() {
		List<Prodotto> prodotti= service.ricercaProdottiScontati();
		return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	@RequestMapping(value="/scheda",method = RequestMethod.GET)
	public ModelAndView schedaProdotto(@RequestParam(value="idProdotto") int idProdotto) {
		Prodotto p;
		try {
			p = service.getSchedaProdotto(idProdotto);
			return new ModelAndView("dettagliProdotto", "prodotto", p);
		} catch (ProdottoNonTrovatoException e) {
			return new ModelAndView("erroreGenerico", "msg", e);
		}
	}
//	@RequestMapping("/dettagliProdotto")
//	public ModelAndView getDettagliProdotto(int idProdotto) {
//		return new ModelAndView("dettagliProdotto");
//	}
	@RequestMapping("/eraseProd")
	public ModelAndView eliminaProdotto(int idProdotto, ModelMap model) {
		List<Prodotto> prodotti= service.ricercaProdottiScontati();
		boolean b=service.eliminaProdotto(idProdotto);
		if(b==false) {
			model.addAttribute("msg", "Prodotto non eliminato");
			return new ModelAndView("erroreGenerico");
		}
		else return new ModelAndView("listaProdotti", "lista", prodotti);
	}
	
	
//	metodo di modifica prodotto solo per admin
	@RequestMapping("/editProd")
	public ModelAndView modificaProd(Prodotto p, ModelMap model) {
		boolean b= service.modificaSchedaProdotto(p);
		if(b==false) {
			model.addAttribute("msg", "Prodotto non modificato");
			return new ModelAndView("erroreGenerico");
		}
		else {
			ModelAndView m = new ModelAndView("dettagliProdotto");
			try {
				m.addObject("prodotto", service.getSchedaProdotto(p.getIdProdotto()));
				m.addObject("modifica", true);
				return m;
			} catch (ProdottoNonTrovatoException e) {
				model.addAttribute("msg", "Prodotto non trovato");
				return new ModelAndView("erroreGenerico");
			}
			
		}
	}
	
}
