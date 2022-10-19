<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "../partials/login-validation.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/plugins/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Usuarios | Create</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Usuario</h1>
                <form action="UsuariosController?accion=save" method="POST" enctype="multipart/form-data">
                    Nombre:<br>
                    <input class="form-control" type="text" name="txtNombre"><br>
                    
                    Image: <br>
                    <input class="form-control" type="file" name="image"><br>
                    
                    Email: <br>
                    <input class="form-control" type="text" name="txtEmail"><br>
                    
                    Password: <br>
                    <input class="form-control" type="text" name="txtPassword"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="save">
                    
                    <a href="UsuariosController?accion=index"><button type="button" class="btn btn-primary">Atras</button></a>
                </form>
            </div>

        </div>
    </body>
</html>