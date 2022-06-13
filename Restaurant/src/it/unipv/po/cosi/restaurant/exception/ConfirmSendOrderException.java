package it.unipv.po.cosi.restaurant.exception;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class ConfirmSendOrderException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public ConfirmSendOrderException() {
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); 
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		JFrame okFrame = new JFrame("Conferma Ordine");
		JButton okButton = new JButton("Ok");
		okButton.setFont(new java.awt.Font("Arial", 1, 24));
		JPanel panel = new JPanel(new BorderLayout());
		JTextField msg = new JTextField("Ordine Inviato !");
		msg.setFont(new java.awt.Font("Arial", 1, 24));
		msg.setEditable(false);
		msg.setHorizontalAlignment(JTextField.CENTER);
		okFrame.setLocation((screenWidth/2),(screenHeight/2));
		
		panel.add(msg, BorderLayout.CENTER);
		panel.add(okButton, BorderLayout.SOUTH);
		okFrame.add(panel);
		okFrame.setVisible(true);
		okFrame.setSize(350, 150);
		ActionListener okButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				okFrame.dispose();
				okFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		};
		
		okButton.addActionListener(okButtonListener);
		
	}
}
