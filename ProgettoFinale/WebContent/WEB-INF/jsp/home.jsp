<%@page import="bean.Categoria"%>
<%@page import="bean.DatiOrdine"%>
<%@page import="java.util.List"%>
<%@page import="bean.Prodotto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>   
<head>
<title>Insert title here</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>
<!-- we -->
    <link rel="stylesheet" href="../../css/style.css" media="screen" title="no title" charset="utf-8">
    <script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
    <meta name="robots" content="noindex,follow" />


<script type="text/javascript">

		/* $(document).ready(function() {
	tipoMenu("${tipoCliente}");
}) */


 window.onload = function() { 
	document.getElementById("primo").style.display = "none";
	document.getElementById("primo").onclick(); } 
					
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

function tipoMenu(chiE) {

	if (chiE==0) { var x = document.getElementById("amministratore"); x.style.display = "none"; }
	if (chiE==1) { var x = document.getElementById("utente");         x.style.display = "none"; }
}


</script>
</head>
<body>

<c:set var="valLOGIN" value='<%=session.getAttribute("login") %>'/>
 <c:if test="${valLOGIN!=null}">




<% DatiOrdine d = (DatiOrdine) session.getAttribute("datiordine");
   List<Prodotto> lista = (List<Prodotto>) request.getAttribute("prodotti"); 
   List<String> marche = (List<String>) request.getAttribute("marche");
   List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
	 String username = (String) session.getAttribute("login");														
		int tipoCliente = (Integer) session.getAttribute("admin");													   
   %>
   

<div class="shopping-cart"> 
<form action="../prod/list" method="get">
<select name="menuCategorie">
	<c:forEach var="categorie" items="${categorie}">
		 <option value="${categorie.idCategoria}"><!-- <a href="listaProdotti"> -->${categorie.nomeCategoria}<!-- </a> --></option>
 	</c:forEach>
 	 
 	</select> 
<input type="submit" value="Vai"> 

</form>
            
<%-- <% for(int i=0; i < categorie.size(); i++){%>
 --%>


<%-- 	<option> <a href="listaProdotti"><%= categorie.get(i).getNomeCategoria() %></a></option>
 --%>
	<!-- <option> <a href="listaProdotti"> Telefonia </a></option>
	<option> <a href="listaProdotti"> Computer </a> </option>
	<option> <a href="listaProdotti"> Televisori </a></option>
	<option> <a href="listaProdotti"> Robot da cucina </a></option>
	<option> <a href="listaProdotti"> Elettrodomestici </a></option>
	<option> <a href="listaProdotti"> Console </a> </option>
	<option> <a href="listaProdotti"> Fotocamere </a> </option>
	<option> <a href="listaProdotti"> Musica </a> </option>
	<option> <a href="listaProdotti"> Tablet </a> </option> -->
<!-- </select> -->

<%-- <%} %> --%>

<form action="../prod/search" method="get">
<input type="text" placeholder="Cerca..." name="cerca">
<input type="submit" value="cerca"> <i class="fa fa-search"></i>
</form>

<% if(d==null || d.getProdotti().size()==0){ %>
     <a href = "../../example/carrello/all"><img id="imgCarr" src="../../img/basket-empty-icon.png" alt="Carrello"></a>
<%} else { %>
     <a href = "../../example/carrello/all"><img id="imgCarr"src="../../img/basket-full-icon.png" alt="Carrello"></a>
<%}%>

<!-- <a href="../../example/cliente/loginCliente"> Login </a> -->

</div>
<button id="primo" onclick='tipoMenu("<%=tipoCliente%>")'> Si clicca automaticamente al caricamento della pagina</button>

<div id="utente">
<%-- Ciao utente <%=username %> <br>
Ciao utente ${username} <br> --%>
<ul>
  <li><form action="../cliente/datiCliente">     <input type="hidden"  name="username" value='<%=username%>'><input type="submit" value="I miei dati">  </form></li>
  <li><form action="../cliente/visualizzaOrdini"><input type="hidden"  name="username" value='<%=username%>'><input type="submit" value="I miei ordini"></form></li>
  <li><form action="../cliente/logoutCliente">   <input type="submit"  value="Logout"></form></li>
</ul>
</div>



<div id="amministratore">
<%-- Ciao amministratore <%=username %> <br>
Ciao amministratore ${username} <br> --%>
<ul>
  <li><form action="../cliente/datiCliente">        <input type="hidden"  name="username" value='<%=username%>'><input type="submit" value="I miei dati">  </form></li>
  <li><form action="../cat/pageCreaProd">            									  						<input type="submit" value="Aggiungi Prodotto">  </form></li>
  <li><form action="../cat/pageRate">            									  						    <input type="submit" value="Gestione Rate">  </form></li>
  <li><form action="../cat/list">        																		<input type="submit" value="Gestione Categorie">  </form></li>
  <li><form action="../admin/view">     																	    <input type="submit" value="Gestione Utenti">  </form></li>
  <li><form action="../admin/visualizzaTuttiOrdini">															<input type="submit" value="Visualizza ordini"></form></li>
  <li><form action="../cliente/logoutCliente">      															<input type="submit" value="Logout"></form></li>
  
</ul>
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


       <%--  <div class="description">
          <span><%=p.getMarca() %></span>
          <span><%=p.getDescrizione() %></span>
          </div>
 --%>
 
 <div class="description">
          <a href="../prod/scheda?idProdotto=<%=p.getIdProdotto()%>"><span><%=p.getDescrizione()  %></span></a>
          <span><%=p.getMarca()%></span>
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

        <div class="total-price">
        <span> <%= p.getPrezzoUni() + "POCHIEURI" %></span> <br>
        
        <span> <%= p.getSconto() + "% SCONTO"%></span>
        </div>
      </div>

    
