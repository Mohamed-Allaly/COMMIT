package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlbumsPhotos;

/**
 * Servlet implementation class lister
 */
@WebServlet("/lister")
public class lister extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("numero");
	if (num !=null && num.matches("[0-9]+")) 
		{
			request.setAttribute("photos", AlbumsPhotos.lister(Integer.parseInt(num)));
			getServletContext().getRequestDispatcher("/WEB-INF/mesphots.jsp").forward(request, response);
	}else
		
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
