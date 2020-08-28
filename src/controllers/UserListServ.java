package controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.user;
import models.UserDao;

/**
 * Servlet implementation class UserListServ
 */
@WebServlet("/UserListServ")
public class UserListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		ArrayList<user> ulist = UserDao.getUsers();
		
		pw.print("<table><tr><th>Name</th><th>Email</th><th>Mobile</th></tr>");
		
		for(user u : ulist)
		{
			pw.print("<tr>");
			pw.print("<td>"+u.getName()+"</td>");
			pw.print("<td>"+u.getEmail()+"</td>");
			pw.print("<td>"+u.getMobile()+"</td>");
			pw.print("</tr>");
			
		}
		
		pw.print("</table>");
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
