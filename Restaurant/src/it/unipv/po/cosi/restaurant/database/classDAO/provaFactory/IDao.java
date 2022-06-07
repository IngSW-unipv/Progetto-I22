package it.unipv.po.cosi.restaurant.database.classDAO.provaFactory;

import java.io.FileNotFoundException;

import it.unipv.po.cosi.restaurant.exception.ExceptionFileChooser;

public interface IDao {

	public final static String schema = "restaurant";
	public void initialize() throws ExceptionFileChooser, FileNotFoundException;
	public String booleanToString(Boolean flag);
	
}
