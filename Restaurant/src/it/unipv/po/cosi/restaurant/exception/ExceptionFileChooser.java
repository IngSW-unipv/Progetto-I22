package it.unipv.po.cosi.restaurant.exception;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class ExceptionFileChooser extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;


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


	
	public String getPath() {
		return path;
	}
}
