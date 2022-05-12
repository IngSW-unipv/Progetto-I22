package it.unipv.po.cosi.restaurant.database;

import java.sql.Connection;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.database.classDAO.CategoryDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ModifierDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.OrderDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ServingDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.TableDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.provaFactory.DaoFactory;
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
	private ServingDAO serv; 
	private CategoryDAO cat;
	private ModifierDAO mod;
	private TableDAO tab;
	private OrderDAO ord;
	
	private DbControllerSingleton() {
		
		super();
		this.schema = "restaurant";
		c = DatabaseConnection.startConnection(c, schema);
		serv = DaoFactory.getServingDAO(serv);
		cat = DaoFactory.getCategoryDAO(cat);
		mod = DaoFactory.getModifierDAO(mod);
		tab = DaoFactory.getTableDAO(tab);
		ord = DaoFactory.getOrderDAO(ord);
	}

// populate table with menu .csv file //		
	
	public static DbControllerSingleton getInstance() {
		
		if (instance == null) {
			
			instance = new DbControllerSingleton();
		}
		
		return instance;
	}
	
	public void initializeServings() {
		
		
		serv.initialize();
		
	}
			
	
	public void initializeCategories() {
	
		
		cat.initialize();
	
	}
						
	
	public void initializeModifiers() {
	
		
		mod.initialize();
	
	}
			
	
	public void initializeTables() {
	
		
		tab.initialize();
	
	}
	
	
//SERVING
	public ArrayList<Serving> selectAllServings() {
		
		return serv.selectAllServings(RestaurantModel.getInstance().getCategoriesArray());
		
	}
	
	public void populateServingsArray() {
		
		populateServingHiding();
	}
	
	
//ORDER
	
	public ArrayList<Order> selectAllOrders() {
		return ord.selectAllOrders();
	}
	
	public void insertOrder(Order order) {
		ord.insertOrder(order);
	}
	
	public Order selectOrder(int id) {
		return ord.selectOrder(id, RestaurantModel.getInstance().getCategoriesArray());
	}
	

//MODIFIER
	
	public ArrayList<Modifier> selectAllModifiers() {
		
		return mod.selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray());
		
	}
	
	public void populateModifiersArray() {
		
		populateModifiersHiding();
		
	}
	
	
//CATEGORY
	
	public ArrayList<Category> selectAllCategories() {
	
		return cat.selectAllCategories();
		
	}
	
	public void populateCategoriesArray() {
		
		populateCategoriesHiding();
	}
	

//TABLE
	
	public ArrayList<Table> selectAllTables() {
		
		return tab.selectAllTable();

	}
	
	public void populateTalesArray() {
		
		populateTablesHiding();
	}
	
	// STRUCTURE HIDING PATTERN //
	
	private void populateServingHiding() {  
		
		RestaurantModel.getInstance().populateServing(serv.initializeActiveServings(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	private void populateModifiersHiding() {
		
		RestaurantModel.getInstance().populateModifiers(mod.selectAllModifiers(RestaurantModel.getInstance().getCategoriesArray()));
	}
	
	private void populateCategoriesHiding() {
		
		RestaurantModel.getInstance().populateCategories(cat.selectAllCategories());
	}
	
	private void populateTablesHiding() {
		
		RestaurantModel.getInstance().populateTables(tab.selectAllTable());
	}
}
