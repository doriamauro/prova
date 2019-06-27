<%@page import="bean.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<script type="text/javascript"




></script>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>

    <link rel="stylesheet" href="style.css" media="screen" title="no title" charset="utf-8">
    <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
    <meta name="robots" content="noindex,follow" />
  </head>
<!--METTERE FUNZIONE  -->
<body>

<div class="shopping-cart">
      <!-- Title -->
      <div class="title">
        Catalogo
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

  </script><br><br><br>
  
 <c:set var="val" value='<%=request.getParameter("menuCategorie") %>'/>
 <c:if test="${val!=null}">
 <form action="searchPrice/menuCategorie" method="get" >
 <input type="hidden" value="<%= request.getParameter("menuCategorie") %>" name="menuCategorie" />
 <input type="number" name="min"> Prezzo minimo<br><br>
 <input type="number" name="max"> Prezzo massimo<br><br><br>
 <input type="submit" value="applica"><br><br><br>
</form>
</c:if>

 <c:set var="val2" value='<%=request.getParameter("cerca") %>'/>
 <c:if test="${val2!=null}">
 <form action="searchPrice/cerca" method="get" >
 <input type="hidden" value="<%= request.getParameter("cerca") %>" name="cerca" />
 <input type="number" name="min"> Prezzo minimo<br><br>
 <input type="number" name="max"> Prezzo massimo<br><br><br>
 <input type="submit" value="applica"><br><br><br>
</form>
</c:if>

 <c:set var="val3" value='<%=request.getParameter("marca") %>'/>
 <c:if test="${val3!=null}">
 <form action="searchPrice/marca" method="get" >
 <input type="hidden" value="<%= request.getParameter("marca") %>" name="marca" />
 <input type="number" name="min"> Prezzo minimo<br><br>
 <input type="number" name="max"> Prezzo massimo<br><br><br>
 <input type="submit" value="applica"><br><br><br>
</form>
</c:if>

<form action="../home/index">
	<input type="submit" value="Home">
</form>

</body>
</html>