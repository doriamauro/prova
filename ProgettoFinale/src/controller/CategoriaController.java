package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.CatalogoService;
import service.UtenteService;

@Controller
@RequestMapping("/cat")
public class CategoriaController {


	
	@Autowired
	private CatalogoService service;
	
	
	@RequestMapping("/new")
	public void creaCategoria()
}
