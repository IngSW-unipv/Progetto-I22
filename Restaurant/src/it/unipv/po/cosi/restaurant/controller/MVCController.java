package it.unipv.po.cosi.restaurant.controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.view.MainView;

import javax.swing.table.DefaultTableModel;

public class MVCController {
	
	private static RestaurantModel model;
	private static MainView view;
	
	public MVCController(RestaurantModel m, MainView v) {
		
		model = m;
		view = v;
		initComponents();
	}
	
	private void initComponents() {
		
		
		addListener();
	}
	      	
	
	
	
	 private void addListener() {
		 
		 	

	      TableHandler.addListeners(model, view);
	      CategoryHandler.addListeners(model, view);
	      ServingHandler.addListeners(model, view);
	      SettingHandler.addListeners(model, view);
	      ModifierHandler.addListeners(model, view);
	      SettingHandler.addListeners(model, view);
	      ButtonHandler.addListeners(model, view);
	      MonitorsHandler.createMonitors(model);
	      MonitorsHandler.addListeners(model, view);
	     
	 }      
	 
	 
	 
		
	 
	 protected static void populateOrderList(ArrayList<Serving> servings) {
		 
		 view.getOrderView().getOrderList().setModel(getServingDefaultList(servings));

	 }
	 
		public static DefaultListModel<Serving> getServingDefaultList(ArrayList<Serving> servings) {
			
			DefaultListModel<Serving> s = new DefaultListModel<Serving>();
			int i = 0;
			
			for (Serving serving : servings) {
				
				s.add(i, serving);
				i++;
			} 
			
			return s;
		}
		

		public static DefaultListModel<Modifier> getModifierDefaultList(ArrayList<Modifier> modifiers) {
			
			DefaultListModel<Modifier> s = new DefaultListModel<Modifier>();
			int i = 0;
			
			for (Modifier modifier : modifiers) {
					
					s.add(i, modifier);
					i++;
			} 
			
			return s;
		}
		
		public static DefaultTableModel getDefaultTable(ArrayList<String[]> source) {
			
			DefaultTableModel model = new DefaultTableModel(0,0) {
				
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			
			
			for (String[] array : source) {
				
				model.addColumn("", array);
			}
			
			return model;
		}
		

}
