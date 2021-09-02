<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leilões</title>
</head>
<body>
	<hl>Sistema Leilões</hl>
	<ul id="menu" >
		<li> <a href = "${pageContext.request.contextPath}/entrada?acao=novo">cadastro de leilão</a></li>
		<li> <a href = "${pageContext.request.contextPath}/entrada?acao=listar">leilões</a></li> 
	</ul>
</body>
</html>