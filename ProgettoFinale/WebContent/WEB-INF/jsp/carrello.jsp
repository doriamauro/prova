<%@page import="bean.DatiOrdine"%>
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

    <link rel="stylesheet" href="../../css/style2.css" media="screen" title="no title" charset="utf-8">
    <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
    <meta name="robots" content="noindex,follow" />
    
    <script type="text/javascript">
    
 /*    function acquista() {

    	
    } */
    
   	function remove(idProdotto,index) {
   		console.log(idProdotto);
   		
   		var d = document.getElementById("ProdottiNelCarrello");
			
		var p = document.getElementById("prodotto"+index);
		console.log(p);
		console.log(index);
		console.log(typeof p)
		d.removeChild(p);
   		
   		var xhttp = new XMLHttpRequest();
   		
   		// gestire l'invocazione al server
   		xhttp.onreadystatechange = function() {
   			// codice da eseguire quando arriva una risposta dal server
   			if (this.readyState == 4 && this.status == 200) {
   				
   				var d = document.getElementsByClassName("shopping-cart");
   				
   				var p = document.getElementById("prodotto"+index);
   				
   				d.removeChild(p);
   				
   			}
   		}
   		xhttp.open("GET", "../../example/carrello/remove?idProdotto=" + idProdotto, true);
   		xhttp.send();
   	}
    
/*     $('.minus-btn').on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());
     
        if (value &amp;gt; 1) {
            value = value - 1;
        } else {
            value = 0;
        }
     
      $input.val(value);
     
    });
     
    $('.plus-btn').on('click', function(e) {
        e.preventDefault();
        var $this = $(this);
        var $input = $this.closest('div').find('input');
        var value = parseInt($input.val());
     
        if (value &amp;lt; 100) {
            value = value + 1;
        } else {
            value =100;
        }
     
        $input.val(value);
    }); */
    
    </script>
    
</head>
<body>

<div id="ProdottiNelCarrello" class="shopping-cart">

  <!-- Title -->
  <div class="title">
    Shopping Bag
  </div>
 
 <%
 DatiOrdine d = (DatiOrdine)session.getAttribute("datiordine");
 List<Prodotto> prodotti = d.getProdotti();
 
 int index = 0;
 for (Prodotto p: prodotti ){%>
 


  <div id='<%= "prodotto"+ index %>' class="item">
    <div class="buttons">
      <button class="delete-btn" type="button" name="button" onclick="remove(<%= p.getIdProdotto() %>, <%= index %>)">
       <img src="../../img/delete-icn.svg" alt="" />
    </div>
 
    <div class="image">
      <img src="<%="../../"+p.getImmaginePrimaria()%>" alt="Prodotto nel carrello" />
    </div>
 
    <div class="description">
      <span><%=p.getMarca() %></span>
      <span><%=p.getDescrizione() %></span>
    </div>
 
    <div class="quantity">
      <button class="plus-btn" type="button" name="button" onclick="piu(<%= index %>)">
        <img src="../../img/plus.svg" alt="" />
      </button>
      <input type="text" name="name" id='<%= "id"+ index %>' value="<%= p.getDisponibilita() %>">
      <button class="minus-btn" type="button" name="button" onclick="meno(<%= index %>)">
        <img src="../../img/minus.svg" alt="" />
      </button>
    </div>
 
    <div class="total-price"> <%=p.getPrezzoUni() %></div>
  </div>
  <% index++; %>
  <!-- inserire il calcolo totale -->
  <% } %>
  
 <!--    <div class="buttons">
      <button class="acquista" type="button" name="button" onclick="acquista()">
       <img src="../../img/shopping-cart.svg" alt="" />
    </div>  
   -->
  </div>
  

  
  
  
  
</body>
</html>