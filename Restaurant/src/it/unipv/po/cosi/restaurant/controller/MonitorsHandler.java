package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.outputModel.monitorModel.Monitor;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class MonitorsHandler {

	public static void createMonitors(RestaurantModel model) {

		ArrayList<Category> c = model.getActiveCategories();
		ArrayList<Monitor> m = new ArrayList<Monitor>();
		
		for (Category category : c) {
			m.add(new Monitor(category, category.getName()));
		}
		
		model.populateMonitors(m);
	}
	
	public static void addListeners(RestaurantModel model, MainView view) {
		
		
		ActionListener submitOrderListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				Order o = view.getOrderView().getSource().getTable().getOrder();
				
				manageAction(o);
				
			}
			
			public void manageAction(Order o) {
				
				ArrayList<Monitor> m = model.getMonitors();
				
				for (Monitor monitor : m) {
					
					System.out.println(monitor.print(o));
				}
				
			}
		};
		
		
		view.getOrderView().getSend().addActionListener(submitOrderListener);
		
	}
}
