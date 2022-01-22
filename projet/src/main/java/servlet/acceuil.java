package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Album;
import dao.AlbumsPhotos;

/**
 * Servlet implementation class acceuil
 */
@WebServlet("/acceuil")
public class acceuil extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("Albums", AlbumsPhotos.ListerALbums());
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
