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
 * This class represents a customized exception to notify the order has been sent
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 3
 */
public class ConfirmSendOrderException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * the method creates a new frame
	 * okButtonListener closes the frame
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
