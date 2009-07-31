// orderitem is a simple class to 
// hold the dummy order data
// it prints out via a print stream

package common;

import java.io.*;

    public class OrderItem {

	// orderitem member variables
	public int quantity= 0;
	public String productCode = "";
	public String description = "";
	public double price = 0.0;
	private StringBuffer sb = new StringBuffer(1024);

	
	public String print (PrintStream out) {
		sb.append("OrderItem: " ); 
		sb.append("Quantity: " + Integer.toString(quantity) + " ");
		sb.append("ProductCode: " + productCode + " ");
		sb.append("Description: " + description + " ");
		sb.append("Price: " + Double.toString(price) + " ");
		return sb.toString();
	} // end print
    }// end orderitem
