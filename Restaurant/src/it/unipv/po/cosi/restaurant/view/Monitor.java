package it.unipv.po.cosi.restaurant.view;

import javax.swing.JTextArea;


/**
 * @author      cosi'
 * @version     iterazione 3
 * @since		iterazione 3
 */
public class Monitor {

	private String category;
	private JTextArea display;
	
	public Monitor(String c, JTextArea d) {
		category = c;
		display = d;
	}
	
	/**
	 * @return Description
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @return Description
	 */
	public JTextArea getDisplay() {
		return display;
	}
	
	/**
	 * @param c String c
	 */
	public void setCategory(String c) {
		category = c;
	}
	
	/**
	 * @param  d JTextArea 
	 */
	public void setDisplay(JTextArea d) {
		display = d;
	}
	
}
