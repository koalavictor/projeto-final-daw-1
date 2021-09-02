<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pessoas</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Lista de Pessoas</h1>
	<p><a href= "${pageContext.request.contextPath}/entrada?acao=novaPessoa">Nova Pessoa</a></p>
	
	<table>
		<thead>
			<tr>
				<th>nome</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach 	items="${pessoas}" var= "p">
				<tr>
					<td>${p.nome}</td>
					<td><a href="entrada?acao=excluirPessoa&nomePessoa=${p.nome}">excluir</a></td>
					<td><a href="entrada?acao=atualizarPessoa&nomePessoa=${p.nome}">atualizar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>