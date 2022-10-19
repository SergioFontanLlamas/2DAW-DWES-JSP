<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p>Insertando cookie</p>
		<% 
			String pelota = request.getParameter("pelota");
		
			/* Creamos la cookie */
			// VER API JEE CLASE COOKIE - Par nombre,valor
			
			Cookie cookie = new Cookie("pelotas_favoritas.pelota_seleccionada", pelota);
			
			// EStablecermos vida de la cookie
			// pide en segundos. Esta dura un año
			cookie.setMaxAge(60*60*24*365);
			
			// Enviar la cookie al ordenador del usuario
			response.addCookie(cookie);			
			
		%>
		Gracias por enviar las preferencias de pelota.
		
		<a href="getCookies.jsp">Ver pelotas</a>
	</body>
</html>