package it.unipv.po.cosi.restaurant.model;

import java.util.ArrayList;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.*;
import it.unipv.po.cosi.restaurant.model.orderModel.*;
import it.unipv.po.cosi.restaurant.model.outputModel.monitorModel.Monitor;

public class RestaurantModel {

	private ArrayList<Serving> servings;
	private ArrayList<Table> tables;
	private ArrayList<Modifier> modifiers;
	private ArrayList<Order> orders;
	private ArrayList<Category> categories;
	private ArrayList<Monitor> monitors;
	private static RestaurantModel jRestaurant;
	private int maxId;
	
	private RestaurantModel() {
		
		//Using Exoert pattern
		
		this.servings = new ArrayList<Serving>();
		this.tables = new ArrayList<Table>();
		this.orders = new ArrayList<Order>();
		this.modifiers = new ArrayList<Modifier>();
		this.categories = new ArrayList<Category>();
		this.monitors = new ArrayList<Monitor>();
		this.initializeMaxId();
		
	}
	
	public static RestaurantModel getInstance() {
		
		if(jRestaurant == null) {
			
			jRestaurant = new RestaurantModel();
			
		}
		
		return jRestaurant;
		
	}
	

	
	public Serving getServing(String name) {
		
		for (Serving serving : servings) {
			
			if(serving.getName().equals(name.toLowerCase())) {
				
				return serving;
				
			}
			
		}
		
		return null;		
		
	}
	
	
	// SERVINGS //
	
	public void populateServing(ArrayList<Serving> s) {
		
		this.servings = s;
		
	}
	
	public void addServing(Serving serving) {
		
		servings.add(serving);
	}
	
	
	// MODIFIERS //
	
	public void populateModifiers(ArrayList<Modifier> m) {
		
		this.modifiers = m;
		
	}
	
	// TABLES //
	
	public void populateTables(ArrayList<Table> t) {
		
		this.tables = t;
		
	}
	
	// CATEGORIES //
	
	public void populateCategories(ArrayList<Category> c) {
		
		this.categories = c;
		
	}
	
	// ORDERS //
	
	public void addOrder(Order o) {
		
		this.orders.add(o);
	}
	
	//MONITORS
	
	public void populateMonitors(ArrayList<Monitor> m) {
		this.monitors = m;
	}
	
	// GETTER and SETTERS //
	
	public ArrayList<Monitor> getMonitors() {
		return monitors;
	}

	public ArrayList<Serving> getServingsArray() {
		return servings;
	}

	public ArrayList<Table> getTablesArray() {
		return tables;
	}

	public ArrayList<Modifier> getModifiersArray() {
		return modifiers;
	}

	public ArrayList<Order> getOrdersArray() {
		return orders;
	}

	public ArrayList<Category> getCategoriesArray() {
		return categories;
	}
	
	public ArrayList<Category> getActiveCategories(){
		
		ArrayList<Category> rslt = new ArrayList<Category>();
		
		for(Category c: categories) {
			
			if(c.isActiveFlag()) {
				rslt.add(c);
			}
		}
		return rslt;	
		
	}
	
	public ArrayList<Serving> getServingsPerCategory(Category c) {
		
		ArrayList<Serving> rslt = new ArrayList<Serving>();
		
		for(Serving s: servings) {
			
			if(c.equals(s.getCategory()) && s.isActiveFlag()) {
				rslt.add(s);
			}
		}
		return rslt;
	}
	
	public ArrayList<Modifier> getModifiersPerCategory(Category c) {
		
		ArrayList<Modifier> rslt = new ArrayList<Modifier>();
		
		for(Modifier s: modifiers) {
			
			if(c.equals(s.getCategory()) && s.isActiveFlag()) {
				rslt.add(s);
			}
		}
		return rslt;
	}
	
	public void initializeMaxId() {
		
		int max = 0;
		for (Serving s : servings) {
			
			if(s.getId() > max) {
				max = s.getId();
			}	
		}
		this.maxId = max;
	}
	
	public int getMaxId() {
		return maxId;
	}	
	
	// METODO CHE NON SO A COSA SERVA //
	


	public boolean update() {
		
		return true;
		
	}

	
}
