<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="background-color:#d71868;"><center>Edit Shoe Details</center></h1>
<form action="/edit">
<center>
<p><Label>ShoeId:</Label>&nbsp<input type="text" name="id" ></p>
<p><Label>ShoeBrand:</Label>&nbsp<input type="text" name="brand" ></p>
<p><Label>Color:    </Label>&nbsp<input type="text" name="col" ></p>
<p><Label>Quantity:  </Label>&nbsp<input type="text" name="qn" ></p>
<p><Label>Cost:  </Label>&nbsp<input type="text" name="cost" ></p>
<p><input type="submit" value="Edit"></p>
</center>
</form>
<center>
<form action="/getallShoe">
<input type="submit" Value="Back">
</form>
</center>
</body>
</html>