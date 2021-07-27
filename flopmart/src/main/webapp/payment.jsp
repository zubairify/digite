<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% double total = (Double) request.getAttribute("TOTAL"); %>
<form action="Checkout.fm">
	Order Amount: <input value=<%= total %> readonly>
	
</form>
</body>
</html>