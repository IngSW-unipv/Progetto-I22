package it.unipv.po.cosi.restaurant.view.mainInterface;
import java.awt.*;
import java.lang.Math;
import javax.swing.*;

import it.unipv.po.cosi.restaurant.view.listeners.TableListener;
import it.unipv.po.cosi.restaurant.view.subMenu.Status;



public class TablePanel extends JPanel{


	
	private int num_tables;
	private JFrame f;
//	private final static String t = "tables"; 

	
public TablePanel(int n, JFrame f) {

	this.num_tables = n;
	this.f = f;
	setLayout(new GridLayout((int)Math.ceil(Math.sqrt(num_tables)), (int)Math.ceil(Math.sqrt(num_tables))));
	
	//il tavolo 0 lo tengo per l'asporto
	for (int i = 0; i <= num_tables; i++){
		JButton tavolo = new JButton();
		add(tavolo);
		tavolo.setBackground(new Color(40, 180, 40));
		TableListener tl = new TableListener(tavolo, this, f);
		
		tavolo.addActionListener(tl);
		tavolo.setText("Tavolo " + i);
		tavolo.setOpaque(true);
	
		
	}
		
	setBackground(Color.BLACK);
	}




//
//public void initListeners(JButton b)
//{
//	
//}







}