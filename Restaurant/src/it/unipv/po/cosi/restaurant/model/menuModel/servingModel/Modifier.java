package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

public class Modifier {

	private String name;
	private Category category;
	private float price;
	
	public Modifier(String name, Category category, float price) {
		
		this.name = name;
		this.category = category;
		this.price = price;	
		
	}
	
	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}	
	
	@Override
	public String toString() {
		return name;
	}
}
