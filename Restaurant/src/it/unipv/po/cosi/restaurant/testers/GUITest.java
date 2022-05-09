package it.unipv.po.cosi.restaurant.testers;

import java.io.IOException;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.menuModel.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.view2.MVCController;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class GUITest {

	public static void main(String[] args) throws IOException {

		
			DbControllerSingleton dbc = DbControllerSingleton.getInstance();
			
			dbc.initializeCategories();
			dbc.initializeTables();
			dbc.initializeModifiers();
			dbc.initializeServings();
			dbc.populateCategoriesArray();
			dbc.populateServingsArray();
			dbc.populateTalesArray();
			
			RestaurantModel m = RestaurantModel.getInstance();
			MainView v = new MainView(m.getTablesArray(), m.getCategoriesArray());
			v.setVisible(true);
			
//			Order o = new Order(m.getTablesArray().get(0));
//			o.addServing(m.getServingsArray().get(0));
//			m.getTablesArray().get(0).setOrder(o);
//			m.getTablesArray().get(1).setOrder(o);
//			
			MVCController c = new MVCController(m, v);
			
	}

}
