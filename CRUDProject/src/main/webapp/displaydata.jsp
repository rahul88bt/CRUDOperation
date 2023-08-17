<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Rahul.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="addData" method="post">
		Full Name:<br>
		<input type="text" name="name"><br>
		Email:<br>
		<input type="text" name="email"><br>
		Address:<br>
		<input type="text" name="address"><br>
		<input type="submit">
	</form>
	
	<br>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email-Id</th>
			<th>Address</th>
			<th>Update</th>
			<th>Remove</th>
			
		</tr>
		
		<%
			List<User> userList=(List<User>)
			request.getAttribute("userList");
			if(userList !=null){
				for(User user: userList){
					out.println("<tr>");
					out.println("<td>" + user.getId() + "</td>");
					out.println("<td>" + user.getName() + "</td>");
					out.println("<td>" + user.getEmail() + "</td>");
					out.println("<td>" + user.getAddress() + "</td>"); %>
					<td><form action="addData" method="post">
						<input type="text" name="name">
						<input type="text" name="email">
						<input type="text" name="address">
						<input type="submit" value="Edit">
					</form></td>
					<td><form action="DisplayDataServlet" method="post">
						<input type="hidden" name="id" value="<%= user.getId() %>">
						<input type="submit" value="Delete">
					</form></td>
					<% out.println("<tr>");
				}
			}
		%>
	</table>
	<br>
	<form action="/DisplayDataServlet" method="get">
		<label for="search">Search:</label>
		<input type="search" id="search" name="id" placeholder="id...">
		<input type="submit" value="search">
	</form>
	
</body>
</html>