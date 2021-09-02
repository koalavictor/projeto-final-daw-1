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
<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Lista de Leiloes</h1>
	<p><a href= "${pageContext.request.contextPath}/entrada?acao=novo">Novo leilao</a></p>
	
	<table>
		<thead>
			<tr>
				<th>nome</th>
				<th>data expiracao</th>
				<th>Lance minimo</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach 	items="${leiloes}" var= "l">
				<tr>
					<td>${l.item}</td>
					<td>${l.dataExpiracao}</td>
					<td>${l.valor}</td>
					<td><a href="entrada?acao=excluir&nomeLeilao=${l.item}">excluir</a></td>
					<td><a href="entrada?acao=atualizar&nomeLeilao=${l.item}">atualizar</a></td>
					<td><a href="entrada?acao=listarLances&nomeLeilao=${l.item}">lance</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>