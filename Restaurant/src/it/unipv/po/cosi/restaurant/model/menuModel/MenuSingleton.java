package it.unipv.po.cosi.restaurant.model.menuModel;

import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class MenuSingleton {

	private ArrayList<Serving> servings;
	private static MenuSingleton menu;
	
	private MenuSingleton() {
		
		this.servings = new ArrayList<Serving>();
		
	}
	
	public static MenuSingleton getInstance() {
		
		if(menu == null) {
			
			menu = new MenuSingleton();
			
		}
		
		return menu;
		
	}
	

	
	public Serving getServing(String name) {
		
		for (Serving serving : servings) {
			
			if(serving.getName().equals(name.toLowerCase())) {
				
				return serving;
				
			}
			
		}
		
		return null;
		
	}
	
	public boolean update() {
		
		return true;
		
	}
	
}
