package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.view2.JCategoryButton;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class CategoryHandler extends MVCController{

	public CategoryHandler(RestaurantModel m, MainView v) {
		super(m, v);
		// TODO Auto-generated constructor stub
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
//				s.sort(null);
				view.getOrderView().getServingList().setModel(getServingDefaultList(s));
			}
	    	  
	      };
	      
	      for(JCategoryButton butt: view.getOrderView().getCategoryButtons()) {
	    	  butt.addActionListener(categoryListener);
	      }
	      
	}
	
	
	
}
