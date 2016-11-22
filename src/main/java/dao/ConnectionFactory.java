package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){

		try{
			
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			
		    String username = dbUri.getUserInfo().split(":")[0];
		    String password = dbUri.getUserInfo().split(":")[1];
		    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		
		    return DriverManager.getConnection(dbUrl, username, password);
		
		} catch(SQLException e){
			throw new RuntimeException(e);
			
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
}
