package it.unipv.po.cosi.restaurant.testers;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.database.DbControllerSingleton;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
public class DBTest {

	public static void main(String[] args) {
	
		DbControllerSingleton c= new DbControllerSingleton();
		
		ArrayList<Serving> arr = new ArrayList<Serving>();
		
		arr = c.selectAllServings();
		
		for (Serving serving : arr) {
			
			System.out.println(serving.getName());
		}
			

	}

}
