package it.unipv.po.cosi.restaurant.view2;

import javax.swing.JFrame;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

import javax.swing.*;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
	private JStatusButton orderedButton;
	private JStatusButton waitingButton;
	private JStatusButton payingSoonButton;
	private JTableButton source = null;
	private JList<Serving> orderList;
//	private DefaultListModel<Serving> orderListModel;
	private JList<Serving> servingList;
//	private DefaultListModel<Serving> servingListModel;
	
	public OrderView() {
		
		initComponents();
	}

	private void initComponents() {
		
	// LIST PANE //
		
		// ORDER LIST SCROLLER //
		
//		orderListModel = new DefaultListModel<Serving>();
		orderList = new JList<Serving>();
		orderList.setFont(new java.awt.Font("Arial", 0, 24));
		orderScroller = new JScrollPane(orderList);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(-1);
//		listScroller.setPreferredSize(new Dimension(250, 80));
		
		orderList.setForeground(Color.black);
		orderList.setVisible(true);
		orderList.setBackground(Color.white);
		
//		orderList.setModel(orderListModel);
		
		
		// SERVING LIST SCROLLER //

//		servingListModel = new DefaultListModel<Serving>();
		servingList = new JList<Serving>();
		servingList.setFont(new java.awt.Font("Arial", 0, 24));
		servingScroller = new JScrollPane(orderList);
		servingList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		servingList.setLayoutOrientation(JList.VERTICAL);
		servingList.setVisibleRowCount(-1);
//		listScroller.setPreferredSize(new Dimension(250, 80));
		
		servingList.setForeground(Color.black);
		servingList.setVisible(true);
		servingList.setBackground(Color.white);
		
//		servingList.setModel(servingListModel);
		
		
	// BACK BUTTON //
		
		mainButtonPane = new JPanel();
		mainButtonPane.setLayout(new BorderLayout());
		mainButtonPane.add(backButton = new JButton("❮ Back"), BorderLayout.WEST);
		backButton.setFont(new java.awt.Font("Synchro LET", 1, 36));
		
		
		// STATUS CONTROL PANE //
		
		statusControlPane = new JPanel();
		statusControlPane.setLayout(new GridLayout(4, 1));
		statusControlPane.add(freeButton = new JStatusButton("FREE", 1));
		statusControlPane.add(orderedButton = new JStatusButton("ORDERED", 2));
		statusControlPane.add(waitingButton = new JStatusButton("WAITING", 3));
		statusControlPane.add(payingSoonButton = new JStatusButton("PAYING SOON", 4));
		
		freeButton.setFont(new java.awt.Font("Arial", 4, 26));
		orderedButton.setFont(new java.awt.Font("Arial", 4, 26));
		waitingButton.setFont(new java.awt.Font("Arial", 4, 26));
		payingSoonButton.setFont(new java.awt.Font("Arial", 4, 26));
		
		
		// THIS VIEW OPIONS //
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		  Dimension screenSize = kit.getScreenSize(); 
		  int screenHeight = screenSize.height;
		  int screenWidth = screenSize.width;
//		  setSize(screenWidth,(int)(screenHeight-0.1*screenHeight)); 
		  setSize(screenWidth/2,(screenHeight/2));
	      setResizable(true);
	      
		getContentPane().add(orderScroller, BorderLayout.WEST);
		getContentPane().add(servingScroller, BorderLayout.CENTER);
		getContentPane().add(mainButtonPane, BorderLayout.NORTH);
		getContentPane().add(statusControlPane, BorderLayout.EAST);
		
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

	public JList<Serving> getServingList() {
		return orderList;
	}
	
//	public void addElementToList(Serving o) {
//		this.orderListModel.add(0, o);
//	}
//
//	public DefaultListModel<Serving> getListModel() {
//		return orderListModel;
//	}

	public JScrollPane getServingScroller() {
		return servingScroller;
	}

	public JList<Serving> getOrderList() {
		return orderList;
	}
	
	
}
