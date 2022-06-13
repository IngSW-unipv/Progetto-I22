package it.unipv.po.cosi.restaurant.view;

import javax.swing.JTextArea;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class Monitor {

	private String category;
	private JTextArea display;
	
	public Monitor(String c, JTextArea d) {
		category = c;
		display = d;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return Description text text text.
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return Description text text text.
	 */
	public JTextArea getDisplay() {
		return display;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return Description text text text.
	 */
	public void setCategory(String c) {
		category = c;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  variable Description text text text.          (3)
	 * @return Description text text text.
	 */
	public void setDisplay(JTextArea d) {
		display = d;
	}
	
}
