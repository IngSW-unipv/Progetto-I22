package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;


/**
 * @author      cosi'
 * @version     iteration 2
 * @since 		iteration 1
 */
public class Modifier {

	/**
	 * the String that describes the name of this Modifier instance
	 */
	private String name;
	/**
	 * the Category whose this serving belongs
	 */
	private Category category;
	/**
	 *  the price of this Serving instance
	 */
	private float price;
	/**
	 * the String that describes the name of this Modifier instance
	 */
	private boolean activeFlag;
	
	public Modifier(String name, Category category, float price, boolean activeFlag) {
		
		this.name = name;
		this.category = category;
		this.price = price;	
		this.activeFlag = activeFlag;
		
	}
	
	/**
	 * getter that gets the name of the modifier
	 * @return string containing the name of the modifier
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter that gets the Category of the modifier
	 * @return category containing the category of the modifier
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * getter that gets the price of the modifier
	 * @return float containing the price of the modifier
	 */
	public float getPrice() {
		return price;
	}	
	
	/**
	 * overrides the toString method 
	 * @return string containing the name attribute of the modifier 
	 */
	@Override
	public String toString() {
		return name;
	}
	/**
	 * getter for the isActiveFlag 
	 * @return boolean value of the activeFlag of the modifier
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/**
	 * sets active the activeFlag of the modifier
	 * @param activeFlag boolean value
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
