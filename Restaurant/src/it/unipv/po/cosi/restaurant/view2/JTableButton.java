package it.unipv.po.cosi.restaurant.view2;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class JTableButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int ID;
	
	
	
	public JTableButton(int ID) {
		super();
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JTableButton(Action a, int ID) {
		super(a);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JTableButton(Icon icon, int ID) {
		super(icon);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JTableButton(String text, Icon icon, int ID) {
		super(text, icon);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public JTableButton(String text, int ID) {
		super(text);
		this.ID = ID;
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}
	
	

}
