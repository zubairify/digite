<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="media/theme.css">
</head>
<body>
<%@ include file="banner.html" %>
<table width="800" border="2">
<tr><td valign="top">
		<b>Hello and Welcome to Flopmart.com</b><br>
	</td>
	<td>
		<% if(request.getParameter("invalid") != null) { %>
			<span id="err">Invalid Email ID/Password</span>
		<% } %>
		<form action="User.fm">
		<table>
			<tr><th colspan="2">Login Screen</th></tr>
			<tr><td>Email ID</td>
				<td><input name="email"></td>
			</tr>
			<tr><td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr><th colspan="2"><input type="submit" value="Login"></th></tr>
		</table>
		</form>
	</td>
</tr>
</table>
</body>
</html>