<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Registrazione dell'utente:

<form action="registrazioneCliente">
  <input type="text" name="username">Username<br><br>
  <input type="text" name="nome">Nome<br><br>
  <input type="text" name="cognome">Cognome<br><br>
  <input type="radio" name="tipologia" value="0"/>Privato<br><br>
  <input type="radio" name="tipologia" value="1"/>Azienda<br><br>
  <input type="text" name="partitaIva">PartitaIva<br><br>
  <input type="text" name="codiceFiscale">Codice fiscale<br><br>
  <input type="text" name="cellulare">Cellulare<br><br>
  <input type="text" name="telefonoFisso">Telefono Fisso<br><br>
  <input type="email" name="email">Email<br><br>
  <input type="text" name="password">Password<br><br>
  <input type="radio" name="attivo" value="0">Attivo<br><br>
  <input type="radio" name="attivo" value="1">Non attivo<br><br>
  <input type="radio" name="affidabile" value="0">Affidabile<br><br>
  <input type="radio" name="affidabile" value="1">Non affidabile<br><br>
  <input type="text" name="via">Via<br><br>
  <input type="text" name="cap">Cap<br><br>
  <input type="text" name="comune">Comune<br><br>
  <input type="text" name="provincia">Provincia<br><br>
  <input type="text" name="nazione">Nazione<br><br>
  
  <input type="submit" value="registrati"><br>
</form>

</body>
</html>