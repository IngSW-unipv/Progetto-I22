package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JFrame;
import javax.swing.border.Border;
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

	
	
	
	public MainView(int n) throws IOException {
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		tableButtons = new ArrayList<JTableButton>();
		initComponents(n);
	
	}
	
	private void initComponents(int n) throws IOException {
		
		// TABLE PANEL //
		orderView = new OrderView();
		tablePane = new JPanel();
		tablePane.setLayout(new GridLayout((int)Math.ceil(Math.sqrt(n)), (int)Math.ceil(Math.sqrt(n)), 15, 15));
		
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
		editPane.add(editButton, BorderLayout.NORTH);
//		editPane.add(legendPane, BorderLayout.CENTER);
		
		for(int i=0; i<=n; i++) {
			
			JTableButton butt = new JTableButton(""+i, i);
			butt.setFont(new java.awt.Font("Synchro LET", 1, 24));
			butt.setOpaque(true);
//			butt.setBorderPainted(false);
			butt.setBackground(Color.green);
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
		  setSize(screenWidth,(int)(screenHeight-0.1*screenHeight)); 
//		  ssetLocation(screenWidth/4,screenHeight/4);
	      
//	      setExtendedState(JFrame.MAXIMIZED_BOTH);
		  setResizable(false);
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
			
			if(id==b.getID()) {
				return b;
			}		
		}
		return null;
	} 
}
