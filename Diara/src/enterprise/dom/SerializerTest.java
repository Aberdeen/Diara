/*-- 

 Copyright (C) 2001 Brett McLaughlin.
 All rights reserved.
 
 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions, and the following disclaimer.
 
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions, and the disclaimer that follows 
    these conditions in the documentation and/or other materials 
    provided with the distribution.

 3. The name "Java and XML" must not be used to endorse or promote products
    derived from this software without prior written permission.  For
    written permission, please contact brett@newInstance.com.
 
 In addition, we request (but do not require) that you include in the 
 end-user documentation provided with the redistribution and/or in the 
 software itself an acknowledgement equivalent to the following:
     "This product includes software developed for the
      'Java and XML' book, by Brett McLaughlin (O'Reilly & Associates)."

 THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED.  IN NO EVENT SHALL THE JDOM AUTHORS OR THE PROJECT
 CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGE.

 */
package enterprise.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

// Parser import
//import org.apache.xerces.parsers.DOMParser;

/**
 * <p><b><code>SerializerTest</code></b> simply provides
 *   a test case for the <code>{@link DOMSerializer}</code>
 *   class, by building a DOM tree from a supplied filename
 *   and then serializing that tree back out.</p>
 */
public class SerializerTest {

    /**
     * <p>This creates a DOM tree from the supplied XML
     *   filename, and then serializes the tree to the 
     *   specified file.</p>
     *
     * @param xmlDocument filename of XML input document.
     * @param outputFilename filename of output document.
     */
  //  public String test(String xmlDocument, String outputFilename)  throws Exception {
    public String test(String xmlDocument, String outputFilename)  throws Exception {
    	StringBuffer sb = new StringBuffer(1024);
   //     File outputFile = new File(outputFilename);
        DOMParser parser = new DOMParser();
     Document doc;
     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     DocumentBuilder builder = factory.newDocumentBuilder();
     doc = builder.parse(xmlDocument);
     sb.append(doc);

        // Get the DOM tree as a Document object
      //  parser.parse(xmlDocument);
      //  Document doc = parser.getDocument();

        // Serialize
        DOMSerializer serializer = new DOMSerializer();
        serializer.serialize(doc, new File(outputFilename));
        return  sb.toString();
    }

    /**
     * <p>Provide a static entry point for testing the
     *   <code>DOMSerializer</code>.</p>
     */

}