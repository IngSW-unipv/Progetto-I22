 package it.unipv.po.cosi.restaurant.model.orderModel;

import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class Order {

	private int id;
	private static int startingId;
	private ArrayList<Serving> servings;
	private ArrayList<Serving> sent;
	private Table table;
	private float total;
	private String dateTime;
	


	public Order() {
		
		id = ++startingId;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.total = 0;	
		this.dateTime = null;
	}
	
	public Order(Table table) {
		
		id = ++startingId;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.table = table;
		this.total = 0;
		this.dateTime = null;
	}
	
	public Order(int id) {
		
		this.id = id;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.total = 0;
		this.dateTime = null;
	}
	
	public Order(int id, float total) {
			
		this.total = total;
		this.id = id;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.dateTime = null;	
	}
	
	public Order(Table table, int id) {
		
		this.id = id;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.table = table;
		this.total = 0;
		this.dateTime = null;
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
	public void addServing(Serving serving) {
		
		Boolean flag = false;
		
		for (Serving serv : servings) {
			
			if(serv.getId() == serving.getId()) {
				serv.incrementQuantity();
				flag = true;
			}
		}
		if(!flag) {
			Serving s = serving.copy();
			servings.add(s);
			s.setModifiers(serving.getModifiers());
			s.incrementQuantity();
			
		}
		updateTotal();
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
	public void addServingWithModifiers(Serving serving) {
		
		servings.add(serving);
		serving.incrementQuantity();
		updateTotal();
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
	

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return this.servings.remove(serving) text text text.
	 */
	public boolean removeServing(Serving serving) {
		
		return this.servings.remove(serving);
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  tmp Description text text text.          (3)
	 * @return tmp text text text.
	 */
	public float updateTotal() {
		
		float tmp = 0.0f;
		
		for (Serving serving : servings) {

			tmp += serving.getPrice();
		
		}
		
		this.total = tmp;
		return tmp;
		
	}
	
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return id text text text.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return servings text text text.
	 */
	public ArrayList<Serving> getServings() {
		return servings;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return table text text text.
	 */
	public Table getTable() {
		return table;
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
	public void setTable(Table table) {
		this.table = table;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return total text text text.
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return startingId text text text.
	 */
	public static int getStartingId() {
		return startingId;
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
	public static void setStartingId(int startingId) {
		Order.startingId = startingId;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return dateTime text text text.
	 */
	public String getDateTime() {
		return dateTime;
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
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return sent text text text.
	 */
	public ArrayList<Serving> getSent() {
		return sent;
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
	public void setSent(ArrayList<Serving> sent) {
		this.sent = sent;
	}
}
