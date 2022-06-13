package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.orderModel.Table;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class TableCheckBox extends JCheckBox{
	
	private static final long serialVersionUID = 1L;
	private Table table;

	public TableCheckBox(Table table) {
		super();
		this.table = table;
	}

	public TableCheckBox(String text, Table table) {
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
