<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
Registrazione Utente:

<form:form method="post" modelAttribute="cliente" action="registrazioneCliente"><br>
<form:input path="username"/> Username <br> <form:errors path="username"/><br>
<form:input path="nome"/> Nome <br> <form:errors path="nome"/><br>
<form:input path="cognome"/> Cognome <br> <form:errors path="cognome"/><br>
<form:radiobutton path="tipologia" value="PRIVATO"/> Privato <br> <form:errors path="tipologia"/><br>
<form:radiobutton path="tipologia" value="AZIENDA"/> Azienda <br> <form:errors path="tipologia"/><br>
<form:input path="partitaIva"/> PartitaIva <br><form:errors path="partitaIva"/><br>
<form:input path="codiceFiscale"/> Codice Fiscale <br><form:errors path="codiceFiscale"/><br>
<form:input path="cellulare"/> Cellulare <br><form:errors path="cellulare"/><br>
<form:input path="telefonoFisso"/> Telefono Fisso <br><form:errors path="telefonoFisso"/><br>
<form:input path="email"/> Email <br><form:errors path="email"/><br>
<form:input path="password"/> Password <br><form:errors path="password"/><br>
<form:input path="via"/> Via <br><form:errors path="via"/><br>
<form:input path="cap"/> Cap <br><form:errors path="cap"/><br>
<form:input path="comune"/> Comune <br><form:errors path="comune"/><br>
<form:input path="provincia"/> Provincia <br><form:errors path="provincia"/><br>
<form:input path="nazione"/> Nazione <br><form:errors path="nazione"/><br><br><br>

<input type="submit" value="registrati"><br>

</form:form>
<!-- Registrazione dell'utente:

<form method="get" action="registrazioneCliente">
  <input type="text" name="username">Username<br><br>
  <input type="text" name="nome">Nome<br><br>
  <input type="text" name="cognome">Cognome<br><br>
  <input type="radio" name="tipologia" value="NO"/>Privato<br><br>
  <input type="radio" name="tipologia" value="SI"/>Azienda<br><br>
  <input type="text" name="partitaIva">PartitaIva<br><br>
  <input type="text" name="codiceFiscale">Codice fiscale<br><br>
  <input type="text" name="cellulare">Cellulare<br><br>
  <input type="text" name="telefonoFisso">Telefono Fisso<br><br>
  <input type="email" name="email">Email<br><br>
  <input type="text" name="password">Password<br><br>
  <input type="radio" name="attivo" value="0">Non Attivo<br><br>
  <input type="radio" name="attivo" value="1">Attivo<br><br>
  <input type="text" name="via">Via<br><br>
  <input type="text" name="cap">Cap<br><br>
  <input type="text" name="comune">Comune<br><br>
  <input type="text" name="provincia">Provincia<br><br>
  <input type="text" name="nazione">Nazione<br><br>
  
  <input type="submit" value="registrati"><br>
</form> -->

</body>
</html>