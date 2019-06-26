<%@page import="bean.DatiRate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<!-- METTERE FUNZIONE -->




Dati rateizzazione: <br><br>

<% DatiRate dr= (DatiRate) request.getAttribute("datiRate"); %>
<form>
<input type="number" name="Tan" value="<%= dr.getTan() %>" > <br>
<input type="number" name="maxTaeg" value="<%= dr.getMaxTaeg() %>" > <br>
<input type="number" name="nRate" value="<%= dr.getnRate() %>" > <br>
<input type="button" value="Modifica">
</form>

 
        



 <script type="text/javascript">
      $('.button').on('click' ) {
    		
    	    	});
  </script>


</body>
</html>