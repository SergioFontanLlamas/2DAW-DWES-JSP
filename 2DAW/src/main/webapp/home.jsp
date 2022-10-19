<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "login-validation.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>HOLA ESTOY EN MI HOME</h1>
		<a href="UsuariosController?action=index">Index usuarios</a>
		<a href="AuthController?action=logout">Cerrar sesion</a>
	</body>
</html>