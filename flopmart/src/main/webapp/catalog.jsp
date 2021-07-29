<%@page import="com.flopmart.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="banner.jsp" />
<h1>Welcome to Product Catalogue</h1>
<% List<ProductBean> catalog = (List<ProductBean>) request.getAttribute("CATALOG"); %>
<table border="2">
<tr><th>Code</th><th>Name</th><th>Price</th><th>Stock</th><th>Image</th><th>Action</th></tr>
	<% for(ProductBean p : catalog) { %>
		<tr>
			<td>${p.code}</td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getStock() %></td>
			<td><img src=<%=p.getImage() %> height="50" width="50"></td>
			<% if(p.getStock() == 0) { %>
				<td><a href="Cart.fm?code=<%=p.getCode()%>">Add to Cart</a></td>
			<% } else { %>
				<td>Out of stock</td>
			<% } %>
		</tr>
	<% } %>
</table>
</body>
</html>
