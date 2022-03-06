package it.unipv.po.cosi.restaurant.model.outputModel.monitorModel;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;

public class Monitor {

	private String name;
	private Category[] pertinence;
	
	public Monitor(Category[] pertinence) {
		
		name = "Monitor";
		this.pertinence = pertinence;
		
	}
	
	public Monitor(Category[] pertinence, String name) {
		
		this.name = name;
		this.pertinence = pertinence;
		
	}
	
	public String print(Order order) {
		
		String temp = "";
		
		for (Serving serving : order.getServings()) {
			
			for (Category category : pertinence) {
				
				if(category.equals(serving.getCategory())) {
						
						temp += serving.getQuantity() + serving.getName() + "\n";
					
						for (Modifier modifier : serving.getModifiers()) {
						
							temp += "\t+" + modifier.getName() + "\n\n";	
							
					}
				
				}
				
			}
			
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
