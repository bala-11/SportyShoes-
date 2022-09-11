<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 ><center>New User</center></h1>
<form action="/adduser">
<center>
<p><Label>UserName:</Label>&nbsp<input type="text" name="name" placeholder="Enter Name"></p>
<p><Label>Password: </Label>&nbsp<input type="password" name="pwd" placeholder="Enter Password"></p>
<p><Label>Email Id:    </Label>&nbsp<input type="email" name="email" placeholder="Enter EmailId"></p>
<p><Label>Address:  </Label>&nbsp<input type="text" name="ad" placeholder="Enter Address"></p>
<p><Label>PhoneNo:  </Label>&nbsp<input type="text" name="no" placeholder="Enter Phoneno"></p>

<p><input type="submit" value="Add"></p>
</center>
</form>
</body>
</html>