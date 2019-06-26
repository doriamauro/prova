<%@page import="bean.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Prodotto</title>
</head>
<body>



<!--

METTERE I METODI SU FUNCTION
  -->
  
  
Dettagli del prodotto:

<% Prodotto p= (Prodotto) request.getAttribute("prodotto");%>

	 <div class="dettagliProdotto">
	   	  <span id="id" > ID: <%= p.getIdProdotto() %></span>
	 	  <span id="descrizione"> Descrizione: <%= p.getDescrizione() %></span>
          <span id="marca"> Marca: <%= p.getMarca() %></span>
          <span id="codiceEAN"> Codice EAN: <%= p.getCodiceEAN() %></span>
          <span id="prezzoUni"> Prezzo Unitario: <%= p.getPrezzoUni() %></span>
          <span id="disponibilita"> Disponibilità: <%= p.getDisponibilita() %></span>
          <span id="linkProduttore"> Link Produttore: <%= p.getLinkProduttore() %></span>
          <span id="costoSped"> Costo spedizione: <%= p.getCostoSped() %></span>
          <span id="tempoConsegna"> Tempo di consegna: <%= p.getTempoConsegna() %></span>
          <span id="immaginePrimaria"> Immagine Principale: <%= p.getImmaginePrimaria() %></span>
          <span id="immagineSec"> Immagine Sencondaria: <%= p.getImmagineSec() %></span>
          <span id="idCategoria"> ID Categoria: <%= p.getIdCategoria() %></span>
          <span id="sconto"> Sconto :<%= p.getSconto() %></span>
        </div>
	
<form>
<input type="button" class="aggiungi" value="Aggiungi al carrello">
<input type="button" class="modifica" value="Modifica prodotto">
<input type="button" class="crea" value="Crea nuovo prodotto">
</form>	
	

 <script type="text/javascript">
      $('.modifica').on('click', function(e) {
    		var id = document.getElementById("id");
    		
    		
    		
    	    	});
      

	
 <script type="text/javascript">
      $('.aggiungi').on('click', function(f) {
    		

    	});


<script type="text/javascript">
      $('.crea').on('click', function(g) {
    		

    	});

  </script>

</body>
</html>