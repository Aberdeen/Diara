<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" import="java.util.Date, java.util.Enumeration, com.Laptop.Count" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="CountFunction" prefix="count" %>
<head>
<title>Insert title here</title>
</head>
<jsp:useBean id="myDate" class="java.util.Date" />
<jsp:useBean id="countA" class="com.Laptop.Count"/>
<jsp:setProperty name="countA" property="count" value="0"/>
<jsp:useBean id="countB" class="com.Laptop.Count"/>

<body>
<h4>This is an expression:  ${myDate } </h4>
<h4>We can also do scriptlets based on Java code in the file:</h4>
<jsp:setProperty name="countA" property="count" value="1"/>
<p>Local variable countA is now: ${countA.count }
</p>
<jsp:setProperty name="countB" property="count" value="1"/>
<p>Global variable countB is now ${countB.count} </p>
<h4>We can also use methods in the page:</h4>
<jsp:setProperty name="countB" property="count" value="6"/>
<p>Global variable countB is now ${countB.count} </p>
<p>DoubleCount is: ???? ${count:doubleCount(6) }</p>
<p>To have it take a parameter we need to write our own tag, which is
beyond the scope of what we are doing: see chapter 9 in HeadFirst Servlets</p>


</body>
</html>