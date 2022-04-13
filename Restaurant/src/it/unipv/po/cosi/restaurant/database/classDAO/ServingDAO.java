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
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class ServingDAO {
	
	public ServingDAO() {}
		
		
	public void initializeServings(Connection c) {
			
		File f	 = new File("src/it/unipv/po/cosi/restaurant/database/config/servings.csv");
	  	String absolutePath = f.getAbsolutePath();

	  	
		try {
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			Statement st1;
			
			String line=br.readLine();
			while(line!=null) {
			
				
				String[] entries=line.split(";");
				
				st1 = c.createStatement();
				String query =  "INSERT INTO serving (name, price, category) VALUE ('"
								+ entries[0] + "','"  + entries[1] + "','" + entries[2]+ "','" + entries[3]  + "');";
				
//				st1.executeUpdate(query);
				System.out.println(query);
				line=br.readLine();
			}
			
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Serving> selectAllServings(Connection c) {
		
		ArrayList<Serving> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM SERVING";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), new Category(rs1.getString(4)));
				result.add(serving);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}


	
}
