package it.unipv.po.cosi.restaurant.view;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import it.unipv.po.cosi.restaurant.model.orderModel.Table;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class JTableButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Table table;
	
	
	
	public JTableButton(Table table) {
		super();
		this.table = table;
	}

	public JTableButton(Action a, Table table) {
		super(a);
		this.table = table;
	}

	public JTableButton(Icon icon, Table table) {
		super(icon);
		this.table = table;
	}

	public JTableButton(String text, Icon icon, Table table) {
		super(text, icon);
		this.table = table;
	}

	public JTableButton(String text, Table table) {
		super(text);
		this.table = table;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return table text text text.
	 */
	public Table getTable() {
		return table;
	}

}
