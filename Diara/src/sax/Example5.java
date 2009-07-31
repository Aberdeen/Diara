package sax;
//Example4.java to use string variables to hold data
// checks for repeated variable names

import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;
import java.util.*;

import common.*; // the customer and orderitem classes

public class Example5 extends DefaultHandler {

    // default parser to use
    private static String parserClass = "org.apache.xerces.parsers.SAXParser";

    // local customer to store data from the xml document
    private Customer cust = new Customer();

    //local list of order items
    private Vector orderItems = new Vector();

    // local current orderitem reference
    private Accessories currentOrderItem;

    // buffer for collecting data from the 
    // characters() sax event
    private CharArrayWriter contents = new CharArrayWriter();

    //override methods of the DefaultHandler class
    // to gain notification of sax events
    // see org.xml.sax.ContentHandler for all available events
    // 
    public void startDocument() throws SAXException {
	System.out.println("sax event: startDocument");
    }// end startDocument

    public void endDocument() throws SAXException{
	System.out.println("sax event: endDocument");
    }// end endDocument

    public void startElement(String namespaceURI, String localName,
			 String qName, Attributes attr) throws SAXException {
	contents.reset();

	// new twist...
	if (localName.equals("Topping")){
	    currentOrderItem = new Accessories();
	    orderItems.addElement(currentOrderItem);
	}

    } // end of startElement
   public void endElement(String namespaceURI, String localName, String qName)
	           throws SAXException{
	if (localName.equals("FirstName")){
	    cust.firstName = contents.toString();
	}
	if (localName.equals("LastName")){
	    cust.lastName = contents.toString();
	}
	if (localName.equals("CustID")){
	    cust.custID= contents.toString();
	}
	if (localName.equals("InStock")){
	    currentOrderItem.quantity = 
                     Integer.valueOf(contents.toString().trim()).intValue();
	}
       
        if (localName.equals("Name")){
		currentOrderItem.name = contents.toString();
        }
	if (localName.equals("Price")){
	    currentOrderItem.price = 
                     Double.valueOf(contents.toString().trim()).doubleValue();
	}
    }// end endElement

    public void characters(char[] ch, int start, int length) 
                  throws SAXException{
	contents.write(ch, start, length);
    }// end characters

    public Customer getCustomer() {
	return cust;
    }// end getCustomer

    public Vector getOrderItems(){
	return orderItems;
    }// end getOrderItems

  //  public static void main(String[] argv){
    public String Parse (String filePath){
    	StringBuffer sb = new StringBuffer (1024);
	System.out.println("example5:");
	try {
	    // create sax2 parser
	    XMLReader xr = XMLReaderFactory.createXMLReader(parserClass);

	    // set the ContentHandler
	    Example5 ex5 = new Example5();
	    xr.setContentHandler(ex5);

	    // parse the file
	    xr.parse(new InputSource( new FileReader(filePath)));

	    // say customer to stdout
	    Customer cust = ex5.getCustomer();
	    sb.append(cust.print());
	    //display all order items to stdout
	    Accessories i;
	    Vector items = ex5.getOrderItems();
	    Enumeration e = items.elements();
	    while(e.hasMoreElements()){
		i = (Accessories) e.nextElement();
		sb.append(i.print());
	    }// end while

	}catch (Exception e) {
	     e.printStackTrace();
        }// end catch
	return sb.toString();
    }// end main
}// end of Example1
