<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Usuario: ${usuarioLogado}
	<a href="entrada?acao=listarLances">Lances</a>
	<a href="entrada?acao=listar">Leiloes</a>
	<a href="entrada?acao=listarPessoas">Pessoas</a>
	<a href="${pageContext.request.contextPath}/entrada?acao=logout">sair</a>
</body>
</html>