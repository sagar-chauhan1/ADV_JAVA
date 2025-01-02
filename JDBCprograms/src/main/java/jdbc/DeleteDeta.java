package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDeta {
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded sucessfully!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String qury = "delete from Student where id=2";
			
			stmt.executeUpdate(qury);
			System.out.println("delete deta sucessfully!!");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
