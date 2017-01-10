package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Establishment;
import model.PriceList;

public class PriceListDao {

	public static PriceList Insert(PriceList priceList) {	
		
		try { 
			
			// price list
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO price_list (establishment_id,product_id,price,unit) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,priceList.getEstablishment().getId());
			stmt.setLong(2,priceList.getProduct().getId());
			stmt.setDouble(3,priceList.getPrice());
			stmt.setString(4,priceList.getUnit());
			stmt.execute();
			
			// get generated price list id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				priceList.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return priceList;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static PriceList GetPriceListByEstablishment(Establishment establishment){
		
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select * from price_list where establishment_id=?");
	    	stmt.setLong(1,establishment.getId());
	    	ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;

			PriceList priceList = new PriceList();
			priceList.setEstablishment(establishment);
			priceList.setProduct(ProductDao.GetProductById(rs.getLong("product_id")));
			priceList.setPrice(rs.getDouble("price"));
			priceList.setUnit(rs.getString("unit"));
			
			rs.close();
			stmt.close();
			connection.close();
			return priceList;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
