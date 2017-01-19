package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Order;
import model.OrderItem;
 
public class OrderDao {

	public static Order Insert(Order order) {	
		
		try {
						
			// insert order
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO order_entry (establishment_id, account_id, status) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,order.getEstablishment().getId());
			stmt.setLong(2,order.getAccount().getId());
			stmt.setString(3,order.getStatus());
			stmt.execute();

			// get generated account id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    order.setId(rs.getLong(1));
	
			// insert order item
			for(OrderItem orderItem : order.getOrderItem())
				OrderItemDao.Insert(order, orderItem);
				
			rs.close();
			stmt.close();
			connection.close();
			
			return order;
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
