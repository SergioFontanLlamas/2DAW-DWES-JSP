<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
    if (session.getAttribute("usuario") == null) {
    	out.println("USUARIO ES NULL");
        response.sendRedirect("AuthController?accion=login");
        
    }else{
    	//System.out.println("USUARIO NO ES NULL");
    }
%>