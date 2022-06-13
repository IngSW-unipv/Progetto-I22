package it.unipv.po.cosi.restaurant.view;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


/**
 * @author      cosi'
 * @version     iterazione 1
 * @since 		iterazione 1
 */
public class JStatusButton extends JButton {

	private static final long serialVersionUID = 1L;
	int ID;
	
	
	
	public JStatusButton(int ID) {
		super();
		this.ID = ID;
	}

	public JStatusButton(Action a, int ID) {
		super(a);
		this.ID = ID;
	}

	public JStatusButton(Icon icon, int ID) {
		super(icon);
		this.ID = ID;
	}

	public JStatusButton(String text, Icon icon, int ID) {
		super(text, icon);
		this.ID = ID;
	}

	public JStatusButton(String text, int ID) {
		super(text);
		this.ID = ID;
	}

	/**
	 * @return ID 
	 */
	public int getID() {
		return ID;
	}
}