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

public class SettingsView extends JPanel {

	private JScrollPane servingCheck;
	private JScrollPane modifierCheck;
	private JScrollPane categoryCheck;
	private JScrollPane tableCheck;
	
	public SettingsView(DefaultListModel<Serving> servings, DefaultListModel<Category> categories, DefaultListModel<Modifier> modifiers, DefaultListModel<Table> tables) throws HeadlessException {
		super();
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		initComponents(servings, categories, modifiers, tables);
	}

	private void initComponents(DefaultListModel<Serving> servings, DefaultListModel<Category> categories, DefaultListModel<Modifier> modifiers, DefaultListModel<Table> tables) {
		
		
		for(int i=0; i<=categories.size();i++) {
			
		}
		
		
		
		
		
		servingCheck = new JScrollPane();
		modifierCheck = new JScrollPane();
		categoryCheck = new JScrollPane();
		tableCheck = new JScrollPane();
		
//		servingCheck;		
		
		// THIS PANE OPTIONS //
		
		setLayout(new BorderLayout());
		add(servingCheck, BorderLayout.CENTER);
		setVisible(true);
		
	}
	
}
