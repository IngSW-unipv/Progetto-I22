package it.unipv.po.cosi.restaurant.model.menuModel;

import java.util.ArrayList;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.*;
import it.unipv.po.cosi.restaurant.model.orderModel.*;

public class RestaurantModel {

	private ArrayList<Serving> servings;
	private ArrayList<Table> tables;
	private ArrayList<Modifier> modifiers;
	private ArrayList<Order> orders;
	private ArrayList<Category> categories;
	
	private static RestaurantModel jRestaurant;
	
	private RestaurantModel() {
		
		//Using Exoert pattern
		
		this.servings = new ArrayList<Serving>();
		this.tables = new ArrayList<Table>();
		this.orders = new ArrayList<Order>();
		this.modifiers = new ArrayList<Modifier>();
		this.categories = new ArrayList<Category>();
		
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
	
	// GETTER and SETTERS //
	
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
	
	// METODO CHE NON SO A COSA SERVA //
	
	public boolean update() {
		
		return true;
		
	}

	
}
