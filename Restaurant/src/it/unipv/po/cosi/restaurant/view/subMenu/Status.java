package it.unipv.po.cosi.restaurant.view.subMenu;

import javax.swing.*;

import it.unipv.po.cosi.restaurant.view.subMenu.smlisteners.BlueListener;
import it.unipv.po.cosi.restaurant.view.subMenu.smlisteners.GreenListener;
import it.unipv.po.cosi.restaurant.view.subMenu.smlisteners.RedListener;
import it.unipv.po.cosi.restaurant.view.subMenu.smlisteners.YellowListener;

import java.awt.*;

public class Status extends JPanel{
	
	
	
	
	public Status(JButton b) {
		setLayout(new GridLayout(4, 1));
		JButton status1 = new JButton("Ordinato");
		JButton status2 = new JButton("Ordinato Dolce");
		JButton status3 = new JButton("Da Pagare");
		JButton status4 = new JButton("Paga Ora");

		add(status1);
		add(status2);
		add(status3);
		add(status4);
		
		status1.setBackground(Color.black);
		status2.setForeground(Color.black);
		status3.setForeground(Color.black);
		status4.setForeground(Color.black);
		
//		graphicButton(status1);
//		graphicButton(status2);
//		graphicButton(status3);
//		graphicButton(status4);
		
		
		
		RedListener rl = new RedListener(b);
		status1.addActionListener(rl);
	
		YellowListener yl = new YellowListener(b);
		status2.addActionListener(yl);
	
		BlueListener bl = new BlueListener(b);
		status3.addActionListener(bl);
		
		GreenListener gl = new GreenListener(b);
		status4.addActionListener(gl);
	}
	
	
	
	public void graphicButton(JButton b)
	{
		b.setForeground(Color.white);
		b.setBackground(Color.black);
	}
	
	
	
	
	
	
	
	
	
	
	

}
