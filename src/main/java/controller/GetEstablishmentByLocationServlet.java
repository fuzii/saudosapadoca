package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
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
		
		JSONArray jsonArrayEstablishment = new JSONArray();
		
		try {
			
			for(Address a : addresses){
				
				Establishment establishment = EstablishmentDao.GetEstablishmentsById(a.getEstablishmentId());
				
				// establishment
				JSONObject jsonProfile = new JSONObject();
				jsonProfile.put("Id",establishment.getId());
				jsonProfile.put("Name",establishment.getName());
				jsonProfile.put("Alias",establishment.getAlias());
				jsonProfile.put("RegisterNumber",establishment.getRegisterNumber());
				
				// address
				JSONObject jsonAddress = new JSONObject();
				jsonAddress.put("Id",a.getId());
				jsonAddress.put("AccountId",a.getAccountId());
				jsonAddress.put("EstablishmentId",a.getEstablishmentId());
				jsonAddress.put("ZipCode",a.getZipCode());
				jsonAddress.put("Street",a.getStreet());
				jsonAddress.put("City",a.getCity());
				jsonAddress.put("State",a.getState());
				jsonAddress.put("Number;",a.getNumber()); 
				jsonAddress.put("Premise",a.getPremise());
				jsonAddress.put("Country",a.getCountry());
				jsonAddress.put("Latitude",a.getLatitude());
				jsonAddress.put("Longitude",a.getLongitude());
				jsonAddress.put("Radius",a.getRadius());
				
				JSONObject jsonEstablishment = new JSONObject();
				jsonEstablishment.put("address", jsonAddress);
				jsonEstablishment.put("profile", jsonProfile);
				
				jsonArrayEstablishment.put(jsonEstablishment);

			}
			
			JSONObject jsonEstablishments = new JSONObject();
			jsonEstablishments.put("establishment", jsonArrayEstablishment);
			
			JSONObject jsonMain = new JSONObject();
			jsonMain.put("establishments", jsonEstablishments);
			
			PrintWriter out = response.getWriter();
			out.println(jsonMain.toString());
			
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
