package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JTextArea;

public class Monitor {

	private String category;
	private JTextArea display;
	
	public Monitor(String c, JTextArea d) {
		category = c;
		display = d;
	}
	
	public String getCategory() {
		return category;
	}
	
	public JTextArea getDisplay() {
		return display;
	}
	
	public void setCategory(String c) {
		category = c;
	}
	
	public void setDisplay(JTextArea d) {
		display = d;
	}
	
}
