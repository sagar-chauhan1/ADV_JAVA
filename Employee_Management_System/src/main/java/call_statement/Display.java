package call_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;


public class Display {
	
	public static void main(String args[]) {
		
		
		Connection con = null;
		CallableStatement callstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucessfully!!!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Sagar");
			System.out.println("Connnection established!!!");
			
			String query = "{CALL DisplayEmployee()}";
			callstmt = con.prepareCall(query);
			
			rs = callstmt.executeQuery();
			
			System.out.println("Employee Details:");
			System.out.println("id\tname\tage\tsalary");
			System.out.println("--------------------");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}
}
