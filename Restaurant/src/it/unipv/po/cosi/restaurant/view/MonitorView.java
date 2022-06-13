package it.unipv.po.cosi.restaurant.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;


/**
 * @author      cosi'
 * @version     iterazione 3
 * @since 		iterazione 3
 */
public class MonitorView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;
	private ArrayList<Monitor> monitors;
	private JButton backButton;
	
	
	public MonitorView(ArrayList<Category> c) {
		
		this.setLayout(new BorderLayout());

		mainPanel = new JPanel();
		monitors = new ArrayList<Monitor>();
		backButton = new JButton("Indietro");
		backButton.setFont(new java.awt.Font("Arial", 0, 36));
		
		this.add(backButton, BorderLayout.NORTH);
		
		
		for (Category category : c) {
			
			if(category.isActiveFlag())
			{

				JTextArea display = new JTextArea(category.getName());
				display.setFont(new java.awt.Font("Arial", 1, 24));
				display.setBackground(Color.BLACK);
				display.setForeground(Color.GREEN);
				display.setEditable(false);
				Monitor m = new Monitor(category.getName(), display);
				mainPanel.setLayout(new GridLayout());
				mainPanel.add(display);
				mainPanel.setVisible(true);
				monitors.add(m);
			}
			
		}
		
		this.add(mainPanel, BorderLayout.CENTER);
		
	}

	/**
	 * @return monitors 
	 */
	public ArrayList<Monitor> getMonitor() {
		return monitors;
	}


	/**
	 * 
	 */
	public void setMonitors(ArrayList<Monitor> monitors) {
		this.monitors = monitors;
	}


	/**
	 * @return backButton 
	 */
	public JButton getBackButton() {
		return backButton;
	}
	
}