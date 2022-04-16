package xmlManager;

import java.util.ArrayList;



public interface EntityObserver<T extends Comparable<T>> {

	  public void entityUpdated(ArrayList<T> items);
	  public void entityAdded(ArrayList<T> items);
	  public void entityRemoved(ArrayList<T> items);
	  public abstract void entityRefresh() ;
	}