package it.unipv.po.cosi.restaurant.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;

public class DbControllerSingleton {

	private String schema;
	private Connection c;
	
	public DbControllerSingleton() {
		super();
		this.schema = "restaurant";
		c = DatabaseConnection.startConnection(c, schema);
	}

// populate table with menu .csv file //
	
	public void initializeServings() {
		
String RelativePath	 = "";
	    
		Statement st1;
		
		try {
			st1 = c.createStatement(); 
			String query = "";
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	
	
	
//SERVING
	public ArrayList<Serving> selectAllServings() {
		
		ArrayList<Serving> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM SERVING";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), new Category(rs1.getString(4)));
				result.add(serving);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}

//ORDER
	public ArrayList<Order> selectAllOrders() {
		
		ArrayList<Order> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM ORDERING";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Order order = new Order(new Table(rs1.getInt(2)), rs1.getInt(1));
				
				Statement st2 = c.createStatement();
				query = "SELECT S.* FROM"
				+ "NATURAL JOIN (SELECT ID AS SERVING, NAME, PRICE, CATEGORY FROM RESTAURANTS.SERVING)S"
				+ "NATURAL JOIN (SELECT ID AS 'ORDERING', RESTAURANT.ORDERING.TABLE, TOTAL FROM RESTAURANT.ORDERING WHERE ID = "
				+ order.getId();
				ResultSet rs2 = st2.executeQuery(query);
				
				while(rs2.next()) {
					
					Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), new Category(rs1.getString(4)));
					order.addServing(serving);
				
				}
				
				result.add(order);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
	public void insertOrder(Order order) {
		
		Statement st1;
		
		try {
			st1 = c.createStatement();
			String query = "INSERT INTO RESTAURANT.ORDERING VALUES (" + order.getId() + "," + order.getTable().getNumber() + "," + order.getSubtotal() + ");";
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
		
	}
	
	public Order selectOrder(int id) {
		
		Order result = new Order(id);
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT S.* FROM"
					+ "NATURAL JOIN (SELECT ID AS SERVING, NAME, PRICE, CATEGORY FROM RESTAURANTS.SERVING)S"
					+ "NATURAL JOIN (SELECT ID AS 'ORDERING', RESTAURANT.ORDERING.TABLE, TOTAL FROM RESTAURANT.ORDERING WHERE ID = "
					+ id;
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Serving serving = new Serving(rs1.getInt(1), rs1.getString(2), rs1.getFloat(3), new Category(rs1.getString(4)));
				result.addServing(serving);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}

//MODIFIER
	public ArrayList<Modifier> selectAllModifiers() {
		
		ArrayList<Modifier> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM MODIFIER;";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Modifier modifier = new Modifier(rs1.getString(1), new Category(rs1.getString(3)), rs1.getFloat(2));
				result.add(modifier);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}
	
//CATEGORY
	public ArrayList<Category> selectAllCategories() {
		
		ArrayList<Category> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM CATEGORY;";
			rs1 = st1.executeQuery(query);
	
			while(rs1.next()) {
				
				Category category = new Category(rs1.getString(1));
				result.add(category);
				
			}
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return result;
		
	}

//TABLE
	public ArrayList<Table> selectAllTable() {
		
		ArrayList<Table> result = new ArrayList<>();
		
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			String query = "SELECT * FROM TABLE;";
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
	
	public boolean closeConnection() {
		
		return DatabaseConnection.closeConnection(c);	
		
	}
	
}
