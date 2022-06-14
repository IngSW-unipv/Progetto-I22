package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;

import java.util.ArrayList;


/**
 * @author      cosi'
 * @version     iteration 2                 (current version number of program)
 * @since		iteration 1
 * 
 */
public class Serving implements Comparable<Serving> {
	/**
	 * number to identify an instance of the serving class
	 */
	private int id;
	/**
	 * string to describe the serving instance
	 */
	private String name;
	/**
	 * category that contains the serving instance
	 */
	private Category category;
	/**
	 * float number that indicates the serving price
	 */
	private float price;
	/**
	 * list of possible modifiers associated to a serving
	 */
	private ArrayList<Modifier> modifiers;
	/**
	 * number that identifies the quantity of the serving
	 */
	private int quantity;
	/**
	 * counter that identifies the quantity of the servings that has been already sent
	 */
	private int served;
	/**
	 * flag that allows to enable or disable the serving instance in the GUI
	 */
	private boolean activeFlag;

	/**
	 * serving class construnctor
	 * @param id id attribute
	 * @see id
	 * @param name name attribute
	 * @see name
	 * @param price price attribute
	 * @see price
	 * @param category category attribute
	 * @see category
	 * @param activeFlag attribute
	 * @see activeFlag
	 */	
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
	
	/**
	 * serving class construnctor
	 * @param id id attribute
	 * @see id
	 * @param name name attribute
	 * @see name
	 * @param price price attribute
	 * @see price
	 * @param category category attribute
	 * @see category
	 */	
	public Serving(int id, String name, float price, Category category) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;	
		modifiers = new ArrayList<Modifier>();
		this.quantity = 0;
		this.served = 0;
		
	}
	

	/**
	 * method that adds a modifier into the modifiers attribute
	 * <p>
	 * if the modifier category is equal to the serving category the modifier
	 * will be added into the modifiers attribute of this instance and will
	 * returns true, else returns false.
	 * @param modifier modifier that will be added to the modifiers arraylist
	 * @return boolean
	 */
	public boolean addModifier(Modifier modifier) {
		
		if(modifier.getCategory().equals(getCategory())) {
			
			modifiers.add(modifier);
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * getter for the name attribute
	 * @return the name attribute of this instance
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter for the category attribute
	 * @return category attribute of this instance
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * returns price attribute
	 * <p>
	 * it returns the total price which includes the quantity of the serving,
	 * and all the added modifiers to it
	 * @return the total price
	 */
	public float getPrice() {
		
		float temp = price*quantity;
		System.out.println("temp = " + temp + "single price = " + this.getSinglePrice() + "quantity = " + this.getQuantity());
		for (Modifier modifier : modifiers) {
			
			temp = temp + modifier.getPrice();
		}
		return temp;
		
	}

	/**
	 * getter for the quantity attribute
	 * @return quantity attribute
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * setter for the quantity attribute
	 * @param quantity int value that will be assigned to the quantity attribute
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * incements the quantity attribute
	 */
	public void incrementQuantity() {
		quantity++;
	}
	
	/**
	 * decrement the quantity attribute
	 */
	public void decrementQuantity() {
		quantity--;
	}
	
	/**
	 * getter for the modifiers attribute
	 * @return modifiers arrayList attribute
	 */
	public ArrayList<Modifier> getModifiers() {
		return modifiers;
	}

	/**
	 * getter for the id attribute
	 * @return id attribute
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * getter for the activeFlag attribute
	 * @return activeFlag attribute
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}
	
	/**
	 * setter for the activeFlag attribute
	 * @param activeFlag the boolean value that will be assigned to the activeFlag attribute
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * Setter for the id attribute
	 * @param id serving identifier
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * returns a string made of attributes chaining
	 * @return a string of attributes chaining
	 */
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

	/**
	 * compares the names of the servings using compareTo method from String class
	 * @return name.compareTo(o.getName())
	 * @see String.compareTo()
	 */
	@Override
	public int compareTo(Serving o) {
		
		return name.compareTo(o.getName());
	}

	/**
	 * returns a copy of this serving instance
	 * @return sCopy serving instance copy
	 */
	public Serving copy() {
		
		Serving sCopy = new Serving(this.getId(), this.getName(), this.getSinglePrice(), this.getCategory());
		sCopy.setQuantity(this.getQuantity());
		return sCopy;
	}

	/**
	 * setter for the modifiers attribute
	 * @param modifiers modifier arrayList that will be assigned to the modifiers attribute
	 */
	public void setModifiers(ArrayList<Modifier> modifiers) {
		this.modifiers = modifiers;
	}
	
	/**
	 * getter for the price attribute
	 * @return price price attribute
	 */
	public float getSinglePrice() {
		return price;
	}

	/**
	 * getter for the served attribute
	 * @return served served attribute
	 */
	public int getServed() {
		return served;
	}

	/**
	 * setter for the served attribute
	 * @param served int value that will be assigned to the served attribute
	 */
	public void setServed(int served) {
		this.served = served;
	}

	
}
