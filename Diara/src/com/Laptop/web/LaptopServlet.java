package com.Laptop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Laptop.models.Accessories;

/**
 * Servlet implementation class LaptopServlet
 */
public class LaptopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LaptopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		PrintWriter out = response.getWriter();
        // the action element that we'll check for
        String cmd;

        cmd = request.getParameter("action");
        if (cmd != null) {
            if (cmd.equals("home")) {
                goHome(request, response);
            } else if (cmd.equals("list")) {
                try {
					listAccessories(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else if (cmd.equals("add")){
                addAccessories(request, response);
            } else if (cmd.equals("insert")){
                insertAccessories(request, response);



            } else if (cmd.equals("delete")){
                deleteAccessory(request, response);
            }  else if (cmd.equals("deleteAccessory")){
                try {
					Accessory(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else {
                // no command set
                out.println("Error: No page set " + cmd);
            }
            out.flush();
            
        }
    }

	private void Accessory(HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException, InstantiationException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("id");
		request.setAttribute("accessory", cmd);
		request.setAttribute("action","deleted");
		try {
			Accessories.deleteAccessory(cmd);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String stringURL = "/messages.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(stringURL);
		try {
			rd.forward (request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertAccessories(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		 String name = request.getParameter("name");
	        String quantity = request.getParameter("quantity");
	        String price = request.getParameter("price");
	        
	        Accessories top = new Accessories();
	            try {
					top.insertAccessory(name,Integer.parseInt(quantity),Double.parseDouble(price));
					request.setAttribute("action","added");
					request.setAttribute("accessory", name);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	        //return a message to the browser
	        String id = "Thanks for adding the Accessory";
	        StringBuffer message = new StringBuffer(1024);
	        message.append("Thanks for adding the new Accessory. <br />");
	        message.append(name + "<br/>");
	        message.append("Be sure to also update the chalkboard outside the door.");
	        String stringURL = "/messages.jsp?param=" + message + "&id=" + id;
	        //    forward message to 'message' page
	        RequestDispatcher rd = request.getRequestDispatcher(stringURL);
	        try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
	}

	private void deleteAccessory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Accessories top = new Accessories();
        Vector <Accessories> vec = new Vector <Accessories>( );
        try {
			vec = top.listAccessories("all");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("items", vec);
		String stringURL = "/delete.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(stringURL);
		rd.forward (request, response);
		// TODO Auto-generated method stub
		
	}

	private void addAccessories(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String stringURL = "/add.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(stringURL);
		rd.forward (request, response);
		// TODO Auto-generated method stub
		
	}

	private void listAccessories(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Accessories top = new Accessories();
        Vector <Accessories> vec = new Vector <Accessories>( );
        vec = top.listAccessories("all");
        
        request.setAttribute("stuff", vec);
		String stringURL = "/list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(stringURL);
		rd.forward (request, response);

		// TODO Auto-generated method stub
		
	}

	private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringURL = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(stringURL);
		rd.forward (request, response);
		// TODO Auto-generated method stub
		
	}              
	}


