<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="background-color:#d71868;"><center>Edit User Details</center></h1>
<form action="/editUser">
<center>
<p><Label>UserId:</Label>&nbsp<input type="text" name="id" ></p>
<p><Label>UserName:</Label>&nbsp<input type="text" name="name" ></p>
<p><Label>Password: </Label>&nbsp<input type="password" name="pwd"></p>
<p><Label>Email Id:    </Label>&nbsp<input type="email" name="email"></p>
<p><Label>Address:  </Label>&nbsp<input type="text" name="ad" ></p>
<p><Label>PhoneNo:  </Label>&nbsp<input type="text" name="no" ></p>

<p><input type="submit" value="Edit"></p>
</center>
<center>
<form action="/allUsers">
<input type="submit" Value="Back">
</form>
</center>
</form>
</body>
</html>