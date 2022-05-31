package it.unipv.po.cosi.restaurant.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Status;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view2.JStatusButton;
import it.unipv.po.cosi.restaurant.view2.JTableButton;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class TableHandler extends MVCController{

	
	
	public TableHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

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
//	            view.getOrderView().setVisible(true);
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
	            view.getOrderView().getOrderTitle().setText("      Ordine N° " + table.getOrder().getId()+" (Tavolo " +table.getNumber() + ")");   
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
		    			break; // could add an exception for index not valid
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