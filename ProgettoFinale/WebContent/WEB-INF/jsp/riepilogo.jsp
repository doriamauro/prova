<%@page import="bean.Prodotto"%>
<%@page import="java.util.List"%>
<%@page import="bean.IndirizzoOrdine"%>
<%@page import="bean.DatiOrdine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- vf -->

Riepilogo dei dati:


<% 
DatiOrdine datiFinali = (DatiOrdine)session.getAttribute("datiordine");

out.println("L'utente " + session.getAttribute("login"));

if(datiFinali.getModPag().getIdMod()==3) {
	out.println("paga con carta di credito numero: "+ datiFinali.getNumCarta());
}
out.println("I prodotti acquistati sono:\n");
for (Prodotto p : datiFinali.getProdotti()) {
	out.println("<ul>");
	
	out.println("<li>" + p.getDescrizione() + "</li>");
	out.println("<li>" + p.getPrezzoUni() + "</li>");
	
	out.println("</ul>");
}
out.println("Il totale dovuto è: " + datiFinali.calcolaTotale());

if(datiFinali.getModPag().getIdMod()!=1) {
out.println( "L'indirizzo per la spedizione è :\n" + "via " +
datiFinali.getIndOrd().getVia() + "\n" + "Comune di " + datiFinali.getIndOrd().getComune() + "\n"+
		"Cap " + datiFinali.getIndOrd().getCap() + "\n" +"Provincia di " +datiFinali.getIndOrd().getProvincia() + 
		"\n" + "Nazione " + datiFinali.getIndOrd().getProvincia());
}
%>

<form action="finalizza">
<input type="submit" value="conferma">
</form>

</body>
</html>