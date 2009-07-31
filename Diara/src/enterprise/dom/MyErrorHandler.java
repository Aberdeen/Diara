package enterprise.dom;
// Fig 8.11  : MyErrorHandler.java
// Error Handler for validation errors.

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler 
{

   // throw SAXException for fatal errors
   public void fatalError( SAXParseException exception )
      throws SAXException 
   {
      throw exception;
   }

   public void error( SAXParseException e )
      throws SAXParseException
   {
     throw e;
   }

   // print any warnings 
   public void warning( SAXParseException err )
      throws SAXParseException
   {
      System.err.println( "Warning: " + err.getMessage() );
   }
}
