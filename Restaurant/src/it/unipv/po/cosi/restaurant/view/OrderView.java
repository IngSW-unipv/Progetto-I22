package it.unipv.po.cosi.restaurant.view;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.CardLayout;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class OrderView extends JPanel{
	
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
	private JButton decrementFromOrderButton;
	private JButton removeButton;
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
	private JButton send;
	
	

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
		addToOrderButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view/icons/add.png"));
		addToOrderButton.setText("Aggiungi");
		addToOrderButton.setFont(new java.awt.Font("Arial", 0, 36));
		decrementFromOrderButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view/icons/decrement.png"));
		decrementFromOrderButton.setText("Decrementa");
		decrementFromOrderButton.setFont(new java.awt.Font("Arial", 0, 36));
		removeButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view/icons/revert.png"));
		removeButton.setText("Rimuovi");
		removeButton.setFont(new java.awt.Font("Arial", 0, 36));
		
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
		
		orderList = new JList<Serving>();
		orderList.setFont(new java.awt.Font("Arial", 0, 32));
		orderScroller = new JScrollPane(orderList);
		orderList.setFixedCellHeight(80);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderList.setLayoutOrientation(JList.VERTICAL);
		orderList.setVisibleRowCount(-1);
		
		
		// SERVING LIST SCROLLER //

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
		mainButtonPane.setLayout(new GridLayout(1,4));
		mainButtonPane.add(backButton = new JButton("Indietro"));
		backButton.setFont(new java.awt.Font("Arial", 1, 36));
		backButton.setIcon(new ImageIcon("src/it/unipv/po/cosi/restaurant/view/icons/back.png"));
		
		orderTitle = new JTextField("      Ordine: ");
		orderTitle.setEditable(false);
		orderTitle.setFont(new java.awt.Font("Arial", 0, 40));
		mainButtonPane.add(orderTitle);
		
		mainButtonPane.add(send = new JButton("Invia Ordine"));
		send.setFont(new java.awt.Font("Arial", 1, 36));
		closeOrderButton = new JButton("Close/Pay order");
		closeOrderButton.setBackground(Color.decode("#D00000"));
		closeOrderButton.setForeground(Color.white);
		closeOrderButton.setFont(new java.awt.Font("Arial", 0, 36));
		mainButtonPane.add(closeOrderButton);
		
		
		
		
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
	      
	    JPanel southernPanelLeftContainer = new JPanel(new GridLayout(1,2));
	    southernPanelLeftContainer.add(decrementFromOrderButton);
	    southernPanelLeftContainer.add(removeButton);
		scrollingContainer.add(scrollingLeftContainer);
		scrollingContainer.add(menuCardPane);
		scrollingRightContainer.add(servingScroller, BorderLayout.CENTER);
		scrollingLeftContainer.add(orderScroller, BorderLayout.CENTER);
		scrollingLeftContainer.add(southernPanelLeftContainer, BorderLayout.SOUTH);
		scrollingRightContainer.add(categoryButtonPane, BorderLayout.NORTH );
		setLayout(new BorderLayout());
		add(scrollingContainer, BorderLayout.CENTER);
		add(mainButtonPane, BorderLayout.NORTH);
		add(statusControlPane, BorderLayout.EAST);
		
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return orderScroller text text text.
	 */
	public JScrollPane getListScroller() {
		return orderScroller;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return mainButtonPane text text text.
	 */
	public JPanel getMainButtonPane() {
		return mainButtonPane;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return statusControlPane text text text.
	 */
	public JPanel getStatusControlPane() {
		return statusControlPane;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return backButton text text text.
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return freeButton text text text.
	 */
	public JStatusButton getFreeButton() {
		return freeButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return orderedButton text text text.
	 */
	public JStatusButton getOrderedButton() {
		return orderedButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return waitingButton text text text.
	 */
	public JStatusButton getWaitingButton() {
		return waitingButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return source text text text.
	 */
	public JTableButton getSource() {
		return source;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setSource(JTableButton source) {
		this.source = source;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return payingSoonButton text text text.
	 */
	public JStatusButton getPayingSoonButton() {
		return payingSoonButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return prenotedButton text text text.
	 */
	public JStatusButton getPrenotedButton() {
		return prenotedButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return servingList text text text.
	 */
	public JList<Serving> getServingList() {
		return servingList;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return servingScroller text text text.
	 */
	public JScrollPane getServingScroller() {
		return servingScroller;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return orderList text text text.
	 */
	public JList<Serving> getOrderList() {
		return orderList;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return categoryButtons text text text.
	 */
	public ArrayList<JCategoryButton> getCategoryButtons() {
		return categoryButtons;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return addToOrderButton text text text.
	 */
	public JButton getAddToOrderButton() {
		return addToOrderButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return decrementFromOrderButton text text text.
	 */
	public JButton getDecrementFromOrderButton() {
		return decrementFromOrderButton;
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return removeButton text text text.
	 */
	public JButton getRemoveFromOrderButton() {
		return removeButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return addModifierButton text text text.
	 */
	public JButton getAddModifierButton() {
		return addModifierButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return orderTitle text text text.
	 */
	public JTextField getOrderTitle() {
		return orderTitle;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return modifierList text text text.
	 */
	public JList<Modifier> getModifierList() {
		return modifierList;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return confirmModifiers text text text.
	 */
	public JButton getConfirmModifiers() {
		return confirmModifiers;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return rejectModifiers text text text.
	 */
	public JButton getRejectModifiers() {
		return rejectModifiers;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return menuCardPane text text text.
	 */
	public JPanel getMenuCardPane() {
		return menuCardPane;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return c1 text text text.
	 */
	public CardLayout getC1() {
		return c1;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return closeOrderButton text text text.
	 */
	public JButton getCloseOrderButton() {
		return closeOrderButton;
	}

	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return send text text text.
	 */
	public JButton getSend() {
		return send;
	}
	
}