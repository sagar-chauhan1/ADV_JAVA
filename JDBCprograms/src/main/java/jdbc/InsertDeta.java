package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDeta {
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String query = "insert into Student values(2,'dharmik',78)";
			stmt.executeUpdate(query);
			System.out.println("Data added Sucessfully!!!");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
