// Customer is a simple class to hold fields for 
// dummy customer data.
// It prints itself to a print stream to print

package common;

import java.io.*;

    public class Customer {

	// customer member variables
	public String firstName = "";
	public String lastName = "";
	public String custID = "";
	private StringBuffer sb = new StringBuffer(1024);

	public String print () {
	    sb.append("Customer: <br>" ); 
	    sb.append("First Name: " + firstName + "<br>");
	    sb.append("Last Name: " + lastName + "<br>");
	    sb.append("Customer ID: " + custID + "<br>");
	    return sb.toString();
	} // end print
    }// end customer
