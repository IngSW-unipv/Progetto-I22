package it.unipv.po.cosi.restaurant.database.classDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import it.unipv.po.cosi.restaurant.database.DatabaseConnection;
import it.unipv.po.cosi.restaurant.database.classDAO.daoFactory.IDao;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Category;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Modifier;
import it.unipv.po.cosi.restaurant.model.menuModel.servingModel.Serving;
import it.unipv.po.cosi.restaurant.model.orderModel.Order;
import java.sql.Connection;

/**
 * DAO class which manages the DB operations on order
 * 
 * @author      cosi'
 * @version     iteration 3
 * @since		iteration 1
 */
public class OrderDAO implements IDao{
	
	/**
	 * connection attribute
	 */
	private Connection c;

	/**
	 * default constructor
	 */
	public OrderDAO() {
		
	}
	
	/**
	 * it sets the order startingID
	 */
	public void initialize() {
		Order.setStartingId(this.getOrderingMaxId());
	}
	
	/**
	 * it returns all the orders from the DB
	 * 
	 * @return all the id orders in an string arraylist
	 */
	public ArrayList<String[]> selectAllOrders() {
		
		c = DatabaseConnection.startConnection(c, schema);
		
		ArrayList<String[]> rslt = new ArrayList<>();
		
		int maxId = this.getOrderingCountId();
		
		String idArray[] = new String[maxId+1];
		String totalArray[] = new String[maxId+1];
		String dateArray[] = new String[maxId+1];

		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = c.createStatement();
			
			String query = "SELECT id, total, time_date FROM ordering";
			
			
			rs1 = st1.executeQuery(query);
	
			
				idArray[0] = "ID ORDINE";
				totalArray[0] = "TOTALE";
				dateArray[0] = "DATA E ORA";
				
				for(int i = 1;rs1.next();i++ ) {
					
					idArray[i] = rs1.getString(1);
					totalArray[i] = rs1.getString(2) + " euro";
					dateArray[i] = rs1.getString(3);
					
					System.out.println(idArray[i]);
					System.out.println(totalArray[i]);
					System.out.println(dateArray[i]);
					
			}
			
			rslt.add(idArray);
			rslt.add(totalArray);
			rslt.add(dateArray);
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		DatabaseConnection.closeConnection(c);
		
		return rslt;
		
		
	}

	/**
	 * it returns all the servings in an order
	 * 
	 * @param id order identifier
	 * @return all the serving ids of an order in a string arraylist
	 */
	public ArrayList<String[]> selectServingFromOrder(int id) {
		
		c = DatabaseConnection.startConnection(c, schema);
		ArrayList<String[]> rslt = new ArrayList<>();
		
		try {
		 
			Statement st;
			ResultSet rs;
			int dim = getOderSize(id);
			
			String servingNameArray[] = new String[dim+1];
			String quantityArray[] = new String[dim+1];
			String priceArray[] = new String[dim+1];
			
			st = c.createStatement();
			
			String query = "SELECT name, quantity, ((price*quantity)+overprice) FROM "
					 + "(SELECT id FROM ordering WHERE id = " + id + ") A "
					 + "NATURAL JOIN "
					 + "(SELECT ordering as id, serving, quantity, overprice FROM order_serving) B "
					 + "NATURAL JOIN "
					 + "(SELECT id as serving, name, price FROM serving) C;";
			
			rs = st.executeQuery(query);
			
			servingNameArray[0] = "PIATTO";
			quantityArray[0] = "QUANTITA'";
			priceArray[0] = "PREZZO";
			
			for(int i = 1; rs.next(); i++) {
				
				servingNameArray[i] = rs.getString(1);
				quantityArray[i] = rs.getString(2);
				priceArray[i] = rs.getString(3) +" euro";
			
				System.out.println(servingNameArray[i]);
				System.out.println(quantityArray[i]);
				System.out.println(priceArray[i]);
			}
			
			rslt.add(servingNameArray);
			rslt.add(quantityArray);
			rslt.add(priceArray);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatabaseConnection.closeConnection(c);
		return rslt;
		
	}

	/**
	 * it inserts an order in the DB
	 * 
	 * @param order order parameter
	 * @param servings serving arraylist parameter
	 */
	public void insertOrder(Order order, ArrayList<Serving> servings) {
		
		c = DatabaseConnection.startConnection(c, schema);
		Statement st1;

		try {
			st1 = c.createStatement();
			String query = "INSERT INTO RESTAURANT.ORDERING VALUES (" + order.getId() + "," + order.getTable().getNumber() + "," + order.getTotal() + ",'" + order.getDateTime() + "');";
			st1.executeUpdate(query);
		
			for (Serving serving : order.getServings()) {
			
				float overprice = 0;
				
				for (Modifier mod : serving.getModifiers()) {
					overprice += mod.getPrice() ;
				}
				
				if(serving.getId()>this.getServingMaxId()) {
					for (Serving serving2 : servings) {
						if(serving2.getName().equals(serving.getName())) {
							serving.setId(serving2.getId());
						}
					}
				}
				
				st1 = c.createStatement();
				st1.addBatch("ALTER TABLE `restaurant`.`order_serving` "
						+ "DROP FOREIGN KEY `FK4`;");
				st1.addBatch("ALTER TABLE `restaurant`.`order_serving` "
						+ "DROP FOREIGN KEY `FK5`;");
				st1.addBatch("INSERT INTO order_serving (ordering, serving, quantity, overprice) VALUES (" + order.getId() + "," + serving.getId() + "," + serving.getQuantity() + ","+ overprice + ");");
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
	
	/**
	 * returns the chosen order from the DB
	 * 
	 * @param id order identifier
	 * @param categories categories arraylist parameter
	 * @return the order which has id equal to the id parameter
	 */
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
	
	/**
	 * it gets the order maxId from the DB
	 * 
	 * @return the maximum order id
	 */
	public int getOrderingMaxId() {
		
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
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	/**
	 * it gets the number of orders from the DB
	 * 
	 * @return the numbers of orders
	 */
	public int getOrderingCountId() {
		
		c = DatabaseConnection.startConnection(c, schema);
		Statement st1;
		ResultSet rs;
		
		try {
			
			st1 = c.createStatement();
			String qry = "select count(id) from restaurant.ordering";
			rs = st1.executeQuery(qry);
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	/**
	 * it gets the serving maxId
	 * 
	 * @return the maximum serving id
	 */
	public int getServingMaxId() {
		
		c = DatabaseConnection.startConnection(c, schema);
		Statement st1;
		ResultSet rs;
		
		try {
			
			st1 = c.createStatement();
			String qry = "select max(id) from restaurant.serving";
			rs = st1.executeQuery(qry);
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	/**
	 * it returns the order size from the DB
	 * 
	 * @param id identifier parameter
	 * @return the number of servings in an order which has the id parameter
	 */
	private int getOderSize(int id) {
				

		try {

			Statement st;
			ResultSet rs;	
				
			st = c.createStatement();
			
			String query = "select count(id) from order_serving where ordering = " + id;
			
			rs = st.executeQuery(query);
			rs.next();
			
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return 0;
		
	}

}
