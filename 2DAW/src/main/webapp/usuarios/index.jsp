<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@ page import="nombredominio.modelsDAO.UsuarioDAO" %>
<%@ page import="nombredominio.models.Usuario" %>
<%@ page import="java.util.ArrayList"%>
<%@ include file = "../login-validation.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>USUARIOS | index</title>
		<link href="resources/css/style.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<h1>USUARIOS INDEX</h1>
		<a href="UsuariosController?action=create">Crear usuario</a>
		<table>
			<div class="row">
		        <div class="col-lg-4"></div>
			        <div class="col-lg-4">
			            <table class="table">
			                <thead>
			                    <tr>
			                        <th scope="col">#</th>
			                        <th scope="col">Nombre</th>
			                        <th scope="col">Email</th>
			                        <th scope="col"></th>
			                    </tr>
			                </thead>
			                <tbody class="table-group-divider">
			                 <%-- <%
			                	ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usu");
			                	
			                	for (int i= 0; i < usuarios.size(); i++){
			                		Usuario usuario = usuarios.get(i);
			                %>
			                    <tr>
			                        <td><%= usuario.getId() %></td>
			                        <td><%= usuario.getNombre() %></td>
			                        <td><%= usuario.getEmail() %></td>
			                        <td>
				                        <a href="UsuariosController?action=edit&id=<%= usuario.getId() %>">Edit</a>
				                        <a href="UsuariosController?action=delete&id=<%= usuario.getId() %>">Delete</a>
			                        </td>
			                    </tr>
			                    <%} %> --%>
			                    <daw:forEach var="usuario" items="${usu}">
			                    	<tr>
				                        <td>${usuario.getId()}</td>
				                        <td>${usuario.getNombre()}</td>
				                        <td>${usuario.getEmail()}</td>
				                        <td>
					                        <a href="UsuariosController?action=edit&id=${usuario.getId()}">Edit</a>
					                        <a href="UsuariosController?action=delete&id=${usuario.getId()}">Delete</a>
				                        </td>
				                    </tr>
			                    </daw:forEach>
			                </tbody>
			            </table>
			        </div>
		        <div class="col-lg-4">
		        
			        <!--  
			        	el atributo items recoge el elemnto que trae mi controller. Seria equivalente al request.getAttribute()
			        	el atributo var seria la variable local para cada iteracion del forEach
			        -->
		        	<daw:forEach var="usuario" items="${usu}">
                    	<daw:if test="${usuario.getId() == 1}">
                    		<h1> HOLA ${usuario.getNombre() }</h1>
                    	</daw:if>
                    </daw:forEach>
                    
                    <!-- 
	                    la etiqueta out recoge un valor o variable que esté situado dentro de mi .jsp
	                    El atributo value contiene el nombre de esa variable que en este caso me manda el controlador
                     -->
                    <p><daw:out value="${clase}"></daw:out></p>
					
                    <daw:forEach var="usuario" items="${usu}">
	                    <!-- 
		                    El atributo test evalua una codicion
		                    choose es similar a un switch y contiene lo siguiente
			                    when seria el equivalente al case
			                    otherwise seria equivalente al default
	                    -->
	                    <daw:choose>
		                    <daw:when test="${usuario.getId() == 5}">
		                    	<h1> HOLA ${usuario.nombre } ESTAMOS EN EL 5</h1>
		                    </daw:when>
		                    
		                    <daw:when test="${usuario.getId() == 6}">
		                    	<h1> HOLA ${usuario.nombre } ESTAMOS EN EL 6</h1>
		                    </daw:when>
		                    
		                    <daw:otherwise>
		                    	<h1> DIRECTORA FUERA </h1>
		                    </daw:otherwise>
	                    </daw:choose>
                     </daw:forEach>
		        </div>
		    </div>
		</table>
	</body>
</html>