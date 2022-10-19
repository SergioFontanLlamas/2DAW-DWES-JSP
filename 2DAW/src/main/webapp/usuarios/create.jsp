<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="nombredominio.modelsDAO.UsuarioDAO" %>
<%@ page import="nombredominio.models.Usuario" %>
<%@ include file = "../login-validation.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>USUARIOS | CREATE</title>
	</head>
	<body>
	<h1>USUARIOS CREATE</h1>
		<form method="POST" action="UsuariosController?action=create">
        	
        	<input type="hidden" name="id">
        	<p>Nombre:</p>
        	<input type="text" name="nombre">
        	<br>
        	<p>Email:</p>
        	<input type="email" name="email">
        	<br>
        	<p>Password</p>
        	<input type="text" name="password">
        	
        	<button type="submit">Enviar</button>
        </form>
	</body>
</html>