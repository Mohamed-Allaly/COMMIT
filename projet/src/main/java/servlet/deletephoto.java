package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumsPhotos;

/**
 * Servlet implementation class deletephoto
 */
@WebServlet("/deletephoto")
public class deletephoto extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id!=null && id.matches("[0-9]+"))
		{
			AlbumsPhotos.supprimerPhoto(Integer.parseInt(id));
		}
		
		response.sendRedirect(request.getContextPath()+"/acceuil");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
