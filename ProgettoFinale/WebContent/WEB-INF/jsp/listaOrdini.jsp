<%@page import="bean.Ordine"%>
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
<!--fr  -->
	I tuoi ordini sono:
	<%
		List<Ordine> lista = (List<Ordine>) request.getAttribute("lista");
		for (Ordine o : lista) {
			out.println("<ul>");
			out.println("<li>" + o.getCodOrdine() + "</li>");
			out.println("<li>" + o.getUsOrdine() + "</li>");
			out.println("<li>" + o.getDataOrdine()+ "</li>");
			out.println("<li>" + o.getPrezzoFinale() + "</li>");
			out.println("<li>" + o.getIdIndOrd() + "</li>");
			out.println("<li>" + o.getIdModPag() + "</li>");
			out.println("</ul>");
		}		
	%>
</body>
</html>