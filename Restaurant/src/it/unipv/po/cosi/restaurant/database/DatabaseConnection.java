package it.unipv.po.cosi.restaurant.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author      così
 * @version     1.0                 (current version number of program)
 */
public class DatabaseConnection {

	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 * @return c text text text.
	 */
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
	
	/**
	 * Short one line description.                           (1)
	 * <p>
	 * Longer description. If there were any, it would be    (2)
	 * here.
	 * <p>
	 * And even more explanations to follow in consecutive
	 * paragraphs separated by HTML paragraph breaks.
	 *
	 * @param  c Description text text text.          (3)
	 * @return Description text text text.
	 */
	public static boolean isOpen(Connection c) {
		if( c == null) {
			return false;
		}
		return true;
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
	 * @param  c Description text text text.          (3)
	 * @return Description text text text.
	 */
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

