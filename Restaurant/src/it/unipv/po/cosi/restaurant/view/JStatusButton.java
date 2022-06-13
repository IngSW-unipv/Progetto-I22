package it.unipv.po.cosi.restaurant.view;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return ID text text text.
	 */
	public int getID() {
		return ID;
	}
}