package it.unipv.po.cosi.restaurant.database.classDAO.daoFactory;

import java.io.FileNotFoundException;

import it.unipv.po.cosi.restaurant.exception.ExceptionFileChooser;

/**
 * Interface for the DAO Classes
 * @author 		cosi'
 * @version		iteration 3
 * @since		iteration 2
 *
 */
public interface IDao {

	/**
	 * schema represents the schema's name
	 */
	public final static String schema = "restaurant";
	
	/**
	 * method to initialize the DAO object
	 * @throws ExceptionFileChooser if file not found
	 * @throws FileNotFoundException if file not found
	 */
	public void initialize() throws ExceptionFileChooser, FileNotFoundException;
	
	/**
	 * path for configFile
	 */
	public final static String pathDoc ="src/it/unipv/po/cosi/restaurant/database/config/pathConfig.txt";
	
}
