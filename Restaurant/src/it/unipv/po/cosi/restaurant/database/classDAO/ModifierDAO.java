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
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;


/**
 * @author      cosi'
 * @version     1.0                 (current version number of program)
 */
public class ModifierDAO implements IDao{
	
	private Connection c;

	public ModifierDAO() {
		
	}
	
	public void initialize() {
	    
		c = DatabaseConnection.startConnection(c, schema);
		
try {
			
			String path = "src/it/unipv/po/cosi/restaurant/database/config/modifiers.csv";
			String absolutePath;
			
			
		  	path = CheckConfigFile.pathFinder(path, pathDoc, "Modifier");
			
			File f = new File(path);
			absolutePath = f.getAbsolutePath();
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			Statement st1;
			ResultSet rs1;	
			st1 = c.createStatement(); 
			rs1 = st1.executeQuery("select count(*) from modifier");
			rs1.next();
			int nummod = rs1.getInt(1);
			String line=br.readLine();
			rs1 = st1.executeQuery("select name from restaurant.modifier");
			String[] mod = new String[nummod];
			boolean aflag;
			boolean dbflag;
			ArrayList<String> check = new ArrayList<String>();
			
			for(int i=0; i<nummod; i++) {
				rs1.next();
				mod[i] = rs1.getString(1); 
			}
			
			while(line!=null) {
			
				aflag = false;
				dbflag = false;
				
				String[] entries=line.split(";");
				
				for (String string : check) {
					if(entries[0].equals(string)) {
						aflag = true;
					}
				}
				
				for(int i=0;i<nummod;i++) {
					if(entries[0].equals(mod[i])) {
						dbflag = true;
					}
				}
				
				if(!aflag && !dbflag) {
					
					check.add(entries[0]);
					String query = "INSERT INTO modifier (name, price, category) VALUE ('" 
							+ entries[0] + "','"  + entries[1] + "','" + entries[2]  + "');";					
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
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  categories Description text text text.          (3)
	 * @return result text text text.
	 */
	public ArrayList<Modifier> selectAllModifiers(ArrayList<Category> categories) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
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
				Modifier modifier = new Modifier(rs1.getString(1), cat, rs1.getFloat(2), Boolean.parseBoolean(rs1.getString(4)));
				result.add(modifier);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return result;
		
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  modifiers Description text text text.          (3)
	 */
	public void updateActiveModifiers(ArrayList<Modifier> modifiers) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		Statement st1;
		
		try {

			st1 = c.createStatement();
			String query;
			
			for (Modifier modifier : modifiers) {
				
				query = "update modifier set active = '" + booleanToString(modifier.isActiveFlag()) + "' where name = '" + modifier.getName() + "';"; 
				st1.executeUpdate(query);	
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  flag Description text text text.          (3)
	 * @return Description text text text.
	 */
	public String booleanToString(Boolean flag) {
	
	if(flag) {
		return "true";
	}
	
	return "false";
}
	
}
