<%@page import="bean.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Dati modificabili dell'utente:

<br><br>
<%
 Cliente c = (Cliente) request.getAttribute("c");
%>

<%-- <form:form method="post" modelAttribute="cliente" action="modifica"><br>

<form:input path="username" value="<%=c.getUsername() %>"/> Username <br> 
<form:input path="nome"value="<%=c.getNome() %>"/> Nome <br> 
<form:input path="cognome"value="<%=c.getCognome() %>"/> Cognome <br> 
<form:radiobutton path="tipologia" value="PRIVATO"/> Privato <br> 
<form:radiobutton path="tipologia" value="AZIENDA"/> Azienda <br> 
<form:input path="partitaIva" value="<%=c.getPartitaIva() %>"/> PartitaIva <br>
<form:input path="codiceFiscale" value="<%=c.getCodiceFiscale() %>"/> Codice Fiscale <br>
<form:input path="cellulare" value="<%=c.getCellulare() %>"/> Cellulare <br>
<form:input path="telefonoFisso" value="<%=c.getTelefonoFisso() %>"/> Telefono Fisso <br>
<form:input path="email" value="<%=c.getEmail() %>"/> Email <br>
<form:input path="password" value="<%=c.getPassword() %>"/> Password <br>
<form:radiobutton path="attivo" value="NO"/> Non attivo <br> 
<form:radiobutton path="attivo" value="SI"/> Attivo <br>
<form:radiobutton path="admin" value="NO"/> Utente <br> 
<form:radiobutton path="admin" value="SI"/> Admin <br> 
<form:radiobutton path="affidabile" value="NO"/> Non affidabile <br> 
<form:radiobutton path="affidabile" value="SI"/> Affidabile <br> 
<form:input path="via" value="<%=c.getVia() %>"/> Via <br>
<form:input path="cap" value="<%=c.getCap() %>"/> Cap <br><
<form:input path="comune" value="<%=c.getComune() %>"/> Comune <br>
<form:input path="provincia" value="<%=c.getProvincia() %>"/> Provincia <br>
<form:input path="nazione" value="<%=c.getNazione() %>"/> Nazione <br><br><br><br>

<input type="submit" value="modifica"><br>
</form:form> --%>

<form action="modificaD">
  <input type="text" name="username" value="<%=c.getUsername()%>">Username<br><br>
  <input type="text" name="nome" value="<%=c.getNome()%>">Nome<br><br>
  <input type="text" name="cognome" value="<%=c.getCognome()%>">Cognome<br><br>
  <input type="text" name="tipologia" value="<%=c.getTipologia()%>"/>Tipologia<br><br>
  <input type="text" name="partitaIva" value="<%=c.getPartitaIva()%>">PartitaIva<br><br>
  <input type="text" name="codiceFiscale" value="<%=c.getCodiceFiscale()%>">Codice fiscale<br><br>
  <input type="text" name="cellulare" value="<%=c.getCellulare()%>">Cellulare<br><br>
  <input type="text" name="telefonoFisso" value="<%=c.getTelefonoFisso()%>">Telefono Fisso<br><br>
  <input type="text" name="email" value="<%=c.getEmail()%>">Email<br><br>
  <input type="text" name="password" value="<%=c.getPassword()%>">Password<br><br>
  <input type="text" name="attivo" value="<%=c.getAttivo()%>">Attivo<br><br>
  <input type="text" name="affidabile" value="<%=c.getAffidabile()%>">Affidabile<br><br>
  <input type="text" name="via" value="<%=c.getVia()%>">Via<br><br>
  <input type="text" name="cap" value="<%=c.getCap()%>">Cap<br><br>
  <input type="text" name="comune" value="<%=c.getComune()%>">Comune<br><br>
  <input type="text" name="provincia" value="<%=c.getProvincia()%>">Provincia<br><br>
  <input type="text" name="nazione" value="<%=c.getNazione()%>">Nazione<br><br>

  <input type="submit" value="modifica"><br><br><br>  
</form> 

<form action="view">
	<input type="submit" value="indietro"><br>
</form> 


</body>
</html>