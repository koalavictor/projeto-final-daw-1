<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Propoe Lances</title>
</head>
<body>
	<hl>Propoe Lances</hl>
		<form action="entrada?acao=propoeLance" method="post">
		<input type="text" placeholder="lance" width="200px" name="lance">
		<input type="text" placeholder="leilao" width="200px" name="leilao">
		<input type="text" placeholder="pessoa" width="200px" name="pessoa">
		<input type="submit" value="lance">
	</form>
</body>
</html>