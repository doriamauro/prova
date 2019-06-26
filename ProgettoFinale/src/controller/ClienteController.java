package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
			String username = c.getUsername();
			return new ModelAndView("registrazioneOk", "username", username);
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}

	@RequestMapping("/loginCliente")
	public ModelAndView logCliente(String username, String password, HttpSession session) {
		try {
			if (service.checkCredenziali(username, password)) {
				session.setAttribute("login", username);
				return new ModelAndView("home");
			}
			return new ModelAndView("login");
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
	}
	
	@RequestMapping("/datiCliente")
	public ModelAndView visualizzaDati(String username) {
		Cliente c = service.getCliente(username);
		return new ModelAndView("schedaCliente", "cliente", c);
	}
	
	@RequestMapping("/disabilitaCliente")
	public ModelAndView disabilitaCliente(String username) {
		try {
			service.disabilitaCliente(username);
			return new ModelAndView("disabilitazione","username", username);
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());
		}
		
	}
	@RequestMapping("/riabilitaCliente")
	public ModelAndView riabilitaCliente(String username, String password) {
		try {
			service.riabilitaCliente(username, password);
			return new ModelAndView("riabilitazione","username", username);
		} catch (ClienteException e) {
			return new ModelAndView("erroreGenerico", "msg", e.getMessage());

		}
	}
	
	public ModelAndView visualizzaOrdini(String username) {
		List<Ordine> lista = service.getOrdini(username);
		return new ModelAndView("listaOrdini", "lista", lista);
	}
		
}
