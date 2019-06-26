package conf;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInizializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		System.out.println("inizializzazione");
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//	      appContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
//  
	      ServletRegistration.Dynamic registration =
	    	        container.addServlet("dispatcher", new DispatcherServlet(appContext));
	      
		registration.setLoadOnStartup(1); 
		registration.addMapping("/example/*"); 


	}

}
