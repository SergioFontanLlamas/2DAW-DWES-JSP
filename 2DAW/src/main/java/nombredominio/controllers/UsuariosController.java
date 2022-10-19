package nombredominio.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nombredominio.models.Usuario;
import nombredominio.modelsDAO.UsuarioDAO;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Servlet implementation class UsuariosController
 */
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	String acceso; // Variable que distingue entre las vistas a las que tengo que redireccionar
	String action; // Variable que recibo por URL y que me enlaza con el metodo/vista correspondiente
	
	Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	String nombre, email, password;
	
	String index = "usuarios/index.jsp";
	String create = "usuarios/create.jsp";
	String edit = "usuarios/edit.jsp";
	
	ArrayList<Usuario> usuarios;
	
	int id;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acceso = "";
		action =  request.getParameter("action"); // valor que recojo por url 
		
		switch (action) {
			case "index":
				usuarios  = usuarioDAO.all();
				request.setAttribute("usu", usuarios);
				request.setAttribute("clase", "Somos de 2DAW");
				acceso = index;
				break;
				
			case "create":
				acceso = create;
				break;
				
			case "edit":
				// Recojo el ID por URL
				id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("usu", usuarioDAO.find(id));			
				acceso = edit;
				break;
				
			case "delete":
				id = Integer.parseInt(request.getParameter("id"));
				usuarioDAO.delete(id);
				
				acceso = index;
				break;
				
			default:
				
				break;
		}
//		response.sendRedirect(acceso);
		response.setHeader("Location", request.getContextPath() + "/" + acceso);
		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acceso = "";
		action =  request.getParameter("action"); // valor que recojo por url 
		
		switch (action) {
			case "create":
				nombre = request.getParameter("nombre");
				email = request.getParameter("email");
				password = request.getParameter("password");
				
				usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setEmail(email);
				usuario.setPassword(getMD5(password));
				
				usuarioDAO.save(usuario);
				acceso = index;
				
				break;
			
			case "update":
				id = Integer.parseInt(request.getParameter("id"));
				nombre = request.getParameter("nombre");
				email = request.getParameter("email");
				password = request.getParameter("password");
				
				usuario = new Usuario();
				usuario.setId(id);
				usuario.setNombre(nombre);
				usuario.setEmail(email);
				
				if(password != null && password != "") {
					usuario.setPassword(getMD5(password));
				}
				// Si usuario no introduce password, no hay setPassword. Queda en null
				usuarioDAO.update(usuario);
				
				acceso = index;
				break;

	
			default:
				
				break;
		}
		
		// Lanzar la vista en funcion del action recibido
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}
	
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
