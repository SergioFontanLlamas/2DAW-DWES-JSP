<!DOCTYPE html>
<html>
    <head>
        <title>INDEX</title>
    </head>
    <body>
        <h1> EXPRESIONES </h1>
        <p> La fecha del sistema es: <%= new java.util.Date() %></p>
        <p> Nombre en mayusculas: <%= new String("juan").toUpperCase() %> </p>
        <p> La suma de 3 y 5 es: <%= 5+7 %></p>
        
        
        <h1> SCRIPTLETS </h1>
        <%
        	for (int i= 0; i<10; i++){
        		out.println("iteracion " + i);	
        		out.println("<br>");
        		
        	}
        
        %>
        
        <h1> DECLARACIONES</h1>
        <%!
        	int resultado = 0;
        	public int suma (int a, int b){
        		resultado = a+b;
        		return resultado;
        	}
        %>
        
        <%= suma(4,5) %>
    </body>
</html>