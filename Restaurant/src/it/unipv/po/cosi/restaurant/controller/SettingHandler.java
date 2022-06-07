package it.unipv.po.cosi.restaurant.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.exception.WarningFrameException;
import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.testers.GUITest;
import it.unipv.po.cosi.restaurant.view2.CategoryCheckBox;
import it.unipv.po.cosi.restaurant.view2.MainView;
import it.unipv.po.cosi.restaurant.view2.ModifierCheckBox;
import it.unipv.po.cosi.restaurant.view2.ServingCheckBox;
import it.unipv.po.cosi.restaurant.view2.TableCheckBox;
import it.unipv.po.cosi.restaurant.view2.WarningFrame;

public class SettingHandler extends MVCController{

	public SettingHandler(RestaurantModel m, MainView v) {
		super(m, v);
		// TODO Auto-generated constructor stub
	}

	public static void addListeners(RestaurantModel model, MainView view) {
		
		   // SETTINGS BUTTON LISTENER //
	      
	      ActionListener settingsButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manageAction();
			}
	    	
			private void manageAction() {
				// TODO
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
					if(updatedFlag) throw new WarningFrameException("Riavvio necessario");
					
				}
	  
		      };
	      
	      view.getSettingsView().getConfirmButton().addActionListener(confirmListener);
	
	}
	
}
