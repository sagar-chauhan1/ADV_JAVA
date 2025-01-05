package servletwithjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("name");
		String userpass = request.getParameter("pass");
		PrintWriter out = response.getWriter();		
	    
	    Boolean flag = false;
	    
	    if (username == null || userpass == null) {
            out.print("Username or Password cannot be null");
            return; 
        }
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucsessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String quary = "select * from register";
			
			ResultSet re = stmt.executeQuery(quary);
			
			while(re.next()) {
				String name = re.getString(1);
				String pass = re.getString(2);
				
				if(username.equals(name) && userpass.equals(pass)) {
					flag = true;
				}
			}
			if(flag) {
				out.print("Login successfully");
			}else {
				out.print("Login Failed");
				
				RequestDispatcher rd = request.getRequestDispatcher("/indet.html");
			    rd.forward(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
