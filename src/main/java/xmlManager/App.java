package xmlManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xmlManager.command.read.ReadXml;
import xmlManager.command.read.XmlReader;
import xmlManager.entity.ImportedDocument;
import xmlManager.state.Context;

public class App {
	public static String Log4JPath = null;
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	

	private static String inputFilePathName=null;
	public static void main(String[] args) {
		initApp();
		logger.info("APP_STARTED");
		//Context context = new Context(null);
		//context.setInputFilePathName(getInputFilePathName());
		Context.getInstance().getKbObserver().addAffiliationObserver(new SubjectCategoryWrapper());
		  XmlReader xmlReader = new XmlReader();

		  ReadXml readXml = new ReadXml();
		  readXml.setXmlReader(xmlReader);
	      
		  Broker broker = new Broker();
	      broker.takeOrder(readXml);
	      

	      broker.placeOrders();
	      
		//context.update();
		logger.info("APP_FINISHED");
	}
	public static void initApp() {
		Properties applicationProperties = getApplicationProperties();
		setLog4JPath(applicationProperties.getProperty("LOG4J_PATH"));
		setInputFilePathName(applicationProperties.getProperty("PATH_NAME_INPUT_FILE"));
		loadLog4j();
	}
	
	public static String getLog4JPath() {
		return Log4JPath;
	}

	public static void setLog4JPath(String log4jPath) {
		Log4JPath = log4jPath;
	}

	public static Properties getApplicationProperties() {
		App application = new App();

		InputStream inputStream = null;
		Properties applicationProp = null;
		try {
			inputStream = new FileInputStream(new File("./resources/application.properties"));
			applicationProp = new Properties();
			applicationProp.load(inputStream);
			inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return applicationProp;
	}
	public static String getInputFilePathName() {
		return inputFilePathName;
	}

	public static void setInputFilePathName(String inputFilePathName) {
		App.inputFilePathName = inputFilePathName;
	}
	

	private static void loadLog4j() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		context.setConfigLocation(new File(getLog4JPath()).toURI());
	}
	private static class SubjectCategoryWrapper implements EntityObserver<ImportedDocument>{
		
		@Override
		public void entityUpdated(ArrayList<ImportedDocument> items) {
			// TODO Auto-generated method stub
			logger.info("entity added");
		}

		@Override
		public void entityAdded(ArrayList<ImportedDocument> items) {
			// TODO Auto-generated method stub
			logger.info("entity added_1");
		}

		@Override
		public void entityRemoved(ArrayList<ImportedDocument> items) {
			// TODO Auto-generated method stub
			logger.info("entity added");
		}

		@Override
		public void entityRefresh() {
			// TODO Auto-generated method stub
			logger.info("entity added");
		}
		
	}
}