<% index++;
} %>


<ul>
<% for(String s: marche){%>
<li><a href="../prod/searchMarca?marca=<%= s %>"><%= s %></a> <br></li> 
<%} %>
</ul>


</div>

</c:if>


 <c:if test="${valLOGIN==null}">



<% DatiOrdine d = (DatiOrdine) session.getAttribute("datiordine");
   List<Prodotto> lista = (List<Prodotto>) request.getAttribute("prodotti"); 
   List<String> marche = (List<String>) request.getAttribute("marche");
   List<Categoria> categorie = (List<Categoria>) request.getAttribute("categorie");
	/*  String username = (String) session.getAttribute("login");	 */													
		/* int tipoCliente = (Integer) session.getAttribute("admin"); */													   
   %>
   

<div class="shopping-cart"> 
<form action="../prod/list" method="get">
<select name="menuCategorie">
	<c:forEach var="categorie" items="${categorie}">
		 <option value="${categorie.idCategoria}"><!-- <a href="listaProdotti"> -->${categorie.nomeCategoria}<!-- </a> --></option>
 	</c:forEach>
 	 
 	</select> 
<input type="submit" value="Vai"> 

</form>
            
<%-- <% for(int i=0; i < categorie.size(); i++){%>
 --%>


<%-- 	<option> <a href="listaProdotti"><%= categorie.get(i).getNomeCategoria() %></a></option>
 --%>
	<!-- <option> <a href="listaProdotti"> Telefonia </a></option>
	<option> <a href="listaProdotti"> Computer </a> </option>
	<option> <a href="listaProdotti"> Televisori </a></option>
	<option> <a href="listaProdotti"> Robot da cucina </a></option>
	<option> <a href="listaProdotti"> Elettrodomestici </a></option>
	<option> <a href="listaProdotti"> Console </a> </option>
	<option> <a href="listaProdotti"> Fotocamere </a> </option>
	<option> <a href="listaProdotti"> Musica </a> </option>
	<option> <a href="listaProdotti"> Tablet </a> </option> -->
<!-- </select> -->

<%-- <%} %> --%>

<form action="../prod/search" method="get">
<input type="text" placeholder="Cerca..." name="cerca">
<input type="submit" value="cerca"> <i class="fa fa-search"></i>
</form>

 <% if(d==null || d.getProdotti().size()==0){ %>
     <a href = "../../example/carrello/all"><img id="imgCarr" src="../../img/basket-empty-icon.png" alt="Carrello"></a>
<%} else { %>
     <a href = "../../example/carrello/all"><img id="imgCarr"src="../../img/basket-full-icon.png" alt="Carrello"></a>
<%}%>

<a href="../../example/cliente/loginCliente"> Login </a>

</div>
<button id="primo" onclick=''> Si clicca automaticamente al caricamento della pagina</button>

<%-- <div id="utente">
Ciao utente <%=username %> <br>
Ciao utente ${username} <br>
<ul>
  <li><form action="../cliente/datiCliente">     <input type="hidden"  name="username" value='<%=username%>'><input type="submit" value="I miei dati">  </form></li>
  <li><form action="../cliente/visualizzaOrdini"><input type="hidden"  name="username" value='<%=username%>'><input type="submit" value="I miei ordini"></form></li>
  <li><form action="../cliente/logoutCliente">   <input type="submit"  value="Logout"></form></li>
</ul>
</div>
 --%>


<%-- <div id="amministratore">
Ciao amministratore <%=username %> <br>
Ciao amministratore ${username} <br>
<ul>
  <li><form action="../cliente/datiCliente">        <input type="hidden"  name="username" value='<%=username%>'><input type="submit" value="I miei dati">  </form></li>
  <li><form action="../cat/pageCreaProd">            									  						<input type="submit" value="Aggiungi Prodotto">  </form></li>
  <li><form action="../cat/pageRate">            									  						    <input type="submit" value="Gestione Rate">  </form></li>
  <li><form action="../cat/list">        																		<input type="submit" value="Gestione Categorie">  </form></li>
  <li><form action="../admin/vedi">     																	    <input type="submit" value="Gestione Utenti">  </form></li>
  <li><form action="../admin/visualizzaTuttiOrdini">															<input type="submit" value="Visualizza ordini"></form></li>
  <li><form action="../cliente/logoutCliente">      															<input type="submit" value="Logout"></form></li>
  
</ul>
</div> --%>
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


       <%--  <div class="description">
          <span><%=p.getMarca() %></span>
          <span><%=p.getDescrizione() %></span>
          </div>
 --%>
 
 <div class="description">
          <a href="../prod/scheda?idProdotto=<%=p.getIdProdotto()%>"><span><%=p.getDescrizione()  %></span></a>
          <span><%=p.getMarca()%></span>
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

        <div class="total-price">
        <span> <%= p.getPrezzoUni()  %></span> <br>
        
        <span> <%= p.getSconto() + "%"%></span>
        </div>
      </div>

    
<% index++;
} %>


<ul>
<% for(String s: marche){%>
<li><a href="../prod/searchMarca?marca=<%= s %>"><%= s %></a> <br></li> 
<%} %>
</ul>


</div>

</c:if>
</body>
</html>