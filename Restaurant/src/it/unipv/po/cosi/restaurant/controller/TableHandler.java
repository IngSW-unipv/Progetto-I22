package it.unipv.po.cosi.restaurant.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Status;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view.JStatusButton;
import it.unipv.po.cosi.restaurant.view.JTableButton;
import it.unipv.po.cosi.restaurant.view.MainView;

/**
 * Handler Event Handling is the mechanism that controls the event and decides what should happen if an event occurs. 
 * This mechanism have the code which is known as event handler that is executed when an event occurs.ù
 * 
 * @author 		cosi'
 * @version 	iteration 3
 * @since		iteration 3
 */

public class TableHandler extends MVCController{

	
	
	public TableHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	/**
	 * 
	 * This method adds the listeners for Tables
	 * <p>
	 * This method adds the listeners for Tables
	 * tableListener: shows the order view when the user clicks on a table
	 * statusListener: set the status of the table
	 * @param model model parameter
	 * @param view view parameter
	 * 
	 */
	public static void addListeners(RestaurantModel model, MainView view) {
		
		 // TABLE BUTTON LISTENERS //
		
		 ActionListener tableListener = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent ae) {
	        	 view.getOrderView().setSource(((JTableButton) ae.getSource()));
	        	 JTableButton butt = view.getOrderView().getSource();  
	        	 manageAction(butt.getTable());
	         }

	         private void manageAction(Table table) {
	        	 view.getC1().show(view.getCardPane(), "2");
	            
	            
	            if(table.getOrder()!= null) {
	            	populateOrderList(table.getOrder().getServings());
	            }
	            else {
	            	Order o = new Order(table);
					table.setOrder(o);
					o.setTable(table);
	            	populateOrderList(o.getServings());
	            }
	            view.getOrderView().getOrderTitle().setText("Ordine NÂ° " + table.getOrder().getId()+" (Tavolo " +table.getNumber() + ")");   
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
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).getTable().setStatus(Status.FREE);
		    			 break;
		    		 case 2:
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(252,93,93));   // RED
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).getTable().setStatus(Status.ORDERED);
		    			 break;
		    		 case 3:
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(170, 93, 252)); // VIOLET
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).getTable().setStatus(Status.ORDERED_DESSERT);
		    			 break;
		    		 case 4:
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(0, 136, 255)); // BLUE
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).getTable().setStatus(Status.READY_TO_PAY);
		    			 break;
		    		 case 5:
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).setBackground(new Color(250,181,42));   //  ORANGE\YELLOW
		    			 view.getSingleButton(view.getOrderView().getSource().getTable().getNumber()).getTable().setStatus(Status.PRENOTED);
		    			 break;
		    		
		    		 default:
		    			break;
		    		 }
		    	  }
		      };
		      
		      view.getOrderView().getFreeButton().addActionListener(statusListener);
		      view.getOrderView().getOrderedButton().addActionListener(statusListener);
		      view.getOrderView().getWaitingButton().addActionListener(statusListener);
		      view.getOrderView().getPayingSoonButton().addActionListener(statusListener);
		      view.getOrderView().getPrenotedButton().addActionListener(statusListener);   	
	      	      	
	      	
	}

	
}
