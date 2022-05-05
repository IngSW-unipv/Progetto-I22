package it.unipv.po.cosi.restaurant.testers;

import java.io.IOException;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.menuModel.RestaurantModel;
import it.unipv.po.cosi.restaurant.view2.MVCController;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class GUITest {

	public static void main(String[] args) throws IOException {

		
			DbControllerSingleton dbc = DbControllerSingleton.getInstance();
			dbc.populateCategoriesArray();
			dbc.populateServingsArray();
			RestaurantModel m = RestaurantModel.getInstance();
			MainView v = new MainView(100);
			v.setVisible(true);
			
			MVCController c = new MVCController(m, v);
			
	

	}

}
