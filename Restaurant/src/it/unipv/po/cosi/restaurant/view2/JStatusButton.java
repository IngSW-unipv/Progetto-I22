package it.unipv.po.cosi.restaurant.view2;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class JStatusButton extends JButton {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int ID;
	
	
	
	public JStatusButton(int ID) {
		super();
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JStatusButton(Action a, int ID) {
		super(a);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JStatusButton(Icon icon, int ID) {
		super(icon);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JStatusButton(String text, Icon icon, int ID) {
		super(text, icon);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JStatusButton(String text, int ID) {
		super(text);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}
}
