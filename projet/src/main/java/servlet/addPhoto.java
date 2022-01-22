package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.AlbumsPhotos;

/**
 * Servlet implementation class addPhoto
 */
@WebServlet("/add")
public class addPhoto extends HttpServlet {
	
	public static final String CHAMP_FICHIER     = "image";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("ids", AlbumsPhotos.get());
		getServletContext().getRequestDispatcher("/WEB-INF/photo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		String description =request.getParameter("description");
		String numero = request.getParameter("num");
		
		for (Part part : request.getParts()) {
			
			String filename = getFilename(part);
			
			if(!filename.isEmpty())
			{
				//String fieldname = part.getName();
	            filename = filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.   
	           
	            AlbumsPhotos.AjoutPhoto(titre, description, filename, Integer.parseInt(numero));
	           
			}
			
	    }
		
		response.sendRedirect(request.getContextPath()+"/acceuil");
	}

	private String getFilename(Part part) {
		 for (String cd : part.getHeader("content-disposition").split(";")) {
		        if (cd.trim().endsWith("jpg")) {
		            return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
		        }
		    }
		    return null;
	}

	

}
