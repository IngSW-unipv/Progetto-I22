package it.unipv.po.cosi.restaurant.view2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;

public class MonitorView extends JPanel{

	private JPanel mainPanel;
//	private ArrayList<JTextArea> monitors;
	private ArrayList<Monitor> monitors;
	private JButton backButton;
	
	
	public MonitorView(ArrayList<Category> c) {
		
		this.setLayout(new BorderLayout());

		mainPanel = new JPanel();
//		monitors = new ArrayList<JTextArea>();
		monitors = new ArrayList<Monitor>();
		
		backButton = new JButton("Indietro");
		backButton.setFont(new java.awt.Font("Arial", 0, 36));
		
		this.add(backButton, BorderLayout.NORTH);
		
		
		for (Category category : c) {
			
			JTextArea display = new JTextArea(category.getName());
			display.setFont(new java.awt.Font("Arial", 1, 24));
			display.setBackground(Color.BLACK);
			display.setForeground(Color.GREEN);
			display.setEditable(false);

			Monitor m = new Monitor(category.getName(), display);
			
			mainPanel.setLayout(new GridLayout());
			mainPanel.add(display);
			mainPanel.setVisible(true);
			
			monitors.add(m);
//			monitors.add(display);
			
		}
		
		this.add(mainPanel, BorderLayout.CENTER);
		
	}



	public ArrayList<Monitor> getMonitor() {
		return monitors;
	}



	public void setMonitors(ArrayList<Monitor> monitors) {
		this.monitors = monitors;
	}



	public JButton getBackButton() {
		return backButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
