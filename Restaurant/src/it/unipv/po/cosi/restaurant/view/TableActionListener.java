package it.unipv.po.cosi.restaurant.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TableActionListener implements ActionListener {

	private TableButton table;
	private Container panel;
	
	public TableActionListener(TableButton table, Container panel) {
		
		this.table = table;
		this.panel = panel;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		table.setText("prova");
		table.repaint();
		panel.repaint();
		
	}
	
	
	
	
	
}
