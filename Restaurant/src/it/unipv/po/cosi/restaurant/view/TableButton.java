package it.unipv.po.cosi.restaurant.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TableButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int number;
	
	public TableButton(int number, ImageIcon icon) {
		
		super();
		this.number = number;
		this.setText(Integer.toString(number));
		this.setIcon(icon);
		
	}
	
	
	
	public int getNumber() {
		return number;
	}

	
	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
