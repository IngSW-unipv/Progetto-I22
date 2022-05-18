package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;

public class ModifierCheckBox extends JCheckBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Modifier modifier;

	public ModifierCheckBox(Modifier modifier) {
		super();
		this.modifier = modifier;
	}

	public ModifierCheckBox(String text, Modifier modifier) {
		super(text);
		this.modifier = modifier;
	}

	public Modifier getModifier() {
		return modifier;
	}
	
	
	
	
}
