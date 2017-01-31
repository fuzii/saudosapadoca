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
        
        public static Order Upsert(Order order) {	
            try {
                
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt;
                if(order.getId() == -1) 
                {
                    stmt = connection.prepareStatement("INSERT INTO order_entry (establishment_id, account_id, status) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
                }
                else
                {
                    stmt = connection.prepareStatement("UPDATE order_entry SET establishment_id=?, account_id=?, status=? WHERE id=?",Statement.RETURN_GENERATED_KEYS);
                    stmt.setLong(4, order.getId());
                }
                // insert order
                stmt.setLong(1,order.getEstablishment().getId());
                stmt.setLong(2,order.getAccount().getId());
                stmt.setString(3,order.getStatus());
                stmt.execute();
                //delete order items
                OrderItemDao.DeleteByOrderId(order);
                // insert order item
                for(OrderItem orderItem : order.getOrderItem())
                    OrderItemDao.Insert(order, orderItem);

                // get generated account id
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                    order.setId(rs.getLong(1));
                rs.close();
                stmt.close();
                connection.close();
                
                return order;
            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }
	}
        
        public static Order GetOrderByAccountId(Long id) {	
            try {
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_entry WHERE account_id=? ORDER BY created DESC");
                stmt.setLong(1,id);
                ResultSet rs = stmt.executeQuery();

                if(!rs.next())
                    return null;
                
                Order order = new Order();
                order.setId(rs.getLong(1));
                order.setAccount(dao.AccountDao.GetAccountsById(id));
                order.setEstablishment(dao.EstablishmentDao.GetEstablishmentsById(rs.getLong("establishment_id")));
                List<OrderItem> orderItems = dao.OrderItemDao.GetOrderItemsByOrderId(order.getId());
                order.setOrderItem(orderItems);

                rs.close();
                stmt.close();
                connection.close();
                
                return order;

            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }
	}
        
        public static List<Order> GetOrdersByAccountId(Long id) {	
            try {
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_entry WHERE account_id=? ORDER BY created DESC");
                stmt.setLong(1,id);
                ResultSet rs = stmt.executeQuery();

                List<Order> orders = new ArrayList<Order>();
                while(rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getLong(1));
                    order.setAccount(dao.AccountDao.GetAccountsById(id));
                    order.setEstablishment(dao.EstablishmentDao.GetEstablishmentsById(rs.getLong("establishment_id")));
                    List<OrderItem> orderItems = dao.OrderItemDao.GetOrderItemsByOrderId(order.getId());
                    order.setOrderItem(orderItems);
                    order.setStatus(rs.getString("status"));
                    order.setCreated(rs.getDate("created"));
                    orders.add(order);
                }
                
                rs.close();
                stmt.close();
                connection.close();
                
                return orders;

            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }
	}
        
        public static List<Order> GetOrdersByEstablishmentId(Long id) {	
            try {
                Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement("SELECT * FROM order_entry WHERE establishment_id=? ORDER BY created DESC");
                stmt.setLong(1,id);
                ResultSet rs = stmt.executeQuery();

                List<Order> orders = new ArrayList<Order>();
                while(rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getLong(1));
                    order.setAccount(dao.AccountDao.GetAccountsById(rs.getLong("account_id")));
                    order.setEstablishment(dao.EstablishmentDao.GetEstablishmentsById(id));
                    List<OrderItem> orderItems = dao.OrderItemDao.GetOrderItemsByOrderId(order.getId());
                    order.setOrderItem(orderItems);
                    order.setStatus(rs.getString("status"));
                    order.setCreated(rs.getDate("created"));
                    orders.add(order);
                }
                
                rs.close();
                stmt.close();
                connection.close();
                
                return orders;

            } catch (SQLException e) {
                    throw new RuntimeException(e);
            }
	}
}
