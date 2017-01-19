package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Order;
import model.OrderItem;
 
public class OrderItemDao {

	public static OrderItem Insert(Order order, OrderItem orderItem) {	
		
		try {
						
			// insert order
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO order_item (order_id, product_id, day_week, delivery_time, quantity, item_price) values (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,order.getId());
			stmt.setLong(2,orderItem.getProduct().getId());
			stmt.setString(3,orderItem.getDayOfWeek());
			stmt.setString(4,String.valueOf(orderItem.getDeliveryTime()));
			stmt.setInt(5,orderItem.getQuantity());
			stmt.setDouble(6,orderItem.getPrice());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    orderItem.setId(rs.getLong(1));
	
			rs.close();
			stmt.close();
			connection.close();
			
			return orderItem;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
