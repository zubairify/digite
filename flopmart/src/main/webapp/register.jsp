<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="banner.html" %>
<h1>Registration Page</h1>
<form action="User.fm" method="post">
<table>
	<tr><td>Name</td>
		<td><input name="name" required></td>
	</tr>
	<tr><td>Email ID</td>
		<td><input name="email" required></td>
	</tr>
	<tr><td>Password</td>
		<td><input type="password" name="password" required></td>
	</tr>
	<tr><td>Age</td>
		<td><select name="age" required>
			<% for(int a=12;a<=99;a++) { %>
				<option value="<%=a %>"><%=a %></option>
			<% } %>
			</select></td>
	</tr>
	<tr><td>Gender</td>
		<td><input type="radio" name="gender" value="Male" checked>Male
			<input type="radio" name="gender" value="Female">Female</td>
	</tr>
	<tr><td>City</td>
		<td><select name="city" required>
				<% String[] cities = {"Mumbai","Pune","Mangalore","Bengaluru","Kolkata","Delhi","Indore"}; 
				   for(String ct : cities) {%>
				   	<option value="<%=ct %>"><%=ct %></option>
				<% } %>
			</select></td>
	</tr>
	<tr><td>Mobile No</td>
		<td><input name="mobile" required></td>
	</tr>
	<tr><td><button type="submit">Register</button></td>
		<td><button type="reset">Cancel</button></td>
	</tr>
</table>
</form>
</body>
</html>