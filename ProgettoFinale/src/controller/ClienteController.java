package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
				if (c.getAttivo().equals(Attivo.SI)) {
					session.setAttribute("login", username);
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
			return new ModelAndView("erroreGenerico", "msg", e.getMessage()); // probabilmente inutile
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
	public ModelAndView riabilitaCliente(String username, String password) {
		try {
			service.riabilitaCliente(username, password);
			return new ModelAndView("home");
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());

		}
	}
	
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
}
