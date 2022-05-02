package it.unipv.po.cosi.restaurant.testers;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.menuModel.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

@SuppressWarnings("unused")
public class DBTest {

	public static void main(String[] args) {
	
		DbControllerSingleton c = DbControllerSingleton.getInstance();

		
//		Order order = new Order(new Table(3), 856);
//		
//		Serving serv = new Serving(1, "margherita", 15, new Category("pizzeria"));
//		Serving serv2 = new Serving(2, "marinara", 18, new Category("pizzeria"));
//		
//		order.addServing(serv);
//		order.addServing(serv2);
//		
//		c.insertOrder(order);
		
//		c.initializeCategories();
//		c.initializeTables();
//		c.initializeModifiers();
//		c.initializeServings();
		c.populateCategoriesArray();
		c.populateServingsArray();
		
		
		for (Serving plate : RestaurantModel.getInstance().getServingsArray()) {
			System.out.println(plate);
		}
	
	}

}
