<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="background-color:#d71868;"><center>Login</center></h1>
<form action=/userlogin>
<center>
<p><Label>UserName</Label><input type="text" name="name" placeholder="Enter Name"></p>
<p><Label>Password</Label><input type="password" name="pwd" placeholder="Enter Password"></p>
<p><input type="submit" value="Login"></p>
</form>
<form action="/userlogin.jsp">
<input type="submit" value="New User">
</form>
<br>

</center>

</body>
</html>