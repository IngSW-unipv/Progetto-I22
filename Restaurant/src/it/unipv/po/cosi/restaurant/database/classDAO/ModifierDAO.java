package it.unipv.po.cosi.restaurant.database.classDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class ModifierDAO {

	public ModifierDAO() {}
	
	public void initializeModifiers(Connection c) {
	    
		File f = new File("src/it/unipv/po/cosi/restaurant/database/config/modifiers.csv");
		String absolutePath = f.getAbsolutePath();
		
		
		try {
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			Statement st1;
			
			String line=br.readLine();
			while(line!=null) {
			
				String[] entries=line.split(";");
				
				st1 = c.createStatement(); 
				String query = "INSERT INTO modifier (name, price, category) VALUE ('" 
								+ entries[0] + "','"  + entries[1] + "','" + entries[2]  + "');";

				st1.executeUpdate(query);
				System.out.println(query);
				line=br.readLine();
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	public ArrayList<Modifier> selectAllModifiers(Connection c, ArrayList<Category> categories) {
		
		ArrayList<Modifier> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM MODIFIER;";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Category cat = null;
				
				for (Category category : categories) {
				
					if(category.getName().equals(rs1.getString(3))) {
						
						cat=category;
						
					}
					
				}
				Modifier modifier = new Modifier(rs1.getString(1), cat, rs1.getFloat(2));
				result.add(modifier);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	
}
