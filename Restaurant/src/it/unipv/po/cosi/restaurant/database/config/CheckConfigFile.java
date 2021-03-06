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
 * This class manages configFile
 * @author      cosi'
 * @version     iteration 3
 * @since 		iteration 3
 */
public class CheckConfigFile {

	private static String path;
	
	/**
	 * Default Constructor
	 */
	public CheckConfigFile() {}
	
	/**
	 * This method tries to find the path of the document "className.csv"
	 * @param sourcePath path of the document "className.csv"
	 * @param pathDoc path of the file "pathConfig"
	 * @param className name to "match" in file "pathConfig"
	 * @return path path of the className.csv File
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
