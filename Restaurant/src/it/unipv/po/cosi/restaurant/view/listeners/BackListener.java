package it.unipv.po.cosi.restaurant.view.listeners;


import javax.swing.*;

import it.unipv.po.cosi.restaurant.view.mainInterface.TablePanel;

import java.awt.event.*;

public class BackListener implements ActionListener {
	
	private JPanel t;
	

	public BackListener(JPanel t){
		
		this.t = t;

	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		t.setVisible(true);
	}
	
	

}
