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

public class ServingHandler extends MVCController{

	
	public ServingHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

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
