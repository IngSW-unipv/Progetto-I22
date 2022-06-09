package it.unipv.po.cosi.restaurant.testers;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class DBTest {

	public static void main(String[] args) {
	
		DbControllerSingleton c = DbControllerSingleton.getInstance();

		
		c.populateCategoriesArray();
		c.populateServingsArray();
		
		
		for (Serving plate : RestaurantModel.getInstance().getServingsArray()) {
			System.out.println(plate);
		}
	
	}

}
