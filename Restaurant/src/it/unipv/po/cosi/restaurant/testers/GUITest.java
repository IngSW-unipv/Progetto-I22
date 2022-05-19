package it.unipv.po.cosi.restaurant.testers;

import java.io.IOException;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.view2.MVCController;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class GUITest {

	public static void main(String[] args) throws IOException {

		
			DbControllerSingleton dbc = DbControllerSingleton.getInstance();
			
			dbc.initializeCategories();
			dbc.initializeTables();
			dbc.initializeModifiers();
			dbc.initializeServings();
			dbc.initializeOrders();
			dbc.populateCategoriesArray();
			dbc.populateServingsArray();
			dbc.populateModifiersArray();
			dbc.populateTalesArray();
			
			RestaurantModel m = RestaurantModel.getInstance();
			MainView v = new MainView(m.getServingsArray(), m.getCategoriesArray(), m.getModifiersArray(), m.getTablesArray(),0,0);
			v.setVisible(true);
			
//			m.getServingsArray().get(40).setActiveFlag(true);
//			dbc.updateActiveServings();
			
//			Order o = new Order(m.getTablesArray().get(0));
//			o.addServing(m.getServingsArray().get(0));
//			m.getTablesArray().get(0).setOrder(o);
//			m.getTablesArray().get(1).setOrder(o);
			
			MVCController c = new MVCController(m, v);
//			System.out.println(m.getModifiersArray().get(0).getCategory().equals(m.getCategoriesArray().get(0)));
//			for (Modifier string : m.getModifiersArray()) {
//				System.out.println(string.getCategory());
//			}
			
			v.getHistoryView().getHistoryTable().setModel(c.getOrderDefaultList(dbc.selectAllOrders()));	
	}

}
