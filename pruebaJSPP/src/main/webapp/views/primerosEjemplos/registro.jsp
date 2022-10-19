<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Usuario confirmado
		<br>
		<p>Nombre: <%= request.getParameter("nombre") %></p>
		<p>Email: <%= request.getParameter("email") %></p>
		
		<% 
			
			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoJSP", "root", "");
			java.sql.Statement statement = conexion.createStatement();
			String instruccionSQL ="INSERT INTO usuarios (nombre, email, password) VALUES('"+ nombre +"', '"+ email +"', null) ";
			statement.executeUpdate(instruccionSQL);
			out.println(instruccionSQL);
			out.println("Registrado con exito");
		%>
	</body>
</html>