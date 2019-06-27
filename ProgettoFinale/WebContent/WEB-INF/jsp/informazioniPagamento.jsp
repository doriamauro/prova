<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- fr -->
Scelta della modalità di pagamento:

<form action="scelta">
  <input type="radio" name="pag" value="1">Contanti con ritiro in negozio<br>
  <input type="radio" name="pag" value="2">Bonifico bancario<br>
  <input type="radio" name="pag" value="3">Carta di credito<br>
  <input type="radio" name="pag" value="4">Vaglia postale<br>
  <input type="radio" name="pag" value="5">Rateizzazione<br>
<input type="submit" value="avanti"><br> 
</form>

<form action="all">
<input type="submit" value="annulla"><br> 
</form>
</body>
</html>