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

<% DatiRate dr= (DatiRate) request.getAttribute("datiRate");
%>

 <div class="datiRate">
          <span><%= dr.getTan() %></span>
          <span><%= dr.getMaxTaeg() %></span>
          <span><%= dr.getnRate() %></span>
            
        </div>
        
        
<div class="bottoni">
 <script type="text/javascript">
      $('.modifica-btn').on('click', function(e) {
    		
    	    	});
      

  </script>


</body>
</html>