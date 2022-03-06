package it.unipv.po.cosi.restaurant.model.orderModel;

import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class Order {

	@SuppressWarnings("unused")
	private int id;
	private static int counter;
	private ArrayList<Serving> servings;
	
	public Order() {
		
		id = counter++;
		servings = new ArrayList<Serving>();
		
	}
	
	public boolean addServing(Serving serving) {
		
		servings.add(serving);
		return true;
		
	}
	
	public boolean decrementServing(Serving serving) {
		
		for (Serving serv : servings) {
			
			if(serving.equals(serv)) {
				if(serv.getQuantity() > 1) {
					
					serv.setQuantity(serv.getQuantity()-1);
					return true;
					
				} else {
					
					servings.remove(serv);
					return true;
					
				}
			}	
		}
		
		return false;
		
	}
	

	public boolean removeServing(Serving serving) {
		
		for (Serving serv : servings) {
			
			if(serving.equals(serv)) {
					
					servings.remove(serv);
					return true;
					
			}
		}	
			
		return false;
			
	}

	public float getSubtotal() {
		
		float temp = 0.0f;
		
		for (Serving serving : servings) {
			
			temp += serving.getPrice();			
		}
		
		return temp;
		
	}
	
	
	public int getId() {
		return id;
	}

	public ArrayList<Serving> getServings() {
		return servings;
	}
	
	
}
