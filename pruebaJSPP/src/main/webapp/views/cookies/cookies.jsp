<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SET COOKIES</title>
	</head>
	<body>
		<form action="setCookies.jsp">
			<p>Selecciona un tipo de pelota</p>
			<select name="pelota">
				<option>Tenis</option>
				<option>Baloncesto</option>
				<option>Futbol</option>
				<option>Balonmano</option>
			</select>
			
			<input type="submit" value="Enviar">
		</form>
	</body>
</html>