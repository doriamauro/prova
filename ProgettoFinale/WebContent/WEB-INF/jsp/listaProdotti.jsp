<%@page import="bean.Prodotto"%>
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

<%
		List<Prodotto> lista = (List<Prodotto>) request.getAttribute("lista");
		for (Prodotto p : lista) {
			out.println("<ul>");
			out.println("<li>" + p.getMarca() + "</li>");
			out.println("<li>" + p.getDescrizione() + "</li>");
			out.println("<li>" + p.getPrezzoUni() + "</li>");
			
			out.println("</ul>");
		}		
	%>

</body>
</html>