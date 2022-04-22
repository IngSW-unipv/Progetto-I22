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

import it.unipv.po.cosi.restaurant.model.menuModel.MenuSingleton;
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
			MenuSingleton menu = MenuSingleton.getInstance();
			int i = 0;
			Statement st1, st2;
			ResultSet rs;
			String qry = "select max(id) from restaurant.serving;";
			String line=br.readLine();
			
			
			st2 = c.createStatement();
			rs = st2.executeQuery(qry);
			
			rs.next();
			Serving.setStartingID(rs.getInt(1));
			
//			st2.executeUpdate("update restaurant.serving set active = 0 where id;");
			
			st2.addBatch("ALTER TABLE `restaurant`.`serving` "
						+ "DROP FOREIGN KEY `FK3`;");
			st2.addBatch("ALTER TABLE `restaurant`.`order_serving` "
					+ "DROP FOREIGN KEY `FK5`;");
			
			st2.addBatch("TRUNCATE `restaurant`.`serving`;"); // TRUNCATE TABLE
			
			st2.addBatch("ALTER TABLE `restaurant`.`serving` "
						+ "ADD CONSTRAINT `FK3` "
						+ "FOREIGN KEY (`category`) "
						+ "REFERENCES `restaurant`.`category` (`name`);");
			st2.addBatch("ALTER TABLE `restaurant`.`order_serving` "
					+ "ADD CONSTRAINT `FK5` "
					+ "FOREIGN KEY (`serving`) "
					+ "REFERENCES `restaurant`.`serving` (`ID`);");
			st2.executeBatch();

			
			while(line!=null) {
			
				
				String[] entries=line.split(";");
				
				
//				for(i=0;i<rs.getInt(1);i++) {
//					
//					if(entries[1].equals(st2.executeQuery("select name from serving where id ="+ i +";").getString(1))) {
//						
//						st2.executeUpdate("update restaurant.serving set active = 1 where id =" + i + ";");
//						
//					}
//					else {
//						
//						
//						
//					}
//				
//				}
				
				Serving serving = new Serving(entries[1], Float.parseFloat(entries[2]), new Category(entries[3]));
				
				menu.addServing(serving);
				
				st1 = c.createStatement();
				String query =  "INSERT INTO serving (id, name, price, category) VALUE ('"
								+ serving.getId() + "','"  + serving.getName() + "','" + serving.getPrice() 
								+ "','" + serving.getCategory().getName()  + "');";
				
				st1.executeUpdate(query);
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
		ArrayList<Category> categories = new ArrayList<Category>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM SERVING";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Category cat = null;
				
				for (Category category : categories) {
				
					if(category.getName().equals(rs1.getString(3))) {
						
						cat=category;
						
					}
					
				}
				
				Serving serving = new Serving(rs1.getString(1), rs1.getFloat(2), cat);
				result.add(serving);
								
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}


	
}
