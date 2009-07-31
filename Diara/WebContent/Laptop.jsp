<%@ page language="java" import="java.util.Date,java.util.Vector,java.util.Iterator, java.sql.SQLException, com.Laptop.models.Accessories  " 
contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Laptop</title>
</head>
<body>
<h3>Laptops built to your specification</h3>
<h4>This is an expression: 
<%=new Date() %></h4>

<h4>We can also do scriptlets based on Java code in the file:</h4>
<% int count = 0; %>
<%! int count2 = 0; %>
<p>Local variable count is now: <%=++count %></p>
<p>Global variable count2 is now <%= ++count2 %></p>
<h4>We can also declare methods in the page:</h4>
<%! int doubleCount(){
    count2 = count2*2;
    return count2;
    } %>	
    <p>DoubleCount is: <%=doubleCount() %> </p>
<p>Retrieved shout: <%=request.getParameter("message").toUpperCase() %></p>


<p>We'll put some Laptop Accessories here later.</p>
<p>We'll put some Laptop Accessories here later.</p>
<%@ include file="myInclude.txt" %>
<% String name = request.getParameter("name");
        out.println("<div align=\"center\"><table><tr><td<a href =\"/Diara/\">");
        out.println("<table bgcolor=\"#66ccff\"><tr><td><div align=\"center\"><table><tr><td<a href =\"/Diara/index.html\">Home</a>");
        out.println("<a href =\"shout.jsp\">go to shout</a>");
        out.println("<table bgcolor=\"#ffffcc\">");
        try {
        	Accessories top = new Accessories();
        	Vector <Accessories> vec = new Vector <Accessories>();
        	vec = top.selectAccessory(name);
        	
        	//rsmd = rs.getMetaData();
        	//numColumns = rsmd.getColumnCount();
        	
        	Iterator <Accessories> iter = vec.iterator();
        	while (iter.hasNext()){
        		top = (Accessories) iter.next();
        		
        	out.println("<tr><td>" + top.getId() + "</td>");
        	out.println("<td>" + top.getName() + "</td>");
        	out.println("<td>" + top.getQuantity() + "</td>");
        	out.println("<td>" + top.getPrice() + "</td></tr>");
        	}
        	out.println("</table></td></tr></table>"
        			+ new java.util.Date()
        			+"</td></tr></table></div></body></html>");
        	
        	}  catch (SQLException e) {} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} %>

</body>
</html>