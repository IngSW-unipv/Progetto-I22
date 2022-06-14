package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;


/**
 * @author      cosi'
 * @version     iterazione 2
 * @since 		iterazione 1
 */
public class Category {

	/**
	 * the string containing the name attribute of the category 
	 */
	private String name;
	/**
	 * the activeFlag showing if a category is active or not
	 */
	private boolean activeFlag;
	
	/**
	 * constructor of the category class
	 * @param name string 
	 * @see name
	 * @param activeFlag boolean
	 * @see activeflag
	 */
	public Category(String name, boolean activeFlag){
		
		this.name = name;
		this.activeFlag = activeFlag;
		
	}

	
	/**
	 * getter that gets the name of the category
	 * @return string containing the name of the category
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * overrides the toString method 
	 * @return string containing the name attribute of the category 
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * getter for the isActiveFlag 
	 * @return boolean value of the activeFlag of the category
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/**
	 * sets active the activeFlag of the category
	 * @param activeFlag boolean value
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
