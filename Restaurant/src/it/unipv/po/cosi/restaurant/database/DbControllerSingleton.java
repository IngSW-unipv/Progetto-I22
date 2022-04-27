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
		
		
		serv.initializeServings(c);
		
	}
			
	
	public void initializeCategories() {
	
		
		cat.initializeCategories(c);
	
	}
						
	
	public void initializeModifiers() {
	
		
		mod.initializeModifiers(c);
	
	}
			
	
	public void initializeTables() {
	
		
		tab.initializeTables(c);
	
	}
	
	
//SERVING
	public ArrayList<Serving> selectAllServings() {
		
		return serv.selectAllServings(c, cat.selectAllCategories(c));
		
	}
	
	public void initializeActiveServings() {
		
		serv.initializeActiveServings(c, cat.selectAllCategories(c));
	}
	
//ORDER
	public ArrayList<Order> selectAllOrders(Connection c) {
		return ord.selectAllOrders(c);
	}
	
	public void insertOrder(Order order, Connection c) {
		ord.insertOrder(order, c);
	}
	
	public Order selectOrder(int id, Connection c) {
		return ord.selectOrder(id, c, cat.selectAllCategories(c));
	}
	
	

//MODIFIER
	public ArrayList<Modifier> selectAllModifiers(Connection c) {
		
		return mod.selectAllModifiers(c, cat.selectAllCategories(c));
		
	}
	
//CATEGORY
	public ArrayList<Category> selectAllCategories(Connection c) {
	
		return cat.selectAllCategories(c);
		
	}

//TABLE
	public ArrayList<Table> selectAllTable(Connection c) {
		
		return tab.selectAllTable(c);
		
	}
	
//CLOSE CONNECTION
	public boolean closeConnection() {
		
		return DatabaseConnection.closeConnection(c);	
		
	}
	
}
