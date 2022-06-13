package it.unipv.po.cosi.restaurant.view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class WarningFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea text;
	private JButton confirmButton;
	private JButton ignoreButton;
	private JPanel buttonPane;
	
	public WarningFrame(String title, String msg) throws HeadlessException {
		super(title);
		
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(490,190); 
		setLocation((screenWidth/2)-490/2,(screenHeight/2)-190/2);
		buttonPane = new JPanel();
		
		text = new JTextArea(msg);
		text.setFont(new java.awt.Font("Arial", 1, 14));
		text.setEditable(false);
		confirmButton = new JButton("Conferma");
		confirmButton.setFont(new java.awt.Font("Arial", 1, 22));
		ignoreButton = new JButton("Ignora  ");
		ignoreButton.setFont(new java.awt.Font("Arial", 1, 22));
		setLayout(new BorderLayout());
		buttonPane.setLayout(new BorderLayout());
		buttonPane.add(confirmButton, BorderLayout.EAST);
		buttonPane.add(ignoreButton, BorderLayout.WEST);
		add(buttonPane, BorderLayout.SOUTH);
		add(text, BorderLayout.CENTER);
		this.setVisible(true);
		
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return ignoreButton text text text.
	 */
	public JButton getIgnoreButton() {
		return ignoreButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return text text text text.
	 */
	public JTextArea getText() {
		return text;
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
	 * @return confirmButton text text text.
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
}