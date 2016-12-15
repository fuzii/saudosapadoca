package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Schedule;

public class ScheduleDao {

	public static Schedule Insert(Schedule schedule) {	
		
		try { 
			
			// schedule
			Connection connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO establishment_schedule (establishment_id,day_week,start_time,end_time) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,schedule.getEstablishmentId());
			stmt.setString(2,schedule.getDayWeek());
			stmt.setString(3,schedule.getStartTime());
			stmt.setString(4,schedule.getEndTime());
			stmt.execute();

			// get generated schedule id
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				schedule.setId(rs.getLong(1));

			rs.close();
			stmt.close();
			connection.close();
			
			return schedule;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
}
