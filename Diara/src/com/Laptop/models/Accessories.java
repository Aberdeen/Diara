
package com.Laptop.models;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.Laptop.db.DbBean;

/**
 * @author Ogbuakanne John
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Accessories {
	int id = 0;
	String name = "";
	int quantity = 0;
	double price = 0;
	
	
	/**
	 * default constructor
	 */
	public Accessories() {
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
	
	/**
	 * add a new Accessories to the database of Accessories
	 * @param name
	 * @param quantity
	 * @param price
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public void insertAccessory(String name, int quantity, double price) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		DbBean db = new DbBean();
	
		try {
			db.connect();
			int max = db.getMaxValue("Accessories", "ID");
			//increment by one to generate unique id
			max = max+1;
			PreparedStatement inst = db.prepareStatement("INSERT INTO Accessories VALUES(?,?,?,?)");
			inst.setInt(1,max);
			inst.setString(2,name);
			inst.setInt(3,quantity);
			inst.setDouble(4,price);
			inst.executeUpdate();
			inst.close();
		
			// close the database connection
			db.close();
		} catch (SQLException e) {
			System.out.println(
				"SQLException from db: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * delete the speficied Accessory
	 * @param id
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void deleteAccessory(String name) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		
		DbBean db = new DbBean();
		StringBuffer qry = new StringBuffer(1024);
		qry.append("DELETE * FROM Accessories WHERE name='");
		qry.append(name);
		qry.append('\'');
		db.connect();
		Statement stmt = db.createStatement();
		stmt.executeUpdate(qry.toString());
		stmt.close();
		// need to close the db connection,or 
		// the database will not actually commit the action
		db.close();
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Vector <Accessories>listAccessories(String value) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		Vector <Accessories>list = new Vector <Accessories>();
		ResultSet rs = null;
		DbBean db = new DbBean();
		StringBuffer qry = new StringBuffer(1024);
		if (value.equals("all")){
			qry.append("SELECT * from Accessories");
		} else {
			qry.append("SELECT * from Accessories where ");
			qry.append("ID = ");
			qry.append(Integer.parseInt(value));
		}
		db.connect();
		rs = db.execSQL(qry);
		while (rs.next()){
			Accessories top = new Accessories();
			top.setId(rs.getInt("ID"));
			top.setName(rs.getString("Name"));
			top.setQuantity(rs.getInt("Quantity"));
			top.setPrice(rs.getDouble("Price"));
			list.add(top);
		}
		rs.close();
		db.close();
		return list;
	}
	
	/**
	 * select single Accessory 
	 * warning: as this selects using
	 * name, could conceivably have multiples,
	 * as don't check that the name is already in the db
	 * @param name
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Vector <Accessories> selectAccessory(String name) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		ResultSet rs = null;
		DbBean db = new DbBean();
		StringBuffer qry = new StringBuffer(1024);
		Vector <Accessories>list = new Vector <Accessories>();
		qry.append("SELECT * ");
		qry.append("FROM Accessories WHERE Accessories.name Like \'");
		qry.append(name);
		qry.append("\'");
		db.connect();
		Statement stmt = db.createStatement();
		rs = stmt.executeQuery(qry.toString());
		try {
			while (rs.next()){
				System.out.println("in while");
				Accessories top = new Accessories();
				top.setId(rs.getInt("ID"));
				top.setName(rs.getString("name"));
				top.setQuantity(rs.getInt("quantity"));
				top.setPrice(rs.getDouble("price"));
				list.add(top);
			}
			rs.close();
			db.close();
		} catch (SQLException e) {
			// problem
			System.out.println("didn't get to rs.next: ");
			e.printStackTrace();
		}
		return list;
	}
}
