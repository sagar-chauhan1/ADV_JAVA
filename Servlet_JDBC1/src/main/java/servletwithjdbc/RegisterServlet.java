package servletwithjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String pass = req.getParameter("pass");
		PrintWriter out = resp.getWriter();
		out.println("<h1>Welcome "+ name +"</h1>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Sagar");
			System.out.println("Connnection established!!!");
			
			
			String query = "insert into register values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.executeUpdate();
			System.out.println("Registered successfully");
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/Login.html");
			rd.include(req, resp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
