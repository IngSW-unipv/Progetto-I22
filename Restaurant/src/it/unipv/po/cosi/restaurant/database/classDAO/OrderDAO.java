package it.unipv.po.cosi.restaurant.database.classDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import it.unipv.po.cosi.restaurant.database.DatabaseConnection;
import it.unipv.po.cosi.restaurant.database.classDAO.provaFactory.DAOClass;
import it.unipv.po.cosi.restaurant.database.classDAO.provaFactory.IDao;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import java.sql.Connection;

public class OrderDAO extends DAOClass implements IDao{
	
	private Connection c;

	public OrderDAO() {
		
	}
	
	public void initialize() {
		Order.setStartingId(this.getMaxId());
	}
	
	public ArrayList<String[]> selectAllOrders() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<String[]> rslt = new ArrayList<>();

		
		String idArray[] = new String[50];
		String servingNameArray[] = new String[50];
		String totalArray[] = new String[50];
		String dateArray[] = new String[50];
//		
//		ArrayList<String> servingNameArray = new ArrayList<>();
//		ArrayList<String> totalArray = new ArrayList<>();
//		ArrayList<String> dateArray = new ArrayList<>();

		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			
			String query = "SELECT id, name as Piatto, total as Totale, time_date as Data FROM "
					+ "(SELECT ordering AS id, serving FROM order_serving) A "
					+ "NATURAL JOIN "
					+ "(SELECT * FROM restaurant.ordering) B "
					+ "NATURAL JOIN "
					+ "(SELECT id as serving, name  from serving) C";
			
			rs1 = st1.executeQuery(query);
	
//			while(rs1.next()) {
				
//				System.out.println(rs1.getString(1));
//				System.out.println(rs1.getString(2));
//				System.out.println(rs1.getString(3));
//				System.out.println(rs1.getString(4));
			
				idArray[0] = "ID ORDINE";
				servingNameArray[0] = "PIATTO";
				totalArray[0] = "TOTALE";
				dateArray[0] = "DATA E ORA";
				
//				idArray[2] = "";
//				servingNameArray[2] = "";
//				totalArray[2] = "";
//				dateArray[2] = "";
			
				for(int i = 1;rs1.next();i++ ) {
					
					idArray[i] = rs1.getString(1);
					servingNameArray[i] = rs1.getString(2);
					totalArray[i] = rs1.getString(3)+" €";
					dateArray[i] = rs1.getString(4);
					
					System.out.println(idArray[i]);
					System.out.println(servingNameArray[i]);
					System.out.println(totalArray[i]);
					System.out.println(dateArray[i]);
					
//					idArray.add(rs1.getString(1));
//					servingNameArray.add(rs1.getString(2));
//					totalArray.add(rs1.getString(3));
//					dateArray.add(rs1.getString(4));
					
//				}
			}
			
			rslt.add(idArray);
			rslt.add(servingNameArray);
			rslt.add(totalArray);
			rslt.add(dateArray);
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return rslt;
		
		
	}
	
	public void insertOrder(Order order) {
		
		c = DatabaseConnection.startConnection(c, schema);
		Statement st1;

		try {
			st1 = c.createStatement();
			String query = "INSERT INTO RESTAURANT.ORDERING VALUES (" + order.getId() + "," + order.getTable().getNumber() + "," + order.getSubtotal() + ",'" + order.getDateTime() + "');";
			st1.executeUpdate(query);
			
			for (Serving serving : order.getServings()) {
				
				st1 = c.createStatement();
				st1.addBatch("ALTER TABLE `restaurant`.`order_serving` "
						+ "DROP FOREIGN KEY `FK4`;");
				st1.addBatch("ALTER TABLE `restaurant`.`order_serving` "
						+ "DROP FOREIGN KEY `FK5`;");
				st1.addBatch("INSERT INTO order_serving (ordering, serving) VALUES (" + order.getId() + "," + serving.getId() + " );");
				st1.addBatch("ALTER TABLE `restaurant`.`order_serving` "
						+ "ADD CONSTRAINT `FK4` "
						+ "FOREIGN KEY (`ordering`) "
						+ "REFERENCES `restaurant`.`ordering` (`ID`);");
				st1.addBatch("ALTER TABLE `restaurant`.`order_serving` "
						+ "ADD CONSTRAINT `FK5` "
						+ "FOREIGN KEY (`serving`) "
						+ "REFERENCES `restaurant`.`serving` (`ID`);");
				st1.executeBatch();
	
			}
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
	}
	
	public Order selectOrder(int id, ArrayList<Category> categories) {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		Order result = new Order(id);
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT S.* FROM"
					+ "NATURAL JOIN (SELECT ID AS SERVING, NAME, PRICE, CATEGORY FROM RESTAURANTS.SERVING)S"
					+ "NATURAL JOIN (SELECT ID AS 'ORDERING', RESTAURANT.ORDERING.TABLE, TOTAL FROM RESTAURANT.ORDERING WHERE ID = "
					+ id +");";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Category cat = null;
				
				for (Category category : categories) {
				
					if(category.getName().equals(rs1.getString(3))) {
						
						cat=category;
						
					}
					
				}
				
				Serving serving = new Serving(rs1.getInt(1),rs1.getString(2) , rs1.getFloat(3), cat, rs1.getBoolean(4));
				result.addServing(serving);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return result;
		
	}
	
	public int getMaxId() {
		
		c = DatabaseConnection.startConnection(c, schema);
		Statement st1;
		ResultSet rs;
		
		try {
			
			st1 = c.createStatement();
			String qry = "select max(id) from restaurant.ordering";
			rs = st1.executeQuery(qry);
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
