<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Iterator, java.util.Vector, com.Laptop.models.Accessories" 
    %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="top" class="com.Laptop.models.Accessories" scope="session"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>

<%

Vector <Accessories> vec = new Vector <Accessories>( );
 vec = (Vector)request.getAttribute("stuff");
%>

<table border="0">
<tr><td>ID</td><td>Name</td><td>Quantity</td><td>Price</td></tr>
<%
Iterator iter = vec.iterator();
while (iter.hasNext()){
    top = (Accessories) iter.next();
%>
<tr><td><%=top.getId() %></td><td><%=top.getName() %></td>
<td><%=top.getQuantity() %></td><td><%=top.getPrice() %></td></tr>
<%
}
%>
</table>


</body>
</html>