 package it.unipv.po.cosi.restaurant.model.orderModel;

import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;


/**
 * class that permits to create a list of the ordered servings and their modifiers.
 * once the order gets closed it will be printed as the bill
 * 
 * @author      cosi'
 * @version     iteration 3.0
 * @since		iteration 1.0
 */
public class Order {

	/**
	 * number to identify an order instance
	 */
	private int id;
	/**
	 * int value that identify the starting id which is the maximum id of the previous orders
	 */
	private static int startingId;
	/**
	 * servings list which contains the ordered servings in this instance
	 */
	private ArrayList<Serving> servings;
	/**
	 * servings list which contains the already sent servings in this order instance
	 */
	private ArrayList<Serving> sent;
	/**
	 * table instance on which the order has been taken
	 */
	private Table table;
	/**
	 * float total order price value
	 */
	private float total;
	/**
	 * date and time of the order closing in a timestamp string
	 */
	private String dateTime;
	

	/**
	 * order class constructor
	 */	
	public Order() {
		
		id = ++startingId;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.total = 0;	
		this.dateTime = null;
	}
	
	/**
	 * order class constructor
	 * @param table table attribute
	 * @see table
	 */	
	public Order(Table table) {
		
		id = ++startingId;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.table = table;
		this.total = 0;
		this.dateTime = null;
	}
	
	/**
	 * order class constructor
	 * @param id id attribute
	 * @see id
	 */	
	public Order(int id) {
		
		this.id = id;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.total = 0;
		this.dateTime = null;
	}
	
	/**
	 * order class constructor
	 * @param id id attribute
	 * @see id
	 * @param total total attribute
	 * @see total
	 */	
	public Order(int id, float total) {
			
		this.total = total;
		this.id = id;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.dateTime = null;	
	}
	
	/**
	 * serving class constructor
	 * @param table table attribute
	 * @see table
	 * @param id id attribute
	 * @see id
	 */	
	public Order(Table table, int id) {
		
		this.id = id;
		servings = new ArrayList<Serving>();
		sent = new ArrayList<Serving>();
		this.table = table;
		this.total = 0;
		this.dateTime = null;
	}
	
	/**
	 * adds a serving in the servings attribute
	 * <p>
	 * it checks if there is a serving with the same id of the param serving
	 * into the servings attribute arrayList.
	 * if it is true the method will increment the quantity of this serving,
	 * else it will copy the param serving and it will adds it and its modifiers 
	 * into the arraylist and will increment the quantity.
	 * it will also update the total price
	 * @param serving serving which will be added to the servings attribute
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
	 * adds the serving into the servings arraylist attribute
	 * <p>
	 * it adds the serving into the servings attribute, increments the quantity
	 * and updates the total price of the order
	 * @param serving serving that will be added to the servings attribute
	 */
	public void addServingWithModifiers(Serving serving) {
		
		servings.add(serving);
		serving.incrementQuantity();
		updateTotal();
	}
	
	
	/**
	 * decrements the quantity of the serving
	 * <p>
	 * it decrements the quantity of the param serving in the servings arraylist attribute
	 * and removes it if the quantity reaches 0
	 * @return boolean
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
	 * removes a serving from the servings attribute arraylist
	 * @return boolean value from ArrayList.remove() method
	 */
	public boolean removeServing(Serving serving) {
		
		return this.servings.remove(serving);
	}

	/**
	 * updates the total price of the order
	 * <p>
	 * it updates the total price of the order adding to it the new added serving prices
	 * @return the updated total price of the order
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
	 * getter for the id attribute
	 * @return id id attribute
	 */
	public int getId() {
		return id;
	}

	/**
	 * getter for servings attribute arraylist
	 * @return servings attribute
	 */
	public ArrayList<Serving> getServings() {
		return servings;
	}

	/**
	 * getter for the table attribute
	 * @return the table attribute
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * setter for the table attribute
	 * @param table table which will be assigned to the table attribute
	 */
	public void setTable(Table table) {
		this.table = table;
	}
	
	/**
	 * getter for the total price attribute
	 * @return total attribute
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * getter for the startingId attribute
	 * @return startingId attribute
	 */
	public static int getStartingId() {
		return startingId;
	}

	/**
	 * setter for the startingId attribute
	 * @param startingId value which will be assigned to the startingId attribute
	 */
	public static void setStartingId(int startingId) {
		Order.startingId = startingId;
	}

	/**
	 * getter for the datetime attribute
	 * @return the string datetime attribute
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * setter for the datetime attribute
	 * @param dateTime string that will be assigned to the dateTime attribute
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	/**
	 * getter for the sent attribute
	 * @return sent arraylist of serving attribute
	 */
	public ArrayList<Serving> getSent() {
		return sent;
	}
	
	/**
	 * setter for the sent attribute
	 * @param sent arraylist of serving that will be assigned to the sent attribute
	 */
	public void setSent(ArrayList<Serving> sent) {
		this.sent = sent;
	}
}
