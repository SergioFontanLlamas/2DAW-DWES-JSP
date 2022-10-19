
<%@page import="nombredominio.models.Usuario"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../partials/login-validation.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/plugins/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>USUARIOS | EDIT</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              	<%
              		Usuario user = (Usuario) request.getAttribute("user");
          		%>
            <h1>Modificar Usuario</h1>
            <form action="UsuariosController?accion=update" method="POST">
                Nombre:<br>
                <input class="form-control" type="text" name="txtNombre" value="<%= user.getNombre()%>"><br>
                
                Email: <br>
                <input class="form-control" type="text" name="txtEmail" value="<%= user.getEmail()%>"><br>
                
                 Password: <br>
                <input class="form-control" type="text" name="txtPassword"><br>
                
                <input type="hidden" name="txtid" value="<%= user.getId()%>">
                
                <button class="btn btn-primary" type="submit" name="accion" value="update">Actualizar</button>
                <a href="UsuariosController?accion=index"><button type="button" class="btn btn-primary">Regresar</button></a>
            </form>
          </div>
        </div>
    </body>
</html>