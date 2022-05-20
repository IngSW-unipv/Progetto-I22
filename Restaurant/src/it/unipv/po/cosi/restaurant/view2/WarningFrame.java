package it.unipv.po.cosi.restaurant.view2;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WarningFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text;
	private JButton confirmButton;
	private JButton ignoreButton;
	private JPanel buttonPane;
	
	public WarningFrame(String title) throws HeadlessException {
		super(title);
		
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(490,190); 
		setLocation((screenWidth/2)-490/2,(screenHeight/2)-190/2);
		buttonPane = new JPanel();
		
		text = new JTextField("  E' necessario riavviare l'applicazione per completare l'operazione  ");
		text.setFont(new java.awt.Font("Arial", 0, 16));
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
		
	}

	public JTextField getText() {
		return text;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	
}
