package it.unipv.po.cosi.restaurant.view.subMenu.smlisteners;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.unipv.po.cosi.restaurant.view.listeners.BackListener;
import it.unipv.po.cosi.restaurant.view.mainInterface.TablePanel;

import java.awt.*;

public class TableSubMenu extends JPanel{
	
	private JButton adder;
	private JButton remover;
	private JButton back;
	private TablePanel p;
	
	public TableSubMenu(String add, String rem, String back, TablePanel p) {
		
		this.p = p;
		setBackground(Color.black);
		
		Icon icon = new ImageIcon(back);
		this.back = new JButton(icon);
		add(this.back);
		graphicButton(this.back);
		this.back.setText("Back");
		BackListener b = new BackListener(p);
		this.back.addActionListener(b);
		
		icon = new ImageIcon(add);
		this.adder = new JButton(icon);
		add(adder);
		graphicButton(adder);
		adder.setText("Add Serving");
		
		icon = new ImageIcon(rem);
		this.remover = new JButton(icon);
		add(remover);
		graphicButton(remover);
		remover.setText("Remove Serving");
		

	
	}
	
	
	
	
	public void graphicButton(JButton b) {
		b.setBackground(Color.black);
		b.setForeground(Color.white);
	}
	
	

	/*
	 * Questa classe rappresenta il pannello del frame che si apre
	 *  ogni qualvolta si clicca su un tavolo*/
	
	
	public JButton getAdder() {
		return adder;
	}
	
	public JButton getRemover() {
		return remover;
	}
	
	public JButton getBack() {
		return back;
	}
	
	
	
	
}