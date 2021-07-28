<%@page import="com.flopmart.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="media/perhead.jpg" width="300" height=50 align="left">
<span style="font:38pt georgia;color:teal">FLOPMART</span>
<%	RegisterBean user = (RegisterBean) session.getAttribute("USER");
	if(user != null) { %>
		<span>Hello <%=user.getName() %> 
		<a href="profile.jsp">Profile</a> |
		<a href="cart.jsp">My Cart</a> |
		<a href="Cart.fm">Catalogue</a> |  
		<a href="User.fm?logout=yes">Logout</a></span>
<%	} else { %>
		<span>Hello Guest!</span>
<%	} %>
<hr size=4 color="gold">
</body>
</html>
