package it.unipv.po.cosi.restaurant.database;

import java.sql.Connection;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.database.classDAO.CategoryDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ModifierDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.OrderDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ServingDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.TableDAO;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class DbControllerSingleton {

	private String schema;
	private Connection c;
	ServingDAO serv = new ServingDAO();
	CategoryDAO cat = new CategoryDAO();
	ModifierDAO mod = new ModifierDAO();
	TableDAO tab = new TableDAO();
	OrderDAO ord = new OrderDAO();
	
	public DbControllerSingleton() {
		super();
		this.schema = "restaurant";
		c = DatabaseConnection.startConnection(c, schema);
	}

// populate table with menu .csv file //		
	
	
	public void initializeServings() {
		
		
		serv.initializeServings();
		
	}
			
	
	public void initializeCategories() {
	
		
		cat.initializeCategories();
	
	}
						
	
	public void initializeModifiers() {
	
		
		mod.initializeModifiers();
	
	}
			
	
	public void initializeTables() {
	
		
		tab.initializeTables();
	
	}
	
	
//SERVING
	public ArrayList<Serving> selectAllServings() {
		
		return serv.selectAllServings(cat.selectAllCategories());
		
	}
	
	public void initializeActiveServings() {
		
		serv.initializeActiveServings(cat.selectAllCategories());
	}
	
//ORDER
	public ArrayList<Order> selectAllOrders() {
		return ord.selectAllOrders();
	}
	
	public void insertOrder(Order order) {
		ord.insertOrder(order);
	}
	
	public Order selectOrder(int id) {
		return ord.selectOrder(id, cat.selectAllCategories());
	}
	
	

//MODIFIER
	public ArrayList<Modifier> selectAllModifiers() {
		
		return mod.selectAllModifiers(cat.selectAllCategories());
		
	}
	
//CATEGORY
	public ArrayList<Category> selectAllCategories() {
	
		return cat.selectAllCategories();
		
	}

//TABLE
	public ArrayList<Table> selectAllTable() {
		
		return tab.selectAllTable();
		
	}	
}
