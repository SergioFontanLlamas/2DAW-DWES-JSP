package nombredominio.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nombredominio.modelsDAO.UsuarioDAO;

import java.io.IOException;

/**
 * Servlet implementation class ImagesController
 */
public class ImagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioDAO usuarioDAO = new UsuarioDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	    int id = Integer.parseInt(request.getParameter("id"));
	    usuarioDAO.getImage(id, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
