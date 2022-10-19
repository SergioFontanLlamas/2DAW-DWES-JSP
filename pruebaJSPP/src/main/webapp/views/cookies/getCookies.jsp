<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GET COOKIES</title>
	</head>
	<body>
	
		<%
			String pelota = "";
			// Leer la cookie de la peticion del navegador
			// Almacenamos todas las cookies del navegador
			
			Cookie[] cookies = request.getCookies();
		
			// Buscamos las preferencias. En este caso la cookie de la pelota
			// Comprobamos si visita la pagina web por primera vez
			
			if(cookies != null){
				for (Cookie cookie_temporal: cookies){
					if("pelotas_favoritas.pelota_seleccionada".equals(cookie_temporal.getName())){
						pelota = cookie_temporal.getValue();
					}
				}
			}
		%>
		
		<p> Pelotas favoritas <%= pelota %>
	</body>
</html>