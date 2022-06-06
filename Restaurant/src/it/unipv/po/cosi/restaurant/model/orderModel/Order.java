 package it.unipv.po.cosi.restaurant.model.orderModel;

import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class Order {

	@SuppressWarnings("unused")
	private int id;
	private static int startingId;
	private ArrayList<Serving> servings;
	private Table table;
	private float total;
	private String dateTime;
	


	public Order() {
		
		id = ++startingId;
		servings = new ArrayList<Serving>();
		this.total = 0;	
		this.dateTime = null;
	}
	
	public Order(Table table) {
		
		id = ++startingId;
		servings = new ArrayList<Serving>();
		this.table = table;
		this.total = 0;
		this.dateTime = null;
	}
	
	public Order(int id) {
		
		this.id = id;
		servings = new ArrayList<Serving>();
		this.total = 0;
		this.dateTime = null;
	}
	
	public Order(int id, float total) {
			
		this.total = total;
		this.id = id;
		servings = new ArrayList<Serving>();
		this.dateTime = null;	
	}
	
	public Order(Table table, int id) {
		
		this.id = id;
		servings = new ArrayList<Serving>();
		this.table = table;
		this.total = 0;
		this.dateTime = null;
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
		
		return this.servings.remove(serving);
	}

	public float getSubtotal() {
		
		float tmp = 0.0f;
		
		for (Serving serving : servings) {
			
			tmp += serving.getPrice();
			
			for (Modifier m : serving.getModifiers()) {
				tmp += m.getPrice();
			}			
		}
		
		this.total = tmp;
		return tmp;
		
	}
	
	
	public int getId() {
		return id;
	}

	public ArrayList<Serving> getServings() {
		return servings;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	public float getTotal() {
		return total;
	}

	public static int getStartingId() {
		return startingId;
	}

	public static void setStartingId(int startingId) {
		Order.startingId = startingId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
