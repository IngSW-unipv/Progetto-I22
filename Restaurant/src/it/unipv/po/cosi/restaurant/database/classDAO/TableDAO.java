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
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class TableDAO implements IDao{

	private Connection c;

	public TableDAO() {
		
	}

	public void initialize() {

		c = DatabaseConnection.startConnection(c, schema);
		File f = new File("src/it/unipv/po/cosi/restaurant/database/config/tables.csv");		
		String absolutePath = f.getAbsolutePath();


		try {
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		DatabaseConnection.closeConnection(c);
	}	

	public ArrayList<Table> selectAllTable() {

		c = DatabaseConnection.startConnection(c, schema);

		ArrayList<Table> result = new ArrayList<>();
		Statement st1;
		ResultSet rs1;

		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM RESTAURANT.TABLE;";
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
}
