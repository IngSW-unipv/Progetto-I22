package it.unipv.po.cosi.restaurant.view;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;


/**
 * @author      cosi'
 * @version     iterazione 3
 * @since 		iterazione 1
 */
public class HistoryView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton backButton;
	private JButton openOrderButton;
	private JPanel tablePane;
	private JTable historyTable;
	private JTable servingTable;
	private JPanel buttonPane;
	private JScrollPane scrollPaneHistory;
	private JScrollPane scrollPaneServing;
	
	public HistoryView() {
		super();
			
		this.setLayout(new BorderLayout());
		buttonPane = new JPanel(new BorderLayout());
		tablePane = new JPanel(new GridLayout(1,2));
		historyTable = new JTable(0,0);
		historyTable.setCellEditor(null);
		historyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servingTable = new JTable(0,0);
		scrollPaneHistory = new JScrollPane(historyTable);
		scrollPaneServing = new JScrollPane(servingTable);
		this.add(buttonPane, BorderLayout.NORTH);
		backButton = new JButton("Indietro");
		openOrderButton = new JButton("Apri Ordine");
		backButton.setFont(new java.awt.Font("Arial", 1, 36));
		openOrderButton.setFont(new java.awt.Font("Arial", 1, 36));
		backButton.setIcon(new ImageIcon("src/it/unipv/po/cosi/restaurant/view/icons/back.png"));
		buttonPane.add(backButton, BorderLayout.WEST);
		buttonPane.add(openOrderButton, BorderLayout.EAST);
		tablePane.add(scrollPaneHistory);
		tablePane.add(scrollPaneServing);

		historyTable.setRowHeight(30);
		servingTable.setRowHeight(30);
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		historyTable.setDefaultRenderer(String.class, centerRender);
		servingTable.setDefaultRenderer(String.class, centerRender);
		
		historyTable.setFont(new java.awt.Font("Arial", 0, 18));
		servingTable.setFont(new java.awt.Font("Arial", 0, 18));
		this.add(tablePane, BorderLayout.CENTER);
		
	}

	/**
	 * @return backButton
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * @return openOrderButton 
	 */
	public JButton getOpenOrderButton() {
		return openOrderButton;
	}

	/**
	 * @return historyTable 
	 */
	public JTable getHistoryTable() {
		return historyTable;
	}

	/**
	 * @return buttonPane 
	 */
	public JPanel getButtonPane() {
		return buttonPane;
	}

	/**
	 * @return servingTable 
	 */
	public JTable getServingTable() {
		return servingTable;
	}
	
}