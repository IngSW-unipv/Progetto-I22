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
import it.unipv.po.cosi.restaurant.database.classDAO.provaFactory.IDao;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;

public class ServingDAO implements IDao{
	
	private Connection c;
	
	public ServingDAO() {
		
	}
		
		
	public void initialize() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		File f	 = new File("src/it/unipv/po/cosi/restaurant/database/config/servings.csv");
	  	String absolutePath = f.getAbsolutePath();
	  	
		try {
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			Statement st1, st2;
			ResultSet rs, rs1;
			String qry = "select max(id) from restaurant.serving;";
			String line=br.readLine();
			boolean flag;
			st2 = c.createStatement();
			rs = st2.executeQuery(qry);
			rs.next();
			int max = rs.getInt(1);
//			Serving.setStartingID(max);
			System.out.println("max = "+max);
			
			System.out.println("porcodio\n\n\n\n\n");
			while(line!=null) {
			
				flag = false;

				String[] entries=line.split(";");
//				System.out.println(entries[4]);
				
				for(i=1;i<=max;i++) {
					
					
					System.out.println("i ="+i);
					
					rs1 = st2.executeQuery("select name from serving where id ="+ i +";");
					rs1.next();
					
					if(entries[1].equals(rs1.getString(1))) {
						
						st2.executeUpdate("update restaurant.serving set active =" + entries[4] + " where id =" + i + ";");
						flag = true;
					}
					
				}
				
				if(!flag) {
				
//						Serving serving = new Serving(entries[1], Float.parseFloat(entries[2]), new Category(entries[3]));
						
//						menu.addServing(serving);
						
						st1 = c.createStatement();
						String query =  "INSERT INTO serving (name, price, category, active) VALUE ('"
										+ entries[1] + "','" + entries[2] 
										+ "','" + entries[3] + "','" + entries[4] +"');";
						
						st1.executeUpdate(query);
						System.out.println(query);
						
				}
				
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
	
	
	
	public ArrayList<Serving> selectAllServings(ArrayList<Category> categories) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<Serving> result = new ArrayList<>();		
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
				
				Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), cat);
				result.add(serving);
								
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return result;
		
	}

	
	
	public ArrayList<Serving> initializeActiveServings(ArrayList<Category> categories) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<Serving> rslt = new ArrayList<Serving>();
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM SERVING where active = 1";
			rs1 = st1.executeQuery(query);
			
	
			while(rs1.next()) {
				
				Category cat = null;
				
				for (Category category : categories) {
				
					if(category.getName().equals(rs1.getString(3))) {
						
						cat=category;
						
					}
					
				}
				
				Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(4), cat);
				rslt.add(serving);
								
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		return rslt;
	}
	
}

	

