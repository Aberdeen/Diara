<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="addAccessory" method="post" action="Laptop?action=insert">
<table border="0" width="90%">
<tr><td colspan="2"><h2>Add a new product</h2></td></tr>
<tr><td>Name</td><td><input type="text" name="name"></td></tr>
<tr><td>Quantity</td><td><input type="text" name="quantity"></td></tr>
<tr><td>Price</td><td><input type="text" name="price"></td></tr>
 <tr><td colspan="2"><input type="submit" name="Submit" value="Submit"></td></tr>
</table>    
</form>


</body>
</html>