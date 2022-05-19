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
	
	public ArrayList<ArrayList<String>> selectAllOrders() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<ArrayList<String>> rslt = new ArrayList<>();

		
		ArrayList<String> idArray = new ArrayList<>();
		ArrayList<String> nameArray = new ArrayList<>();
		ArrayList<String> totalArray = new ArrayList<>();
		ArrayList<String> Array = new ArrayList<>();
//		ArrayList<String> idArray = new ArrayList<>();

		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * "
					+ "(SELECT ordering AS id, serving FROM order_serving) A "
					+ "NATURAL JOIN "
					+ "(SELECT * FROM restaurant.ordering) B "
					+ "NATURAL JOIN "
					+ "(SELECT id as serving, name  from serving) C";
			rs1 = st1.executeQuery(query);
	
			
			
			while(rs1.next()) {
				
				
				
				
			}
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
