package it.unipv.po.cosi.restaurant.model.orderModel;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
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
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return temp + "\n\nTOTAL PRICE: " + order.updateTotal() text text text.
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return number text text text.
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return status text text text.
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return order text text text.
	 */
	public Order getOrder() {
		return order;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return number + "" text text text.
	 */
	@Override
	public String toString() {
		return number + "";
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return activeFlag text text text.
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
