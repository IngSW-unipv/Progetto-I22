package it.unipv.po.cosi.restaurant.model.orderModel;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class Table {

	private int number;
	private Status status;
	private Order order;
	private boolean activeFlag;
	
	public Table(int number, Status status, boolean activeFlag) {
		
		this.number = number;
		this.status = status;
		this.activeFlag = activeFlag;
		
	}
	
	public Table(int number, boolean activeFlag) {
		
		this.number = number;
		this.activeFlag = activeFlag;
		
	}
	
	public String getBill() {
		
	String temp = "";
			
			for (Serving serving : order.getServings()) {
							
				temp += serving.getName() + "\t" + serving.getPrice();
						
				for (Modifier modifier : serving.getModifiers()) {
							
					temp += " + " + modifier.getName();	
					
				}
				temp += "\n";
				
			}
		
		return temp + "\n\nTOTAL PRICE: " + order.updateTotal();
		
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

	@Override
	public String toString() {
		return number + "";
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
