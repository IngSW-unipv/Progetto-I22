package it.unipv.po.cosi.restaurant.view2;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import it.unipv.po.cosi.restaurant.model.menuModel.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

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
	        	 manageAction(butt.getTable());
	         }

	         private void manageAction(Table table) {
	            view.getOrderView().setVisible(true);
	            populateMenuList();
	            
	            if(table.getOrder()!= null) {
	            	populateOrderList(table.getOrder().getServings());
	            }
	            else {
	            	Order o = new Order(table);
	            	model.addOrder(o);
	            	populateOrderList(o.getServings());
	            }
	               
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
	    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(0,191,57)); // GREEN
	    			 break;
	    		 case 2:
	    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(252,93,93));   // RED
//	    			 view.getSingleButton(view.getOrderView().getSource().getID()).setForeground(Color.white);
	    			 break;
	    		 case 3:
	    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(170, 93, 252)); // VIOLET
	    			 break;
	    		 case 4:
	    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(0, 136, 255)); // BLUE
	    			 break;
	    		 case 5:
	    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(250,181,42));   //  ORANGE\YELLOW
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
	      view.getOrderView().getPrenotedButton().addActionListener(statusListener);
	     
	      
	      
	      
	      
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
	 
	 private void populateMenuList() {
		 
//		 view.getOrderView().setListModel(model.getOrders().get(0).getServinNamesArray());
		 view.getOrderView().getServingList().setModel(getServingDefaultList(model.getServingsArray()));


	 }
	 
	 private void populateOrderList(ArrayList<Serving> servings) {
		 
//		 view.getOrderView().setListModel(model.getOrders().get(0).getServinNamesArray());
		 view.getOrderView().getOrderList().setModel(getServingDefaultList(servings));


	 }
	 
		public DefaultListModel<Serving> getServingDefaultList(ArrayList<Serving> servings) {
			
			DefaultListModel<Serving> s = new DefaultListModel<Serving>();
			int i = 0;
			
			for (Serving serving : servings) {
				
				s.add(i, serving);
//				System.out.println(i + serving.getName());
				i++;
			} 
			
			return s;
		}
}
