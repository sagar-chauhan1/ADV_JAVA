package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RegistationDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("name");
		String pass = request.getParameter("pass");
		
	 	RegistationDao dao = new RegistationDao();
	 	
	 	Boolean flag = dao.loginDetials(user, pass);
	 	
	 	if(flag==true) {
	 		RequestDispatcher rd = request.getRequestDispatcher("/Login_Sucess.jsp");
	 		rd.forward(request, response);
	 	}else {
	 		RequestDispatcher rd = request.getRequestDispatcher("/Invalid_info.jsp");
	 		rd.forward(request, response);
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
