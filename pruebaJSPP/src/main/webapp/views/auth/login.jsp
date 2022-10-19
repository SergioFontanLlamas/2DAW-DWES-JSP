<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/plugins/bootstrap/dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>LOGIN</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>LOGIN</h1>
                
                <form action="AuthController?accion=login" method="POST">                    
                    Email: <br>
                    <input class="form-control" type="text" name="txtEmail"><br>
                    
                    Password: <br>
                    <input class="form-control" type="text" name="txtPassword"><br>
                    
                    <button class="btn btn-primary" type="submit" name="accion" value="AuthController?accion=login">Login</button>
                    <a href="IndexController?accion=index">Atras</a>
                </form>
            </div>

        </div>
    </body>
</html>