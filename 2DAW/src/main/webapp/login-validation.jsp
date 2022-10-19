<%@page import="nombredominio.models.Usuario" %>
<%
	if(request.getSession().getAttribute("usuario")!= null){
		out.println("<p>EXISTE USUARIO LOGUEADO</p>");
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		out.println("USUARIO LOGUEADO : " + u.getNombre());
		
		//out.println(request.getSession().getAttribute("usuario").getEmail());
	}else{
		//Redirigir al login para introducir credenciales
		response.sendRedirect("AuthController?action=login");
	}
%>