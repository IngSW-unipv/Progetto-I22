package it.unipv.po.cosi.restaurant.view.subMenu.smlisteners;

import java.awt.event.*;
import java.awt.*;

import javax.swing.JButton;
public class RedListener implements ActionListener{

	private JButton tavolo;
	
	public RedListener(JButton b) {
		this.tavolo = b;
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		tavolo.setBackground(new Color(160, 0, 60));
		tavolo.setForeground(Color.white);
	
		
	}
	
}
