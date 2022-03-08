package it.unipv.po.cosi.restaurant.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import it.unipv.po.cosi.restaurant.model.orderModel.Status;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.*;

public class CassaView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CassaView window = new CassaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public CassaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 823, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		TableButton btnNewButton = new TableButton(1,null);
		btnNewButton.addActionListener(new TableActionListener(btnNewButton, frame.getContentPane()));
		frame.getContentPane().add(btnNewButton);
	
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setSize(screenWidth,screenHeight);
		frame.setLocationRelativeTo(null);
	
	}
	
}
