package it.unipv.po.cosi.restaurant.view2;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import it.unipv.po.cosi.restaurant.model.menuModel.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class MVCController {
	
	private RestaurantModel model;
	private MainView view;
	
	public MVCController(RestaurantModel m, MainView v) {
		
		model = m;
		view = v;
		initComponents();
	}
	
	private void initComponents() {
		
		
		addListener();
	}
	      	
	
	
	
	 private void addListener() {
		 
		 
		 // TABLE BUTTON LISTENERS //
		
		 ActionListener tableListener = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	 view.getOrderView().setSource(((JTableButton) ae.getSource()));
	        	 JTableButton butt = view.getOrderView().getSource();  
	        	 manageAction(butt.getID());
	         }

	         private void manageAction(int b) {
	            view.getOrderView().setVisible(true);
	            populateList(0);
	               
	         }
	      };
	      	for (JButton cb : view.getTableButtons()) {
	      			cb.addActionListener(tableListener);
	      	}
	      	
	      	
	      	
	      	
	      	
	      	// STATUS BUTTON LISTENERS //
	
	      ActionListener statusListener = new ActionListener() {
	    	  @Override
	    	  public void actionPerformed(ActionEvent ae) {
	    		  manageAction(((JStatusButton) ae.getSource()).getID());  
	    	  }
	    	  
	    	  private void manageAction(int b) {
	    		 switch (b) {
	    		 	
	    		 case 1: // case FREE
	    			 view.getSingleButton(view.getOrderView().getSource().getID()).setBackground(Color.green);
	    			 break;
	    		 case 2:
	    			 view.getSingleButton(view.getOrderView().getSource().getID()).setBackground(Color.red);
//	    			 view.getSingleButton(view.getOrderView().getSource().getID()).setForeground(Color.white);
	    			 break;
	    		 case 3:
	    			 view.getSingleButton(view.getOrderView().getSource().getID()).setBackground(new Color(255, 219, 88));
	    			 break;
	    		 case 4:
	    			 view.getSingleButton(view.getOrderView().getSource().getID()).setBackground(new Color(0,255,255));
	    			 break;
	    			 
	    		default:
	    			break; // could add an exception for index not valid
	    		 }
	    	  }
	      };
	      
	      view.getOrderView().getFreeButton().addActionListener(statusListener);
	      view.getOrderView().getOrderedButton().addActionListener(statusListener);
	      view.getOrderView().getWaitingButton().addActionListener(statusListener);
	      view.getOrderView().getPayingSoonButton().addActionListener(statusListener);
	      	
	     
	      
	      
	      
	      
	      // BACK BUTTON LISTENER //
	      
	      ActionListener backListener = new ActionListener() {
	    	  @Override
	    	  public void actionPerformed(ActionEvent ae) {
	    		  
	    		  manageAction();
	    		  
	    	  }
	    	  
	    	  private void manageAction() {
	    		  
	    		  view.getOrderView().dispose();
	    	  }
	      };
	      
	      view.getOrderView().getBackButton().addActionListener(backListener);
	 }
	 
	 private void populateList(int id) {
		 
//		 view.getOrderView().setListModel(model.getOrders().get(0).getServinNamesArray());
		 view.getOrderView().getServingList().setModel(getServingDefaultList());


	 }
	 
		public DefaultListModel<Serving> getServingDefaultList() {
			
			DefaultListModel<Serving> s = new DefaultListModel<Serving>();
			int i = 0;
			
			for (Serving serving : model.getServingsArray()) {
				
				s.add(i, serving);
//				System.out.println(i + serving.getName());
				i++;
			} 
			
			return s;
		}
}
