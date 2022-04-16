package xmlManager.state;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import xmlManager.Observer;
import xmlManager.dao.XmlReadDAO;




public class Context {

	private ManagerState currentState;
	private String inputFilePathName=null;
	private String defaultEncoding="UTF-8";
	private Observer kbObserver = new Observer();
	
	public Observer getKbObserver() {
		return kbObserver;
	}
	public void setKbObserver(Observer kbObserver) {
		this.kbObserver = kbObserver;
	}
	public DocumentBuilder getDocumentBuilder() {
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			return dBuilder;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	 public static Context getInstance() {
		    return ContextSingleton.INSTANCE;
		  }

	  /**
	   * 
	   */
	  private static class ContextSingleton {
	    private static final Context INSTANCE = new Context(null);
	  }
	public XmlReadDAO getXmlDaoRead() {
		return new XmlReadDAO();
	}

	public Context(ManagerState currentState) {
		this.currentState = currentState;
		if (currentState == null) {
			this.currentState = StateReading.instance();
		}
	}

	public ManagerState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ManagerState currentState) {
		this.currentState = currentState;
	}

	public void update() {
		currentState.updateState(this);
	}
	public String getInputFilePathName() {
		return inputFilePathName;
	}

	public void setInputFilePathName(String inputFilePathName) {
		this.inputFilePathName = inputFilePathName;
	}
	public String getDefaultEncoding() {
		return defaultEncoding;
	}
}