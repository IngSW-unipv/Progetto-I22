package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.view.MainView;
import it.unipv.po.cosi.restaurant.view.Monitor;

public class MonitorsHandler {

	public static void createMonitors(RestaurantModel model) {}
		
	
	public static void addListeners(RestaurantModel model, MainView view) {
		
		
		ActionListener submitOrderListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				Order o = view.getOrderView().getSource().getTable().getOrder();
				
				manageAction(o);
				
			}
			
			public void manageAction(Order o) {
				
				ArrayList<Monitor> monitors = view.getMonitors().getMonitor();
				ArrayList<Serving> addedServ = new ArrayList<Serving>();
				
				
				for (Serving serving : o.getServings()) {
					int diff = serving.getQuantity()-serving.getServed();
					
					if(diff>0) {
						Serving s = serving.copy();
						s.setQuantity(diff);
						addedServ.add(s);
						serving.setServed(serving.getQuantity());
					}
				
					for (Monitor monitor : monitors) {
						monitor.getDisplay().setText(monitor.getCategory());
						for (Serving s : addedServ) {
							if(monitor.getCategory().equals(s.getCategory().getName())) {
								
								monitor.getDisplay().append("\n");
								monitor.getDisplay().append("T:" + o.getTable().getNumber() + "-> ");
								monitor.getDisplay().append(s.toString());
								
							}
						}
					}
				}
				
				addedServ.clear();
			}
		};
		
		
		view.getOrderView().getSend().addActionListener(submitOrderListener);
		
		
		ActionListener monitorListener = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						view.getC1().show(view.getCardPane(), "5");
						
					}
				};
						
				view.getMonitorButton().addActionListener(monitorListener);
		
				
		ActionListener backMonitorListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getC1().show(view.getCardPane(), "1");
				
			}
		};
		
		
		view.getMonitors().getBackButton().addActionListener(backMonitorListener);
		
		
		
	}
}
