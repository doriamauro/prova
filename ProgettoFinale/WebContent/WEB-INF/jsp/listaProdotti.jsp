<%@page import="bean.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>

    <link rel="stylesheet" href="style.css" media="screen" title="no title" charset="utf-8">
    <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
    <meta name="robots" content="noindex,follow" />
  </head>

<body>

<div class="shopping-cart">
      <!-- Title -->
      <div class="title">
        catalogo
      </div>

<%
		List<Prodotto> lista = (List<Prodotto>) request.getAttribute("lista");
		for (Prodotto p : lista) {
%>

      <!-- Product #1 -->
      <div class="item">
        <div class="buttons">
          <span class="delete-btn"></span>
        </div>

        <div class="image">
          <img src="<%= p.getImmaginePrimaria() %>" alt="" />
        </div>

        <div class="description">
          <span><%= p.getMarca() %></span>
          <span><%= p.getDescrizione() %></span>
          <span><%= p.getCodiceEAN() %></span>
            <span><%= p.getDisponibilita() %></span>
        </div>
     

        <div class="total-price">
          <span><%= p.getPrezzoUni() %></span>
        </div>
      </div>

     <%	}		
	%>

    <script type="text/javascript">
      $('.delete-btn').on('click', function(e) {
    		

    	});

  
	
<form>
	
	<input type="button" value="Svuota categoria" onclick=""> 
	
</form>

<form>

	<input type="checkbox"> Prodotti scontati 

</form>

	
<form>

		

</form>

</body>
</html>