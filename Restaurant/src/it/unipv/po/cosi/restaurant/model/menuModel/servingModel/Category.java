package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

public class Category {

	private String name;
	
	public Category(String name){
		
		this.name = name;
		
	}

	//ASSIGNMONITOR
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
