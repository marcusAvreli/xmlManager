package xmlManager.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import xmlManager.entity.ImportedDocument;
import xmlManager.event.read.ReadXmlEvent;
import xmlManager.events.EventsReceiver;
import xmlManager.state.Context;

public class XmlReadDAO {	
	public boolean  xmlReadDAO() {
		boolean notifyObservers=true;
		ImportedDocument importedDocument = new ImportedDocument();
		 // Notify to the observer
		
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(Context.getInstance().getInputFilePathName());		
	        Reader reader = new InputStreamReader(inputStream,Context.getInstance().getDefaultEncoding());
	        InputSource is = new InputSource(reader);
	        is.setEncoding(Context.getInstance().getDefaultEncoding());
	       
	        Document document = Context.getInstance().getDocumentBuilder().parse(is);
	        importedDocument.setDocument(document);
		} catch (  SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if (notifyObservers) {	  
	    	
	      EventsReceiver.getInstance().addEvent(new ReadXmlEvent(importedDocument));
	      return true;
	    }
	    return true;
	}
}
