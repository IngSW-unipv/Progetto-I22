package it.unipv.po.cosi.restaurant.model;

import java.util.ArrayList;
import java.util.Collections;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.*;
import it.unipv.po.cosi.restaurant.model.orderModel.*;


/**
 * @author      cosi'
 * @version     iterazione 3
 * @since		iterazione 1
 */
public class RestaurantModel {

	/**
	 * arrayList containing all the servings of the model
	 */
	private ArrayList<Serving> servings;
	/**
	 * arrayList containing all the tables of the model
	 */
	private ArrayList<Table> tables;
	/**
	 * arrayList containing all the modifiers of the model
	 */
	private ArrayList<Modifier> modifiers;
	/**
	 * arrayList containing all the orders of the model
	 */
	private ArrayList<Order> orders;
	/**
	 * arrayList containing all the categories of the model
	 */
	private ArrayList<Category> categories;
	/**
	 * singleton pattern: static variable of the ResturantModel class instance
	 */
	private static RestaurantModel jRestaurant;
	/**
	 * the maximum id of all servings
	 */
	private int maxId;
	
	
	/**
	 * the constructor of the RestaurantModel class 
	 * <p>
	 * the method is private because of the use of singleton pattern;
	 * initializes all the ArrayLists
	 */
	private RestaurantModel() {
		
		
		this.servings = new ArrayList<Serving>();
		this.tables = new ArrayList<Table>();
		this.orders = new ArrayList<Order>();
		this.modifiers = new ArrayList<Modifier>();
		this.categories = new ArrayList<Category>();
		this.initializeMaxId();
		
	}
	
	/**
	 * singleton pattern static method that allows to get the singular instance of the class
	 * @return jRestaurant instance 
	 */
	public static RestaurantModel getInstance() {
		
		if(jRestaurant == null) {
			
			jRestaurant = new RestaurantModel();
			
		}
		
		return jRestaurant;
		
	}
	


	/**
	 * method that allows to get a single serving from the ArrayList of servings, searching it by name
	 * <p>
	 * if not found, the return value is null
	 * @param name the name you are looking for
	 * @return serving the result if it exists
	 */
	public Serving getServing(String name) {
		
		for (Serving serving : servings) {
			
			if(serving.getName().equals(name.toLowerCase())) {
				
				return serving;
				
			}
			
		}
		
		return null;		
		
	}
	
	
	// SERVINGS //
	
	/**
	 *  assigns the source ArrayList to the attribute servings
	 * <p>
	 * it also sorts the ArrayList
	 * @param s the source ArrayList
	 */
	public void populateServing(ArrayList<Serving> s) {
		
		this.servings = s;
		Collections.sort(s);
		
	}
	
	/**
	 * method that allows to add a single serving to the servings ArrayList
	 */
	public void addServing(Serving serving) {
		
		servings.add(serving);
	}
	
	
	// MODIFIERS //
	/**
	 *  assigns the source ArrayList to the attribute modifiers 
	 * @param m the source ArrayList
	 */
	public void populateModifiers(ArrayList<Modifier> m) {
		
		this.modifiers = m;
	}
	
	// TABLES //
	/**
	 *  assigns the source ArrayList to the attribute tables 
	 * @param t the source ArrayList
	 */
	public void populateTables(ArrayList<Table> t) {
		
		this.tables = t;
		
	}
	
	// CATEGORIES //
	/**
	 *  assigns the source ArrayList to the attribute categories 
	 * @param c the source ArrayList
	 */
	public void populateCategories(ArrayList<Category> c) {
		
		this.categories = c;
		
	}
	
	// ORDERS //
	/**
	 *  method that allows to add an order to the ArrayList
	 * @param o the order that gets inserted
	 */
	public void addOrder(Order o) {
		
		this.orders.add(o);
		
	}
	


	/**
	 * the getter for the ArrayList of servings
	 * @return ArrayList<Serving> servings
	 */
	public ArrayList<Serving> getServingsArray() {
		return servings;
	}

	/**
	 * the getter for the ArrayList of tables
	 * @return ArrayList<table> tables
	 */
	public ArrayList<Table> getTablesArray() {
		return tables;
	}

	/**
	 * the getter for the ArrayList of modifiers
	 * @return ArrayList<modifier> modifiers
	 */
	public ArrayList<Modifier> getModifiersArray() {
		return modifiers;
	}

	/**
	 * the getter for the ArrayList of orders
	 * @return ArrayList<order> serving
	 */
	public ArrayList<Order> getOrdersArray() {
		return orders;
	}

	/**
	 * the getter for the ArrayList of categories
	 * @return ArrayList<category> serving
	 */
	public ArrayList<Category> getCategoriesArray() {
		return categories;
	}
	
	/**
	 * returns the ArrayLists composed of all the active categories 
	 * <p>
	 * a category whose activeFlag is true is active
	 * @return rslt ArrayList of all the active categories
	 */
	public ArrayList<Category> getActiveCategories(){
		
		ArrayList<Category> rslt = new ArrayList<Category>();
		
		for(Category c: categories) {
			
			if(c.isActiveFlag()) {
				rslt.add(c);
			}
		}
		return rslt;	
		
	}
	
	/**
	 * returns the ArrayLists composed of all the active servings that belong to the given category 
	 * <p>
	 * each serving that contains the given category and has the activeFlag true, is returned
	 * @param c the category whose ArrayList of servings is requested
	 * @return rslt ArrayList of all the active servings in the category
	 */
	public ArrayList<Serving> getServingsPerCategory(Category c) {
		
		ArrayList<Serving> rslt = new ArrayList<Serving>();
		
		for(Serving s: servings) {
			
			if(c.equals(s.getCategory()) && s.isActiveFlag()) {
				rslt.add(s);
			}
		}
		return rslt;
	}
	
	/**
	 * returns the ArrayLists composed of all the active modifiers that belong to the given category 
	 * <p>
	 * each modifier that contains the given category and has the activeFlag true, is returned
	 * @param c the category whose ArrayList of modifiers is requested
	 * @return rslt ArrayList of all the active modifiers in the category
	 */
	public ArrayList<Modifier> getModifiersPerCategory(Category c) {
		
		ArrayList<Modifier> rslt = new ArrayList<Modifier>();
		
		for(Modifier s: modifiers) {
			
			if(c.equals(s.getCategory()) && s.isActiveFlag()) {
				rslt.add(s);
			}
		}
		return rslt;
	}
	
	/**
	 * initializes the maxId attribute with the maximum serving id contained into servings attributes
	 */
	public void initializeMaxId() {
		
		int max = 0;
		for (Serving s : servings) {
			
			if(s.getId() > max) {
				max = s.getId();
			}	
		}
		this.maxId = max;
	}
	
	/**
	 * method that gets the maxId
	 * @see initializeMaxId
	 * @see maxId
	 * @return int maxId 
	 */
	public int getMaxId() {
		return maxId;
	}

	/**
	 * method that sets the maxId
	 * @see maxId
	 */
	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}	
	
	
}
