<%@page import="bean.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
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

<% Prodotto p= (Prodotto) request.getAttribute("prodotto");
int index = 0;
%>

	 <div class="dettagliProdotto">
	   	  <span id="id" > ID: <%= p.getIdProdotto() %></span><br>
	 	  <span id="descrizione"> Descrizione: <%= p.getDescrizione() %></span><br>
          <span id="marca"> Marca: <%= p.getMarca() %></span><br>
          <span id="codiceEAN"> Codice EAN: <%= p.getCodiceEAN() %></span><br>
          <span id="prezzoUni"> Prezzo Unitario: <%= p.getPrezzoUni() %></span><br>
          <span id="disponibilita"> Disponibilità: <%= p.getDisponibilita() %></span><br>
          <span id="linkProduttore"> Link Produttore: <%= p.getLinkProduttore() %></span><br>
          <span id="costoSped"> Costo spedizione: <%= p.getCostoSped() %></span><br>
          <span id="tempoConsegna"> Tempo di consegna: <%= p.getTempoConsegna() %></span><br>
          <span id="immaginePrimaria"> Immagine Principale: <%= p.getImmaginePrimaria() %></span><br>
          <span id="immagineSec"> Immagine Sencondaria: <%= p.getImmagineSec() %></span><br>
          <span id="idCategoria"> ID Categoria: <%= p.getIdCategoria() %></span><br>
          <span id="sconto"> Sconto :<%= p.getSconto() %></span><br>
        </div>
        
        
        
        
        <div class="quantity">
         
          <button class="minus-btn" type="button" name="button"onclick="meno(<%= index %>)">
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
          </div>
          
        
	

<form>
<input type="button" class="modifica" value="Modifica prodotto">
</form>	
<form>
<input type="button" class="crea" value="Crea nuovo prodotto">
</form>	
	


  

</body>
</html>