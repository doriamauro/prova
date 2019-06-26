<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	I tuoi dati:
	<ul>
		<li>${cliente.username}</li>
		<li>${cliente.nome}</li>
		<li>${cliente.cognome}</li>
		<li>${cliente.tipologia}</li>
		<li>${cliente.partitaIva}</li>
		<li>${cliente.codiceFiscale}</li>
		<li>${cliente.cellulare}</li>
		<li>${cliente.telefonoFisso}</li>
		<li>${cliente.email}</li>
		<li>${cliente.via}</li>
		<li>${cliente.cap}</li>
		<li>${cliente.comune}</li>
		<li>${cliente.provincia}</li>
		<li>${cliente.nazione}</li>
	</ul>
</body>
</html>