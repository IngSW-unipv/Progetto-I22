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
import it.unipv.po.cosi.restaurant.database.classDAO.daoFactory.IDao;
import it.unipv.po.cosi.restaurant.database.config.CheckConfigFile;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;


/**
 * DAO class which manages the DB operations on table
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since 		iteration 1
 */
public class TableDAO implements IDao{

	/**
	 * connection attribute
	 */
	private Connection c;

	/**
	 * default constructor
	 */
	public TableDAO() {
		
	}
	
	/**
	 * it initializes the "table" table in the DB
	 */
	public void initialize() {

		c = DatabaseConnection.startConnection(c, schema);
		
		try {
			
			String path = "src/it/unipv/po/cosi/restaurant/database/config/tables.csv";
			String absolutePath;
			
			path = CheckConfigFile.pathFinder(path, pathDoc, "Table");
			
			File f = new File(path);
			absolutePath = f.getAbsolutePath();			
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);

			Statement st1;
			ResultSet rs1,rs_num;
			String line = br.readLine();

			st1 = c.createStatement();
			rs_num = st1.executeQuery("select count(*) from restaurant.table");
			rs_num.next();
			int tot = rs_num.getInt(1);
			int[] numbers = new int[tot];
			rs1 = st1.executeQuery("select * from restaurant.table");
			boolean aflag;
			boolean dbflag;
			ArrayList<String> check = new ArrayList<String>();
			
			for(int i=0;i<tot;i++) {

				rs1.next();
				numbers[i] = rs1.getInt(1); 

			}

			while(line!=null) {

				aflag = false;
				dbflag = false;
				
				for(String string: check) {
					if(line.equals(string)) {
						aflag = true;
					}
				}

				for(int i=0;i<tot;i++) {
					if(Integer.parseInt(line) == numbers[i]) {
						dbflag = true;
					}
				}

				if(!aflag && !dbflag) {

					check.add(line);
					String query = "INSERT INTO restaurant.table (number) VALUE ('" + line + "');";
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

	/**
	 * it returns all the tables from the DB
	 * 
	 * @return a table arraylist
	 */
	public ArrayList<Table> selectAllTable() {

		c = DatabaseConnection.startConnection(c, schema);

		ArrayList<Table> result = new ArrayList<>();
		Statement st1;
		ResultSet rs1;

		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM restaurant.table;";
			rs1 = st1.executeQuery(query);

			while(rs1.next()) {

				Table table = new Table(rs1.getInt(1), Boolean.parseBoolean(rs1.getString(2)));
				result.add(table);

			}
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		DatabaseConnection.closeConnection(c);

		return result;

	}
	
	/**
	 * it updates the activeFlag in the tables
	 * 
	 * @param tables tables arraylist parameter
	 */
	public void updateActiveTables(ArrayList<Table> tables) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		Statement st1;
		
		try {
			
			st1 = c.createStatement();
			String query;
			
			for (Table table : tables) {
				
				query = "update restaurant.table set active = '" + booleanToString(table.isActiveFlag()) + "' where number = " + table.getNumber() + ";";
				st1.executeUpdate(query);
			}
			

		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
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
