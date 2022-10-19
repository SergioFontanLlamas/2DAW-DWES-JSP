<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<p>Insertando la cookie</p>
		<%
			// 1. Recoger elemento del select
			String deporte = request.getParameter("favorito");	
			
			// 2. Creo la Cookie --> (clave, valor)
			// Ver API JEE Cookie.
			Cookie cookie = new Cookie("deporte_favorito", deporte);
			
			// 3. Establecer la vida de la cookie.
			// Tener en cuenta que es en segundos
			//cookie.setMaxAge(60*60); // 1h
			cookie.setMaxAge(5); // 5seg
			
			// 4. Enviar la cookie
			response.addCookie(cookie);
		%>
		<a href="getCookies.jsp">Ver deportes</a>
	</body>
</html>