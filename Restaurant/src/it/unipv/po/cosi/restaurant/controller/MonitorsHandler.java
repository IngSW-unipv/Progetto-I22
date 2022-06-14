package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.exception.ConfirmSendOrderException;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.view.MainView;
import it.unipv.po.cosi.restaurant.view.Monitor;

/**
 * Handler Event Handling is the mechanism that controls the event and decides what should happen if an event occurs. 
 * This mechanism have the code which is known as event handler that is executed when an event occurs.
 * @author 		cosi'
 * @version 	iterazione 3
 * @since		iterazione 3
 */
public class MonitorsHandler {

	/**
	 * 
	 * This method adds the listeners for monitors
	 * <p>
	 * This method adds the listeners for monitors
	 * submitOrderListener: sends the servings of the order to the relative category
	 * monitorListener: shows monitorView
	 * backMonitorListener: shows the main view
	 * @param model
	 * @param view
	 * 
	 */
	public static void addListeners(RestaurantModel model, MainView view) {
		
		
		ActionListener submitOrderListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


				Order o = view.getOrderView().getSource().getTable().getOrder();
				
				try {
					manageAction(o);
				} catch (ConfirmSendOrderException e1) {}
				
				
				
			}
			
			public void manageAction(Order o) throws ConfirmSendOrderException {
				
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
				throw new ConfirmSendOrderException();
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
