package it.unipv.po.cosi.restaurant.model.outputModel.monitorModel;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;

public class Monitor {

	private String name;
	private Category pertinence;
	
	//creare il monitor con un for dove passo l'arraylist di categories e per ogni elemento prendo nome di categoria e categoria stessa.
	
	public Monitor(Category c, String name) {
		
		this.name = name;
		this.pertinence = c;
		
	}
	
	public String print(Order order) {
		
		String temp = "Monitor " + pertinence.toString() + "\n\n";
		
		for (Serving serving : order.getServings()) {
			
				
				if(pertinence.equals(serving.getCategory())) {
						
						temp += serving.getName();
					
						for (Modifier modifier : serving.getModifiers()) {
						
							temp += " + " + modifier.getName();	
				}
				
			} else continue;
				
				temp += "\n";
			
		}
		
		return temp;
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
