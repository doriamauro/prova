package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Categoria;
import bean.Cliente;
import bean.Ordine;
import service.UtenteService;
// ciao
@Controller
@RequestMapping("/admin")
public class AdminUtenteController {
	  
	@Autowired
	private UtenteService service;
	
	@RequestMapping("/vedi")
	public String visualizzaClienti() {
		service.visualizzaClienti();
		return "gestioneUtenti";
		}
	
	@RequestMapping("/view")
	public ModelAndView visualizzaLista() {
		try {
			List<Cliente> c = service.visualizzaClienti();
			return new ModelAndView("gestioneUtenti", "c", c);
		} catch (Exception e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	@RequestMapping("/inaffidabili")
	public ModelAndView visualizzaInaffidabili(String username) {
		try {
			List<Cliente> c = service.visualizzaClientiInaffidabili();
			return new ModelAndView("gestioneUtenti", "c", c);
		} catch (Exception e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	@RequestMapping("/affidabili")
	public ModelAndView visualizzaAffidabili(String username) {
		try {
			List<Cliente> c = service.visualizzaClientiAffidabili();
			return new ModelAndView("gestioneUtenti", "c", c);
		} catch (Exception e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	@RequestMapping("/modifica")
	public ModelAndView modifica(Cliente c) {
		try {
			service.modificaDatiCliente(c);
			return new ModelAndView("datiUtente", "c",c);
		} catch (Exception e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	//	metodo che restituisce tutti gli ordini

	@RequestMapping("/visDatiCliente")
	public ModelAndView modificaDati(String username) {
		try {
			Cliente c = service.visualizzaDatiCliente(username);
			return new ModelAndView("datiUtente", "c", c);
			
		} catch (Exception e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}



	// nuova fabio e gianluca
	@RequestMapping("/visualizzaTuttiOrdini")
	public ModelAndView visualizzaTuttiOrdini() {
		try {
			List<Ordine> listaOrdini = service.visualizzaTuttiGliOrdini();
			return new ModelAndView("listaOrdini", "lista", listaOrdini);
		} catch (Exception e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	
	

}
