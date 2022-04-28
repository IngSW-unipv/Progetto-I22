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

import it.unipv.po.cosi.restaurant.database.DatabaseConnection;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;

public class CategoryDAO {	
	
	private String schema;
	private Connection c;

	public CategoryDAO() {
		this.schema = "restaurant";
	}
	
	
	public void initializeCategories() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		File f = new File("src/it/unipv/po/cosi/restaurant/database/config/categories.csv");
		String absolutePath = f.getAbsolutePath();
		
		try {
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			Statement st1;

			String line = br.readLine();
			while(line!=null) {				

				st1 = c.createStatement(); 
				String query = "INSERT INTO category (name) VALUE ('" + line + "');";
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
		
		DatabaseConnection.closeConnection(c);

	}
	
	public ArrayList<Category> selectAllCategories() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<Category> result = new ArrayList<>();
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM CATEGORY;";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Category category = new Category(rs1.getString(1));
				result.add(category);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return result;
		
	}

	
	
}
