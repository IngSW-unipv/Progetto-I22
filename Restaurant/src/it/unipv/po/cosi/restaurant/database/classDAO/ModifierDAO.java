package it.unipv.po.cosi.restaurant.database.classDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

public class ModifierDAO {

	public ModifierDAO() {}
	
	
	
	public void initializeModifiers(Connection c) {
		
	    
		File f = new File("src/it/unipv/po/cosi/restaurant/database/config/modifiers.csv");
		String absolutePath = f.getAbsolutePath();

		System.out.println(absolutePath);
		System.out.println(f.exists());
		System.out.println(f.isFile());

		Statement st1;
					
		try {
			st1 = c.createStatement(); 
			String query = "LOAD DATA LOCAL INFILE ' " + absolutePath + " '"
					+ " into table category "
					+ "CHARACTER SET UTF8MB4 "
					+ "FIELDS TERMINATED BY ';' "
					+ "ENCLOSED BY '\"'"
					+ "LINES TERMINATED BY '\n';";
			st1.executeQuery(query);
		}

catch (Exception e) {
	
	e.printStackTrace();
	
}
}
	
	
	
	
}
