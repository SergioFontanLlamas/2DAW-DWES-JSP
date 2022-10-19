<%@page import="java.util.ArrayList"%>
<%@page import="nombredominio.models.Usuario"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>

<%@ include file = "../partials/login-validation.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/plugins/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Usuarios | index</title>
    </head>
    <body>
        <div class="container">
            <h1>Usuarios</h1>
            <a class="btn btn-success" href="UsuariosController?accion=create">Nuevo Usuario</a>
            <a href="AuthController?accion=home"><button type="button" class="btn btn-primary">Atras</button></a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">EMAIL</th>
                        <th class="text-center">IMAGE</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
	                <c:forEach var="usuario" items="${usuarios}">
	                	<tr>
		                	<td class='text-center'> ${usuario.getId()} </td>
		                	<td class='text-center'> ${usuario.getNombre()}</td>
		                	<td class='text-center'> ${usuario.getEmail()} </td>
		                	<td class='text-center'> <img src="ImagesController?id=${usuario.getId()}" width="120px" height="120px" ></td>
		                	<td class='text-center'> 
		                			 <a class='btn btn-warning' href='UsuariosController?accion=edit&id=${usuario.getId()}'>Editar</a>
		                             <a class='btn btn-danger' href='UsuariosController?accion=delete&id=${usuario.getId()}'>Eliminar</a>
		                	</td>
	                	</tr>
	                </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
