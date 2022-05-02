package it.unipv.po.cosi.restaurant.view.mainInterface;

import java.awt.*;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.*;




public class MainMenu extends JFrame {
	
	

	
	private TablePanel tp;
	private static JPanel activePanel;
	private static CommandPanel commands;
	public final static String logo = "src/it/unipv/po/cosi/restaurant/view/properties/R1.png";
	public final static String add = "src/it/unipv/po/cosi/restaurant/view/properties/add.png";
	public final static String lens = "src/it/unipv/po/cosi/restaurant/view/properties/lente.png";
	//public final static String editMenu = "src/it/unipv/po/cosi/restaurant/view/properties/editMenu.png";
	//public final static String rev = "src/it/unipv/po/cosi/restaurant/view/properties/revert.png";
	public final static String remove = "src/it/unipv/po/cosi/restaurant/view/properties/minus.png";
	public final static String pTables = "src/it/unipv/po/cosi/restaurant/view/properties/tables";
	public final static String back = "src/it/unipv/po/cosi/restaurant/view/properties/back.png";
	
	
	public MainMenu() {
		
		
		centerFrame();
		setTitle("Restaurant");
		setIconImage(Toolkit.getDefaultToolkit().getImage(logo));
		
		int n = getTablesNumb();
		this.tp = new TablePanel(n, this);
		this.activePanel = tp;
		Container c = getContentPane();

		commands = new CommandPanel();
		c.add(commands, BorderLayout.NORTH);
		
		c.add(tp, BorderLayout.CENTER);
				
		//LowerPanel lp = new LowerPanel();
		//c.add(lp, BorderLayout.SOUTH);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}
	
	
	
	public static void main(String[] args) {
	
		
		MainMenu p = new MainMenu();
		

	}
	
	
	public void centerFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth,screenHeight);
		setLocation(screenWidth,screenHeight);
	}
	
	
	
	public int getTablesNumb() {
		try {
			//questa � logica di dominio e va messa da un'altra parte. qu� serve solo per fare un test. al costruttore tablePanel devo solo passare 
			//un int che � il numero di tavoli da realizzare, va nel contoller
			Properties p = new Properties(System.getProperties());
			p.load(new FileInputStream(pTables));
		return (int)Integer.parseInt(p.getProperty("tables"));

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	public static CommandPanel getCommand()
	{
		return commands;
	}

	/*
	 * legenda:
	 * pTables = path file configurazione Tavoli
	 * */
	
	
	public TablePanel getTablePanel() {
		return tp;
	}
	
	
	public static void setActivePanel(JPanel p){
		activePanel = p;
	}
	
	
	public static JPanel getActivePanel() {
		return activePanel;
	}
	
	
}
