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

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class CategoryDAO implements IDao{	
	
	private Connection c;

	public CategoryDAO() {
		
	}
	
	
	public void initialize() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		try {
			String path = "src/it/unipv/po/cosi/restaurant/database/config/categories.csv";
			String absolutePath;
			
		  	path = CheckConfigFile.pathFinder(path, pathDoc, "Category");
			File f = new File(path);
			absolutePath = f.getAbsolutePath();
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);

			
			Statement st1;
			ResultSet rs1, rs_num;
			String line = br.readLine();
			
			st1 = c.createStatement(); 
			rs_num = st1.executeQuery("select count(*) from restaurant.category");
			rs_num.next();
			int totcat = rs_num.getInt(1);
			String[] categories = new String[totcat];
			rs1 = st1.executeQuery("select * from restaurant.category");
			boolean aflag;
			boolean dbflag;
			ArrayList<String> check = new ArrayList<String>();
			
			for(int i=0;i<totcat;i++) {

				rs1.next();
				categories[i] = rs1.getString(1); 

			}
			
			while(line!=null) {				

				aflag = false;
				dbflag = false;
				
				for (String string : check) {
					if(line.equals(string)) {
						aflag = true;
					}
				}
				
				for(int i=0;i<totcat;i++) {
					if(line.equals(categories[i])) {
						dbflag = true;
					}
				}
				
				if(!aflag && !dbflag) {
					
					check.add(line);
					String query = "INSERT INTO category (name) VALUE ('" + line + "');";
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
	 * @return result text text text.
	 */
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
				
				Category category = new Category(rs1.getString(1), Boolean.parseBoolean(rs1.getString(2)));
				result.add(category);
				
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
	 * @param  categories Description text text text.          (3)
	 */
	public void updateActiveCategories(ArrayList<Category> categories) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		Statement st1;
		
		try {

			st1 = c.createStatement();
			String query;
			
			for (Category category : categories) {
				
				query = "update category set active = '" + booleanToString(category.isActiveFlag()) + "' where name = '" + category.getName() + "';"; 
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
	 */
	public String booleanToString(Boolean flag) {
		
	if(flag) {
		return "true";
	}
	
	return "false";
}
}
