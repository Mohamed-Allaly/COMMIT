package servlet;

import java.io.IOException;
import java.io.InputStream;
//import java.util.Date;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Album;
import beans.Photos;
import dao.AlbumsPhotos;

/**
 * Servlet implementation class updatephoto
 */
@WebServlet("/updatephoto")
public class updatephoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String numero = request.getParameter("numero_album");
		String file_name =request.getParameter("file_name");
		String taille =request.getParameter("taille");
		InputStream image =request.getInputStream();
		String date_creation =request.getParameter("date_creation");
		String date_update =request.getParameter("date_update");
		
		if(id != null && id.matches("[0-9]+"))
		{
			try {
		Photos photo = new Photos(Integer.parseInt(id),titre,description,file_name,Long.parseLong(taille),new  SimpleDateFormat( "jj/MM/aaaa" ).parse(date_creation),new  SimpleDateFormat( "jj/MM/aaaa" ).parse(date_update),image,Integer.parseInt(numero));
			
		AlbumsPhotos.modifierphoto(photo);
			}catch(Exception date)
			{
				
			}
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
