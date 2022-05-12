package it.unipv.po.cosi.restaurant.database.classDAO.provaFactory;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import it.unipv.po.cosi.restaurant.database.classDAO.CategoryDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ModifierDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.OrderDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.ServingDAO;
import it.unipv.po.cosi.restaurant.database.classDAO.TableDAO;

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
	
	public static CategoryDAO getCategoryDAO(IDao dao) {
		
		if(categories == null){
			String categoryClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/provaFactory/properties.txt"));
				categoryClassName=p.getProperty(C_PROPERTYNAME);

				categories = (CategoryDAO)Class.forName(categoryClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return categories;
	}
	
	public static ModifierDAO getModifierDAO(IDao dao) {
		
		if(modifiers == null){
			String modifierClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/provaFactory/properties.txt"));
				modifierClassName=p.getProperty(M_PROPERTYNAME);

				modifiers = (ModifierDAO)Class.forName(modifierClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return modifiers;
	}
	
	public static OrderDAO getOrderDAO(IDao dao) {
		
		if(orders == null){
			String ordersClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/provaFactory/properties.txt"));
				ordersClassName=p.getProperty(O_PROPERTYNAME);

				orders = (OrderDAO)Class.forName(ordersClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return orders;
	}
	
	public static ServingDAO getServingDAO(IDao dao) {
		
		if(servings == null){
			String servingClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/provaFactory/properties.txt"));
				servingClassName=p.getProperty(S_PROPERTYNAME);

				servings = (ServingDAO)Class.forName(servingClassName).newInstance();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return servings;
	}
	
	@SuppressWarnings("deprecation")
	public static TableDAO getTableDAO(IDao dao) {
		
		if(tables == null){
			String tablesClassName;

			try {
				Properties p = new Properties(System.getProperties());
				p.load(new FileInputStream("src/it/unipv/po/cosi/restaurant/database/classDAO/provaFactory/properties.txt"));
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
