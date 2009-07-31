package sax;

//Example1.java to test set up
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.io.*;

public class Example1 extends DefaultHandler {

	StringBuffer sb = new StringBuffer(1024);
	private CharArrayWriter contents = new CharArrayWriter();

    // default parser to use
    private static String parserClass = "org.apache.xerces.parsers.SAXParser";
   
    //override methods of the DefaultHandler class
    // to gain notification of sax events
    // see org.xml.sax.ContentHandler for all available events
    // 
    public void startDocument() throws SAXException {
	sb.append("sax event: startDocument <br>");
    }// end startDocument

    public void endDocument() throws SAXException{
    	sb.append("sax event: endDocument <br>");
    }// end endDocument

    public void startElement(String namespaceURI, String localName,
			 String qName, Attributes attr) throws SAXException {
    	contents.reset();
    	contents.append("sax event: startElement[ " + localName + " ] <br>" );
	// also lets print out the attributes if there are any:
	for (int i = 0; i < attr.getLength();i++){
		contents.append("Attribute: " + 
			       attr.getLocalName(i) +
			       " VALUE: " + attr.getValue(i));
	}// end of for loop
    } // end of startElement

    public void endElement(String namespaceURI, String localName, String qName)
	           throws SAXException{
    	contents.append("sax event: endElement [ " + localName + " ] <br>");
    }// end endElement

    public void characters(char[] ch, int start, int length) 
                  throws SAXException{
    	contents.append("sax event: characters[ " );

	try {
		contents.write(ch, start, length);
		sb.append(contents.toString());
		System.out.println("contents: " + contents.toString());
		System.out.println("sb in characters: " +  sb.toString());
//	    OutputStreamWriter outw = new OutputStreamWriter (System.out);
//	    outw.write(ch, start,length);
//	    outw.flush();
	}catch (Exception e) {
	    e.printStackTrace();
	}
	contents.append(" ] <br> ");
  
    }// end characters

  //  public static void main(String[] argv){
    public String Parse(String path) {
    	StringBuffer sb2 = new StringBuffer(1024);
    	sb2.append("example1 sax events: <br>");
	try {
	    // create sax2 parser
	    XMLReader xr = XMLReaderFactory.createXMLReader(parserClass);

	    // set the ContentHandler
	    xr.setContentHandler(new Example1());

	    // parse the file
	    sb.append("add me ");
	    System.out.println("preParse sb: " + sb.toString());
	    xr.parse(new InputSource( new FileReader(path)));
	    System.out.println("postParse sb: " + sb.toString());
		sb2.append("contents from parse: " + contents.toString());
	}catch (Exception e) {
	     e.printStackTrace();
        }
	
	return sb2.toString();
    }// end main
}// end of Example1
