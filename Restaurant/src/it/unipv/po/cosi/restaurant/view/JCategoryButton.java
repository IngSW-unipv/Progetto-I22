package it.unipv.po.cosi.restaurant.view;

import javax.swing.*;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class JCategoryButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Category category;

	public JCategoryButton(String s, Category category) {
		super(s);
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
	 *
	 * @param  variable Description text text text.          (3)
	 * @return Description text text text.
	 */
	public Category getCategory() {
		return category;
	}
	
	
}
