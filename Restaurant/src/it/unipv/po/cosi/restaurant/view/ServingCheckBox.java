package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;


/**
 * @author      cosi'
 * @version     iterazione 2
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
	 * @return serving 
	 */
	public Serving getServing() {
		return serving;
	}
	
}
