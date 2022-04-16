package xmlManager.event.read;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import xmlManager.entity.ImportedDocument;
import xmlManager.event.Event;
import xmlManager.events.EventsReceiver;
import xmlManager.state.Context;

public class ReadXmlEvent  implements Event{
	private static final Logger logger = LoggerFactory.getLogger(ReadXmlEvent.class);
	private ArrayList<ImportedDocument> documents;
	@Override
	public void fireEvent() {
		// TODO Auto-generated method stub
		logger.info("firing event");
		Context.getInstance().getKbObserver().fireAffiliationAdded(documents);
	}
	public ReadXmlEvent(List<ImportedDocument> documents) {
		this.documents=(ArrayList<ImportedDocument>) documents;
	}
	public ReadXmlEvent(ImportedDocument document) {
		 this.documents = new ArrayList<ImportedDocument>();
		 this.documents.add(document);
	}
	
}
