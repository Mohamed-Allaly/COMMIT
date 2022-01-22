package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Album;

import dao.AlbumsPhotos;

@WebServlet("/update")
public class update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero = request.getParameter("numero");
		
		if (numero !=null && numero.matches("[0-9]+"))
		{
			Album album = AlbumsPhotos.get(Integer.parseInt(numero));
			
			if(album !=null )
			{
				request.setAttribute("albums", album);
				getServletContext().getRequestDispatcher("/WEB-INF/modification.jsp").forward(request, response);
				
				return;
			}
		}
		
			response.sendRedirect(request.getContextPath()+"/acceuil");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero = request.getParameter("numero");
		String nom = request.getParameter("nom");
		String etat = request.getParameter("etat");
		
		
		if(numero != null && numero.matches("[0-9]+"))
		{
		Album albums = new Album(Integer.parseInt(numero),nom,etat);
		
		AlbumsPhotos.modifier(albums);
		}
		
		response.sendRedirect(request.getContextPath()+"/acceuil");
	}
	

}
