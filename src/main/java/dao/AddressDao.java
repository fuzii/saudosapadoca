package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Account;
import model.Address;

public class AddressDao {

	public static void Insert(Address address) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO address(account_id,zipCode,street,city,state,number,premise,country,latitude,longitude,created_on) values (?,?,?,?,?,?,?,?,?,?,?)");

			stmt.setLong(1,address.getAccountId());
			stmt.setString(2,address.getZipCode());
			stmt.setString(3,address.getStreet());
			stmt.setString(4,address.getCity());
			stmt.setString(5,address.getState());
			stmt.setInt(6,address.getNumber());
			stmt.setString(7,address.getPremise());
			stmt.setString(8,address.getCountry());
			stmt.setDouble(9,address.getLatitude());
			stmt.setDouble(10,address.getLongitude());
			stmt.setDate(11, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.execute();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void Update(Address address) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE address SET account_id=?,zipCode=?,street=?,city=?,state=?,number=?,premise=?,country=?,latitude=?,longitude=? where id=?");

			stmt.setLong(1,address.getAccountId());
			stmt.setString(2,address.getZipCode());
			stmt.setString(3,address.getStreet());
			stmt.setString(4,address.getCity());
			stmt.setString(5,address.getState());
			stmt.setInt(6,address.getNumber());
			stmt.setString(7,address.getPremise());
			stmt.setString(8,address.getCountry());
			stmt.setDouble(9,address.getLatitude());
			stmt.setDouble(10,address.getLongitude());
			stmt.setLong(11, address.getId());
			stmt.execute();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static void Delete(Address address) {
		
	     try {
	    	 
	    	 Connection connection = new ConnectionFactory().getConnection();
	    	 PreparedStatement stmt = connection.prepareStatement("delete from address where id=?");
	    	 stmt.setLong(1, address.getId());
	    	 stmt.execute();
	    	 stmt.close();
	    	 connection.close();
	    	 
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }

	public static List<Address> GetAddresses() {
	     
		try {
		
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from address");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Address address = new Address();
				address.setId(rs.getLong("id"));
				address.setAccountId(rs.getLong("account_id"));
				address.setZipCode(rs.getString("zipCode"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setNumber(rs.getInt("number"));
				address.setPremise(rs.getString("premise"));
				address.setCountry(rs.getString("country"));
				address.setLatitude(rs.getDouble("latitude"));
				address.setLongitude(rs.getDouble("longitude"));
								
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created_on"));
				address.setCreated_on(data);

				addresses.add(address);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return addresses;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	
}
