package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.AddressDao;
import dao.EstablishmentDao;
import dao.PriceListDao;
import dao.ScheduleDao;
import formatter.GenerateJSON;
import formatter.GenerateObject;
import model.Address;
import model.Establishment;
import model.PriceList;
import model.Schedule;

@WebServlet("/establishments")
public class EstablishmentsServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try{		
			Establishment establishment = EstablishmentDao.GetEstablishmentsById(Long.parseLong(request.getAttribute("establishment_id").toString()));
			Address address = AddressDao.GetAddressByEstablishment(establishment).get(0);
			PriceList priceList = PriceListDao.GetPriceListByEstablishment(establishment);
			List<Schedule> schedules = ScheduleDao.GetSchedulesByEstablishment(establishment);
			// response
			response.addHeader("Access-Control-Allow-Origin","*");
			response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
			response.addHeader("Access-Control-Max-Age","3600");
			response.addHeader("Access-Control-Allow-Headers","x-requested-with");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			
			JSONObject jsonMain = new JSONObject();
			PrintWriter out = response.getWriter();
			jsonMain.put("establishment",GenerateJSON.GetEstablishmentJSON(establishment));
			jsonMain.put("address", GenerateJSON.GetAddressJSON(address));
			jsonMain.put("priceList", GenerateJSON.GetPriceListJSON(priceList));
			jsonMain.put("schedules", GenerateJSON.GetListScheduleJSON(schedules));
			out.print(jsonMain);
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}			
	}
}
