package it.unipv.po.cosi.restaurant.database.classDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import it.unipv.po.cosi.restaurant.database.DatabaseConnection;
import it.unipv.po.cosi.restaurant.database.classDAO.daoFactory.IDao;
import it.unipv.po.cosi.restaurant.database.config.CheckConfigFile;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;


/**
 * DAO class which manages the DB operations on modifier
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since 		iteration 1
 */
public class ServingDAO implements IDao{
	
	/**
	 * connection attribute
	 */
	private Connection c;
	
	/**
	 * default constructor
	 */
	public ServingDAO() {
		
	}
		
	/**
	 * it initializes the modifier table in the DB
	 */
	public void initialize() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		try {
			
			String path = "src/it/unipv/po/cosi/restaurant/database/config/servings.csv";
		  	String absolutePath;
		  	
			
		  	path = CheckConfigFile.pathFinder(path, pathDoc, "Serving");
			File f = new File(path); 
			absolutePath = f.getAbsolutePath();
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			int i = 0;
			Statement st1, st2;
			ResultSet rs, rs1;
			String qry = "select max(id) from restaurant.serving;";
			String line=br.readLine();
			boolean aflag;
			boolean dbflag;
			st2 = c.createStatement();
			rs = st2.executeQuery(qry);
			rs.next();
			int max = rs.getInt(1);
			ArrayList<String> check = new ArrayList<String>();
			
			while(line!=null) {
			
				aflag = false;
				dbflag = false;
				
				String[] entries=line.split(";");

				for (String string : check) {
					if(entries[0].equals(string)) {
						aflag = true;
					}
				}
				
				
				for(i=1;i<=max;i++) {
										
					rs1 = st2.executeQuery("select name from serving where id ="+ i +";");
					rs1.next();
					
					if(entries[0].equals(rs1.getString(1))) {
						dbflag = true;
					}
					
				}
				
				if(!aflag && !dbflag) {
					
						check.add(entries[0]);
						st1 = c.createStatement();
						String query =  "INSERT INTO serving (name, price, category) VALUE ('"
										+ entries[0] + "','" + entries[1] 
										+ "','" + entries[2] + "');";
						
						st1.executeUpdate(query);
						System.out.println(query);
						
				}
				
				line=br.readLine();
			}
		
			br.close();
			fr.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		DatabaseConnection.closeConnection(c);
	}
	
	/**
	 * it updates the activeFlag in the servings
	 * 
	 * @param servings servings arraylist parameter
	 */
	public void updateActiveServings(ArrayList<Serving> servings) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		Statement st1;
		
		try {

			st1 = c.createStatement();
			String query;
			
			for (Serving serving : servings) {
				
				query = "update serving set active = '" + booleanToString(serving.isActiveFlag()) + "' where id = " + serving.getId() + ";";
				st1.executeUpdate(query);	
				
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * it returns all the servings from the DB
	 * 
	 * @param categories category arraylist parameter
	 * @return returns all the servings in an arraylist
	 */
	public ArrayList<Serving> selectAllServings(ArrayList<Category> categories) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<Serving> result = new ArrayList<>();		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM serving";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Category cat = null;
				
				for (Category category : categories) {
				
					if(category.getName().equals(rs1.getString(3))) {
						
						cat=category;
						
					}
				}
				
				Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(4), cat, Boolean.parseBoolean(rs1.getString(5)));
				result.add(serving);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return result;
		
	}

	/**
	 * it converts the boolean flag parameter into a string with the same meaning ("true" or "false")
	 * 
	 * @param flag flag parameter
	 * @return string with the same meaning of the parameter flag
	 */
	public String booleanToString(Boolean flag) {
		
	if(flag) {
		return "true";
	}
	
	return "false";
}

}

	

