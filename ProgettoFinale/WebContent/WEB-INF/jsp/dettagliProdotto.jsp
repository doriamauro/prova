<%@page import="bean.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<!--

METTERE I METODI SU FUNCTION
  -->
  
  
Dettagli prodotto:

<% Prodotto p= (Prodotto) request.getAttribute("prodotto");
%>
	 <div class="dettagliProdotto">
	 	<span><%= p.getIdProdotto() %></span>
	 	<span><%= p.getDescrizione() %></span>
          <span><%= p.getMarca() %></span>
          <span><%= p.getCodiceEAN() %></span>
          <span><%= p.getPrezzoUni() %></span>
          <span><%= p.getDisponibilita() %></span>
          <span><%= p.getLinkProduttore() %></span>
          <span><%= p.getCostoSped() %></span>
          <span><%= p.getTempoConsegna() %></span>
          <span><%= p.getImmaginePrimaria() %></span>
          <span><%= p.getImmagineSec() %></span>
          <span><%= p.getIdCategoria() %></span>
          <span><%= p.getSconto() %></span>
        </div>
	
	<div class="bottoni">
 <script type="text/javascript">
      $('.modifica-btn').on('click', function(e) {
    		
    	    	});
      

  </script>
	
 <script type="text/javascript">
      $('.aggiungi-btn').on('click', function(e) {
    		

    	});

  </script>

<script type="text/javascript">
      $('.crea-btn').on('click', function(e) {
    		

    	});

  </script>
</div>
</body>
</html>