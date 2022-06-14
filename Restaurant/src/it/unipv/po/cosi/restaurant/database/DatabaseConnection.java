package it.unipv.po.cosi.restaurant.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author      cosi'
 * @version     iteration 1
 */
public class DatabaseConnection {

	public static Connection startConnection( Connection c, String schema ) {
		String DbDriver = null;
		String DbURL = null;
		String usr = null;
		String password = null;
		
		DbDriver = "com.mysql.cj.jdbc.Driver";
		DbURL = "jdbc:mysql://localhost:3306/" + schema + "?--local_infile=1**";
		usr = "root";
		password = "0123";
		
	
		if(isOpen(c)) {
			closeConnection(c);
		}
		try
		{
			Class.forName(DbDriver);
			c = DriverManager.getConnection(DbURL, usr, password);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		return c;
	
	}
	
	public static boolean isOpen(Connection c) {
		if( c == null) {
			return false;
		}
		return true;
	}
	
	public static boolean closeConnection(Connection c) {
		if(!isOpen(c)) {
			return false;
		}
		
		try 
		{
			c.close();
			c = null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
			
		}
		
		return true;
	}	
	
}

