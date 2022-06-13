package it.unipv.po.cosi.restaurant.model;

import java.util.ArrayList;
import java.util.Collections;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.*;
import it.unipv.po.cosi.restaurant.model.orderModel.*;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class RestaurantModel {

	private ArrayList<Serving> servings;
	private ArrayList<Table> tables;
	private ArrayList<Modifier> modifiers;
	private ArrayList<Order> orders;
	private ArrayList<Category> categories;
	private static RestaurantModel jRestaurant;
	private int maxId;
	
	private RestaurantModel() {
		
		
		this.servings = new ArrayList<Serving>();
		this.tables = new ArrayList<Table>();
		this.orders = new ArrayList<Order>();
		this.modifiers = new ArrayList<Modifier>();
		this.categories = new ArrayList<Category>();
		this.initializeMaxId();
		
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return jRestaurant text text text.
	 */
	public static RestaurantModel getInstance() {
		
		if(jRestaurant == null) {
			
			jRestaurant = new RestaurantModel();
			
		}
		
		return jRestaurant;
		
	}
	


	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return serving text text text.
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void populateServing(ArrayList<Serving> s) {
		
		this.servings = s;
		Collections.sort(s);
		
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
		
		servings.add(serving);
	}
	
	
	// MODIFIERS //
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  m Description text text text.          (3)
	 */
	public void populateModifiers(ArrayList<Modifier> m) {
		
		this.modifiers = m;
	}
	
	// TABLES //
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  t Description text text text.          (3)
	 */
	public void populateTables(ArrayList<Table> t) {
		
		this.tables = t;
		
	}
	
	// CATEGORIES //
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  c Description text text text.          (3)
	 */
	public void populateCategories(ArrayList<Category> c) {
		
		this.categories = c;
		
	}
	
	// ORDERS //
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  o Description text text text.          (3)
	 */
	public void addOrder(Order o) {
		
		this.orders.add(o);
		
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
	public ArrayList<Serving> getServingsArray() {
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
	 * @return tables text text text.
	 */
	public ArrayList<Table> getTablesArray() {
		return tables;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return modifiers text text text.
	 */
	public ArrayList<Modifier> getModifiersArray() {
		return modifiers;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return orders text text text.
	 */
	public ArrayList<Order> getOrdersArray() {
		return orders;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return categories text text text.
	 */
	public ArrayList<Category> getCategoriesArray() {
		return categories;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return rslt text text text.
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return rslt text text text.
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  c Description text text text.          (3)
	 * @return rslt text text text.
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return maxId text text text.
	 */
	public int getMaxId() {
		return maxId;
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
	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}	
	
	
}
