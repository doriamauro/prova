package controller;

//ciao
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Admin;
import bean.Attivo;
import bean.Categoria;
import bean.Cliente;
import bean.Ordine;
import bean.Prodotto;
import exception.ClienteException;
import service.ClienteService;
import service.ProdottoService;
import service.UtenteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {


	
	@Autowired
	private ProdottoService serviceP; 	
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private UtenteService serviceA;
	


	@RequestMapping("/registrazioneCliente")
	public ModelAndView registraCliente(Cliente c) {
		try {
			service.registraCliente(c);
			return new ModelAndView("home");
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	@RequestMapping("/invioRegistrazione")
	public ModelAndView invioRegistrazione() {
		return new ModelAndView("registrazione");
	}

	@RequestMapping("/loginCliente")
	public ModelAndView logCliente(String username, String password, HttpSession session) {		
		Cliente c = service.getCliente(username);
		try {
			if (service.checkCredenziali(username, password)) {
				if (c.getAttivo().equals(Attivo.SI) && c.getAdmin().equals(Admin.NO)) {
					session.setAttribute("login", username);
					session.setAttribute("admin", c.getAdmin().ordinal());
					session.setAttribute("affidabile",c.getAffidabile().ordinal());
					session.setMaxInactiveInterval(0);
					
					List<Prodotto> prodotti= serviceP.ricercaProdottiScontati();
					List<String> marche= serviceP.getMarche();
					List<Categoria> categorie = serviceP.getCategorie();
					ModelAndView mav= new ModelAndView("home");
					mav.addObject("prodotti", prodotti);
					mav.addObject("marche", marche);
					mav.addObject("categorie", categorie);
					return mav;
				}
				else if (c.getAttivo().equals(Attivo.SI) && c.getAdmin().equals(Admin.SI)){
					session.setAttribute("login", username);
					session.setAttribute("admin", c.getAdmin().ordinal());
					session.setAttribute("affidabile",c.getAffidabile().ordinal());
					session.setMaxInactiveInterval(0);
					List<Prodotto> prodotti= serviceP.ricercaProdottiScontati();
					List<String> marche= serviceP.getMarche();
					List<Categoria> categorie = serviceP.getCategorie();
					ModelAndView mav= new ModelAndView("home");
					mav.addObject("prodotti", prodotti);
					mav.addObject("marche", marche);
					mav.addObject("categorie", categorie);
					return mav;
				}
					else
					return new ModelAndView("riabilitati");
				}
			else {
				return new ModelAndView("login"); // non ci entra mai
			}
		} catch (ClienteException e) { // per pwd sbagliata o per username non trovato
			return new ModelAndView("login", "msg", e.getMessage());
		}
	}

	@RequestMapping(value="/datiCliente", method = RequestMethod.GET)
	public ModelAndView visualizzaDati(@RequestParam(value="username") String username) {
		Cliente c = service.getCliente(username);
		return new ModelAndView("datiUtente", "c", c);
	}
	
//	@RequestMapping("/modificaD")
//	public ModelAndView modifica(Cliente c) {
//		try {
//			service.modificaDatiCliente(c);
//			return new ModelAndView("datiUtente", "c",c);
//		} catch (Exception e) {
//			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
//		}
//	}

	@RequestMapping("/disabilitaCliente")
	public ModelAndView disabilitaCliente(String username, HttpSession session) {
		try {
			service.disabilitaCliente(username);
			return logoutCliente(session);
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}

	}
	@RequestMapping("/riabilitaCliente")
	public ModelAndView riabilitaCliente(String username, String password, HttpSession session) {
		try {
			service.riabilitaCliente(username, password);
			return logCliente(username, password, session);
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());

		}
	}

	@RequestMapping("/visualizzaOrdini")
	public ModelAndView visualizzaOrdini(String username) {
		List<Ordine> lista = service.getOrdini(username);
		return new ModelAndView("listaOrdini", "lista", lista);
	}

	@RequestMapping("/logoutCliente")
	public ModelAndView logoutCliente(HttpSession session) {

		//		HttpSession session = request.getSession();

		//		if(session.getAttribute("login") != null) {
		session.invalidate();
//		session.removeAttribute("login");
//		session.removeAttribute("admin");
//		session.removeAttribute("affidabile");
		List<Prodotto> prodotti= serviceP.ricercaProdottiScontati();
		List<String> marche= serviceP.getMarche();
		List<Categoria> categorie = serviceP.getCategorie();
		ModelAndView mav= new ModelAndView("home");
		mav.addObject("prodotti", prodotti);
		mav.addObject("marche", marche);
		mav.addObject("categorie", categorie);
		return mav;
		//		}

	}

	@RequestMapping("/modificaCliente")
	public ModelAndView modificaCliente(Cliente c) {

		try {
			return new ModelAndView("datiAdmin", "modificaCliente", service.updateCliente(c));
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	@RequestMapping("/modificaD")
	public ModelAndView modificaDati(Cliente c) {
		try {
			service.updateCliente(c);
			return new ModelAndView("datiUtente2", "c" ,c);
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
		
	}
	
	
}