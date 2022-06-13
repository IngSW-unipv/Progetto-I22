package it.unipv.po.cosi.restaurant.database.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import it.unipv.po.cosi.restaurant.exception.ExceptionFileChooser;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class CheckConfigFile {

	private static String path;
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return path text text text.
	 */
	public static String pathFinder(String sourcePath, String pathDoc, String className) {
		

		File f = new File(sourcePath);
		
		if(f.exists()) {
			path = f.getAbsolutePath();
			return path;

		}
		

			File fc = new File(pathDoc);

			if(!fc.exists()) {
				try {
					fc.createNewFile();
					fc.setWritable(true);

					
					PrintWriter writer = new PrintWriter(pathDoc, "UTF-8");
					writer.println("Category=\"\"");
					writer.println("Modifier=\"\"");
					writer.println("Serving=\"\"");
					writer.println("Table=\"\"");
					writer.close();
	
				} catch (Exception e) {
				
					System.out.println("Errore creazione file");
				}
			}
			

			Properties p = new Properties(System.getProperties());
			try {
				p.load(new FileInputStream(pathDoc));
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
			path = p.getProperty(className);	
			f = new File(path);
			
			if(f.exists()) {
				path = f.getAbsolutePath();
				return path;
			}
			
			
			try {
				throw new ExceptionFileChooser(className);
			} catch (ExceptionFileChooser e) {
				
				path = e.getPath();
				p.setProperty(className, path);
				try {
					p.store(new FileOutputStream(pathDoc, false), null);
				} catch (FileNotFoundException e1) {
				
					e1.printStackTrace();
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
				
				return path;
			}

	}
}
