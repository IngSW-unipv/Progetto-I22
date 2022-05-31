package it.unipv.po.cosi.restaurant.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.Date;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view2.MainView;

public class ButtonHandler extends MVCController {

	public ButtonHandler(RestaurantModel m, MainView v) {
		super(m, v);
		// TODO Auto-generated constructor stub
	}

	public static void addListeners(RestaurantModel model, MainView view) {
		
	      //---------------------//
	      // POWER OFF LISTENER //
	      
	      ActionListener shutDownListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
			}
			
			private void manageAction() {
			
				System.exit(0);
			}
	    	  
	      };
	      
	      view.getShutDownButton().addActionListener(shutDownListener);
		
	      
	      //CLOSE ORDER LISTENER	//
			
			
	  			ActionListener closeOrderListener = new ActionListener() {

	  				@Override
	  				public void actionPerformed(ActionEvent e) {
	  					
	  					manageAction();
	  					
	  				}

	  				private void manageAction() {
	  					
	  					view.getC1().show(view.getCardPane(), "1");
	  					Table t = view.getOrderView().getSource().getTable();
	  					t.getOrder().setDateTime(Date.from(Instant.now()).toString());
	  	            	model.addOrder(t.getOrder());
	  					view.getOrderView().getSource().setBackground(new Color(0,191,57));
	  					DbControllerSingleton.getInstance().insertOrder(t.getOrder());
	  					t.setOrder(null);
	  				}
	  				
	  			};

	  			view.getOrderView().getCloseOrderButton().addActionListener(closeOrderListener);
		
	  			
	  			
				//	HYSTORY BUTTON LISTENER		//
				
				ActionListener hystoryButtonListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						manageAction();
						
					}
			    	private void manageAction() {
			    		
			    		view.getC1().show(view.getCardPane(),"4");
			    		view.getHistoryView().getHistoryTable().setModel(getOrderDefaultList(DbControllerSingleton.getInstance().selectAllOrders()));
			    	}
			    	
			      };
			      
			      view.getHistoryButton().addActionListener(hystoryButtonListener);
			      
			      
			      
			      
			      //back button listeners
			      
			      ActionListener backListener = new ActionListener() {
			    	  @Override
			    	  public void actionPerformed(ActionEvent ae) {
			    		  
			    		  manageAction();
			    		  
			    	  }
			    	  
			    	  private void manageAction() {
			    		  
//			    		  view.getOrderView().dispose();
			    		  view.getC1().show(view.getCardPane(), "1");

			    	  }
			      };
			      
			      view.getOrderView().getBackButton().addActionListener(backListener);
			      view.getSettingsView().getBackButton().addActionListener(backListener);
			      view.getHistoryView().getBackButton().addActionListener(backListener);
	}
}
