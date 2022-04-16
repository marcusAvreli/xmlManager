package xmlManager.state;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class StateReading implements ManagerState{
	private static final Logger logger = LoggerFactory.getLogger(StateReading.class);
	//Singleton
    private static StateReading instance = new StateReading();
 
    private StateReading() {}
 
    public static StateReading instance() {
        return instance;
    }
	@Override
	public void updateState(Context context) {
		// TODO Auto-generated method stub
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(context.getInputFilePathName());		
	        Reader reader = new InputStreamReader(inputStream,context.getDefaultEncoding());
	        InputSource is = new InputSource(reader);
	        is.setEncoding(context.getDefaultEncoding());
	       
	        Document doc = context.getDocumentBuilder().parse(is);
		} catch (  SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("reading state");
		
	}

}
