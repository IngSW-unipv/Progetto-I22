package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;


/**
 * @author      cosi'
 * @version     iteration 2
 * @since 		iteration 2
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

	public Category getCategory() {
		return category;
	}
	
	
}
