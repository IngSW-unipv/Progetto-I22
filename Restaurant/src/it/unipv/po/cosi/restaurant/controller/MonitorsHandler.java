package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.view2.MainView;
import it.unipv.po.cosi.restaurant.view2.Monitor;

public class MonitorsHandler {

	public static void createMonitors(RestaurantModel model) {

		ArrayList<Category> c = model.getActiveCategories();
		ArrayList<Monitor> m = new ArrayList<Monitor>();
		
	}
		
	
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
				
				
//				ArrayList<Serving> oldserv = new ArrayList<Serving>();
//				ArrayList<Serving> tempServ = new ArrayList<Serving>();
//			
//				
//				
//				
//				if(oldserv.isEmpty()) {
//
//					for (Serving serving : serv) {
//						oldserv.add(serving.copy());
//						tempServ.add(serving.copy());
//					}
//					
//					o.setSent(oldserv);
//					System.out.println("cipolla");
//				} else {
//					
//					tempServ.clear();
//				
//					for (Serving serving : oldserv) {
//						tempServ.add(serving);
//					}
//					
//					for (Serving serving : serv) {
//						for (Serving serving2 : oldserv) {
//							if(serving.getName().equals(serving2.getName()) && (serving.getQuantity() - serving2.getQuantity())<=0) {
//								tempServ.remove(serving2);
//							} 
//							else
//								if(serving.getName().equals(serving2.getName()) && (serving.getQuantity() - serving2.getQuantity())>0){
//								
//								serving2.setQuantity(serving.getQuantity() - serving2.getQuantity());
//								System.out.println("polpetta");
//								
//							}
//						}
//					}
//					
//					oldserv.clear();
//					for (Serving serving : tempServ) {
//						System.out.println("pizza"+oldserv);
//						oldserv.add(serving);
//						
//					}
//					o.setSent(oldserv);
//				}
				
				

				
				
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
		
				System.out.println("vito svita una vite vitale");
				
				
		ActionListener backMonitorListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getC1().show(view.getCardPane(), "1");
				
			}
		};
		
		
		view.getMonitors().getBackButton().addActionListener(backMonitorListener);
		
		
		
	}
}
