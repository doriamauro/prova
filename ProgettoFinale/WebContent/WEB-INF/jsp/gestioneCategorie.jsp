<%@page import="org.springframework.web.bind.annotation.DeleteMapping"%>
<%@page import="bean.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestione Categorie</title>
</head>
<body>

<%
		List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
		for (Categoria c : categorie) {
%>

      <!--Categoria #1 -->
      <div class="item">
        <div class="buttons">
          <span class="delete">
  				
          </span>
        </div>

    

<form>

	
	<input type="text" name="nomeCategoria" value="<%= c.getNomeCategoria() %>" > <br>
	<input type="button" value="Rinomina"> 
	<input type="button" class="delete" value="Rimuovi"> 
</form>
     
        

     <%	}		
	%>
	
<form:form method="post" modelAttribute="cat" action="new">
	
	<form:input path="nomeCategoria"/> Il nome della nuova categoria<br>
	
	<input type="submit" value="aggiungi"> <br>
	
</form:form>

<br><br>
	<script type="text/javascript">
      $('.delete').on('click', function(e) {

    	});

  </script>

</body>
</html>