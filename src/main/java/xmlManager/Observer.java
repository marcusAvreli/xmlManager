package xmlManager;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xmlManager.entity.ImportedDocument;





public class Observer {
	private static final Logger logger = LoggerFactory.getLogger(Observer.class);
	 
	  private ArrayList<EntityObserver<ImportedDocument>> affiliationObservers = new ArrayList<EntityObserver<ImportedDocument>>();
	  

	  
	
	  /*public void fireKnowledgeBaseRefresh() throws KnowledgeBaseException {
		 logger.info("fireKnowledgeBaseRefresh");
	    fireAffiliationRefresh();
	    fireReportRefresh();
	 
	  }*/
	 
	  /**
	   * Add a new observer to the affiliations.
	   *
	   * @param observer the new observer
	   */
	  public void addAffiliationObserver(EntityObserver<ImportedDocument> observer) {

	    this.affiliationObservers.add(observer);
	  }

	  /**
	   * Delete a observer from the affiliations
	   *
	   * @param observer the observer to remove
	   */
	  public void removeAffiliationObserver(EntityObserver<ImportedDocument> observer){

	    this.affiliationObservers.remove(observer);
	  }

	  /**
	   * Notify to the affiliation's observer that a change has happened in it.
	   */
	  public void fireAffiliationAdded(ArrayList<ImportedDocument> items)
	          {
		 
	    int i;

	    for (i = 0; i < this.affiliationObservers.size(); i++) {
	    	logger.info("fire imported dcoument added_1");
	      this.affiliationObservers.get(i).entityAdded(items);
	    }
	  }
	 
	 
	  /**
	   * Notify to the affiliation's observer that a change has happened in it.
	   */
	  public void fireAffiliationRemoved(ArrayList<ImportedDocument> items)
	            {

	    int i;

	    for (i = 0; i < this.affiliationObservers.size(); i++) {

	      this.affiliationObservers.get(i).entityRemoved(items);
	    }
	  }
	  
	  /**
	   * Notify to the affiliation's observer that a change has happened in it.
	   */
	  public void fireAffiliationUpdated(ArrayList<ImportedDocument> items)
	            {

	    int i;

	    for (i = 0; i < this.affiliationObservers.size(); i++) {

	      this.affiliationObservers.get(i).entityUpdated(items);
	    }
	  }

	  /**
	   * Notify to the affiliation's observer that a change has happened in it.
	   */
	  public void fireAffiliationRefresh()   {

	    int i;
	logger.info("fire affiliation refresh");
	    for (i = 0; i < this.affiliationObservers.size(); i++) {

	      this.affiliationObservers.get(i).entityRefresh();
	    }
	  }

	

	 
	  // ------------------------------------------------------------------------

	  /**
	   * Add a new observer to the author references.
	   *
	   * @param observer the new observer
	   */
	 
	  /***************************************************************************/
	  /*                           Private Methods                               */
	  /***************************************************************************/


}
