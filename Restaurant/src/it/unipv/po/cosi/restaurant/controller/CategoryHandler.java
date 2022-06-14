package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.view.JCategoryButton;
import it.unipv.po.cosi.restaurant.view.MainView;

/**
 * Handler Event Handling is the mechanism that controls the event and decides what should happen if an event occurs. 
 * This mechanism have the code which is known as event handler that is executed when an event occurs.
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 3
 */
public class CategoryHandler extends MVCController{

	/**
	 * Constructor
	 * @param m model parameter
	 * @param v view parameter
	 */
	public CategoryHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	/**
	 * This method, when the user clicks on a category, shows the related servings 
	 * @param model model parameter
	 * @param view view parameter
	 */
	public static void addListeners(RestaurantModel model, MainView view) {
		 
		 //--------------------------//
	      // CATEGORY BUTTON LISTENER //
	      
	      ActionListener categoryListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				manageAction(((JCategoryButton)ae.getSource()).getCategory());
				
			}
			
			private void manageAction(Category category) {

				ArrayList<Serving> s = model.getServingsPerCategory(category);
				view.getOrderView().getServingList().setModel(getServingDefaultList(s));
			}
	    	  
	      };
	      
	      for(JCategoryButton butt: view.getOrderView().getCategoryButtons()) {
	    	  butt.addActionListener(categoryListener);
	      }
	      
	}
}
