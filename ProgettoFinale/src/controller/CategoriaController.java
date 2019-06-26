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
import service.UtenteService;

@Controller
@RequestMapping("/cat")
public class CategoriaController { 


	
	@Autowired
	private CatalogoService service;
	
	
	@RequestMapping("/new")
	public String creaCategoria(Categoria c) {
		service.creaCategoria(c);
		return "gestioneCategorie";
		}

	
	@RequestMapping("/erase")
	public String eliminaCategoria(int idCategoria, ModelMap model) {
		boolean b= service.eliminaCategoria(idCategoria);
		if(b==false) {
			model.addAttribute("msg", "Eliminazione non riuscita");
			return "erroreGenerico";
		}
		else return "gestioneCategorie";
		
	}
	
	@RequestMapping("/rename")
	public String modificaNome(int idCategoria, String nome, ModelMap model) {
		boolean b=service.modificaNomeCategoria(idCategoria, nome);
		if(b==false) {
			model.addAttribute("msg", "Categoria non rinominata");
			return "erroreGenerico";
		}
		else return "gestioneCategorie";
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
	
	
}
