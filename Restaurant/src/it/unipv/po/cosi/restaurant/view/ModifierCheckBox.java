package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class ModifierCheckBox extends JCheckBox{

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

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return modifier text text text.
	 */
	public Modifier getModifier() {
		return modifier;
	}
	
}
