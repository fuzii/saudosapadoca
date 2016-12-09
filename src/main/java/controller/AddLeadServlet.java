package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.LeadDao;
import model.Address;
import model.Lead;
import util.Util;

@WebServlet("/addLead")
public class AddLeadServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			// address
			Address address = new Address();
			address.setZipCode(request.getParameter("zipCode"));
			 
			if(!Util.isEmpty(request.getParameter("street")))
				address.setStreet(request.getParameter("street"));
			
			if(!Util.isEmpty(request.getParameter("city")))
				address.setCity(request.getParameter("city"));
			
			if(!Util.isEmpty(request.getParameter("state")))
				address.setState(request.getParameter("state"));			
			
			if(!Util.isEmpty(request.getParameter("country")))
				address.setCountry(request.getParameter("country"));
			
			if(!Util.isEmpty(request.getParameter("latitude")))
				address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
			
			if(!Util.isEmpty(request.getParameter("longitude")))
				address.setLongitude(Double.parseDouble(request.getParameter("longitude")));

			if(!Util.isEmpty(request.getParameter("number")))
				address.setNumber(Integer.parseInt(request.getParameter("number")));
			
			
			// lead
			Lead lead = new Lead();
			lead.setName(request.getParameter("name"));
			lead.setEmail(request.getParameter("email"));
			lead.setAddress(address);
			lead = LeadDao.Insert(lead);

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
