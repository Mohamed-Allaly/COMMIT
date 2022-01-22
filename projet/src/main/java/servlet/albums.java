package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumsPhotos;

/**
 * Servlet implementation class albums
 */
@WebServlet("/album")
public class albums extends HttpServlet {
	
	private boolean message = false;
	
	public boolean getMessage()
	{
		return message;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		getServletContext().getRequestDispatcher("/WEB-INF/albums.jsp").forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String etat = request.getParameter("etat");
		
		if(nom !=null && etat !=null )
		{
			
			AlbumsPhotos.AjoutAlbum(nom, etat);
		
		response.sendRedirect(request.getContextPath()+"/acceuil");
		}
		
		else response.sendRedirect(request.getContextPath()+"/album");
	}

}
