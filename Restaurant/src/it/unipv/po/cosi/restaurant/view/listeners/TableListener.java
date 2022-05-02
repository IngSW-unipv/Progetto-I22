package it.unipv.po.cosi.restaurant.view.listeners;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unipv.po.cosi.restaurant.view.mainInterface.MainMenu;
import it.unipv.po.cosi.restaurant.view.mainInterface.TablePanel;
import it.unipv.po.cosi.restaurant.view.subMenu.Status;
import it.unipv.po.cosi.restaurant.view.subMenu.smlisteners.TableSubMenu;
public class TableListener extends JPanel implements ActionListener {

	private JFrame f;
	private JPanel p;
	private JButton tavolo;
	private JTextArea display;
	private TablePanel tp;
	private JPanel north;
	
	
	public TableListener(JButton tavolo, TablePanel t, JFrame f) {
		this.tp = t;
		this.tavolo = tavolo;
		this.f = f;

	}
	
	
	public void actionPerformed(ActionEvent e) {
	
		this.tp.setVisible(false);
		
		//	MainMenu.getCommand();
		
		p = new JPanel();
		//f = new JFrame();
		p.setVisible(true);	
		
		p.setLayout(new BorderLayout());
		TableSubMenu t = new TableSubMenu(MainMenu.add, MainMenu.remove, MainMenu.back, this.tp);
		
		Container c = f.getContentPane();
		
		//viene creata una text area sulla quale verranno stampate le specifiche dell'ordine.
		this.display = new JTextArea();
		display.setBackground(Color.black);
		display.setForeground(Color.white);
		display.setText("SPECIFICHE ORDINE");
		p.add(display, BorderLayout.CENTER);
		display.setEditable(false);
		Status s = new Status(tavolo);
		c.add(s, BorderLayout.EAST);	
		
		c.add(p, BorderLayout.CENTER);
		p.add(t, BorderLayout.NORTH);
		MainMenu.setActivePanel(p);
		
	

	
		//this.t.setVisible(true);
	
	
	}
	
	
	public JFrame getFrame() {
		return f;
	}
	
	
	
	public JTextArea getDisplay() {
		return display;
	}
	
	
	
	
	
	
	//metodo che posiziona il frame del subMenu
	public void centerFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/4,screenHeight/4);
		setLocation(screenWidth/4,screenHeight/4);
	}

}