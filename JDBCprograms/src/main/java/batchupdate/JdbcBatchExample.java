package batchupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcBatchExample {
	
	public static void main(String args[]) {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Sagar");
			
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			
			stmt.addBatch("insert into Student (id,name,score) values (5,'sanket',89)");
			stmt.addBatch("insert into Student (id,name,score) values (6,'jay',78)");
			stmt.addBatch("insert into Student (id,name,score) values (7,'krupal',91)");
			
			int[] results = stmt.executeBatch();
			
			con.commit();
			
			System.out.println("Batch executed sucessfully. row add:"+results.length);
			for(int result : results) {
				System.out.println(result);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				if(stmt!= null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	}

}
