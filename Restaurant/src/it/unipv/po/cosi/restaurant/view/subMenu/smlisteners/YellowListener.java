package it.unipv.po.cosi.restaurant.view.subMenu.smlisteners;

import java.awt.event.*;

import javax.swing.JButton;

import java.awt.*;

public class YellowListener implements ActionListener {

	private JButton tavolo;
	
	public YellowListener(JButton b) {
		this.tavolo = b;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		tavolo.setBackground(new Color(180, 150, 0));
		tavolo.setForeground(Color.black);
		
	}








}