package it.unipv.po.cosi.restaurant.database;

import java.sql.Connection;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.database.classDAO.CategoryDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ModifierDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.OrderDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ServingDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.TableDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.provaFactory.DaoFactory;
import it.unipv.po.cosi.restaurant.database.classDAO.provaFactory.IDao;
import it.unipv.po.cosi.restaurant.model.menuModel.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class DbControllerSingleton {
	
	private static DbControllerSingleton instance;
	
	private String schema;
	private Connection c;

	private IDao serv;
	private IDao cat;
	private IDao mod;
	private IDao tab;
	private IDao ord;
	
	
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
		DaoFactory.getOrderDAO(ord).initialize();
	}
	
	public void initializeServings() {
		
		
		DaoFactory.getServingDAO(serv).initialize();
		
	}
			
	
	public void initializeCategories() {
	
		
		DaoFactory.getCategoryDAO(cat).initialize();
	
	}
						
	
	public void initializeModifiers() {
	
		
		DaoFactory.getModifierDAO(mod).initialize();
	
	}
			
	
	public void initializeTables() {
	
		
		DaoFactory.getTableDAO(tab).initialize();
	
	}
	
	
//SERVING
	public ArrayList<Serving> selectAllServings() {
		
		return DaoFactory.getServingDAO(serv).selectAllServings(RestaurantModel.getInstance().getCategoriesArray());
		
	}
	
	public void populateServingsArray() {
		
		populateServingHiding();
	}
	
	
//ORDER
	
	public ArrayList<Order> selectAllOrders() {
		return DaoFactory.getOrderDAO(ord).selectAllOrders();
	}
	
	public void insertOrder(Order order) {
		DaoFactory.getOrderDAO(ord).insertOrder(order);
	}
	
	public Order selectOrder(int id) {
		return DaoFactory.getOrderDAO(ord).selectOrder(id, RestaurantModel.getInstance().getCategoriesArray());
	}
	

//MODIFIER
	
	public ArrayList<Modifier> selectAllModifiers() {
		
		return DaoFactory.getModifierDAO(mod).selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray());
		
	}
	
	public void populateModifiersArray() {
		
		populateModifiersHiding();
		
	}
	
	
//CATEGORY
	
	public ArrayList<Category> selectAllCategories() {
	
		return DaoFactory.getCategoryDAO(cat).selectAllCategories();
		
	}
	
	public void populateCategoriesArray() {
		
		populateCategoriesHiding();
	}
	

//TABLE
	
	public ArrayList<Table> selectAllTables() {
		
		return DaoFactory.getTableDAO(tab).selectAllTable();

	}
	
	public void populateTalesArray() {
		
		populateTablesHiding();
	}
	
	// STRUCTURE HIDING PATTERN //
	
	private void populateServingHiding() {  
		
		RestaurantModel.getInstance().populateServing(DaoFactory.getServingDAO(serv).initializeActiveServings(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	private void populateModifiersHiding() {
		
		RestaurantModel.getInstance().populateModifiers(DaoFactory.getModifierDAO(mod).selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	private void populateCategoriesHiding() {
		
		RestaurantModel.getInstance().populateCategories(DaoFactory.getCategoryDAO(cat).selectAllCategories());
	}
	
	private void populateTablesHiding() {
		
		RestaurantModel.getInstance().populateTables(DaoFactory.getTableDAO(tab).selectAllTable());
	}
}
