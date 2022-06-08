package it.unipv.po.cosi.restaurant.database.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import it.unipv.po.cosi.restaurant.exception.ExceptionFileChooser;

public class CheckConfigFile {

	private static String path;
	
	public static String pathFinder(String sourcePath, String pathDoc, String className) {
		
//		String path ="";
		File f = new File(sourcePath);
		File finocchio = new File(pathDoc);
		
		System.out.println(finocchio.isFile() + "\n" +  finocchio.canWrite() +"\n\n\n\n\n\n\n\n");
		
		
		if(f.exists()) {
			path = f.getAbsolutePath();
			return path;
			//vuol dire che il path passato corrisponde a qualcosa di esistente e corretto
		}
		


			Properties p = new Properties(System.getProperties());
			try {
				p.load(new FileInputStream(pathDoc));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			path = p.getProperty(className);
			System.out.println("Paullastro 23" + path);
			
			f = new File(path);
			
			if(f.exists()) {
				path = f.getAbsolutePath();
				return path;
			}
			
			
			try {
				throw new ExceptionFileChooser(className);
			} catch (ExceptionFileChooser e) {
				// il path viene preso dal file chooser e messo nel file di proprietà e viene aperto il file corrispondente al path prelevato da filechooser
				path = e.getPath();
				System.out.println("Salsicce con la cocaina" + path);
				p.setProperty(className, path);
				try {
					p.store(new FileOutputStream(pathDoc, false), null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//p.put(className, path);
				return path;
			}

	}
}
