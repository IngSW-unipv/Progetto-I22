package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

import java.util.ArrayList;

public class Serving {
	
	private String name;
	private Category category;
	private float price;
	private ArrayList<Modifier> modifiers;
	private int quantity;
	
	public Serving(String name, Category category, float price) {
		
		this.name = name;
		this.category = category;
		this.price = price;	
		modifiers = new ArrayList<Modifier>();
		
	}
	
	public boolean addModifier(Modifier modifier) {
		
		if(modifier.getCategory().equals(getCategory())) {
			
			modifiers.add(modifier);
			return true;
			
		}
		
		return false;
		
	}
	
	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public float getPrice() {
		
		float temp = 0.0f;
		
		for (Modifier modifier : modifiers) {
			
			temp += modifier.getPrice();
			
		}
		
		return price + temp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<Modifier> getModifiers() {
		return modifiers;
	}
	
	
}
