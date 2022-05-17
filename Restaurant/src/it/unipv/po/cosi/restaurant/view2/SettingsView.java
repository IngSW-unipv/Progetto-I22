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

	private JScrollPane servingScroller;
	private JScrollPane modifierScroller;
	private JScrollPane categoryScroller;
	private JScrollPane tableScroller;
	private ArrayList<TableCheckBox> tableChecks;
	private ArrayList<ServingCheckBox> servingChecks;
	private ArrayList<ModifierCheckBox> modifierChecks;
	private ArrayList<CategoryCheckBox> categoryChecks;
	private JPanel servingPane;
	private JPanel categoryPane;
	private JPanel modifierPane;
	private JPanel tablePane;
	private JPanel mainPane;
	private JPanel controlPane;
	private JButton backButton;
	private JButton confirmButton;
	private JTextField titleText;
	
	public SettingsView(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables) throws HeadlessException {
		super();
		servingChecks = new ArrayList<ServingCheckBox>();
		tableChecks = new ArrayList<TableCheckBox>();
		modifierChecks = new ArrayList<ModifierCheckBox>();
		categoryChecks = new ArrayList<CategoryCheckBox>();
		
		
//		try {
//		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName());
//		 } catch (Exception e) {
//		            e.printStackTrace();
//		 }
		
		initComponents(servings, categories, modifiers, tables);
	}

	private void initComponents(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables) {
		
		mainPane = new JPanel();
		controlPane = new JPanel();
		backButton = new JButton("Annulla");
		backButton.setFont(new java.awt.Font("Arial", 0, 30));
		backButton.setBackground(Color.RED);
		backButton.setForeground(Color.WHITE);
		confirmButton = new JButton("Conferma");
		confirmButton.setFont(new java.awt.Font("Arial", 0, 30));
		confirmButton.setBackground(Color.GREEN);
		titleText = new JTextField("                              MODIFICA IL TUO RISTORANTE");
		titleText.setFont(new java.awt.Font("Arial", 0, 30));
		servingPane = new JPanel(new GridLayout(servings.size(), 1));
		modifierPane =  new JPanel(new GridLayout(modifiers.size(), 1));
		categoryPane = new JPanel(new GridLayout(categories.size(), 1));
		tablePane = new JPanel(new GridLayout(tables.size(), 1));
		servingScroller = new JScrollPane();
		
//		servingCheck	

		for (Serving serving : servings) {
			
			ServingCheckBox a = new ServingCheckBox(serving.getName(),serving);
			a.setFont(new java.awt.Font("Arial", 0, 24));
			a.setSelected(serving.isActiveFlag());
			servingPane.add(a);
			servingChecks.add(a);
		}

//		tableCheck
		
		for (Table table : tables) {
			
			TableCheckBox a = new TableCheckBox(Integer.toString(table.getNumber()) ,table);
			a.setFont(new java.awt.Font("Arial", 0, 24));
			a.setSelected(table.isActiveFlag());
			tablePane.add(a);
			tableChecks.add(a);
		}
		
//		categoryCheck
		
		for (Category category : categories) {
			
			CategoryCheckBox a = new CategoryCheckBox(category.getName(),category);
			a.setFont(new java.awt.Font("Arial", 0, 24));
			a.setSelected(category.isActiveFlag());
			categoryPane.add(a);
			categoryChecks.add(a);
		}
		
//		modifierCheck
		
		for (Modifier modifier : modifiers) {
			
			ModifierCheckBox a = new ModifierCheckBox(modifier.getName(),modifier);
			a.setFont(new java.awt.Font("Arial", 0, 24));
			a.setSelected(modifier.isActiveFlag());
			modifierPane.add(a);
			modifierChecks.add(a);
		}
		
		servingScroller = new JScrollPane(servingPane);
		modifierScroller = new JScrollPane(modifierPane);
		categoryScroller = new JScrollPane(categoryPane);
		tableScroller = new JScrollPane(tablePane);
		
		servingScroller.setHorizontalScrollBar(null);
		
		// THIS PANE OPTIONS //
		
		setLayout(new BorderLayout());
		mainPane.setLayout(new GridLayout(1,4));
		mainPane.add(categoryScroller);
		mainPane.add(servingScroller);
		mainPane.add(modifierScroller);
		mainPane.add(tableScroller);
		add(mainPane, BorderLayout.CENTER);
		add(controlPane, BorderLayout.NORTH);
		controlPane.setLayout(new BorderLayout());
		controlPane.add(backButton, BorderLayout.WEST);
		controlPane.add(titleText, BorderLayout.CENTER);
		controlPane.add(confirmButton, BorderLayout.EAST);
		
	}

	public ArrayList<TableCheckBox> getTableChecks() {
		return tableChecks;
	}

	public ArrayList<ServingCheckBox> getServingChecks() {
		return servingChecks;
	}

	public ArrayList<ModifierCheckBox> getModifierChecks() {
		return modifierChecks;
	}

	public ArrayList<CategoryCheckBox> getCategoryChecks() {
		return categoryChecks;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}
	
	
	
}
