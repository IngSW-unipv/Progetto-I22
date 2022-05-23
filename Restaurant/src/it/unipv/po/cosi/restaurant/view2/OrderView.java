package it.unipv.po.cosi.restaurant.view2;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.CardLayout;


public class OrderView extends JPanel{
	
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
	private JButton addModifierButton;
	private JPanel servingSettingsPane;
	private JButton closeOrderButton;
	private JTextField orderTitle;
	private JPanel menuCardPane;
	private JPanel modifierPane;
	private JPanel modifierButtonPane;
	private JScrollPane modifierScroller;
	private JList<Modifier> modifierList;
	private JButton confirmModifiers;
	private JButton rejectModifiers;
	private CardLayout c1;
	
	
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
		addToOrderButton.setFont(new java.awt.Font("Arial", 0, 36));
		removeFromOrderButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/revert.png"));
		removeFromOrderButton.setText("Rimuovi");
		removeFromOrderButton.setFont(new java.awt.Font("Arial", 0, 36));
		servingSettingsPane = new JPanel();
		servingSettingsPane.setLayout(new BorderLayout());
		menuCardPane = new JPanel();
		modifierPane = new JPanel(new BorderLayout());
		modifierButtonPane = new JPanel(new BorderLayout());
		modifierList = new JList<Modifier>();
		modifierScroller = new JScrollPane(modifierList);
		confirmModifiers = new JButton("Conferma");
		confirmModifiers.setFont(new java.awt.Font("Arial", 0, 36));
		confirmModifiers.setBackground(Color.decode("#00BF39"));
		rejectModifiers = new JButton("Annulla");
		rejectModifiers.setFont(new java.awt.Font("Arial", 0, 36));
		modifierPane.add(modifierScroller, BorderLayout.CENTER);
		modifierPane.add(modifierButtonPane, BorderLayout.SOUTH);
		modifierButtonPane.add(confirmModifiers, BorderLayout.EAST);
		modifierButtonPane.add(rejectModifiers, BorderLayout.WEST);
		c1 =  new CardLayout();
		menuCardPane.setLayout(c1);
		menuCardPane.add(scrollingRightContainer, "1");
		menuCardPane.add(modifierPane, "2");
		c1.show(menuCardPane, "1");
		scrollingRightContainer.add(servingSettingsPane, BorderLayout.SOUTH);
		addModifierButton = new JButton("Modifica");
		addModifierButton.setFont(new java.awt.Font("Arial", 0, 36));
		servingSettingsPane.add(addModifierButton, BorderLayout.EAST);
		servingSettingsPane.add(addToOrderButton, BorderLayout.CENTER);
		addModifierButton.setVisible(false);
		
		
		modifierList.setFont(new java.awt.Font("Arial", 0, 32));
		modifierList.setFixedCellHeight(80);
		modifierList.setLayoutOrientation(JList.VERTICAL);
		modifierList.setVisibleRowCount(-1);
		
		modifierList.setSelectionModel(new DefaultListSelectionModel() {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public void setSelectionInterval(int index0, int index1) {
		        if(super.isSelectedIndex(index0)) {
		            super.removeSelectionInterval(index0, index1);
		        }
		        else {
		            super.addSelectionInterval(index0, index1);
		        }
		    }
		});
		
		// ORDER LIST SCROLLER //
		
//		orderListModel = new DefaultListModel<Serving>();
		orderList = new JList<Serving>();
		orderList.setFont(new java.awt.Font("Arial", 0, 32));
		orderScroller = new JScrollPane(orderList);
		orderList.setFixedCellHeight(80);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(-1);
		
		
		
		// SERVING LIST SCROLLER //

//		servingListModel = new DefaultListModel<Serving>();
		servingList = new JList<Serving>();
		servingList.setFont(new java.awt.Font("Arial", 0, 36));
		servingScroller = new JScrollPane(servingList);
		servingScroller.setHorizontalScrollBar(null);
		servingList.setFixedCellHeight(100);
		servingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servingList.setLayoutOrientation(JList.VERTICAL);
		servingList.setVisibleRowCount(-1);
		
