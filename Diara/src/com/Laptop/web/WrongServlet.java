package com.Laptop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Laptop.db.DbBean;
import com.Laptop.models.Accessories;

/**
 * Servlet implementation class WrongServlet
 */
public class WrongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WrongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mess = request.getParameter("message");
		String done = mess;
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        out.println("<html><head><title>Zibra Computers</title></head>");
        out.println("<body><h1 align=\"center\">Best Quality Laptops</h1>");
        out.println("<div align=\"center\"><table><tr><td<a href =\"/Laptop/\">");
        out.println("<table bgcolor=\"#66ccff\"><tr><td><div align=\"center\"><table><tr><td<a href =\"/Diara/index.html\">Home</a>");
        out.println("<a href =\"shout.jsp\">connect to shout</a>");
        out.println("<table bgcolor=\"#ffffcc\">");
        try {
        	Accessories top = new Accessories();
        	Vector <Accessories> vec = new Vector <Accessories>();
        	vec = top.selectAccessory(name);
        	
        	      	
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
        	
        	}  catch (SQLException e) {
        
                    
        	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
}
