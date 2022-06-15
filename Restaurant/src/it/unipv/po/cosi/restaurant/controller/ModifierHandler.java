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


/**
 * Handler Event Handling is the mechanism that controls the event and decides what should happen if an event occurs. 
 * This mechanism have the code which is known as event handler that is executed when an event occurs.
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 3
 */
public class ModifierHandler extends MVCController{

	/**
	 * ModifierHandler constructor
	 * @param m model parameter
	 * @param v view parameter
	 */
	public ModifierHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	/**
	 * creates and adds modifiers actionlisteners
	 * <p>
	 * modifyServingListener: it shows the modifiers list populated with the allowed ones for the selected serving (by category)
	 * confirmModifierListener: creates a new serving with a new id  with the selected modifiers and adds it into the order list
	 * rejectedModifierListener: it use cardLayout to go back to serving list ignoring the selected modifiers
	 * @param model model parameter
	 * @param view view parameter
	 */
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
