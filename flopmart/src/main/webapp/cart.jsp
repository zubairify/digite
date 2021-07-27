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
<h1>Welcome to Product Cart</h1>
<% List<ProductBean> cart = (List<ProductBean>) session.getAttribute("CART"); 
   int idx = 0;
   double total = 0; %>
<% if(request.getParameter("index") != null) {
	cart.remove(Integer.parseInt(request.getParameter("index")));
	session.setAttribute("CART", cart);
} %>
<table border="2">
<tr><th>Code</th><th>Name</th><th>Price</th><th>Stock</th><th>Image</th><th>Action</th></tr>
<% if(cart.size() == 0) { %>
	<tr><th colspan="6">Your cart is empty! Add products to your cart.</th></tr>
<% } else { 
		for(ProductBean p : cart) { %>
		<tr>
			<td><%=p.getCode() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getStock() %></td>
			<td><img src=<%=p.getImage() %> height="50" width="50"></td>
			<td><a href="cart.jsp?index=<%=idx%>">Remove from Cart</a></td>
		</tr>
	<% idx ++; total += p.getPrice(); } %>
	<tr><th colspan="6">Cart Total of <%= idx %> products : <%= total %></th></tr>
<% } %>
</table>
<a href="Cart.fm">Add More Products</a> | <a href="Checkout.fm?amount=<%= total %>">Checkout</a>
</body>
</html>
