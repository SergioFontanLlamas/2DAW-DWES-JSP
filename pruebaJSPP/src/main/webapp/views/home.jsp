
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "partials/login-validation.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/plugins/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>HOME</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container">
            <a class="btn btn-success btn-lg" href="UsuariosController?accion=index">Ver usuarios</a>
            <a class="btn btn-danger btn-lg" href="AuthController?accion=logout">Desconectar</a>
        </div>
    </body>
</html>
