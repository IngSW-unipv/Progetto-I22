package it.unipv.po.cosi.restaurant.view.mainInterface;

import java.awt.*;

import javax.swing.*;

public class CommandPanel extends JPanel{
	
	//private String add;
	//private String remove;
	public CommandPanel() {
		
		
//		this.add = add;
//		this.remove = remove;
	setLayout(new GridLayout(1,4));
		
		
//		Icon icon = new ImageIcon(MainMenu.add);
//		JButton adder = new JButton(icon);
//		adder.setText("Add new Order");
//		add(adder);
//		graphicButton(adder);
		
		
		Icon icon = new ImageIcon(MainMenu.lens);
		JButton search = new JButton(icon);
		search.setText("Search");
		add(search);
		graphicButton(search);
		
		
//		icon = new ImageIcon(MainMenu.editMenu);
//		JButton edit = new JButton(icon);
//		edit.setText("Edit Menu");
//		add(edit);
//		graphicButton(edit);
//		
	
//		icon = new ImageIcon(MainMenu.rev);
//		JButton revert = new JButton(icon);
//		revert.setText("Revert Order");
//		add(revert);
//		graphicButton(revert);
		
	}
	

	public void graphicButton(JButton b) {
		b.setBackground(Color.black);
		b.setForeground(Color.white);
	}

	
	
}
