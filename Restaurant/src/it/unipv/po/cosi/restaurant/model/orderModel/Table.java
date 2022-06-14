package it.unipv.po.cosi.restaurant.model.orderModel;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;


/**
 * class which rappresents the actual tables in the restaurant
 * 
 * @author      cosi'
 * @version     iterazione 2
 * @since 		iterazione 1
 */
public class Table {

	/**
	 * number to identify an instance of the Table class
	 */
	private int number;
	/**
	 * Enum Status attribute, it identify the current status of the table
	 */
	private Status status;
	/**
	 * Order attribute, it is the current order for this table
	 */
	private Order order;
	/**
	 * flag that allows to enable or disable the table instance in GUI, if the value is false,
	 *  the serving will be not displayed
	 */
	private boolean activeFlag;
	
	
	/**
	 * constructor of the Table class
	 * @param number number attrubute
	 * @see number
	 * @param status status attribute
	 * @see status
	 * @param activeFlag active flag attribute
	 * @see activeFlag
	 */
	public Table(int number, Status status, boolean activeFlag) {
		
		this.number = number;
		this.status = status;
		this.activeFlag = activeFlag;
		
	}
	/**
	 * constructor of the Table class
	 * @param number number attrubute
	 * @see number
	 * @param status status attribute
	 * @see status
	 */
	public Table(int number, boolean activeFlag) {
		
		this.number = number;
		this.activeFlag = activeFlag;
		
	}
	
	/**
	 * getter that allows to get the String corresponding to the bill
	 * @return the bill of the of the order, with the total price 
	 */
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
	
	/**
	 * getter for the number attribute
	 * @return the number attribute of this instance
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * setter for the number attribute
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * getter for the status attribute
	 * @return the status attribute of this instance
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * setter for the status attribute
	 * @param status the status that will be set to the status attribute
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * getter for the order attribute
	 * @return the order attribute of this instance
	 */
	public Order getOrder() {
		return order;
	}
	
	/**
	 * setter for the status attribute
	 * @param order 
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * returns a string containing the number of the table 
	 * @return string containing the number of the table
	 */
	@Override
	public String toString() {
		return number + "";
	}

	/**
	 * getter for the activeFlag attribute
	 * @return the serving activeFlag attribute 
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/**
	 * setter for the activeFlag attribute
	 * @param activeFlag the boolean value that will be assigned to the activeFlag attribute 
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
