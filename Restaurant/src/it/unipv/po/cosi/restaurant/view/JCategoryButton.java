package it.unipv.po.cosi.restaurant.view;

import javax.swing.*;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;


/**
 * @author      cosi'
 * @version     iterazione 2
 * @since 		iterazione 1
 */
public class JCategoryButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Category category;

	public JCategoryButton(String s, Category category) {
		super(s);
		this.category = category;
	}

	/**
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}
	
	
}
