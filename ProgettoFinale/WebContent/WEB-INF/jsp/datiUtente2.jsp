<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="modificaCliente">
		<input type="text" name="password"> Password <br>
		<input type="text" name="nome"> Nome <br>
		<input type="text" name="partitaIva"> Partita IVA <br>
		<input type="text" name="codiceFiscale"> Codice Fiscale <br>
		<input type="text" name="cellulare"> Cellulare <br>
		<input type="text" name="telefonoFisso"> Telefono Fisso <br>
		<input type="text" name="email"> Email <br>
		<input type="text" name="via"> Via <br>
		<input type="text" name="comune"> Comune <br>
		<input type="text" name="provincia"> Provincia <br>
		<input type="text" name="nazione"> Nazione <br>
		<input type="radio" name="tipologia" value="0"> Privato <br>
		<input type="radio" name="tipologia" value="1"> Azienda <br>
		<input type="submit" value="modifica"><br>
	</form>
</body>
</html>