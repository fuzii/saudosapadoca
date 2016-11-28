package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import dao.AddressDao;
import dao.EstablishmentDao;
import model.Address;
import model.Establishment;

@WebServlet("/getEstablishmentByLocation")
public class GetEstablishmentByLocationServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		Address address = AddressDao.GetAddressById(Long.parseLong(request.getParameter("id")));
		List<Address> addresses = EstablishmentDao.GetEstablishmentsAddressesByLocation(address);
		
		// response
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		try {
			
			for(Address a : addresses){
				
				Establishment establishment = EstablishmentDao.GetEstablishmentsById(a.getEstablishmentId());
				
				JSONObject json = new JSONObject();
				
				// establishment
				json.put("id",establishment.getId());
				json.put("name",establishment.getName());
				json.put("alias",establishment.getAlias());
				json.put("registerNumber",establishment.getRegisterNumber());
				
				// address
				json.put("id",a.getId());
				json.put("accountId",a.getAccountId());
				json.put("establishmentId",a.getEstablishmentId());
				json.put("zipCode",a.getZipCode());
				json.put("street",a.getStreet());
				json.put("city",a.getCity());
				json.put("state",a.getState());
				json.put("number;",a.getNumber()); 
				json.put("premise",a.getPremise());
				json.put("country",a.getCountry());
				json.put("latitude",a.getLatitude());
				json.put("longitude",a.getLongitude());
				json.put("radius",a.getRadius());
				//json.put("created_on",a.getCreated_on());
				out.println(json.toString());
				
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}