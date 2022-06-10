package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.view.JCategoryButton;
import it.unipv.po.cosi.restaurant.view.MainView;

public class CategoryHandler extends MVCController{

	public CategoryHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

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
