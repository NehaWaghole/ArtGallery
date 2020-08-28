package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.user;
import models.UserDao;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServ() {
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
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		System.out.println("Name: "+name);
		System.out.println("Mobile: "+mobile);
		System.out.println("Email: "+email);
		System.out.println("Password: "+password);
		
		user u=new user();
		u.setName(name);
		u.setEmail(email);
		u.setMobile(mobile);
		u.setPassword(password);
		
		int result=UserDao.saveUser(u);
		if(result>0)
		{
		response.getWriter().println("Registration is successful");
		request.getRequestDispatcher("frontpage.jsp").forward(request,response);
	    }
		else
		{
			response.getWriter().println("Registration is not successful");
			
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
