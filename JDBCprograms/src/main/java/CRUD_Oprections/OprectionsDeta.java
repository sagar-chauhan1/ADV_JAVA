package CRUD_Oprections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OprectionsDeta {
	
	public void insert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucsessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String quary = "insert into Student values(1,'dharmik',70)";
			stmt.executeUpdate(quary);
			
			System.out.println("Data added Sucessfully!!!");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucsessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String quary = "update Student set name='ashvin' where id=1";
			stmt.executeUpdate(quary);
			
			System.out.println("Data update Sucessfully!!!");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucsessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String quary = "delete from Student where id=1";
			stmt.executeUpdate(quary);
			
			System.out.println("Data delete Sucessfully!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void show() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucsessfully!!!");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
			System.out.println("Connnection established!!!");
			
			Statement stmt = con.createStatement();
			
			String quary = "select * from Student";
			
			ResultSet rs = stmt.executeQuery(quary);
			
			while(rs.next()) {
				System.out.println("Student id\t"+rs.getInt(1));
				System.out.println("Student name\t"+rs.getString(2));
				System.out.println("Student mark\t"+rs.getInt(3));
			}
			
			System.out.println("Data show Sucessfully!!!");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
