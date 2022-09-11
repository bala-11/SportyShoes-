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
<h1 style="background-color:#d71868;"><center>Your Order</center></h1>
<%List<Orders> s=(List<Orders>)request.getAttribute("list");
%>

<table  align="center">
<tr><th>Your OrderId</th><th>Shoeid</th><th>ShoeBrand</th><th>Color</th><th>Cost</th></tr>
<%for(Orders ss:s){ %>
<tr><td><%=ss.getOrderid()%></td><td><%=ss.getShoeid()%></td><td><%=ss.getShoebrand() %></td><td><%=ss.getColor() %></td><td><%=ss.getCost() %></td></tr>
<%} %>



</table>
<br><center>
<form action="/buy">
<input type="submit" Value="OrderAgain">
</form>
</center>
<br><center>
<form action="last.jsp">
<input type="submit" Value="Exit">
</form>
</center>
</body>
</html>