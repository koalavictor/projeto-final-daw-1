<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lances</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<h1>Lista de Lances</h1>

	<p><a href="${pageContext.request.contextPath}/entrada?acao=lance">Novo lance</a></p>
	<table>
		<thead>
			<tr>
				<th>Leilao</th>
				<th>Valor do lance</th>
				<th>Nome da pessoa</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach 	items="${lances}" var= "l">
				<tr>
					<td>${l.leilao.item}</td>
					<td>R$ ${l.valor}</td>
					<td>${l.pessoa.nome}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
