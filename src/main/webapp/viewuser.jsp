<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.example.demo.*" %>
    <%@ page  import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="background-color:#d71868;"><center>List Of Users</center></h1>
<%List<Users> u=(List<Users>)request.getAttribute("list");
%>

<table  border="1" align="center">
<tr bgcolor="#edc9af"><th>UserId</th><th>UserName</th><th>Email</th><th>Address</th><th>PhoneNo</th><th>Actions</th></tr>
<%for(Users us:u){ %>
<tr><td><%=us.getUserid()%></td><td><%=us.getUsername() %></td><td><%=us.getEmail() %></td><td><%=us.getAddress() %></td><td><%=us.getPhno() %></td><td><a href="editUser.jsp">Edit</a>|<a href="deleteUser?userid=<%=us.getUserid()%>" >Delete</a></tr>
<%} %>



</table>
<br>
<center>
<form action="/new.jsp">
<input type="submit" value="AddUser">
</form>
<br>
<form action="Done.jsp">
<input type="submit" value="HomePage">
</form>
</center>
</body>
</html>