package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class ServingCheckBox extends JCheckBox {

	private static final long serialVersionUID = 1L;
	private Serving serving;

	public ServingCheckBox(Serving serving) {
		super();
		this.serving = serving;
	}

	public ServingCheckBox(String text, Serving serving) {
		super(text);
		this.serving = serving;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return serving text text text.
	 */
	public Serving getServing() {
		return serving;
	}
	
}
