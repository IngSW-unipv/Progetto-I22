package it.unipv.po.cosi.restaurant.testers;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class ModelTest {

	public static void main(String[] args) {
		
		DbControllerSingleton c = DbControllerSingleton.getInstance();
		
		c.populateCategoriesArray();
		c.populateModifiersArray();
		c.populateServingsArray();
		c.populateTalesArray();
		
		for (Serving a : RestaurantModel.getInstance().getServingsArray()) {
			System.out.println(a);

		}
		
		for (Category a : RestaurantModel.getInstance().getCategoriesArray()) {
			System.out.println(a);

		}
		
		for (Table a : RestaurantModel.getInstance().getTablesArray()) {
			System.out.println(a);

		}
		
		for (Modifier a : RestaurantModel.getInstance().getModifiersArray()) {
			System.out.println(a);

		}

	}
}