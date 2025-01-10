package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistationDao {
	
	Connection con;
	PreparedStatement pstmt;
	
	public RegistationDao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucsessfully!!!");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean regDetials(String name, String password) {
		String query = "insert into register values(?,?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean loginDetials(String username , String password) {
		
		String query = "select * from register";
		
		try {
			pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				if(username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					flag = true;
				}
			}
			
			if(flag == true) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

}
