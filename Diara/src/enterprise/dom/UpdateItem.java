/*-- 

 Copyright (C) 2001 Brett McLaughlin.
 All rights reserved.
 
 Changed from a servlet to a POJO
 
 
 */
package enterprise.dom;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.xml.sax.SAXException;

// DOM imports
import org.w3c.dom.*;

// Range import
import org.w3c.dom.ranges.DocumentRange;
import org.w3c.dom.ranges.Range;
import org.w3c.dom.ranges.RangeException;

// Parser import
import org.apache.xerces.dom.DOMImplementationImpl;
import org.apache.xerces.parsers.DOMParser;

/**
 * <b><code>UpdateItem</code></b> demonstrates how the DOM
 *   Level 2 Range module can be used for handling range within a document.
 */
public class UpdateItem {

    /** The directory to load XML from */
    private static final String ITEMS_DIRECTORY = "C:\\Eclipse\\Diara\\xml";

    /**
     * <p>Search for the item specified, and either create a new file or
     *   update the existing one. DOM Level 2 Range is used for quicker
     *   replacement of a range of data.</p>
     */
    
	public static void main(String[] args) {
			if (args.length != 3) {
				System.out.println(
					"Usage: java javaxml2.UpdateItem " +
					"[id] " +
					"[name]" +
					"[description]");
				System.exit(0);
			} else {
				
				try {
					
					UpdateItem updater = new UpdateItem();
					updater.update(args[0],args[1],args[2]);
		
				} catch (Exception e){
					e.printStackTrace();
				}
			}
    }
    
   public void update(String id, String name, String description) {
 	
	try {
		
		// See if this file exists
		Document doc = null;
		File xmlFile = new File(ITEMS_DIRECTORY + "item-" + id + ".xml");
		String docNS = "http://www.oreilly.com/javaxml2";
		
		if (!xmlFile.exists()) {
			// Create new DOM tree
			DOMImplementation domImpl = new DOMImplementationImpl();
			doc = domImpl.createDocument(docNS, "item", null);
			Element root = doc.getDocumentElement();
			root.setAttribute("xmlns", docNS);
		
			// ID of item (as attribute)
			root.setAttribute("id", id);
		
			// Name of item
			Element nameElement = doc.createElementNS(docNS, "name");
			Text nameText = doc.createTextNode(name);
			nameElement.appendChild(nameText);
			root.appendChild(nameElement);
		
			// Description of item
			Element descriptionElement = doc.createElementNS(docNS, "description");
			Text descriptionText = doc.createTextNode(description);
			descriptionElement.appendChild(descriptionText);
			root.appendChild(descriptionElement);
		} else {
			// Load document
			try {
				DOMParser parser = new DOMParser();
				parser.parse(xmlFile.toURL().toString());
				doc = parser.getDocument();
		
				Element root = doc.getDocumentElement();
		
				// Name of item
				NodeList nameElements = root.getElementsByTagNameNS(docNS, "name");
				Element nameElement = (Element)nameElements.item(0);
				Text nameText = (Text)nameElement.getFirstChild();
				nameText.setData(name);
		        
				// Description of item
				NodeList descriptionElements = 
					root.getElementsByTagNameNS(docNS, "description");
				Element descriptionElement = (Element)descriptionElements.item(0);
		
				// Remove and recreate description
				Range range = ((DocumentRange)doc).createRange();
				range.setStartBefore(descriptionElement.getFirstChild());
				range.setEndAfter(descriptionElement.getLastChild());
				range.deleteContents();
				Text descriptionText = doc.createTextNode(description);
				descriptionElement.appendChild(descriptionText);
				
			} catch (SAXException e) {
				// Print error
				System.out.println("Error in reading XML: " +
					e.getMessage());
				return;
			}
			
		}
		
		// Serialize DOM tree
		DOMSerializer serializer = new DOMSerializer();
		serializer.serialize(doc, xmlFile);
		
		// Print confirmation
		System.out.println("Thank you for your submission. " +
			"Your item has been processed.");
			
	} catch (DOMException e) {
		System.out.println("DOMException: ");
		e.printStackTrace();
	} catch (MalformedURLException e) {
		System.out.println("MalformedURLException: ");
		e.printStackTrace();
	} catch (RangeException e) {
		System.out.println("RangeException: ");
		e.printStackTrace();
	} catch (IOException e) {
		System.out.println("IOException: ");
		e.printStackTrace();
   } catch (Exception e) {
	   System.out.println("Exception: ");
	   e.printStackTrace();
   }
 }	
}