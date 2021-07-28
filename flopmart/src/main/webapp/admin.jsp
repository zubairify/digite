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
<li>All Products</li>
<li>Add Product</li>

<% List<ProductBean> products = (List<ProductBean>) request.getAttribute("PRODUCTS"); %>
<table>
<% for(ProductBean p : products) { %>

<tr>
<form action="Admin.fm">
	<td><%= p.getCode() %></td>
	<td><%= p.getName() %></td>
	<td><%= p.getPrice() %></td>
	<td><input name="stock" value=<%=p.getStock() %>><input type="hidden" name="code" value="<%=p.getCode() %>">
		<button type="submit">Update</button></td>
	<td><a href="<%= p.getImage() %>" target="_new">Image</a></td>
</form>
</tr>
<% } %>
</table>
</body>
</html>
