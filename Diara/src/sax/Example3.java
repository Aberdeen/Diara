package sax;
//Example3.java to use string variables to hold data
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

import common.*; // the customer class

public class Example3 extends DefaultHandler {

	
    // default parser to use
    private static String parserClass = "org.apache.xerces.parsers.SAXParser";

    // local customer to store data from the xml document
    private Customer cust = new Customer();

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
	    cust.custID = contents.toString();
	}
    }// end endElement

    public void characters(char[] ch, int start, int length) 
                  throws SAXException{
	contents.write(ch, start, length);
    }// end characters

    public Customer getCustomer() {
	return cust;
    }// end getCustomer

 //   public static void main(String[] argv){
    public String Parse (String filePath){
	System.out.println("example3:");
	StringBuffer sb = new StringBuffer (1024);
	try {
	    // create sax2 parser
	    XMLReader xr = XMLReaderFactory.createXMLReader(parserClass);

	    // set the ContentHandler
	    Example3 ex3 = new Example3();
	    xr.setContentHandler(ex3);

	    // parse the file
	    xr.parse(new InputSource( new FileReader(filePath)));

	    // say customer to stdout
	    Customer cust = ex3.getCustomer();
	  //  System.out.println(cust.print());
	    sb.append(cust.print());
	}catch (Exception e) {
	     e.printStackTrace();
        }// end catch
	
	return sb.toString();
    }// end main
}// end of Example1
