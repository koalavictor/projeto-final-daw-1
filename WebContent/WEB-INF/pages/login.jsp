<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<form action="entrada?acao=login" method="post">
		<input type="text" placeholder="login" width="200px" name="input-login">
		<input type="password" width="200px" name="input-senha">
		<input type="submit" value="entrar">
	</form>
</body>
</html>