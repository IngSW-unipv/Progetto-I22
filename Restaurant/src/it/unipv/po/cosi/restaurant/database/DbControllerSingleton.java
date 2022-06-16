package it.unipv.po.cosi.restaurant.database;

import java.sql.Connection;
import java.util.ArrayList;
import it.unipv.po.cosi.restaurant.database.classDAO.daoFactory.DaoFactory;
import it.unipv.po.cosi.restaurant.exception.ExceptionFileChooser;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;


/** 
 * this class represents the database. The methods allow to do query in the database
 * @author      cosi'
 * @version    	iteration 1
 */
public class DbControllerSingleton {
	
	/**
	 * instance attribute
	 */
	private static DbControllerSingleton instance;

	/**
	 * dbControllerSingleton constructor
	 */
	private DbControllerSingleton() {}
	 
	// populate table with menu .csv file //		
	
	/**
	 * it return this instance if exist, else it will create a new one and it will assigns it to the instance attribute
	 * @return the dbControllerSingleton instance
	 */
	public static DbControllerSingleton getInstance() {
		
		if (instance == null) {
			
			instance = new DbControllerSingleton();
		}
		
		return instance;
	}
	
	/**
	 * Method initialize of class OrderDAO
	 */
	public void initializeOrders() {
	
		DaoFactory.getOrderDAO().initialize();
	}
	
	/**
	 * Method initialize of class ServingDAO
	 */
	public void initializeServings() {
		
		DaoFactory.getServingDAO().initialize();		
	}

	/**
	 * Method initialize of class CategoryDAO
	 * @throws ExceptionFileChooser ExceptionFileChooser
	 */
	public void initializeCategories() throws ExceptionFileChooser {

		DaoFactory.getCategoryDAO().initialize();
	}

	/**
	 * Method initialize of class ModifierDAO
	 */
	public void initializeModifiers() {
		
		DaoFactory.getModifierDAO().initialize();
	}
	
	/**
	 * Method initialize of class TableDAO
	 */
	public void initializeTables() {
		
		DaoFactory.getTableDAO().initialize();
	}
	
	//SERVING

	/**
	 * selectAllServings method
	 * @return all the servings from the DB
	 */
	public ArrayList<Serving> selectAllServings() {
		
		return DaoFactory.getServingDAO().selectAllServings(RestaurantModel.getInstance().getCategoriesArray());
	}

	/**
	 * it populates the servings array
	 */
	public void populateServingsArray() {
		
		populateServingHiding();
	}
	
	/**
	 * updateActiveServings method
	 */
	public void updateActiveServings() {
		
		DaoFactory.getServingDAO().updateActiveServings(RestaurantModel.getInstance().getServingsArray());
	}
	
	//ORDER
	/**
	 * Method selectAllOrders of class OrderDAO
	 * @return all the order from the DB
	 */
	public ArrayList<String[]> selectAllOrders() {
		return DaoFactory.getOrderDAO().selectAllOrders();
	}

	/**
	 * insertOrder method
	 * @param order order
	 */
	public void insertOrder(Order order) {
		DaoFactory.getOrderDAO().insertOrder(order, RestaurantModel.getInstance().getServingsArray());
	}
	
	/**
	 * selectOrder method
	 * @param id order identifier
	 * @return select an order from DB
	 */
	public Order selectOrder(int id) {
		return DaoFactory.getOrderDAO().selectOrder(id, RestaurantModel.getInstance().getCategoriesArray());
	}
	
	/**
	 * selectAllServingFromOrders method
	 * @param id order identifier
	 * @return all the servings from an order from the DB
	 */
	public ArrayList<String[]> selectAllServingFromOrders(int id) {
		return DaoFactory.getOrderDAO().selectServingFromOrder(id);
	}

	//MODIFIER

	/**
	 * selectAllModifiers method
	 * @return all the modifiers from the DB
	 */
	public ArrayList<Modifier> selectAllModifiers() {
		
		return DaoFactory.getModifierDAO().selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray());
		
	}

	/**
	 * it populates the modifiers array 
	 */
	public void populateModifiersArray() {
		
		populateModifiersHiding();
		
	}
	
	/**
	 * updateActiveModifiers method
	 */
	public void updateActiveModifiers() {
		
		DaoFactory.getModifierDAO().updateActiveModifiers(RestaurantModel.getInstance().getModifiersArray());
	}
	
	//CATEGORY
	
	/**
	 * selectAllCategories method
	 * @return all the categories from the DB
	 */
	public ArrayList<Category> selectAllCategories() {
	
		return DaoFactory.getCategoryDAO().selectAllCategories();
	}
	
	/**
	 * it populates the categories array
	 */
	public void populateCategoriesArray() {
		
		populateCategoriesHiding();
	}
	
	/**
	 * updateActiveCategories method
	 */
	public void updateActiveCategories() {
		
		DaoFactory.getCategoryDAO().updateActiveCategories(RestaurantModel.getInstance().getCategoriesArray());
	}

	//TABLE
	/**
	 * selectAllTables method
	 * @return all the tables from the DB
	 */
	public ArrayList<Table> selectAllTables() {
		
		return DaoFactory.getTableDAO().selectAllTable();
	}
	
	/**
	 * it populates tables array
	 */
	public void populateTablesArray() {
		
		populateTablesHiding();
	}
	
	/**
	 * updateActiveTables method
	 */
	public void updateActiveTables() {
		
		DaoFactory.getTableDAO().updateActiveTables(RestaurantModel.getInstance().getTablesArray());
	}
	
	// STRUCTURE HIDING PATTERN //
	/**
	 * Structure Hiding Pattern
	 */
	private void populateServingHiding() {  
		
		RestaurantModel.getInstance().populateServing(DaoFactory.getServingDAO().selectAllServings(RestaurantModel.getInstance().getCategoriesArray()));
	}

	/**
	 * Structure Hiding Pattern
	 */
	private void populateModifiersHiding() {
		
		RestaurantModel.getInstance().populateModifiers(DaoFactory.getModifierDAO().selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	/**
	 * Structure Hiding Pattern
	 */
	private void populateCategoriesHiding() {
		
		RestaurantModel.getInstance().populateCategories(DaoFactory.getCategoryDAO().selectAllCategories());
	}
	
	/**
	 * Structure Hiding Pattern
	 */
	private void populateTablesHiding() {
		
		RestaurantModel.getInstance().populateTables(DaoFactory.getTableDAO().selectAllTable());
	}
}
