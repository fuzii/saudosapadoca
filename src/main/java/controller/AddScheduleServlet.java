package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ScheduleDao;
import model.Schedule;

@WebServlet("/addSchedule")
public class AddScheduleServlet extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			// schedule
			Schedule schedule = new Schedule(); 
			schedule.setEstablishmentId(Long.parseLong(request.getParameter("establishment_id")));
			schedule.setStartTime(request.getParameter("saturday_start_time"));
			schedule.setEndTime(request.getParameter("saturday_end_time"));
			schedule.setDayWeek("Sábado");
			ScheduleDao.Insert(schedule);

			schedule.setStartTime(request.getParameter("sunday_start_time"));
			schedule.setEndTime(request.getParameter("sunday_end_time"));
			schedule.setDayWeek("Domingo");
			ScheduleDao.Insert(schedule);
			
			schedule.setStartTime(request.getParameter("week_start_time"));
			schedule.setEndTime(request.getParameter("week_end_time"));
			schedule.setDayWeek("Segunda");
			ScheduleDao.Insert(schedule);
			schedule.setDayWeek("Terça");
			ScheduleDao.Insert(schedule);
			schedule.setDayWeek("Quarta");
			ScheduleDao.Insert(schedule);
			schedule.setDayWeek("Quinta");
			ScheduleDao.Insert(schedule);
			schedule.setDayWeek("Sexta");
			ScheduleDao.Insert(schedule);
	
			
			// response
			response.addHeader("Access-Control-Allow-Origin","*");
			response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
			response.addHeader("Access-Control-Max-Age","3600");
			response.addHeader("Access-Control-Allow-Headers","x-requested-with");
			response.setStatus(HttpServletResponse.SC_OK);
			
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
