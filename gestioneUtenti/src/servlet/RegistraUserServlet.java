package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Utente;
import service.UtenteService;
import service.UtenteServiceFake;

@WebServlet("/registraUser")
public class RegistraUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String mail = request.getParameter("mail");
		String telefono = request.getParameter("telefono");
		
		UtenteService service = new UtenteServiceFake();
		Utente u = new Utente(username, password, nome, cognome, mail, telefono);
		try {
			service.registraUtente(u);
			this.getServletContext()
		    .getRequestDispatcher("/WEB-INF/jsp/regOk.jsp")
		    .forward(request, response);
		} catch (Exception e) {
			
			request.setAttribute("username", username);
			request.setAttribute("msgCrociere", e.getMessage());
			this.getServletContext()
		    .getRequestDispatcher("/WEB-INF/jsp/regKo.jsp")
		    .forward(request, response);
		}
		
		
		
		
	}

}
