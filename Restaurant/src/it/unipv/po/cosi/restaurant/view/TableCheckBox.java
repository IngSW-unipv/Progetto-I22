package it.unipv.po.cosi.restaurant.view;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.orderModel.Table;

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

	public Table getTable() {
		return table;
	}
	
}
