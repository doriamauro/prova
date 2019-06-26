<%@page import="bean.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Ecco la lista di tutti gli utenti:

	<%
	List<Cliente> c = (List<Cliente>) request.getAttribute("c");
	System.out.println(c);
	out.println("<ol>");
	for (Cliente cl : c) {
		out.println("<li><a href='visDatiCliente?username=" + cl.getUsername() + "'>" + " - "
				+ cl.getCognome() + " " + cl.getNome() + "(" + cl.getEmail() + ")" + "</li><br>");
	}
	out.println("</ol>");
%>

<form action="affidabili">
<input type="submit" value="visualizza clienti affidabili"><br>
</form>

<form action="inaffidabili">
<input type="submit" value="visualizza clienti inaffidabili"><br>
</form>

<form action="view">
<input type="submit" value="visualizza tutti i clienti"><br>
</form>

</body>
</html>