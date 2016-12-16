package json;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import model.Schedule;

public class ScheduleJSON {
	
	public static JSONObject GetScheduleJSON (Schedule schedule){
		
		JSONObject jsonSchedule = null;
		
		try {

			// schedule
			jsonSchedule = new JSONObject();
			jsonSchedule.put("id",schedule.getId());
			jsonSchedule.put("establishmentId",schedule.getEstablishment().getId());
			jsonSchedule.put("dayWeek",schedule.getDayWeek());
			jsonSchedule.put("startTime",schedule.getStartTime());
			jsonSchedule.put("endTime",schedule.getEndTime());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonSchedule;
	
	}
	
	public static JSONArray GetListScheduleJSON (List<Schedule> schedules){
		
		// schedules
		JSONArray jsonSchedules = new JSONArray();
		for(Schedule schedule : schedules)
			jsonSchedules.put(GetScheduleJSON(schedule));

		return jsonSchedules;
	
	}

	
}
