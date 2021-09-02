<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Pessoa</title>
</head>
<body>
	<hl>Cadastro de Pessoa</hl>
	<form action="entrada?acao=cadastrarPessoa" method="post">
		
		<input type="text" name="input-name" placeholder="informe o nome"/>
		<input type="submit" value="salvar"/>
	</form>
</body>
</html>