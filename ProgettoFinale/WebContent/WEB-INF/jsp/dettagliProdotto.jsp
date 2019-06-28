<%@page import="bean.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli Prodotto</title>


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
	console.log(codice);
	console.log(index);
	// recuperare la username dalla form
	var v = document.getElementById("id"+index).value;
	
	// creare l'oggetto AJAX
	var xhttp = new XMLHttpRequest();
	
	// gestire l'invocazione al server
	xhttp.onreadystatechange = function() {
		// codice da eseguire quando arriva una risposta dal server
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("esitoInserimento"+index).innerHTML = "elemento inserito nel carrello";
			
			document.getElementById("imgCarr").src = "../../img/basket-full-icon.png";
		}else{
			
		}
	}
	
	// gestire la risposta in arrivo dal server
	xhttp.open("GET", "../../example/carrello/add?idProdotto=" + codice+"&quantita="+v , true);
	xhttp.send();
}

</script>

</head>

<body>



<!--

METTERE I METODI SU FUNCTION
  -->
  
  
Dettagli del prodotto:
<br><br>
<%-- <% Prodotto p= (Prodotto) request.getAttribute("prodotto");
	Boolean b = (Boolean) request.getAttribute("modifica");
	if(b!=null && b==true) out.println("modifica avvenuta con successo <p>");
	int index = 0;
%> --%>

	 <div class="dettagliProdotto">
	 <form action="addProd">
	   	  <%-- <input id="id"> ID: <%= p.getIdProdotto() %></span><br> --%>
	   	  <input type="text" name="id"> Id<br>
	 	  <input type="text" name="descrizione" > Descrizione<br>
          <input type="text" name="marca"> Marca<br>
          <input type="text" name="codiceEAN"> Codice EAN<br>
          <input type="text" name="prezzoUni"> Prezzo unitario<br>
          <input type="text" name="disponibilita"> Disponibilità<br>
          <input type="text" name="linkProduttore"> Link Produttore<br>
          <input type="text" name="costoSped"> Costo Spedizione<br>
          <input type="text" name="tempoConsegna"> Tempi di consegna<br>
          <input type="text" name="immaginePrimaria"> Immagine primaria<br>
          <input type="text" name="immagineSec"> Immagine secondaria<br>
          <input type="text" name="idCategoria"> Id categoria<br>
          <input type="text" name="sconto"> Sconto<br><br><br><br>


			<input type="submit" class="modifica" value="Aggiungi prodotto">
</form>	
        </div>
<!-- <form action="">
	<input type="submit" value="indietro"><br>
</form>  -->
        
        <br>
     <%--    Aggiungi al carrello:
        
        <div class="quantity">
         
          <button class="minus-btn" type="button" name="button" onclick="meno(<%= index %>)">
            <img src="../../img/minus.svg" alt="" />
          </button>   
          <input type="text" name="name" id='<%= "id"+ index %>'  value="1">
          <button class="plus-btn" type="button" name="button" onclick="piu(<%= index %>)">
            <img src="../../img/plus.svg" alt="" />
          </button>
          
          <button class="minus-btn" type="button" name="buttonAdd" onclick="mettiACarrello(<%= p.getIdProdotto()%>,<%= index %>)">
            <img src="../../img/add.png" alt="" />
          </button>
          <div id="esitoInserimento<%=index %>"></div>
          </div> --%>
	
	


  

</body>
</html>