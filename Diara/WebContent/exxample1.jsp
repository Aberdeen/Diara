<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" import = "enterprise.dom.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%
    String filepath = request.getParameter("browseFile");
    String result = "";
 
 
      if (filepath != null) {
    	  TraverseDOM td = new TraverseDOM();
    	  result = td.Parse(filepath);
      }
    
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>example 1</title>
</head>
<body>
<h1>Example 1 for Java parsing with DOM</h1>
<h4>Pick the file to parse:</h4>
<form action="exxample1.jsp" method="get">
<input type="file" name = "browseFile" />
<p>Enter the filename to save the file to in the 'xml' directory</p>

<input type="submit" value="parse"/>
</form>
<p>File being parsed is: <%=filepath %></p>
<pre>
<%=result %>
</pre>
</body>
</html>