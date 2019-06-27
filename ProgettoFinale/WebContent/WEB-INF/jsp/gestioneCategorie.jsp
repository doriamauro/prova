<%@page import="org.springframework.web.bind.annotation.DeleteMapping"%>
<%@page import="bean.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Categorie</title>
</head>
<body>

<%
	Boolean b = (Boolean) request.getAttribute("modifica");
	if(b!=null && b==true) out.println("modifica avvenuta con successo <p>");

		List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
		for (Categoria c : categorie) {
%>

      <!--Categoria #1 -->
      <div class="item">
        <div class="buttons">
          <span class="delete">
  				
          </span>
        </div>

    

<form action="../cat/rename" method="get">

	<input type="hidden" name="idCat" value="<%= c.getIdCategoria() %>">
	<input type="text" name="nomeCat" value="<%= c.getNomeCategoria() %>" > <br>
	<input type="submit" value="Rinomina"> 
</form>
        

     <%	}		
	%>
	
<form:form method="post" modelAttribute="cat" action="new">
	
	<form:input path="nomeCategoria"/> Il nome della nuova categoria<br>
	
	<input type="submit" value="aggiungi"> <br>
	
</form:form>

<br><br>


</body>
</html>