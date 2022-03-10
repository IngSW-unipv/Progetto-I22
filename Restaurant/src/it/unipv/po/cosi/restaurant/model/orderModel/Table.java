package it.unipv.po.cosi.restaurant.model.orderModel;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class Table {

	private int number;
	private Status status;
	private Order order;
	
	public Table(int number, Status status) {
		
		this.number = number;
		this.status = status;
		
	}
	
	public Table(int number) {
		
		this.number = number;
		
	}
	
	public String getBill() {
		
	String temp = "";
			
			for (Serving serving : order.getServings()) {
							
				temp += serving.getName() + serving.getQuantity() + "\t" + serving.getPrice() + "\n";
						
				for (Modifier modifier : serving.getModifiers()) {
							
					temp += " + " + modifier.getName() + "\n";	
					
				}
				
			}
		
		return temp + "\n\nTOTAL PRICE: " + order.getSubtotal();
		
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	
}
