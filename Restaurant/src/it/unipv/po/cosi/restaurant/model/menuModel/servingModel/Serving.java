package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

import java.util.ArrayList;

public class Serving implements Comparable<Serving> {
	
	private int id;
	private String name;
	private Category category;
	private float price;
	private ArrayList<Modifier> modifiers;
	private int quantity;
	private int served;
	private boolean activeFlag;

	
	public Serving(int id, String name, float price, Category category, boolean activeFlag) {
			
			this.id = id;
			this.name = name;
			this.category = category;
			this.price = price;	
			modifiers = new ArrayList<Modifier>();
			this.activeFlag = activeFlag;
			this.quantity = 0;
			this.served = 0;
			
		}
	
	public Serving(int id, String name, float price, Category category) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;	
		modifiers = new ArrayList<Modifier>();
		this.quantity = 0;
		this.served = 0;
		
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
		
		float temp = price*quantity;
		System.out.println("temp = " + temp + "single price = " + this.getSinglePrice() + "quantity = " + this.getQuantity());
		for (Modifier modifier : modifiers) {
			
			temp = temp + modifier.getPrice();
		}
		return temp;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void incrementQuantity() {
		quantity++;
	}
	
	public void decrementQuantity() {
		quantity--;
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
		
		String rslt = name;
		
		if(quantity>1) {
			rslt = "x" + quantity + " " + rslt;
		}
		
		for (Modifier modifier : modifiers) {
			
			rslt = rslt + " + " + modifier.getName();
		}
		
		return rslt;
	}

	@Override
	public int compareTo(Serving o) {
		
		return name.compareTo(o.getName());
	}

	public Serving copy() {
		
		Serving sCopy = new Serving(this.getId(), this.getName(), this.getSinglePrice(), this.getCategory());
		sCopy.setQuantity(this.getQuantity());
		sCopy.setModifiers(this.getModifiers());
		return sCopy;
	}

	public void setModifiers(ArrayList<Modifier> modifiers) {
		this.modifiers = modifiers;
	}
	
	public float getSinglePrice() {
		return price;
	}

	public int getServed() {
		return served;
	}

	public void setServed(int served) {
		this.served = served;
	}

	
}
