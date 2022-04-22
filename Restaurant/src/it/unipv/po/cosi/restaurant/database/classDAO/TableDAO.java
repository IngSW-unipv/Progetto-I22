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

import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class TableDAO {
	
	public TableDAO() {}

	public void initializeTables(Connection c) {
		
		File f = new File("src/it/unipv/po/cosi/restaurant/database/config/tables.csv");		
		String absolutePath = f.getAbsolutePath();


		try {
			FileReader fr = new FileReader(absolutePath);
			BufferedReader br = new BufferedReader(fr);
			
			Statement st1;
			String line = br.readLine();
			while(line!=null) {
				
				st1 = c.createStatement();
				String query = "INSERT INTO restaurant.table (number) VALUE ('" + line + "');";
				st1.executeUpdate(query);
				System.out.println();
				
				System.out.println(query);
				line=br.readLine();
				
				
			}
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}	
	
	public ArrayList<Table> selectAllTable(Connection c) {
		
		ArrayList<Table> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM RESTAURANT.TABLE;";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Table table = new Table(rs1.getInt(1));
				result.add(table);
				
			}
		}
		
		catch (Exception e) {
		
			e.printStackTrace();
		
		}
		
		return result;
		
	}
	
	
}
