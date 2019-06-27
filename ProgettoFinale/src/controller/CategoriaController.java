package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Categoria;
import bean.DatiRate;
import bean.Prodotto;
import exception.CategoriaException;
import service.CatalogoService;
import service.UtenteService;

@Controller
@RequestMapping("/cat")
public class CategoriaController { 


	
	@Autowired
	private CatalogoService service;
	  
	
	
	@RequestMapping("/new")
	public ModelAndView creaCategoria(Categoria c) {
		service.creaCategoria(c);
		
		
		return visualizzaCategorie();
		}
	
	@RequestMapping("/rename")
	public ModelAndView modificaNome( int idCat, String nomeCat, ModelMap model) {
		boolean b=service.modificaNomeCategoria(idCat, nomeCat);
		if(b==false) 
			return new ModelAndView("erroreGenerico", "msg", "Categoria non rinominata");
		else {
			ModelAndView m = new ModelAndView("gestioneCategorie");
			m.addObject("categorie", service.getCategorie());
			m.addObject("modifica", true);
			return m;
		}
			
		
	}
	
	@RequestMapping("/list")
	public ModelAndView visualizzaCategorie() {
		List<Categoria> categorie= service.getCategorie();
		return new ModelAndView("gestioneCategorie", "categorie", categorie);
		
	}
	
	@RequestMapping("/addProd")
	public String aggiungiProdACat(int idCategoria, Prodotto p,  ModelMap model) {
		try {
			service.addProdottoCategoria(idCategoria, p);
			return "dettagliProdotto";
			
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "erroreGenerico";
			
		}
		
	}
	
	@RequestMapping("/empty")
	public String svuotaCategoria(int idCategoria,ModelMap model) {
		boolean b=service.svuotaCategoria(idCategoria);
		if(b==false) {
			model.addAttribute("msg", "Categoria non svuotata");
			return "erroreGenerico";
		}
		else return "gestioneCategorie";
	}
	
	@RequestMapping("/modRate")
	public String modificaRate(DatiRate dr){
		service.modificaDatiRateizzazione(dr);
		return "datiRate";
	}
	
	@RequestMapping("/pageCreaProd")
	public String paginaCreaProdotto() {
		return "dettagliProdotto";
	}
	
	@RequestMapping("/pageRate")
	public String paginaRate() {
		return "datiRate";
	}
	
	@ModelAttribute("cat")
	public Categoria start() {
		return new Categoria();
	}
}
