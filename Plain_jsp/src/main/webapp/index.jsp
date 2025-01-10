<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page errorPage="error.jsp" %>
    <%@ include file="/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<form action="">
	<label for="name">Name : </label>
	<input type="text" id="name" name="name" required>
	<label for="pass">password : </label>
	<input type="password" id="pass" name="pass" required>
	<input type="submit" value="login">
	</form>
	
	<%!
		//declarstion tag
		public boolean validateUser(String name , String password){
			return name.equals("sagar") && password.equals("1111");
	}
	%>
	
	<%
		//scriptlet teg
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//chaeck if form is submitted
		if(name!=null && pass!=null){
			if(validateUser(name, pass)){
				
	%>
	<h2>Login was successful.....!</h2>
	<!-- expression tag -->
		<p>Expression Example: 269 + 323 = <%= 269 +323 %></p>
		
		<!-- mixing scripting elements with html -->
	<table>
		<tr>
		<th>Numbers :</th>
		<th>Square : </th>
		</tr>
		
		<%
			for(int i=1; i<=5;i++){
		%>
		
		<tr>
		<td><%= i %></td>
		<td><%= i*i %></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
			}else{
				throw new RuntimeException();
			}
		}else{
	%>
		<p>Please enter your information above!</p>
	<%
		}
	%>
		
		
</body>
</html>