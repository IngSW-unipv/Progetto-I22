package it.unipv.po.cosi.restaurant.database.classDAO.daoFactory;


import java.io.FileInputStream;
import java.util.Properties;
import it.unipv.po.cosi.restaurant.database.classDAO.CategoryDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ModifierDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.OrderDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ServingDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.TableDAO;

/**
 * Factory class that creates the Database access Object for every table in the DB
 * This class represents the implementation of creational pattern Factory.
 * Contains method for the creation of CategoryDAO, ServingDAO, OrderDAO, ModifierDAO, TableDAO
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 2
 */
public class DaoFactory {
	private static CategoryDAO categories;
	private static ServingDAO servings;
	private static OrderDAO orders;
	private static TableDAO tables;
	private static ModifierDAO modifiers;
	
	private static final String C_PROPERTYNAME="category.class.name";
	private static final String S_PROPERTYNAME="serving.class.name";
	private static final String O_PROPERTYNAME="order.class.name";
	private static final String T_PROPERTYNAME="table.class.name";
	private static final String M_PROPERTYNAME="modifier.class.name";
	
	/**
	 * Default Constructor
	 */
	public DaoFactory() {}
	
	/**
	 * This method creates an CategoryDAO object using java reflection
	 * @return CategoryDAO is used to manage the Category Table on the DB
	 */
	public static CategoryDAO getCategoryDAO() {
		
		if(categories == null){
			String categoryClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/daoFactory/properties.txt"));
				categoryClassName=p.getProperty(C_PROPERTYNAME);

				categories = (CategoryDAO)Class.forName(categoryClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return categories;
	}
	
	/**
	 * This method creates an ModifierDAO object using java reflection
	 * @return ModifierDAO is used to manage the Modifier Table on the DB
	 */
	public static ModifierDAO getModifierDAO() {
		
		if(modifiers == null){
			String modifierClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/daoFactory/properties.txt"));
				modifierClassName=p.getProperty(M_PROPERTYNAME);

				modifiers = (ModifierDAO)Class.forName(modifierClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return modifiers;
	}
	
	/**
	 * This method creates an OrderDAO object using java reflection
	 * @return OrderDAO is used to manage the Ordering and Order_serving Tables on the DB
	 */
	public static OrderDAO getOrderDAO() {
		
		if(orders == null){
			String ordersClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/daoFactory/properties.txt"));
				ordersClassName=p.getProperty(O_PROPERTYNAME);

				orders = (OrderDAO)Class.forName(ordersClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return orders;
	}
	
	/**
	 * This method creates an ServingDAO object using java reflection
	 * @return ServingDAO is used to manage the Serving table on the DB
	 */
	public static ServingDAO getServingDAO() {
		
		if(servings == null){
			String servingClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/daoFactory/properties.txt"));
				servingClassName=p.getProperty(S_PROPERTYNAME);

				servings = (ServingDAO)Class.forName(servingClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return servings;
	}
	
	/**
	 * This method creates an TableDAO object using java reflection
	 * @return TableDAO is used to manage the "Tables" Table on the DB
	 */
	public static TableDAO getTableDAO() {
		
		if(tables == null){
			String tablesClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/daoFactory/properties.txt"));
				tablesClassName=p.getProperty(T_PROPERTYNAME);

				tables = (TableDAO)Class.forName(tablesClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return tables;
	}
	
}
