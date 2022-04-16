package xmlManager.command.read;


 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xmlManager.App;
import xmlManager.Command;
import xmlManager.events.EventsReceiver;
import xmlManager.state.Context;

public class ReadXml implements Command{
	private static final Logger logger = LoggerFactory.getLogger(ReadXml.class);
	private XmlReader xmlReader;
	public XmlReader getXmlReader() {
		return xmlReader;
	}
	public void setXmlReader(XmlReader xmlReader) {
		this.xmlReader = xmlReader;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		logger.info("read xml");
		boolean successful = Context.getInstance().getXmlDaoRead().xmlReadDAO();
		EventsReceiver.getInstance().fireEvents();
	
	}

}
