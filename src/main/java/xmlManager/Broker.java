package xmlManager;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xmlManager.entity.ImportedDocument;

   public class Broker {
   private List<Command> orderList = new ArrayList<Command>(); 
   private static final Logger logger = LoggerFactory.getLogger(Broker.class);
   public void takeOrder(Command order){
      orderList.add(order);		
   }

   public void placeOrders(){
   
      for (Command order : orderList) {
         order.execute();
      }
      orderList.clear();
   }

	
	
}