package it.unipv.po.cosi.restaurant.view.subMenu.smlisteners;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;


public class BlueListener implements ActionListener {
	
	private JButton tavolo;
	
	
	public BlueListener(JButton b)
	{
		this.tavolo = b;
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		tavolo.setBackground(new Color(0, 40, 160));
		tavolo.setForeground(Color.white);
	}
	
	
}
