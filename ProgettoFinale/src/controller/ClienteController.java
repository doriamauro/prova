package controller;

//ciao
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Admin;
import bean.Attivo;
import bean.Cliente;
import bean.Ordine;
import exception.ClienteException;
import service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping("/registrazioneCliente")
	public ModelAndView registraCliente(Cliente c) {
		try {
			service.registraCliente(c);
			return new ModelAndView("home");
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}

	@RequestMapping("/loginCliente")
	public ModelAndView logCliente(String username, String password, HttpSession session) {		
		Cliente c = service.getCliente(username);
		try {
			if (service.checkCredenziali(username, password)) {
				if (c.getAttivo().equals(Attivo.SI) && c.getAdmin().equals(Admin.NO)) {
					session.setAttribute("login", username);
					session.setAttribute("admin", false);
					session.setMaxInactiveInterval(0);
					return new ModelAndView("home");
				}
				else {
					return new ModelAndView("riabilitati");
				}
			}
			else {
				return new ModelAndView("login");
			}
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}

	@RequestMapping("/datiCliente")
	public ModelAndView visualizzaDati(String username) {
		Cliente c = service.getCliente(username);
		return new ModelAndView("datiUtente", "cliente", c);
	}

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
		return new ModelAndView("visualizzaOrdini", "lista", lista);
	}

	@RequestMapping("/logoutCliente")
	public ModelAndView logoutCliente(HttpSession session) {

		//		HttpSession session = request.getSession();

		//		if(session.getAttribute("login") != null) {
		session.invalidate();
		return new ModelAndView("home");
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
	
	@RequestMapping("/invioRegistrazione")
	public ModelAndView invioRegistrazione() {
		return new ModelAndView("registrazione");
	}
}