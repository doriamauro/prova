<%@page import="bean.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- Dati dell'utente:

<% 
     Cliente c = (Cliente) request.getAttribute("c");
out.println("<ul>");
out.println("<li>"+c.getUsername()+"</li>" +
             "<li>"+c.getNome()+"</li>" +
             "<li>"+c.getCognome() + "<li>"+
             "<li>"+c.getTipologia() + "</li>"+
             "<li>"+c.getPartitaIva() + "</li>"+
             "<li>"+c.getCodiceFiscale() + "</li>"+
             "<li>"+c.getCellulare() + "</li>"+
             "<li>"+c.getTelefonoFisso() + "</li>"+
             "<li>"+c.getEmail() + "</li>"+
             "<li>"+c.getPassword() + "</li>"+
             "<li>"+c.getAttivo() + "</li>"+
             "<li>"+c.getAdmin() + "</li>"+
             "<li>"+c.getAffidabile() + "</li>"+
             "<li>"+c.getVia() + "</li>"+
             "<li>"+c.getCap() + "</li>"+
             "<li>"+c.getComune() + "</li>"+
             "<li>"+c.getProvincia() + "</li>"+
             "<li>"+c.getNazione() + "</li>");
out.println("</ul>");
%> --%>
<br><br>
Dati modificabili dell'utente:
<%
 Cliente c = (Cliente) request.getAttribute("c");
%>
<form method="get" action="modifica">
  <input type="text" name="nome" value="<%=c.getNome() %>">Nome<br>
  <input type="text" name="cognome" value="<%=c.getCognome() %>">Cognome<br><br>
  <input type="text" name="tipologia" value="<%=c.getTipologia() %>"/>Tipologia<br><br>
  <input type="text" name="partitaIva" value="<%=c.getPartitaIva() %>">PartitaIva<br><br>
  <input type="text" name="codiceFiscale" value="<%=c.getCodiceFiscale() %>">Codice fiscale<br><br>
  <input type="text" name="cellulare" value="<%=c.getCellulare() %>">Cellulare<br><br>
  <input type="text" name="telefonoFisso" value="<%=c.getTelefonoFisso() %>">Telefono Fisso<br><br>
  <input type="email" name="email" value="<%=c.getEmail() %>">Email<br><br>
  <input type="text" name="password" value="<%=c.getPassword() %>">Password<br><br>
  <input type="text" name="attivo" value="<%=c.getAttivo() %>">Attivo<br><br>
  <input type="text" name="affidabile" value="<%=c.getAffidabile() %>">Affidabile<br><br>
  <input type="text" name="via" value="<%=c.getVia() %>">Via<br><br>
  <input type="text" name="cap" value="<%=c.getCap() %>">Cap<br><br>
  <input type="text" name="comune" value="<%=c.getComune() %>">Comune<br><br>
  <input type="text" name="provincia" value="<%=c.getProvincia() %>">Provincia<br><br>
  <input type="text" name="nazione" value="<%=c.getNazione() %>">Nazione<br><br>

  <input type="submit" value="modifica"><br>  
</form>

<form action="view">
	<input type="submit" value="torna alla lista dei clienti"><br>
</form>

</body>
</html>