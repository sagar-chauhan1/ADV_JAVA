package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RetriveData {
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connection");
			PreparedStatement ps = con.prepareStatement("insert into Student values(6,'sagar',87)");
			
			int i=ps.executeUpdate();
			
			System.out.println("Success");
			
		}
		catch(Exception e) {
			
		}
		}
		

}
