package it.unipv.po.cosi.restaurant.database.classDAO.provaFactory;

public abstract class DAOClass implements IDao {

	public String booleanToString(Boolean flag) {
		
		if(flag) {
			return "true";
		}
		
		return "false";
	}
}
