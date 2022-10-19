package nombredominio.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nombredominio.config.Conexion;
import nombredominio.models.Usuario;
import nombredominio.modelsDAO.UsuarioDAO;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.SQLException;

/**
 * Servlet implementation class AuthController
 */
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String index = "views/index.jsp";
	String home = "views/home.jsp";
	String login = "views/auth/login.jsp";
	String register = "views/auth/register.jsp";
	
	String acceso, action, email, password;
	
	Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	Conexion conexion = new Conexion();
	
	int id;
	    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	 	response.setContentType("text/html;charset=UTF-8");
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acceso="";
        action = request.getParameter("accion");
        conexion.conectar();
    	switch (action) {
	    	case "home":
				acceso = home;
				break;
			
			case "login":
				acceso = login;
				break;
				
			case "register":
				acceso = register;
				break;
				
			case "logout":
				/*
				 * 1. Destruir sesion usuario
				 * 2. Redireccionar a login 
				 */
				request.getSession().removeAttribute("usuario");
		        request.getSession().invalidate();
		        acceso = login;
		        
				break;
			
			default:
				
				break;
    	
    	}
    	conexion.desconectar();
    	RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acceso = "";
		usuario = null;
        action = request.getParameter("accion");
        conexion.conectar();
    	switch (action) {
			case "login":
				
				email = request.getParameter("txtEmail");
	            password = request.getParameter("txtPassword");

				try {
					usuario = usuarioDAO.loginValidation(email, getMD5(password));
				} catch (SQLException e) {
					e.printStackTrace();
				}
	            
	            if (usuario != null) {
	                request.getSession().setAttribute("usuario", usuario);
	                acceso = home;
	            } else {
	                request.setAttribute("success", 0);
	                acceso = login;
	            }
	            
				break;
				
			case "register":
				break;
			
			default:
				break;
    	}
    	conexion.desconectar();
    	
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
	}
	
	/* metodo de encriptacion la contraseña */
    public String getMD5 (String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] encBytes = md.digest(input.getBytes());
            BigInteger numero = new BigInteger(1,encBytes);
            String encString = numero.toString(16);
            while(encString.length() < 32) {
                encString = "0" + encString;
            }
            return encString;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
