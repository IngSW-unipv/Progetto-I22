package it.unipv.po.cosi.restaurant.testers;

import java.io.IOException;
import it.unipv.po.cosi.restaurant.controller.MVCController;
import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.exception.ExceptionFileChooser;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.view.MainView;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class GUITest {

	public static void main(String[] args) throws IOException, ExceptionFileChooser {

		
			DbControllerSingleton dbc = DbControllerSingleton.getInstance();
			
			dbc.initializeCategories();
			dbc.initializeTables();
			dbc.initializeModifiers();
			dbc.initializeServings();
			dbc.initializeOrders();
			dbc.populateCategoriesArray();
			dbc.populateServingsArray();
			dbc.populateModifiersArray();
			dbc.populateTablesArray();
			
			RestaurantModel m = RestaurantModel.getInstance();
			MainView v = new MainView(m.getServingsArray(), m.getCategoriesArray(), m.getModifiersArray(), m.getTablesArray(),0,0);
			v.setVisible(true);
			MVCController c = new MVCController(m, v);			
	}


}
