<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>user input form</h1>
	
	<form action="">
		<label for="name">Name : </label>
		<input type="text" id="name" name="name" required>
		<label for="password">Password : </label>
		<input type="password" id="pass" name="pass" required>
		<input type="submit" name="login">
	</form>
	
	<%
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
				
		if(name!=null && password!=null){
			boolean isValidUser = checkCredentials(name,password);
			
			if(isValidUser){
	%>
		
		<h2>login was successful.....!</h2>
		<p>Name : <%=name %></p>
		<p>password : <%= password %></p>
		
		<p>Table of squares : </p>
		<table>
			<tr>
				<th>Number</th>
				<th>Square</th>
			</tr>
			<%
			for(int i=1;i<=5;i++){
			%>
			<tr>
				<td><%=i %></td>
				<td><%=i*i %></td>
			</tr>
			<%
			}
			%>
		</table>
		
		<p>Expression Example :268 + 956 = <%=268+956 %></p>
		
		<%
			}else{
				out.println("<p>invelid credentials......!plese try agein...!</p>");
			}
		}else{
		%>
		<p>please enter your information above....!</p>
		<%
		}
		%>
		<%!
		public boolean checkCredentials(String username, String password){
			boolean isValid = false;
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Sagar");
				
				String query = "select * from register where name=? and password=?";
				
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()){
					isValid=true;
				}
				
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return isValid;
		}
		%>
</body>
</html>