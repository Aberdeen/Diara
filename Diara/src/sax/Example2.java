package sax;
//Example2.java to test set up
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class Example2 extends DefaultHandler {

	StringBuffer sb = new StringBuffer(1024);
    // default parser to use
    private static String parserClass = "org.apache.xerces.parsers.SAXParser";

    // local variables to store data from the xml document
    public String name = "";
    public String location = "";

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
	if (localName.equals("name")){
	    name = contents.toString();
	}
	if (localName.equals("location")){
	    location = contents.toString();
	}
    }// end endElement

    public void characters(char[] ch, int start, int length) 
                  throws SAXException{
	contents.write(ch, start, length);
    }// end characters

   // public static void main(String[] argv){
    public String Parse (String filePath){
	System.out.println("example2:");
	try {
	    // create sax2 parser
	    XMLReader xr = XMLReaderFactory.createXMLReader(parserClass);

	    // set the ContentHandler
	    Example2 ex2 = new Example2();
	    xr.setContentHandler(ex2);

	    // parse the file
	    xr.parse(new InputSource( new FileReader(filePath)));

	    // say hello
	    sb.append("Hello world from ");
	    sb.append(ex2.name);
	    sb.append(" in ");
	    sb.append(ex2.location);
	    System.out.println("Hello World from " + ex2.name + " in "
			       + ex2.location);
	}catch (Exception e) {
	     e.printStackTrace();
        }
	return sb.toString();
    }// end main
}// end of Example1
