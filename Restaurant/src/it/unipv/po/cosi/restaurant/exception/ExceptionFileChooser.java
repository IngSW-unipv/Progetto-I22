package it.unipv.po.cosi.restaurant.exception;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


/**
 * This class represents a customized exception.  Creates a new JFileChooser to handle "file not found exception"
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 3
 */
public class ExceptionFileChooser extends Exception {


	private static final long serialVersionUID = 1L;
	/**
	 * string into which is saved the instance variable path
	 */
	private String path;


	/**
	 * This method creates a new JFileChooser to handle "file not found exception"
	 * @param  s missing file's name
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
	 * method used to get path
	 * @return path string that represent the path chosen from the JFileChooser
	 */
	public String getPath() {
		return path;
	}
}
