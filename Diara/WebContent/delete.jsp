<%@ page language="java" import = "java.util.Vector, java.util.Iterator, com.Laptop.models.Accessories" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="top" class="com.Laptop.models.Accessories" />

<%

Vector <Accessories> vec = new Vector <Accessories>( );
 vec = (Vector)request.getAttribute("items");
%>

<table border="0">
<tr><td>ID</td><td>Name</td><td>delete</td></tr>
<%
Iterator iter = vec.iterator();
while (iter.hasNext()){
    top = (Accessories) iter.next();
%>
<tr><td><%=top.getId() %></td><td><%=top.getName() %></td>
<td> <a href= "http://localhost:8080/Diara/Laptop?action=deleteAccessory&id=<%=top.getName()%>"> delete </a> </td>
</tr>
<%
}
%>
</table>


</body>
</html>