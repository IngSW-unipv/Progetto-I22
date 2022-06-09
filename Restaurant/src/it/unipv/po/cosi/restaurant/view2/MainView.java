package it.unipv.po.cosi.restaurant.view2;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;



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
	private JLabel legendImage;
	private JButton historyButton;
	private HistoryView historyView;
	private MonitorView monitors;
	private JButton monitorButton;
	
	public JButton getMonitorButton() {
		return monitorButton;
	}

	public MainView(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables, int r, int c) throws IOException {
		super();

		try {
			this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			this.setUndecorated(true);
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		tableButtons = new ArrayList<JTableButton>();
		initComponents(servings,categories,modifiers,tables,r,c);
	}
	
	private void initComponents(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables, int r, int c) throws IOException {
		
		// CARD LAYOUT PANEL //
		c1 = new CardLayout();
		cardPane = new JPanel();
		cardPane.setLayout(c1);

		// MONITORS
		monitors = new MonitorView(categories);
		
		
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
		
		legendPane = new JPanel();
		legendImage = new JLabel();
		legendImage.setIcon(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/legend.PNG"));
		legendPane.add(legendImage);
		
		// EDIT PANEL //
		
		editPane = new JPanel();
		editPane.setLayout(new BorderLayout());
		editPane.setSize(300, 1000);
		pane = new JPanel(new FlowLayout());
		editButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/settings.PNG"));
		shutDownButton = new JButton(new ImageIcon("src/it/unipv/po/cosi/restaurant/view2/icons/powerOffWhite.PNG"));
		shutDownButton.setBackground(Color.decode("#D00000"));
//		editButton.setContentAreaFilled(false);
//		editPane.add(editButton, BorderLayout.SOUTH);
		
		monitorButton = new JButton("Monitor");
		monitorButton.setFont(new java.awt.Font("Arial", 1, 24));
		
		
		
		
		editPane.add(pane, BorderLayout.NORTH);
		pane.add(editButton);
		pane.add(shutDownButton);
		
		historyButton = new JButton("Storico ordini");
		historyButton.setFont(new java.awt.Font("Arial", 1, 24));
		historyView = new HistoryView();
		
		JPanel temporaryPanel = new JPanel(new GridLayout(2,1));
		temporaryPanel.add(monitorButton);
		temporaryPanel.add(historyButton);
		//editPane.add(historyButton, BorderLayout.SOUTH);
		editPane.add(temporaryPanel, BorderLayout.SOUTH);
		editPane.add(legendPane, BorderLayout.CENTER);
		cardPane.add(historyView,"4");
		
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
		  cardPane.add(monitors, "5");
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

	public JButton getHistoryButton() {
		return historyButton;
	}

	public HistoryView getHistoryView() {
		return historyView;
	}
	
	public MonitorView getMonitors() {
		return monitors;
	}

	
}
