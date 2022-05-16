package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JCheckBox;

import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class TableCheckBox extends JCheckBox{
	
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
