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
<!-- ver -->
	Ecco la lista di tutti gli utenti:

	<%
	List<Cliente> c = (List<Cliente>) request.getAttribute("c");
	System.out.println(c);
	out.println("<ol>");
	for (Cliente cl : c) {
		out.println(
				/* "<li><a href='visDatiCliente?username=" + cl.getUsername() + "'>" + */ 
	cl.getUsername() + " - "
				+ cl.getNome() + "(" + cl.getEmail() + ")" + "</li><br>");
		out.println("<form action='modifica'>");
		out.println("<input type='hidden' name='username' value='" + cl.getUsername() + "'>");
		out.println("<input type='submit' value='" + cl.getUsername() + "'>");
		out.println("</form>");
	}
	out.println("</ol>");
%>

<form action="affidabili">
<input type="submit" value="visualizza clienti affidabili"><br><br><br>
</form>

<form action="inaffidabili">
<input type="submit" value="visualizza clienti inaffidabili"><br><br><br>
</form>

<form action="view">
<input type="submit" value="visualizza tutti i clienti"><br><br><br>
</form>

<!-- <form action="login">
	<input type="submit" value="indietro"><br>
</form -->> 

</body>
</html>