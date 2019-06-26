package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Categoria;
import bean.Prodotto;
import service.ProdottoService;
@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private ProdottoService service; 	
	
	@RequestMapping("/index")
	public ModelAndView ricercaProdottiScontati() {
		List<Prodotto> prodotti= service.ricercaProdottiScontati();
		List<String> marche= service.getMarche();
		List<Categoria> categorie = service.getCategorie();
		ModelAndView mav= new ModelAndView("home");
		mav.addObject("prodotti", prodotti);
		mav.addObject("marche", marche);
		mav.addObject("categorie", categorie);
		return mav;
	}
	

}
