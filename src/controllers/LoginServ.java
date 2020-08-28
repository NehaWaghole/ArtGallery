package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserDao;
import models.user;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        ServletConfig sc = getServletConfig();
		
		String title = sc.getInitParameter("title");
		
		System.out.println("title: "+title);
		
		ServletContext ctx = getServletContext();
		String host = ctx.getInitParameter("host");
		
		System.out.println("Host: "+host);
		
		String name = request.getParameter("uname");
		String password = request.getParameter("password");
		
		System.out.println("Name: "+name);
		System.out.println("Password: "+password);
		
		user u=new user();
		u.setName(name);
		u.setPassword(password);
		
		if(UserDao.validate(name, password))
		{
		response.getWriter().println("Login successful");
		request.getRequestDispatcher("My_profile.jsp").forward(request,response);
	    }
		else
		{
			response.getWriter().println("Login not successful,Please check your name and password");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
