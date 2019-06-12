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


registrazione fallita per username <%= username %> causa: <%= msg %>
</body>
</html>