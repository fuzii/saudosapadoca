package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        
        public static void DeleteByOrderId(Order order)
        {
            try 
            {
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement("DELETE FROM order_item WHERE order_id=? ",Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, order.getId());
                stmt.execute();
                //rs.close();
                stmt.close();
                connection.close();
                
             } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public static OrderItem Upsert(Order order, OrderItem orderItem) {	
            try {		
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt;
                // insert order
                if(order.getId() != -1)
                {
                    stmt = connection.prepareStatement("DELETE FROM order_item WHERE order_id=? ",Statement.RETURN_GENERATED_KEYS);
                    stmt.setLong(1, order.getId());
                    stmt.execute();
                }
                stmt = connection.prepareStatement("INSERT INTO order_item (order_id, product_id, day_week, delivery_time, quantity, item_price) values (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
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
        
        public static List<OrderItem> GetOrderItemsByOrderId(Long id) {	
            try {
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_item WHERE order_id=?");
                stmt.setLong(1,id);
                ResultSet rs = stmt.executeQuery();

                List<OrderItem> orderItems = new ArrayList<OrderItem>();
                
                while(rs.next())
                {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setId(rs.getLong("id"));
                    orderItem.setDayOfWeek(rs.getString("day_week"));
                    orderItem.setDeliveryTime(rs.getTime("delivery_time"));
                    orderItem.setPrice(rs.getDouble("item_price"));
                    orderItem.setUnit("Unidade");
                    orderItem.setQuantity(rs.getInt("quantity"));
                    orderItems.add(orderItem);
                }
                rs.close();
                stmt.close();
                connection.close();

                return orderItems;	
            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }	
	}
}
