<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.dao.UserDao,com.bean.User"%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Insert title here</title>
</head>
<body>

<%  
String id=request.getParameter("id");  
User u=UserDao.getRecordById(Integer.parseInt(id));  
%> 

<form action="edituser.jsp" method="post">  
<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= u.getName()%>" /></td></tr> 
<tr><td>Email:</td><td>  
<input type="email" name="email" value="<%= u.getEmail()%>" /></td></tr> 
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= u.getPassword()%>"  /></td></tr>  

  

<tr><td colspan="2"><input type="submit" /></td></tr> 
</table>  
</form> 


</body>
</html>