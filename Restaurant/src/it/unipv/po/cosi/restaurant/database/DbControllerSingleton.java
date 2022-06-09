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

public class DbControllerSingleton {
	
	private static DbControllerSingleton instance;
	
	private String schema;
	private Connection c;

	
	
	private DbControllerSingleton() {
		
		super();
		this.schema = "restaurant";
		c = DatabaseConnection.startConnection(c, schema);

	}

	// populate table with menu .csv file //		
	
	public static DbControllerSingleton getInstance() {
		
		if (instance == null) {
			
			instance = new DbControllerSingleton();
		}
		
		return instance;
	}
	public void initializeOrders() {
		DaoFactory.getOrderDAO().initialize();
	}
	
	public void initializeServings() {
		
		
		DaoFactory.getServingDAO().initialize();
		
	}
			
	
	public void initializeCategories() throws ExceptionFileChooser {
	
		
		DaoFactory.getCategoryDAO().initialize();
	
	}
						
	
	public void initializeModifiers() {
	
		
		DaoFactory.getModifierDAO().initialize();
	
	}
			
	
	public void initializeTables() {
	
		
		DaoFactory.getTableDAO().initialize();
	
	}
	
	
	//SERVING
	
	public ArrayList<Serving> selectAllServings() {
		
		return DaoFactory.getServingDAO().selectAllServings(RestaurantModel.getInstance().getCategoriesArray());
		
	}
	
	public void populateServingsArray() {
		
		populateServingHiding();
	}
	
	public void updateActiveServings() {
		
		DaoFactory.getServingDAO().updateActiveServings(RestaurantModel.getInstance().getServingsArray());
	}
	
	//ORDER

	public ArrayList<String[]> selectAllOrders() {
		return DaoFactory.getOrderDAO().selectAllOrders();
	}
//	
	public void insertOrder(Order order) {
		DaoFactory.getOrderDAO().insertOrder(order, RestaurantModel.getInstance().getServingsArray());
	}
	
	public Order selectOrder(int id) {
		return DaoFactory.getOrderDAO().selectOrder(id, RestaurantModel.getInstance().getCategoriesArray());
	}
	
	public ArrayList<String[]> selectAllServingFromOrders(int id) {
		return DaoFactory.getOrderDAO().selectServingFromOrder(id);
	}


	//MODIFIER
	
	public ArrayList<Modifier> selectAllModifiers() {
		
		return DaoFactory.getModifierDAO().selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray());
		
	}
	
	public void populateModifiersArray() {
		
		populateModifiersHiding();
		
	}
	
	public void updateActiveModifiers() {
		
		DaoFactory.getModifierDAO().updateActiveModifiers(RestaurantModel.getInstance().getModifiersArray());
	}
	
	
	//CATEGORY
	
	public ArrayList<Category> selectAllCategories() {
	
		return DaoFactory.getCategoryDAO().selectAllCategories();
		
	}
	
	public void populateCategoriesArray() {
		
		populateCategoriesHiding();
	}
	
	public void updateActiveCategories() {
		
		DaoFactory.getCategoryDAO().updateActiveCategories(RestaurantModel.getInstance().getCategoriesArray());
	}
	

	//TABLE
	
	public ArrayList<Table> selectAllTables() {
		
		return DaoFactory.getTableDAO().selectAllTable();

	}
	
	public void populateTablesArray() {
		
		populateTablesHiding();
	}
	
	public void updateActiveTables() {
		
		DaoFactory.getTableDAO().updateActiveTables(RestaurantModel.getInstance().getTablesArray());
	}
	
	// STRUCTURE HIDING PATTERN //
	
	private void populateServingHiding() {  
		
		RestaurantModel.getInstance().populateServing(DaoFactory.getServingDAO().selectAllServings(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	private void populateModifiersHiding() {
		
		RestaurantModel.getInstance().populateModifiers(DaoFactory.getModifierDAO().selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	private void populateCategoriesHiding() {
		
		RestaurantModel.getInstance().populateCategories(DaoFactory.getCategoryDAO().selectAllCategories());
	}
	
	private void populateTablesHiding() {
		
		RestaurantModel.getInstance().populateTables(DaoFactory.getTableDAO().selectAllTable());
	}
}
