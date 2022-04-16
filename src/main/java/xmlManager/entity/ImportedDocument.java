package xmlManager.entity;

import java.io.Serializable;

import org.w3c.dom.Document;



public class ImportedDocument implements Serializable, Comparable<ImportedDocument>, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Document document;
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	@Override
	public int compareTo(ImportedDocument arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}