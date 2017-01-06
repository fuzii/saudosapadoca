package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import model.User;

public class SessionDao {

	public static Map<String, String> GetSessionParameters(User user) {
	     
		try {
			
			Connection connection = new ConnectionFactory().getConnection();
	    	PreparedStatement stmt = connection.prepareStatement("select u.id as user_id, a.id as account_id, e.id as establishment_id"
												    			+ "from user_application u"
												    			+ "left outer join account a on u.id = a.user_id"
												    			+ "left outer join establishment e on u.id = e.user_id"
												    			+ "where u.id=?");
	    	stmt.setLong(1,user.getUserId());
	    	ResultSet rs = stmt.executeQuery();

			if(!rs.next())
				return null;
			
			Map<String, String> map = new HashMap<>();
			map.put("user_id", String.valueOf(rs.getLong("user_id")));
			map.put("account_id", String.valueOf(rs.getLong("account_id")));
			map.put("establishment_id", String.valueOf(rs.getLong("establishment_id")));
											
			rs.close();
			stmt.close();
			connection.close();
			return map;
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
}
