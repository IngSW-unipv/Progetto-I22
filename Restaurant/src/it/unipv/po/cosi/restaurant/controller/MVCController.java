package it.unipv.po.cosi.restaurant.controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

import it.unipv.po.cosi.restaurant.model.RestaurantModel;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.view.MainView;

import javax.swing.table.DefaultTableModel;


/**
 * The front controller design pattern means that all requests that come for a resource in an application will 
 * be handled by a single handler and then dispatched to the appropriate handler for that type of request.
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 1
 */


public class MVCController {
	
	/**
	 * model represents the restaurant's domain
	 */
	private static RestaurantModel model;

	/*
	 * Main view
	 */
	private static MainView view;
	
	/**
	 * Constructor
	 * @param m model parameter
	 * @see model
	 * @param v view parameter
	 * @see view
	 */
	public MVCController(RestaurantModel m, MainView v) {
		
		model = m;
		view = v;
		initComponents();
	}
	
	/**
	 * This method adds the listeners and returns an MVCController Object
	 */
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
	      MonitorsHandler.addListeners(model, view);
	     
	 }      
	 
	 
	 
	 /**
	  * this method takes an ArrayList of servings in input and set the view
	  * @param servings servings arraylist which populates the orderlist
	  */
	 protected static void populateOrderList(ArrayList<Serving> servings) {

		 view.getOrderView().getOrderList().setModel(getServingDefaultList(servings));

	 }
	 
	 /**
	  * this method takes an ArrayList of serving in input and converts it in a DefaultListModel
	  * @param servings servings arraylist which will be converted in DefaultListModel
	  * @return the converted DefaultListModel of Serving
	  */
		public static DefaultListModel<Serving> getServingDefaultList(ArrayList<Serving> servings) {
			
			DefaultListModel<Serving> s = new DefaultListModel<Serving>();
			int i = 0;
			
			for (Serving serving : servings) {
				
				s.add(i, serving);
				i++;
			} 
			
			return s;
		}
		
		 /**
		  * this method takes an ArrayList of Modifier in input and converts it in a DefaultListModel
		  * @param modifiers modifiers arraylist which will be converted in DefalutListModel
		  * @return the DefaultListModel of Modifier
		  */
		public static DefaultListModel<Modifier> getModifierDefaultList(ArrayList<Modifier> modifiers) {
			
			DefaultListModel<Modifier> s = new DefaultListModel<Modifier>();
			int i = 0;
			
			for (Modifier modifier : modifiers) {
					
					s.add(i, modifier);
					i++;
			} 
			
			return s;
		}
		
		/**
		 * this method takes an ArrayList of Strings in input and converts it in a DefaultTableModel
		 * <p>
		 * (each array is converted in a table column)
		 * @param source source arrayList which will be converted in DefaultTableModel
		 * @return the converted DefaultTableModel
		 */
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
