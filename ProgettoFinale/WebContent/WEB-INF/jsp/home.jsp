<%@page import="bean.DatiOrdine"%>
<%@page import="java.util.List"%>
<%@page import="bean.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>

    <link rel="stylesheet" href="../../css/style.css" media="screen" title="no title" charset="utf-8">
    <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
    <meta name="robots" content="noindex,follow" />


<script type="text/javascript">

function piu(index){
	console.log(index);
	document.getElementById("id"+index).value = document.getElementById("id"+index).value - -1; 
}

function meno(index){
	if(document.getElementById("id"+index).value ==1 ) return;
	
	console.log(index);
	document.getElementById("id"+index).value = document.getElementById("id"+index).value -1; 
}

function mettiACarrello(codice, index){
	// recuperare la username dalla form
	var v = document.getElementById("id"+index).value;
	
	// creare l'oggetto AJAX
	var xhttp = new XMLHttpRequest();
	
	// gestire l'invocazione al server
	xhttp.onreadystatechange = function() {
		// codice da eseguire quando arriva una risposta dal server
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("esitoInserimento"+index).innerHTML = "elemento inserito nel carrello";
		}else{
			
		}
	}
	
	// gestire la risposta in arrivo dal server
	xhttp.open("GET", "example/carrello/add?idProdotto=" + codice+"&quantita="+v , true);
	xhttp.send();
}

</script>
</head>
<body>


<% DatiOrdine d = (DatiOrdine) session.getAttribute("datiordine");
   List<Prodotto> lista = (List<Prodotto>) request.getAttribute("prodotti"); 
   List<String> marche = (List<String>) request.getAttribute("marche");%>

<div class="shopping-cart"> 
<select id="menuCategoria">
	<option> <a href="listaProdotti"> Telefonia </a></option>
	<option> <a href="listaProdotti"> Computer </a> </option>
	<option> <a href="listaProdotti"> Televisori </a></option>
	<option> <a href="listaProdotti"> Robot da cucina </a></option>
	<option> <a href="listaProdotti"> Elettrodomestici </a></option>
	<option> <a href="listaProdotti"> Console </a> </option>
	<option> <a href="listaProdotti"> Fotocamere </a> </option>
	<option> <a href="listaProdotti"> Musica </a> </option>
	<option> <a href="listaProdotti"> Tablet </a> </option>
</select>

<form action="/prod/search">
<input type="text" placeholder="Cerca..." name="cerca">
<input type="submit" value="cerca"> <i class="fa fa-search"></i>
</form>

<% if(d==null || d.getProdotti().size()==0){ %>
     <a href = "carrello"><img src="../../img/basket-empty-icon.png" alt="Carrello"></a>
<%} else { %>
     <a href = "carrello"><img src="../../img/basket-full-icon.png" alt="Carrello"></a>
<%}%>

<a href="login"> Login </a>

</div>
<div class="shopping-cart">

      <!-- Title -->
      <div class="title">
        Lista prodotti in sconto
      </div>
        

<% int index = 0;
   for(Prodotto p : lista ){ %>
      
      <div class="item">
        <div class="image">
          <img src="<%=p.getImmaginePrimaria() %>" alt="Prodotto in Sconto" />
        </div>


        <div class="description">
          <span><%=p.getMarca() %></span>
          <span><%=p.getDescrizione() %></span>
          </div>

        <div class="quantity">
         
          <button class="minus-btn" type="button" name="button"onclick="meno(<%= index %>)">
            <img src="../../img/minus.svg" alt="" />
          </button>   
          <input type="text" name="name" id='<%= "id"+ index %>'  value="1">
          <button class="plus-btn" type="button" name="button" onclick="piu(<%= index %>)">
            <img src="../../img/plus.svg" alt="" />
          </button>
          
          <button class="minus-btn" type="button" name="buttonAdd" onclick="mettiACarrello(<%= p.getCodiceEAN(), index %>)">
            <img src="../../img/add.png" alt="" />
          </button>
          <div id="esitoInserimento<%=index %>"></div>
          </div>

        <div class="total-price">
        <span> <%= p.getPrezzoUni() %></span>
        <span> <%= p.getSconto() %></span>
        </div>
      </div>

    
<% index++;
} %>
</div>

</body>
</html>