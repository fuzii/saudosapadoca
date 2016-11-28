package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Establishment;
import util.Geolocation;
import model.Address;

public class EstablishmentDao {
	
	public static void Insert(Establishment establishment) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO establishment (name,alias,register_num,created_on) values (?,?,?,?)");
			
			stmt.setString(1,establishment.getName());
			stmt.setString(2,establishment.getAlias());
			stmt.setLong(3,establishment.getRegisterNumber());
			stmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.execute();
			
			for(Address address: establishment.getAddress()){
				AddressDao.Insert(address);
			}
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void Update(Establishment establishment) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE establishment SET name=?,alias=?,register_num=? where id=?");
			
			stmt.setString(1,establishment.getName());
			stmt.setString(2,establishment.getAlias());
			stmt.setLong(3,establishment.getRegisterNumber());
			stmt.setLong(4,establishment.getId());
			stmt.execute();
			
			for(Address address: establishment.getAddress()){
				AddressDao.Update(address);
			}
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static List<Establishment> GetEstablishments() {
	     
		try {
			
			List<Establishment> establishments = new ArrayList<Establishment>();
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from establishment");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Establishment establishment = new Establishment();
				establishment.setId(rs.getLong("id"));
				establishment.setName(rs.getString("name"));
				establishment.setAlias(rs.getString("alias"));
				establishment.setRegisterNumber(rs.getLong("register_num"));
				establishment.setAddress(GetEstablishmentAddresses(establishment));
												
				// created on
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created_on"));
				establishment.setCreated_on(data);

				establishments.add(establishment);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return establishments;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Establishment GetEstablishmentsById(Long id) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from establishment where id=?");
			stmt.setLong(1,id);
			ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;
			
			Establishment establishment = new Establishment();
			establishment.setId(rs.getLong("id"));
			establishment.setName(rs.getString("name"));
			establishment.setAlias(rs.getString("alias"));
			establishment.setRegisterNumber(rs.getLong("register_num"));
			establishment.setAddress(GetEstablishmentAddresses(establishment));
											
			// created on
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("created_on"));
			establishment.setCreated_on(data);
			
			rs.close();
			stmt.close();
			connection.close();
			return establishment;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public static List<Address> GetEstablishmentsAddressesByLocation(Address address) {
	     
		try {
			
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("select * from address where establishment_id is not null");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				int radius = rs.getInt("radius");
				int distance = Geolocation.Distance(address.getLatitude(), address.getLongitude(), rs.getDouble("latitude"), rs.getDouble("longitude"));
				
				if(radius >= distance){
					
					// Add address
					Address a = new Address();
					a.setId(rs.getLong("id"));
					a.setAccountId(rs.getLong("account_id"));
					a.setZipCode(rs.getString("zipCode"));
					a.setStreet(rs.getString("street"));
					a.setCity(rs.getString("city"));
					a.setState(rs.getString("state"));
					a.setNumber(rs.getInt("number"));
					a.setRadius(rs.getInt("radius"));
					a.setPremise(rs.getString("premise"));
					a.setCountry(rs.getString("country"));
					a.setLatitude(rs.getDouble("latitude"));
					a.setLongitude(rs.getDouble("longitude"));
					a.setAccountId(rs.getLong("establishment_id"));
									
					// created on
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("created_on"));
					a.setCreated_on(data);

					addresses.add(address);
					
				}
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return addresses;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static List<Address> GetEstablishmentAddresses(Establishment establishment) {
	     
		try {
		
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from address where establishment_id=?");
	    	stmt.setLong(1,establishment.getId());
	    	
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Address address = new Address();
				address.setId(rs.getLong("id"));
				address.setEstablishmentId(rs.getLong("establishment_id"));
				address.setZipCode(rs.getString("zipCode"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setNumber(rs.getInt("number"));
				address.setPremise(rs.getString("premise"));
				address.setCountry(rs.getString("country"));
				address.setLatitude(rs.getDouble("latitude"));
				address.setLongitude(rs.getDouble("longitude"));
								
				// created
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

	public static void InsertEstablishmentAddress(Establishment establishment, Address address){
		
		address.setEstablishmentId(establishment.getId());
		AddressDao.Insert(address);
		
	}
	
}
