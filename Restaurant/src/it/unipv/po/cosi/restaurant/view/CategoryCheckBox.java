package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class CategoryCheckBox extends JCheckBox {

	private static final long serialVersionUID = 1L;
	private Category category;

	public CategoryCheckBox(Category category) {
		super();
		this.category = category;
	}

	public CategoryCheckBox(String text, Category category) {
		super(text);
		this.category = category;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return category text text text.
	 */
	public Category getCategory() {
		return category;
	}
	
	
}
