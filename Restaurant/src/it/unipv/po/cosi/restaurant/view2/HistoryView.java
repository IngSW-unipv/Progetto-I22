package it.unipv.po.cosi.restaurant.view2;

import java.awt.LayoutManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;

public class HistoryView extends JPanel{

	private JButton backButton;
	private JButton printButton;
	private JTable historyTable;
	private JPanel buttonPane;
	private JPanel mainPane;
	
	public HistoryView(int r, int c) {
		super();
			
		this.setLayout(new BorderLayout());
		buttonPane = new JPanel(new BorderLayout());
		mainPane = new JPanel(new BorderLayout());		
		this.add(buttonPane, BorderLayout.NORTH);
		this.add(mainPane, BorderLayout.CENTER);
		backButton = new JButton("Indietro");
		printButton = new JButton("Stampa");
		backButton.setFont(new java.awt.Font("Arial", 1, 36));
		backButton.setIcon(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/back.png"));
		printButton.setFont(new java.awt.Font("Synchro LET", 1, 36));
		buttonPane.add(backButton, BorderLayout.WEST);
		buttonPane.add(printButton, BorderLayout.EAST);
		historyTable = new JTable(r,c);
		mainPane.add(historyTable, BorderLayout.CENTER);
		
		
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JButton getPrintButton() {
		return printButton;
	}

	public JTable getHistoryTable() {
		return historyTable;
	}

	public JPanel getButtonPane() {
		return buttonPane;
	}

	public JPanel getMainPane() {
		return mainPane;
	}
	
	
	
}
