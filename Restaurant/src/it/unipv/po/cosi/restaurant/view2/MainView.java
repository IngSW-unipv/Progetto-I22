package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JFrame;
import javax.swing.border.Border;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Collections;
import java.awt.*;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JTableButton> tableButtons;
	private JPanel tablePane;
	private JPanel editPane;
	private JButton editButton;
	private OrderView orderView;
	private JPanel legendPane;

	
	
	
	public MainView(ArrayList<Table> tables, ArrayList<Category> categories) throws IOException {
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		tableButtons = new ArrayList<JTableButton>();
		initComponents(tables, categories);
	
	}
	
	private void initComponents(ArrayList<Table> tables, ArrayList<Category> categories) throws IOException {
		
		// TABLE PANEL //
		int nTables = tables.size();
		orderView = new OrderView(categories);
		tablePane = new JPanel();
		tablePane.setLayout(new GridLayout((int)Math.ceil(Math.sqrt(nTables)), (int)Math.ceil(Math.sqrt(nTables)), 15, 15));
		tablePane.setBorder(BorderFactory.createLineBorder(Color.black));
		// LEGEND PANE //
		
//		BufferedImage image = ImageIO.read(new File("src/view/source/legenda.svg"));
//	    JLabel label = new JLabel(new ImageIcon(image));
//	    legendPane.add(label);
		
//		legendPane.setLayout(new GridLayout(4, 1));
//		legendPane.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("src/view/source/legenda.svg"))));
//		legend = new JTextArea(" \nLEGENDA:\n ");
//		legend.setEditable(false);
//		legend.setFont(new java.awt.Font("Synchro LET", 1, 20));
//		greenDot = new JTextArea(" █:");
//		greenDot.setForeground(Color.green);
//		legendPane.add(legend);
//		legendPane.add(greenDot);
		
		
		// EDIT PANEL //
		
		editPane = new JPanel();
		editPane.setLayout(new BorderLayout());
		editPane.setSize(300, 1000);
		editButton = new JButton(" Impostazioni ");
		editButton.setFont(new java.awt.Font("Synchro LET", 1, 24));
//		editButton.setContentAreaFilled(false);
		editPane.add(editButton, BorderLayout.NORTH);
//		editPane.add(legendPane, BorderLayout.CENTER);
		
		for(Table table: tables) {
			
			JTableButton butt = new JTableButton(""+table.getNumber(), table);
			butt.setFont(new java.awt.Font("Synchro LET", 1, 24));
			butt.setOpaque(true);
//			butt.setBorderPainted(false);
			butt.setBackground(new Color(0,191,57));
//			butt.setVisible(false);
			tableButtons.add(butt);
			tablePane.add(butt);
			
			
		}
		
		
		// THIS VIEW // 
		
		  setLayout(new BorderLayout());
	      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	      
	      Toolkit kit = Toolkit.getDefaultToolkit(); 
		  Dimension screenSize = kit.getScreenSize(); 
		  int screenHeight = screenSize.height;
		  int screenWidth = screenSize.width;
		  setSize(screenWidth,screenHeight); 
//		  ssetLocation(screenWidth/4,screenHeight/4);
	      
//	      setExtendedState(JFrame.MAXIMIZED_BOTH);
		  setResizable(true);
	      add(tablePane, BorderLayout.CENTER);
		  add(editPane, BorderLayout.EAST);
		  
		  
		  
	}

	public ArrayList<JTableButton> getTableButtons() {
		return tableButtons;
	}

	public JPanel getTablePane() {
		return tablePane;
	}

	public JPanel getEditPane() {
		return editPane;
	}

	public JButton getEditButton() {
		return editButton;
	}
	
	public OrderView getOrderView() {
		return orderView;
	}

	public JTableButton getSingleButton(int id) {
		
		for(JTableButton b: tableButtons) {
			
			if(id==b.getTable().getNumber()) {
				return b;
			}		
		}
		return null;
	} 
}
