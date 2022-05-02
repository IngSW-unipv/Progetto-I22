package it.unipv.po.cosi.restaurant.view.subMenu.smlisteners;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;


public class GreenListener implements ActionListener {
	
	private JButton tavolo;
	
	
	public GreenListener(JButton b)
	{
		this.tavolo = b;
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		tavolo.setBackground(new Color (40, 180, 40));
		tavolo.setForeground(Color.black);
	}
	
	
}