		servingList.setForeground(Color.black);
		servingList.setVisible(true);
		servingList.setBackground(Color.white);
		
		
		for(Category c: categories) {
			if(c.isActiveFlag()) {
				JCategoryButton butt = new JCategoryButton(c.getName(), c);
				butt.setFont(new java.awt.Font("Arial", 0, 40));
				butt.setMinimumSize(new Dimension(0, 80));
				categoryButtons.add(butt);
				categoryButtonPane.setLayout(new GridLayout(1, 3));
				categoryButtonPane.add(butt);
			}
		}
		
		
	// BACK BUTTON //
		
		mainButtonPane = new JPanel();
		mainButtonPane.setLayout(new BorderLayout());
		mainButtonPane.add(backButton = new JButton("Indietro"), BorderLayout.WEST);
		backButton.setFont(new java.awt.Font("Arial", 1, 36));
		backButton.setIcon(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/back.png"));
		closeOrderButton = new JButton("Close/Pay order");
		closeOrderButton.setBackground(Color.decode("#D00000"));
		closeOrderButton.setForeground(Color.white);
		closeOrderButton.setFont(new java.awt.Font("Arial", 0, 36));
		orderTitle = new JTextField("      Ordine: ");
		orderTitle.setEditable(false);
		orderTitle.setFont(new java.awt.Font("Arial", 0, 40));
//		orderTitle.setCaretPosition(JTextField.CENTER);
		mainButtonPane.add(closeOrderButton, BorderLayout.EAST);
		mainButtonPane.add(orderTitle, BorderLayout.CENTER);
		
		// STATUS CONTROL PANE //
		
		statusControlPane = new JPanel();
		statusControlPane.setLayout(new GridLayout(5, 1));
		statusControlPane.add(freeButton = new JStatusButton("LIBERO", 1));
		statusControlPane.add(prenotedButton = new JStatusButton("PRENOTATO", 5));
		statusControlPane.add(orderedButton = new JStatusButton("ORDINATO", 2));
		statusControlPane.add(waitingButton = new JStatusButton("ATTESA DOLCE", 3));
		statusControlPane.add(payingSoonButton = new JStatusButton("IN USCITA", 4));
		
		freeButton.setFont(new java.awt.Font("Arial", 4, 26));
		prenotedButton.setFont(new java.awt.Font("Arial", 4, 26));
		orderedButton.setFont(new java.awt.Font("Arial", 4, 26));
		waitingButton.setFont(new java.awt.Font("Arial", 4, 26));
		payingSoonButton.setFont(new java.awt.Font("Arial", 4, 26));
		
		
		// THIS VIEW OPIONS //
//		
//		Toolkit kit = Toolkit.getDefaultToolkit(); 
//		  Dimension screenSize = kit.getScreenSize(); 
//		  int screenHeight = screenSize.height;
//		  int screenWidth = screenSize.width;
//		  setSize(screenWidth,screenHeight); 
//		  setSize(screenWidth/2,(screenHeight/2));
//	      setResizable(true);
	      
	      
		scrollingContainer.add(scrollingLeftContainer);
		scrollingContainer.add(menuCardPane);
		scrollingRightContainer.add(servingScroller, BorderLayout.CENTER);
		scrollingLeftContainer.add(orderScroller, BorderLayout.CENTER);
		scrollingLeftContainer.add(removeFromOrderButton, BorderLayout.SOUTH);
		scrollingRightContainer.add(categoryButtonPane, BorderLayout.NORTH );
		setLayout(new BorderLayout());
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

	public JButton getAddModifierButton() {
		return addModifierButton;
	}

	public JTextField getOrderTitle() {
		return orderTitle;
	}

	public JList<Modifier> getModifierList() {
		return modifierList;
	}

	public JButton getConfirmModifiers() {
		return confirmModifiers;
	}

	public JButton getRejectModifiers() {
		return rejectModifiers;
	}

	public JPanel getMenuCardPane() {
		return menuCardPane;
	}

	public CardLayout getC1() {
		return c1;
	}

	public JButton getCloseOrderButton() {
		return closeOrderButton;
	}

	
	
	
	
}
