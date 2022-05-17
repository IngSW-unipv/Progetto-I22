package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

import java.util.ArrayList;

public class Serving implements Comparable<Serving> {
	
	private int id;
	private String name;
	private Category category;
	private float price;
	private ArrayList<Modifier> modifiers;
	private int quantity;
	private boolean activeFlag;
	
	//	public Serving(int id, String name, float price, Category category) {
//		
//		this.id = id;
//		this.name = name;
//		this.category = category;
//		this.price = price;	
//		modifiers = new ArrayList<Modifier>();
//		
//	}
//	
	public Serving(int id, String name, float price, Category category, boolean activeFlag) {
			
			this.id = id;
			this.name = name;
			this.category = category;
			this.price = price;	
			modifiers = new ArrayList<Modifier>();
			this.activeFlag = activeFlag;
			
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

	public int getId() {
		return id;
	}
	
	public boolean isActiveFlag() {
		return activeFlag;
	}
	
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public void setId(int id) {
		this.id = id;
	}
	 
	public static void setStartingID(int id) {
		
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Serving o) {
		
		return name.compareTo(o.getName());
	}

}
