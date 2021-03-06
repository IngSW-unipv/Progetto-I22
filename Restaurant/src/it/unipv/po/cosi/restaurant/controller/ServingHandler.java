package it.unipv.po.cosi.restaurant.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Status;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view.MainView;

/**
 * Handler Event Handling is the mechanism that controls the event and decides what should happen if an event occurs. 
 * This mechanism have the code which is known as event handler that is executed when an event occurs.
 * 
 * @author 		cosi'
 * @version 	iteration 3
 * @since 		iteration 3
 */

public class ServingHandler extends MVCController{

	/**
	 * servingHandler constructor
	 * @param m model parameter
	 * @param v view parameter
	 */
	public ServingHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	/**
	 * creates and adds serving actionlisteners:
	 * <p>
	 * addServingListener: it adds the selected (if it is not null) serving in the order list
	 * decrementServingListener: it decrements the quantity of the selected serving in the current order
	 * removeServingListener: it removes the selected serving from the current order
	 * servingSelectionListener: it shows the modify button once a serving is selected
	 * @param model model parameter
	 * @param view view parameter
	 */
	public static void addListeners(RestaurantModel model, MainView view) {
	      
		  // ADD SERVING LISTENER //
	      
	      ActionListener addServingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				Table table = view.getOrderView().getSource().getTable();
				manageAction(table);
				
			}
			
			private void manageAction(Table table) {
				
				if(view.getOrderView().getServingList().getSelectedValue()!= null) {
							
						Order o = view.getOrderView().getSource().getTable().getOrder();
		            	o.addServing(view.getOrderView().getServingList().getSelectedValue());
		            	Collections.sort(o.getServings());
		            	populateOrderList(o.getServings());
		    			view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(252,93,93));   // RED
		    			view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).getTable().setStatus(Status.ORDERED);

				}				
				
			}
	    	  
	      };
	      
	      view.getOrderView().getAddToOrderButton().addActionListener(addServingListener);
	      
	      
	      // REMOVE SERVING LISTENER //
	      
	      ActionListener decrementServingListener = new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				
				if(view.getOrderView().getOrderList().getSelectedValue()!= null) {
					
					Order o = view.getOrderView().getSource().getTable().getOrder();
					Serving s = view.getOrderView().getOrderList().getSelectedValue();
					o.decrementServing(s);
					populateOrderList(o.getServings());
				}
			}
	    	  
	      };
	      
	      view.getOrderView().getDecrementFromOrderButton().addActionListener(decrementServingListener);
	      
	      
	      
	      ActionListener removeServingListener = new ActionListener( ) {

				@Override
				public void actionPerformed(ActionEvent e) {
					manageAction();
					
				}
				
				private void manageAction() {
					
					if(view.getOrderView().getOrderList().getSelectedValue()!= null) {
						
						Order o = view.getOrderView().getSource().getTable().getOrder();
						Serving s = view.getOrderView().getOrderList().getSelectedValue();
						o.removeServing(s);
						populateOrderList(o.getServings());
					}
				}
		    	  
		      };
		      
		      view.getOrderView().getRemoveFromOrderButton().addActionListener(removeServingListener);
	      
	      //----------------------------//
	      // SERVING SELECTION LISTENER //
	      
	      ListSelectionListener servingSelectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				manageAction();
				
			}
			
			private void manageAction() {
				if(view.getOrderView().getServingList().getSelectedValue()!= null) {
					
					view.getOrderView().getAddModifierButton().setVisible(true);
				}
				else {
					view.getOrderView().getAddModifierButton().setVisible(false);
				}
			}
			
	      };
	      
	      view.getOrderView().getServingList().addListSelectionListener(servingSelectionListener);
	      
	}
	
}
