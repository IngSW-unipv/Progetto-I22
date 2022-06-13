package it.unipv.po.cosi.restaurant.exception;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class ExceptionFileChooser extends Exception {


	private static final long serialVersionUID = 1L;
	private String path;


	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  s Description text text text.          (3)
	 */
	public ExceptionFileChooser (String s) {
			
		
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Seleziona il file " + s);
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("csv Docs", "csv");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			this.path = jfc.getSelectedFile().getPath();
			System.out.println(path);
		}
		
	}	


	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param path Description text text text.          (3)
	 */
	public String getPath() {
		return path;
	}
}
