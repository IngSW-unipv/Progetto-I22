package it.unipv.po.cosi.restaurant.view2;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.util.Collections;
import java.util.List;


public class OrderView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane orderScroller;
	private JScrollPane servingScroller;
	private JPanel mainButtonPane;
	private JPanel statusControlPane;
	private JButton backButton;
	private JStatusButton freeButton;
	private JStatusButton prenotedButton;
	private JStatusButton orderedButton;
	private JStatusButton waitingButton;
	private JStatusButton payingSoonButton;
	private JTableButton source = null;
	private JList<Serving> orderList;
	private JList<Serving> servingList;
	private JPanel scrollingContainer;
	private JPanel scrollingRightContainer;
	private ArrayList<JCategoryButton> categoryButtons;
	private JPanel categoryButtonPane;
	private JButton addToOrderButton;
	private JButton removeFromOrderButton;
	private JPanel scrollingLeftContainer;
	
	
	public OrderView(ArrayList<Category> categories) {
		
		initComponents(categories);
	}

	private void initComponents(ArrayList<Category> categories) {
		
	// LIST PANE //
		
		scrollingContainer = new JPanel();
		scrollingContainer.setLayout(new GridLayout(1, 2));
		scrollingLeftContainer = new JPanel();
		scrollingLeftContainer.setLayout(new BorderLayout());
		scrollingRightContainer = new JPanel();
		scrollingRightContainer.setLayout(new BorderLayout());
		categoryButtons = new ArrayList<JCategoryButton>(); 
		categoryButtonPane = new JPanel();
		addToOrderButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/add.png"));
		addToOrderButton.setText("Aggiungi");
		addToOrderButton.setFont(new java.awt.Font("Arial", 0, 32));
		
		removeFromOrderButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/revert.png"));
		removeFromOrderButton.setText("Rimuovi");
		removeFromOrderButton.setFont(new java.awt.Font("Arial", 0, 32));
		scrollingRightContainer.add(addToOrderButton, BorderLayout.SOUTH);
		
		
		// ORDER LIST SCROLLER //
		
//		orderListModel = new DefaultListModel<Serving>();
		orderList = new JList<Serving>();
		orderList.setFont(new java.awt.Font("Arial", 0, 32));
		orderScroller = new JScrollPane(orderList);
		orderList.setFixedCellHeight(80);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(-1);
		
		orderList.setForeground(Color.black);
		orderList.setVisible(true);
		orderList.setBackground(Color.white);
		
		
		// SERVING LIST SCROLLER //

//		servingListModel = new DefaultListModel<Serving>();
		servingList = new JList<Serving>();
		servingList.setFont(new java.awt.Font("Arial", 0, 36));
		servingScroller = new JScrollPane(servingList);
		servingList.setFixedCellHeight(100);
		servingList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		servingList.setLayoutOrientation(JList.VERTICAL);
		servingList.setVisibleRowCount(-1);
		
		servingList.setForeground(Color.black);
		servingList.setVisible(true);
		servingList.setBackground(Color.white);
		
		
		for(Category c: categories) {
			
			JCategoryButton butt = new JCategoryButton(c.getName(), c);
			butt.setFont(new java.awt.Font("Arial", 0, 40));
			butt.setMinimumSize(new Dimension(0, 80));
			categoryButtons.add(butt);
			categoryButtonPane.setLayout(new GridLayout(1, 3));
			categoryButtonPane.add(butt);
			
		}
		
		
	// BACK BUTTON //
		
		mainButtonPane = new JPanel();
		mainButtonPane.setLayout(new BorderLayout());
		mainButtonPane.add(backButton = new JButton("❮ Back"), BorderLayout.WEST);
		backButton.setFont(new java.awt.Font("Synchro LET", 1, 36));
		
		
		// STATUS CONTROL PANE //
		
		statusControlPane = new JPanel();
		statusControlPane.setLayout(new GridLayout(5, 1));
		statusControlPane.add(freeButton = new JStatusButton("FREE", 1));
		statusControlPane.add(prenotedButton = new JStatusButton("PRENOTED", 5));
		statusControlPane.add(orderedButton = new JStatusButton("ORDERED", 2));
		statusControlPane.add(waitingButton = new JStatusButton("WAITING", 3));
		statusControlPane.add(payingSoonButton = new JStatusButton("PAYING SOON", 4));
		
		freeButton.setFont(new java.awt.Font("Arial", 4, 26));
		prenotedButton.setFont(new java.awt.Font("Arial", 4, 26));
		orderedButton.setFont(new java.awt.Font("Arial", 4, 26));
		waitingButton.setFont(new java.awt.Font("Arial", 4, 26));
		payingSoonButton.setFont(new java.awt.Font("Arial", 4, 26));
		
		
		// THIS VIEW OPIONS //
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		  Dimension screenSize = kit.getScreenSize(); 
		  int screenHeight = screenSize.height;
		  int screenWidth = screenSize.width;
		  setSize(screenWidth,screenHeight); 
//		  setSize(screenWidth/2,(screenHeight/2));
	      setResizable(true);
	      
	      
		scrollingContainer.add(scrollingLeftContainer);
		scrollingContainer.add(scrollingRightContainer);
		scrollingRightContainer.add(servingScroller, BorderLayout.CENTER);
		scrollingLeftContainer.add(orderScroller, BorderLayout.CENTER);
		scrollingLeftContainer.add(removeFromOrderButton, BorderLayout.SOUTH);
		scrollingRightContainer.add(categoryButtonPane, BorderLayout.NORTH );
		
		add(scrollingContainer, BorderLayout.CENTER);
		add(mainButtonPane, BorderLayout.NORTH);
		add(statusControlPane, BorderLayout.EAST);
		
	}

	public JScrollPane getListScroller() {
		return orderScroller;
	}

	public JPanel getMainButtonPane() {
		return mainButtonPane;
	}

	public JPanel getStatusControlPane() {
		return statusControlPane;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JStatusButton getFreeButton() {
		return freeButton;
	}

	public JStatusButton getOrderedButton() {
		return orderedButton;
	}

	public JStatusButton getWaitingButton() {
		return waitingButton;
	}

	public JTableButton getSource() {
		return source;
	}

	public void setSource(JTableButton source) {
		this.source = source;
	}

	public JStatusButton getPayingSoonButton() {
		return payingSoonButton;
	}

	
	public JStatusButton getPrenotedButton() {
		return prenotedButton;
	}

	public JList<Serving> getServingList() {
		return servingList;
	}

	public JScrollPane getServingScroller() {
		return servingScroller;
	}

	public JList<Serving> getOrderList() {
		return orderList;
	}

	public ArrayList<JCategoryButton> getCategoryButtons() {
		return categoryButtons;
	}

	public JButton getAddToOrderButton() {
		return addToOrderButton;
	}

	public JButton getRemoveFromOrderButton() {
		return removeFromOrderButton;
	}
	
	
}
