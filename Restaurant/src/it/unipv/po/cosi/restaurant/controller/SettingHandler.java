package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.exception.WarningFrameException;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.view.CategoryCheckBox;
import it.unipv.po.cosi.restaurant.view.MainView;
import it.unipv.po.cosi.restaurant.view.ModifierCheckBox;
import it.unipv.po.cosi.restaurant.view.ServingCheckBox;
import it.unipv.po.cosi.restaurant.view.TableCheckBox;

public class SettingHandler extends MVCController{

	public SettingHandler(RestaurantModel m, MainView v) {
		super(m, v);
	}

	public static void addListeners(RestaurantModel model, MainView view) {
		
		   // SETTINGS BUTTON LISTENER //
	      
	      ActionListener settingsButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
			}
	    	
			private void manageAction() {
				view.getC1().show(view.getCardPane(), "3");
			}
			
	      };
	      
	      view.getEditButton().addActionListener(settingsButtonListener);
	      
	           	// confirm listener //
	      
	      ActionListener confirmListener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						manageAction();
					} catch (WarningFrameException e1) {
						

					}
					
				}
		    	 
				private void manageAction() throws WarningFrameException {
					
					boolean updatedFlag = false;
					view.getC1().show(view.getCardPane(), "1");
					
					
					for (ServingCheckBox b : view.getSettingsView().getServingChecks()){
						
							b.getServing().setActiveFlag(b.isSelected());
						
					}
					
					for (CategoryCheckBox b : view.getSettingsView().getCategoryChecks()){
						
						if(b.getCategory().isActiveFlag() != b.isSelected()) {
							
							b.getCategory().setActiveFlag(b.isSelected());
							updatedFlag = true;
						}
						
						
					}
				
					for (ModifierCheckBox b : view.getSettingsView().getModifierChecks()){
						
						b.getModifier().setActiveFlag(b.isSelected());
						
					}
					
					for (TableCheckBox b : view.getSettingsView().getTableChecks()){
						
						if(b.getTable().isActiveFlag() != b.isSelected()) {
							
							b.getTable().setActiveFlag(b.isSelected());
							updatedFlag = true;
						}
						
						
					}
					
					DbControllerSingleton.getInstance().updateActiveServings();
					DbControllerSingleton.getInstance().updateActiveModifiers();
					DbControllerSingleton.getInstance().updateActiveCategories();
					DbControllerSingleton.getInstance().updateActiveTables();
					if(updatedFlag) throw new WarningFrameException("Riavvio necessario", "\n\t\tATTENZIONE:\n E' necessario riavviare l'applicazione per completare l'operazione  \n Il riavvio del sistema provocherà la perdita degli ordini aperti\n \n\t\tContinuare?");
					
				}
	  
		      };
	      
	      view.getSettingsView().getConfirmButton().addActionListener(confirmListener);
	
	}
	
}
