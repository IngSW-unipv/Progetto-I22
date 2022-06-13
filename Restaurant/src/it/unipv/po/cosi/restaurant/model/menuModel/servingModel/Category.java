package it.unipv.po.cosi.restaurant.model.menuModel.servingModel;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class Category {

	private String name;
	private boolean activeFlag;
	
	public Category(String name, boolean activeFlag){
		
		this.name = name;
		this.activeFlag = activeFlag;
		
	}

	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return name text text text.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return name text text text.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return activeFlag text text text.
	 */
	public boolean isActiveFlag() {
		return activeFlag;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	
}
