<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" import = "common.*, sax.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String filepath = request.getParameter("browseFile");
    String result = "";
   
    if (filepath != null) {
       Example4 ex4 = new Example4();
       result = ex4.Parse(filepath);
    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>example 4</title>
</head>
<body>
<h1>Example 4 for Java parsing with SAX</h1>
<h4>Pick the file to parse:</h4>
<form action="example4.jsp" method="get">
<input type="file" name = "browseFile" />
<input type="submit" value="parse"/>
</form>
<pre>
<%=result %>
</pre>
</body>
</html>