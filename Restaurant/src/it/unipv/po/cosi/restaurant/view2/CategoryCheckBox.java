package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;

public class CategoryCheckBox extends JCheckBox {

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