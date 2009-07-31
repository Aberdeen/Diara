package enterprise.dom;
// Fig. 8.15 : TraverseDOM.java
// Traverses DOM and prints various nodes.

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

public class TraverseDOM {
   private Document document;   
   StringBuffer sb = new StringBuffer(1024);
   
   public TraverseDOM () {
	   
   }
   public String Parse( String file )
   {
      try {

         // obtain the default parser
         DocumentBuilderFactory factory =
            DocumentBuilderFactory.newInstance();
      //   factory.setValidating( true );
         DocumentBuilder builder = factory.newDocumentBuilder();

         // set error handler for validation errors
         builder.setErrorHandler( new MyErrorHandler() );

         // obtain document object from XML document
         document = builder.parse( new File( file ) );
         processNode( document );
      } 
      catch ( SAXParseException spe ) {
         sb.append( 
            "Parse error: " + spe.getMessage() );
         System.exit( 1 );
      }
      catch ( SAXException se ) {
         se.printStackTrace();         
      }
      catch ( FileNotFoundException fne ) {
         sb.append( "File \'" 
            + file + "\' not found. " );
         //System.exit( 1 );
      }
      catch ( Exception e ) {
         e.printStackTrace();
      }
      return sb.toString();
   }

   public String processNode( Node currentNode )
   {
      switch ( currentNode.getNodeType() ) {

         // process a Document node
         case Node.DOCUMENT_NODE:
            Document doc = ( Document ) currentNode;

            sb.append( 
                 "Document node: " + doc.getNodeName() +
                 "\nRoot element: " +
                 doc.getDocumentElement().getNodeName() );
            processChildNodes( doc.getChildNodes() );
            break;

         // process an Element node
         case Node.ELEMENT_NODE:   
            sb.append( "\nElement node: " + 
                                currentNode.getNodeName() );
            NamedNodeMap attributeNodes =
               currentNode.getAttributes();

            for ( int i = 0; i < attributeNodes.getLength(); i++){
               Attr attribute = ( Attr ) attributeNodes.item( i );

               sb.append( "\tAttribute: " + 
                  attribute.getNodeName() + " ; Value = " +
                  attribute.getNodeValue() );
            }

            processChildNodes( currentNode.getChildNodes() );
            break;

         // process a text node and a CDATA section
         case Node.CDATA_SECTION_NODE:
         case Node.TEXT_NODE: 
            Text text = ( Text ) currentNode;

            if ( !text.getNodeValue().trim().equals( "" ) )
               sb.append( "\tText: " +
                                text.getNodeValue() );
            break;
      }
      return sb.toString();
   }

   public void processChildNodes( NodeList children )
   {
      if ( children.getLength() != 0 ) 

         for ( int i = 0; i < children.getLength(); i++)
            processNode( children.item( i ) );
   }

 //  public static void main( String args[] )  {
 //  public String Parse (String xmlDocument){
//      if ( args.length < 1 ) {
//         System.err.println( 
//            "Usage: java TraverseDOM <filename>" );
//         System.exit( 1 );
//      }

//      TraverseDOM traverseDOM = new TraverseDOM( xmlDocument);   
      
      
 //  }
}
/*
 **************************************************************************
 * (C) Copyright 2001 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************
*/
