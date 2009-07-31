/*
 * Created on 21-Jan-2005
 *
 * a class to represent the different toppings on the 
 * sandwiches
 */
package common;

import java.io.PrintStream;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * @author bscharla
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Accessories {
	public int id = 0;
	public String name = "";
	public int quantity = 0;
	public String type = "";
	public double price = 0;
	private StringBuffer sb =  new StringBuffer(1024);
	

	/**
	 * default constructor
	 */
	public Accessories() {
		super();
		// set the variables
		this.id = getId();
		this.name = getName();
		this.price = getPrice();
	}

	// getters and setters for the variables
	
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price The price to set.
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return Returns the quantity.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity The quantity to set.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	// the business methods
	
	public String print(){
		sb.append("Accessory: ");
		sb.append("name: " + name + " ");
		sb.append("quantity: " + quantity+ " ");
		sb.append("price: " + price+ " ");
		return sb.toString();
	}
}
