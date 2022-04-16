package xmlManager.events;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xmlManager.App;
import xmlManager.event.Event;



public class EventsReceiver {
	private static final Logger logger = LoggerFactory.getLogger(EventsReceiver.class);

	  /***************************************************************************/
	  /*                        Private attributes                               */
	  /***************************************************************************/
	  
	  private ArrayList<Event> events;
	  
	  /***************************************************************************/
	  /*                            Constructors                                 */
	  /***************************************************************************/
	  
	  /**
	   * 
	   */
	  private EventsReceiver() {
	    
	    this.events = new ArrayList<Event>();
	  }
	  
	  /***************************************************************************/
	  /*                           Public Methods                                */
	  /***************************************************************************/
	  
	  /**
	   * 
	   * @return
	   */
	  public static EventsReceiver getInstance() {
	    return EventsReceiverSingleton.INSTANCE;
	  }

	  /**
	   * 
	   */
	  private static class EventsReceiverSingleton {
	    private static final EventsReceiver INSTANCE = new EventsReceiver();
	  }
	  
	  /**
	   * 
	   * @param event 
	   */
	  public void addEvent(Event event) {
	      
	    this.events.add(event);
	  }
	  
	  /**
	   * 
	   * @throws KnowledgeBaseException 
	   */
	  public void fireEvents()  {
	  logger.info("fire_events");
	    int i;
	    
	    for (i = 0; i < this.events.size(); i++) {
	      
	      this.events.get(i).fireEvent();
	    }
	    
	    this.events.clear();
	  }
	  
	  /***************************************************************************/
	  /*                           Private Methods                               */
	  /***************************************************************************/
}
