package it.unipv.po.cosi.restaurant.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.view.MainView;

public class ModifierHandler extends MVCController{

	public ModifierHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	public static void addListeners(RestaurantModel model, MainView view) {
		
		 //----------------------------//
	    // ADDING MODIFIERS LISTENERS //
	      
	      ActionListener modifyServingListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
				
			}
	    	private void manageAction() {
	    		
	    		view.getOrderView().getC1().show(view.getOrderView().getMenuCardPane(), "2");
	    		Category cat = view.getOrderView().getServingList().getSelectedValue().getCategory();
	    		
	    		ArrayList<Modifier> modifiers = model.getModifiersPerCategory(cat);
	    		view.getOrderView().getModifierList().setModel(getModifierDefaultList(modifiers));
	    		
	    	}
	    
	      };
	      
	      view.getOrderView().getAddModifierButton().addActionListener(modifyServingListener);
	      
	      
	      
	      
	      ActionListener confirmModifiersListener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					manageAction();
					
				}
		    	private void manageAction() {
		    		
		    		
		    		if(!view.getOrderView().getModifierList().getSelectedValuesList().isEmpty()) {
			    		view.getOrderView().getC1().show(view.getOrderView().getMenuCardPane(), "1");
			    		List<Modifier> mod = view.getOrderView().getModifierList().getSelectedValuesList();
			    		
			    		model.initializeMaxId();
			    		Serving s = view.getOrderView().getServingList().getSelectedValue();
			    		Serving s1 = new Serving(model.getMaxId()+1, s.getName(), s.getSinglePrice(), s.getCategory());
			    		model.setMaxId(model.getMaxId()+1);
			    		
			    		for (Modifier modifier : mod) {
							s1.addModifier(modifier);
							
						}
			    		Order o = view.getOrderView().getSource().getTable().getOrder();
			    		o.addServingWithModifiers(s1);
			    		populateOrderList(o.getServings());
			    		view.getOrderView().getSource().setBackground(new Color(252,93,93));
		    		}
		    		else {}
		    	}
		    	
		      };
		      
		      view.getOrderView().getConfirmModifiers().addActionListener(confirmModifiersListener);
		      
		      
		      ActionListener rejectModifiersListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						manageAction();
						
					}
			    	private void manageAction() {
			    		
			    		view.getOrderView().getC1().show(view.getOrderView().getMenuCardPane(), "1");
			    		
			    	}
			    	
			      };
			      
			      view.getOrderView().getRejectModifiers().addActionListener(rejectModifiersListener);
		
	}

}
