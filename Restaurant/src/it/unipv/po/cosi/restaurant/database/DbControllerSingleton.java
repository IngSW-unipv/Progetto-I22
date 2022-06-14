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
 * @author      cosi'
 * @version    	iteration 1
 */
public class DbControllerSingleton {
	
	/**
	 * instance attribute
	 */
	private static DbControllerSingleton instance;
	/**
	 * database schema name
	 */
	private String schema;
	/**
	 * connection attribute linked to the used database
	 */
	private Connection c;

	/**
	 * dbControllerSingleton constructor
	 */
	private DbControllerSingleton() {
		
		super();
		this.schema = "restaurant";
		c = DatabaseConnection.startConnection(c, schema);

	}

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
	 * @see OrderDAO.initialize()
	 */
	public void initializeOrders() {
	
		DaoFactory.getOrderDAO().initialize();
	}
	
	/**
	 * @see ServingDAO.initialize()
	 */
	public void initializeServings() {
		
		DaoFactory.getServingDAO().initialize();		
	}

	/**
	 * @see CategoryDAO.initialize()
	 */
	public void initializeCategories() throws ExceptionFileChooser {

		DaoFactory.getCategoryDAO().initialize();
	}

	/**
	 * @see ModifierDAO.initialize()
	 */
	public void initializeModifiers() {
		
		DaoFactory.getModifierDAO().initialize();
	}
	
	/**
	 * @see TableDAO.initialize() 
	 */
	public void initializeTables() {
		
		DaoFactory.getTableDAO().initialize();
	}
	
	//SERVING
	/**
	 * @see ServingDAO.selectAllServings()
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
	 * @see ServingDAO.updateActiveServing()
	 */
	public void updateActiveServings() {
		
		DaoFactory.getServingDAO().updateActiveServings(RestaurantModel.getInstance().getServingsArray());
	}
	
	//ORDER
	/**
	 * @see OrderDAO.selectAllOrders()
	 */
	public ArrayList<String[]> selectAllOrders() {
		return DaoFactory.getOrderDAO().selectAllOrders();
	}

	/**
	 * @see OrderDAO.insertOrder()
	 */
	public void insertOrder(Order order) {
		DaoFactory.getOrderDAO().insertOrder(order, RestaurantModel.getInstance().getServingsArray());
	}
	
	/**
	 * @see OrderDAO.selectOrder()
	 */
	public Order selectOrder(int id) {
		return DaoFactory.getOrderDAO().selectOrder(id, RestaurantModel.getInstance().getCategoriesArray());
	}
	
	/**
	 * @see OrderDAO.selectServingFromOrder()
	 */
	public ArrayList<String[]> selectAllServingFromOrders(int id) {
		return DaoFactory.getOrderDAO().selectServingFromOrder(id);
	}

	//MODIFIER
	/**
	 * @see ModifierDAO.selectAllModifiers()
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
	 * @see ModifierDAO.updateActiveModifiers()
	 */
	public void updateActiveModifiers() {
		
		DaoFactory.getModifierDAO().updateActiveModifiers(RestaurantModel.getInstance().getModifiersArray());
	}
	
	//CATEGORY
	/**
	 * @see CategoryDAO.selectAllCategories()
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
	 * @see CategoryDAO.updateActiveCategories()
	 */
	public void updateActiveCategories() {
		
		DaoFactory.getCategoryDAO().updateActiveCategories(RestaurantModel.getInstance().getCategoriesArray());
	}

	//TABLE
	/**
	 * @see TableDAO.selectAllTable()
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
	 * @see TableDAO.updateActiveTables()
	 */
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
	
	void populateTablesHiding() {
		
		RestaurantModel.getInstance().populateTables(DaoFactory.getTableDAO().selectAllTable());
	}
}
