package it.unipv.po.cosi.restaurant.database.classDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifierDAO {

	public ModifierDAO() {}
	
	public void initializeModifiers(Connection c) {
	    
		File f = new File("src/it/unipv/po/cosi/restaurant/database/config/modifiers.csv");
		String absolutePath = f.getAbsolutePath();
		
		
		try {
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			Statement st1;
			
			String line="";
			while(line!=null) {
			
				line=br.readLine();
				String[] entries=line.split(";");
				
				st1 = c.createStatement(); 
				String query = "INSERT INTO category (name, price, category) VALUE ('" + entries[0] + "','"  + entries[1] + "','" + entries[2]  + "');";
				//st1.executeUpdate(query);
				
				System.out.println(query);
				
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

//		System.out.println(absolutePath);
//		System.out.println(f.exists());
//		System.out.println(f.isFile());
//
//		Statement st1;
//					
//		try {
//			st1 = c.createStatement(); 
//			String query = "LOAD DATA LOCAL INFILE ' " + absolutePath + " '"
//					+ " into table category "
//					+ "CHARACTER SET UTF8MB4 "
//					+ "FIELDS TERMINATED BY ';' "
//					+ "ENCLOSED BY '\"'"
//					+ "LINES TERMINATED BY '\n';";
//			st1.executeQuery(query);
//		}
//
//		catch (Exception e) {
//	
//			e.printStackTrace();
//	
//		}
	}
	
}
