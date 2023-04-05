<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.dao.UserDao,com.bean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View AllUser</title>
</head>
<body>


	<table border="1" width="50%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>

			<%
			List<User> list = UserDao.GetDetail();
			for (User e : list) {
			%>
		<tr>
			<td><a href="Update.jsp?id=<%= e.getId()%>"><%= e.getId()%></a></td>
			<td><%=e.getName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><a href="delete.jsp?id=<%= e.getId()%>">Delete</a></td>
			<td><a href="Update.jsp?id=<%= e.getId()%>">Update</a></td>
		</tr>


		<%
		}
		%>
	
</body>
</html>