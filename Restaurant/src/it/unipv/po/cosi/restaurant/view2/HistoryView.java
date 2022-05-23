package it.unipv.po.cosi.restaurant.view2;

import java.awt.LayoutManager;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class HistoryView extends JPanel{

	private JButton backButton;
	private JButton printButton;
	private JTable historyTable;
	private JPanel buttonPane;
	private JScrollPane scrollPane;
	
	public HistoryView() {
		super();
			
		this.setLayout(new BorderLayout());
		buttonPane = new JPanel(new BorderLayout());
		historyTable = new JTable(0,0);
		scrollPane = new JScrollPane(historyTable);
		this.add(buttonPane, BorderLayout.NORTH);
		backButton = new JButton("Indietro");
		printButton = new JButton("Stampa");
		backButton.setFont(new java.awt.Font("Arial", 1, 36));
		backButton.setIcon(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/back.png"));
		printButton.setFont(new java.awt.Font("Synchro LET", 1, 36));
		buttonPane.add(backButton, BorderLayout.WEST);
		buttonPane.add(printButton, BorderLayout.EAST);

//		historyTable.setMinimumSize(new Dimension(0, 30));
		historyTable.setRowHeight(30);
//		historyTable.getrow
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		historyTable.setDefaultRenderer(String.class, centerRender);
		
		historyTable.setFont(new java.awt.Font("Arial", 0, 18));
		this.add(scrollPane, BorderLayout.CENTER);
		
		
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
	
	
}
