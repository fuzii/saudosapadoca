package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Account;
import model.Address;

public class AccountDao {
	
	public static void Insert(Account account) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO account(name,email,created_on) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1,account.getName());
			stmt.setString(2,account.getEmail());
			stmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
			    account.setId(rs.getLong(1));
	
			for(Address address: account.getAddress())
				InsertAccountAddress(account, address);
			
			rs.close();
			stmt.close();
			connection.close();
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void Update(Account account) {	
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE account SET name=?,email=? where id=?");

			stmt.setString(1,account.getName());
			stmt.setString(2,account.getEmail());
			stmt.setLong(3,account.getId());
			stmt.execute();
			
			for(Address address: account.getAddress()){
				AddressDao.Update(address);
			}
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static List<Account> GetAccounts() {
	     
		try {
			
			List<Account> accounts = new ArrayList<Account>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from account");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {

				Account account = new Account();
				account.setId(rs.getLong("id"));
				account.setName(rs.getString("name"));
				account.setEmail(rs.getString("email"));
				account.setAddress(GetAccountAddresses(account));
												
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("created_on"));
				account.setCreated_on(data);

				accounts.add(account);
				
			}
			
			rs.close();
			stmt.close();
			connection.close();
			return accounts;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static Account GetAccountsById(Long id) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from account where id=?");
	    	stmt.setLong(1,id);
	    	ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;

			Account account = new Account();
			account.setId(rs.getLong("id"));
			account.setName(rs.getString("name"));
			account.setEmail(rs.getString("email"));
			account.setAddress(GetAccountAddresses(account));
											
			// montando a data através do Calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("created_on"));
			account.setCreated_on(data);
			
			rs.close();
			stmt.close();
			connection.close();
			return account;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static List<Address> GetAccountAddresses(Account account) {
	     
		try {
		
			List<Address> addresses = new ArrayList<Address>();
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from address where account_id=?");
	    	stmt.setLong(1,account.getId());
	    	
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

	public static void InsertAccountAddress(Account account, Address address){
		
		address.setAccountId(account.getId());
		AddressDao.Insert(address);
		
	}
	
}
