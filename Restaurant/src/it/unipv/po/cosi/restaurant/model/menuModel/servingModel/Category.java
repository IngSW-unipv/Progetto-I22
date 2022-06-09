package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

public class Category {

	private String name;
	private boolean activeFlag;
	
	public Category(String name, boolean activeFlag){
		
		this.name = name;
		this.activeFlag = activeFlag;
		
	}

	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
