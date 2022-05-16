package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class ServingCheckBox extends JCheckBox {

	private Serving serving;

	public ServingCheckBox(Serving serving) {
		super();
		this.serving = serving;
	}

	public ServingCheckBox(String text, Serving serving) {
		super(text);
		this.serving = serving;
	}

	public Serving getServing() {
		return serving;
	}
	
	
	
	
}
