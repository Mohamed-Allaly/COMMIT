package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import beans.Photos;
import dao.AlbumsPhotos;

/**
 * Servlet implementation class login
 */
@WebServlet({"","/login"})

public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("album", AlbumsPhotos.ListerALbums());
		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login    =request.getParameter("login");
		String password =request.getParameter("password");
		
		
		if (login.equals("utilisateur") && password.equals("passer"))
		{
			response.sendRedirect(request.getContextPath() +"/acceuil");
		}
		else
		response.sendRedirect(request.getContextPath());
	}

}
