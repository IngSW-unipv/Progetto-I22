package it.unipv.po.cosi.restaurant.view2;

import javax.swing.border.Border;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view.mainInterface.MainMenu;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
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
	private JButton shutDownButton;
	private JPanel pane;
	private JPanel cardPane;
	private JPanel mainPane;
	private SettingsView settingsView;
	private CardLayout c1;
	
	
	public MainView(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables) throws IOException {
		super();

		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		tableButtons = new ArrayList<JTableButton>();
		initComponents(servings,categories,modifiers,tables);
	}
	
	private void initComponents(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables) throws IOException {
		
		// TABLE PANEL //
		int nTables = tables.size();
		orderView = new OrderView(categories);
		settingsView = new SettingsView(servings,categories,modifiers,tables);
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
		
		
		// CARD LAYOUT PANEL //
		
		
		c1 = new CardLayout();
		cardPane = new JPanel();
		cardPane.setLayout(c1);
		
		// EDIT PANEL //
		
		editPane = new JPanel();
		editPane.setLayout(new BorderLayout());
		editPane.setSize(300, 1000);
		pane = new JPanel(new FlowLayout());
		editButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/settings.PNG"));
		shutDownButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/powerOffWhite.PNG"));
		shutDownButton.setBackground(Color.red);
//		editButton.setContentAreaFilled(false);
//		editPane.add(editButton, BorderLayout.SOUTH);
		editPane.add(pane, BorderLayout.NORTH);
		pane.add(editButton);
		pane.add(shutDownButton);
//		editPane.add(legendPane, BorderLayout.CENTER);
		
		for(Table table: tables) {
			
			if(table.isActiveFlag()) {
				JTableButton butt = new JTableButton(""+table.getNumber(), table);
				butt.setFont(new java.awt.Font("Synchro LET", 1, 24));
				butt.setOpaque(true);
	//			butt.setBorderPainted(false);
				butt.setBackground(new Color(0,191,57));
	//			butt.setVisible(false);
				tableButtons.add(butt);
				tablePane.add(butt);
			}
			
		}
		
		
		// THIS VIEW // 
		
		  setLayout(new BorderLayout());
	      setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	      
	      Toolkit kit = Toolkit.getDefaultToolkit(); 
		  Dimension screenSize = kit.getScreenSize(); 
		  int screenHeight = screenSize.height;
		  int screenWidth = screenSize.width;
		  setSize(screenWidth,screenHeight); 
//		  ssetLocation(screenWidth/4,screenHeight/4);
	      
//	      setExtendedState(JFrame.MAXIMIZED_BOTH);
		  setResizable(true);
		  mainPane = new JPanel();
		  mainPane.setLayout(new BorderLayout());
	      mainPane.add(tablePane, BorderLayout.CENTER);
		  mainPane.add(editPane, BorderLayout.EAST);
		  cardPane.add(mainPane, "1");
		  cardPane.add(orderView, "2");
		  cardPane.add(settingsView, "3");
		  c1.show(cardPane, "1");
		  mainPane.setVisible(true);
		  add(cardPane);
		  
		  
	}

	public ArrayList<JTableButton> getTableButtons() {
		return tableButtons;
	}
	
	public CardLayout getC1() {
		return c1;
	}
	
	public JPanel getCardPane() {
		return cardPane;
	}

	public JPanel getMainPane() {
		return mainPane;
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
	
	public JButton getShutDownButton() {
		return shutDownButton;
	}

	public OrderView getOrderView() {
		return orderView;
	}
	
	public SettingsView getSettingsView() {
		return settingsView;
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
