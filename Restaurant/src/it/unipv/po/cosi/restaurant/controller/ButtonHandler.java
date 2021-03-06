package it.unipv.po.cosi.restaurant.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view.MainView;


/**
 * Handler Event Handling is the mechanism that controls the event and decides what should happen if an event occurs. 
 * This mechanism have the code which is known as event handler that is executed when an event occurs.
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 3
 */
public class ButtonHandler extends MVCController {

	/**
	 * buttonHandler constructor
	 * @param m model parameter
	 * @param v view parameter
	 */
	public ButtonHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	/**
	 * creates and adds generic buttons actionlisteners
	 * <p>
	 * shutDownListener: it turns off the software, closing it in the correct way
	 * closeOrderListener: it closes the order, it sets the current table to "free" status,
	 * it inserts the order into the DB, it prints the bill and goes back to the tableView
	 * historyButtonListener: it opens the order history view
	 * backListener: it goes back to the table view
	 * @param model model parameter
	 * @param view view parameter
	 */
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
		
	      
	      //CLOSE ORDER LISTENER//
			
			
	  			ActionListener closeOrderListener = new ActionListener() {

	  				@Override
	  				public void actionPerformed(ActionEvent e) {
	  					
	  					manageAction();
	  					
	  				}

	  				private void manageAction() {
	  					
	  					Table t = view.getOrderView().getSource().getTable();
	  					
	  					if(!t.getOrder().getServings().isEmpty()) {
		  					view.getC1().show(view.getCardPane(), "1");
		  					t.getOrder().setDateTime(Date.from(Instant.now()).toString());
		  	            	model.addOrder(t.getOrder());
		  					view.getOrderView().getSource().setBackground(new Color(0,191,57));
		  					
		  					try {
		  						
		  						File directory = new File("ricevute");
		  						
		  						if(! directory.exists()) {
		  							directory.mkdir();
		  						}
		  						
		  						
		  						File file = new File("ricevute/Ricevuta" + t.getOrder().getId() + ".txt");
		  					    FileWriter fw = new FileWriter(file.getAbsoluteFile());
		  					    BufferedWriter bw = new BufferedWriter(fw);
		  					    bw.write(t.getBill());
		  					    bw.close();
		  					   
	
							} catch (IOException e) {
	
								e.printStackTrace();
							}
		  					
		  					DbControllerSingleton.getInstance().insertOrder(t.getOrder());
		  					t.setOrder(null);
	  					}
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
			    		view.getHistoryView().getHistoryTable().setModel(getDefaultTable(DbControllerSingleton.getInstance().selectAllOrders()));
			    	}
			    	
			      };
			      
			      view.getHistoryButton().addActionListener(hystoryButtonListener);
			      
			      // ORDER SELECTION LISTENER //
			      
			      ActionListener orderSelectionListrener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						manageAction();
					}
					
			    	private void manageAction() {
			    			int selectedRow = view.getHistoryView().getHistoryTable().getSelectedRow();
			    			int id = Integer.parseInt((String)(view.getHistoryView().getHistoryTable().getValueAt(selectedRow, 0)));
			    			System.out.println("ID = " + id);
			    			
			    			if(selectedRow != -1) {
			    				view.getHistoryView().getServingTable().setModel(getDefaultTable(DbControllerSingleton.getInstance().selectAllServingFromOrders(id)));
			    			}
			    		}  
			      };
			      
			      view.getHistoryView().getOpenOrderButton().addActionListener(orderSelectionListrener);


			      //BACK BUTTON LISTENER
			      
			      ActionListener backListener = new ActionListener() {
			    	  @Override
			    	  public void actionPerformed(ActionEvent ae) {
			    		  
			    		  manageAction();
			    		  
			    	  }
			    	  
			    	  private void manageAction() {
			    		  
			    		  view.getC1().show(view.getCardPane(), "1");

			    	  }
			      };
			      
			      view.getOrderView().getBackButton().addActionListener(backListener);
			      view.getSettingsView().getBackButton().addActionListener(backListener);
			      view.getHistoryView().getBackButton().addActionListener(backListener);
	}
}
