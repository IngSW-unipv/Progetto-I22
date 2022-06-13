package it.unipv.po.cosi.restaurant.view;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 * @author      cosi'
 * @version     iterazione 2
 */
public class SettingsView extends JPanel {

	private static final long serialVersionUID = 1L;
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
		
		initComponents(servings, categories, modifiers, tables);
	}

	private void initComponents(ArrayList<Serving> servings, ArrayList<Category> categories, ArrayList<Modifier> modifiers, ArrayList<Table> tables) {
		
		mainPane = new JPanel();
		controlPane = new JPanel();
		backButton = new JButton("Annulla");
		backButton.setFont(new java.awt.Font("Arial", 0, 30));
		backButton.setBackground(Color.decode("#D00000"));
		backButton.setForeground(Color.WHITE);
		confirmButton = new JButton("Conferma");
		confirmButton.setFont(new java.awt.Font("Arial", 0, 30));
		confirmButton.setBackground(Color.GREEN);
		titleText = new JTextField("                              MODIFICA IL TUO RISTORANTE");
		titleText.setFont(new java.awt.Font("Arial", 0, 30));
		servingPane = new JPanel(new GridLayout(servings.size(), 1, 0, 30));
		modifierPane =  new JPanel(new GridLayout(modifiers.size(), 1, 0, 30));
		categoryPane = new JPanel(new GridLayout(categories.size(), 1, 0, 30));
		tablePane = new JPanel(new GridLayout(tables.size(), 1, 0, 30));
		servingScroller = new JScrollPane();
		
		
//		servingCheck	

		for (Serving serving : servings) {
			
			ServingCheckBox a = new ServingCheckBox(serving.getName(),serving);
			a.setFont(new java.awt.Font("Arial", 0, 28));
			a.setSelected(serving.isActiveFlag());
			servingPane.add(a);
			servingChecks.add(a);
		}

//		tableCheck
		
		for (Table table : tables) {
			
			TableCheckBox a = new TableCheckBox(Integer.toString(table.getNumber()) ,table);
			a.setFont(new java.awt.Font("Arial", 0, 28));
			a.setSelected(table.isActiveFlag());
			tablePane.add(a);
			tableChecks.add(a);
		}
		
//		categoryCheck
		
		for (Category category : categories) {
			
			CategoryCheckBox a = new CategoryCheckBox(category.getName(),category);
			a.setFont(new java.awt.Font("Arial", 0, 28));
			a.setSelected(category.isActiveFlag());
			categoryPane.add(a);
			categoryChecks.add(a);
		}
		
//		modifierCheck
		
		for (Modifier modifier : modifiers) {
			
			ModifierCheckBox a = new ModifierCheckBox(modifier.getName(),modifier);
			a.setFont(new java.awt.Font("Arial", 0, 28));
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

	/**
	 * getter for the table checks
	 * @return  ArrayList of tableChecks 
	 */
	public ArrayList<TableCheckBox> getTableChecks() {
		return tableChecks;
	}

	/**
	 * getter for the ServingChecks
	 * @return ArrayList of servingChecks 
	 */
	public ArrayList<ServingCheckBox> getServingChecks() {
		return servingChecks;
	}

	/**
	 * getter for the Modifier
	 * @return Array list of modifierChecks 
	 */
	public ArrayList<ModifierCheckBox> getModifierChecks() {
		return modifierChecks;
	}

	/**

	 * @return categoryChecks 
	 */
	public ArrayList<CategoryCheckBox> getCategoryChecks() {
		return categoryChecks;
	}

	/**
	 * @return backButton 
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * @return confirmButton 
	 */
	public JButton getConfirmButton() {
		return confirmButton;
	}
	
}