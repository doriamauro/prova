<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String username = (String)request.getAttribute("username");
   String msg= (String)request.getAttribute("msgCrociere"); %>
<%
	for(int i = 0; i <lista.size();i++){
		out.println("<a href='getContatti?idRubrica="+ lista.get(i).getIdRubrica()+ "'>" + lista.get(i) + "</a>")
	}

%>
<a href="">pippo baudo</a>
registrazione fallita per username <%= username %> causa: <%= msg %>
</body>
</html>