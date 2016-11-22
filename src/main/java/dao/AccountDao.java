package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import model.Account;

public class AccountDao {
	
	public static void Insert(Account account) {
		
		String sql = "INSERT INTO account(name,email,created_on) values (?,?,?)";
 
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,account.getName());
			stmt.setString(2,account.getEmail());
			stmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));

			stmt.execute();
			stmt.close();
			
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
