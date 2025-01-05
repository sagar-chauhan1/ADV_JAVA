package session1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		out.print("Welcome "+name);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Servlet2");
		rd.forward(request, response);
		HttpSession session = request.getSession(); 
		session.setAttribute("username", name);
		session.setAttribute("password", pass);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
