/**
 * 
 */
package nombredominio.controllers;

import nombredominio.models.*;
import nombredominio.modelsDAO.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.PageContext;

/**
 * @author sergio
 *
 */
//@WebServlet("/usuarios")
@MultipartConfig
public class UsuariosController extends HttpServlet {
	 String index = "views/users/index.jsp";
	 String create = "views/users/create.jsp";
	 String edit = "views/users/edit.jsp";
	 
	 String acceso, action, nombre, email, password, image;
	 
	 Usuario usuario;
	 UsuarioDAO usuarioDAO = new UsuarioDAO();
	 
	 int id;
	 
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 	response.setContentType("text/html;charset=UTF-8");
    }


	    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        acceso="";
        action = request.getParameter("accion");
        
        switch (action) {
//            case "image":
//                id = Integer.parseInt(request.getParameter("id"));
//                usuarioDAO.getImage(id, response);
//                break;
                
			case "index":
			    request.setAttribute("usuarios", usuarioDAO.all());

				acceso = index;  
				break;
				
			case "create":
				acceso = create;
				break;

			case "edit":
				request.setAttribute("user",usuarioDAO.show(Integer.parseInt((String)request.getParameter("id"))));
	            acceso = edit;
	            break;
			
			case "delete":
				id = Integer.parseInt(request.getParameter("id"));
				
				usuario = new Usuario();
	            usuario.setId(id);
	            
	            usuarioDAO.delete(id);
	            
	            acceso = "UsuariosController?accion=index";
				break;
			
			default:
				
				break;
		}
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        
        acceso="";
        action = request.getParameter("accion");
        
        switch (action) {
	        case "save":
				nombre = request.getParameter("txtNombre");
	            email = request.getParameter("txtEmail");
	            password = request.getParameter("txtPassword");

	            Part part = request.getPart("image");
	            InputStream is = part.getInputStream();
	            
	            usuario = new Usuario();
	            usuario.setNombre(nombre);
	            usuario.setEmail(email);
	            usuario.setPassword(getMD5(password));
	            usuario.setImage(is);
	            
	            usuarioDAO.save(usuario);
	            
	            acceso = index;
	            
				break;
			
	        case "update":
				id = Integer.parseInt(request.getParameter("txtid"));
				
				nombre = request.getParameter("txtNombre");
	            email = request.getParameter("txtEmail");
	            password = request.getParameter("txtPassword");
	            
	            usuario = new Usuario();
	            usuario.setId(id);
	            usuario.setNombre(nombre);
	            usuario.setEmail(email);
	            System.out.println("El password recogido es: " + password);
	            if(password != null && password != "") {
	                usuario.setPassword(getMD5(password));
	            }
	            usuarioDAO.update(usuario);
	            
	            acceso = index;
				break;
				
			default:
				break;
        
        }
        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
       
    @Override
    public String getServletInfo() {
        return "Short description";
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
