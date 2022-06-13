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
 * @author      cos�
 * @version     1.0                 (current version number of program)
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return monitors text text text.
	 */
	public ArrayList<Monitor> getMonitor() {
		return monitors;
	}


	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 */
	public void setMonitors(ArrayList<Monitor> monitors) {
		this.monitors = monitors;
	}


	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return backButton text text text.
	 */
	public JButton getBackButton() {
		return backButton;
	}
	
}