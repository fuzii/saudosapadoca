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
				json.put("establishmentId",establishment.getId());
				json.put("establishmentName",establishment.getName());
				json.put("establishmentAlias",establishment.getAlias());
				json.put("establishmentRegisterNumber",establishment.getRegisterNumber());
				
				// address
				json.put("addressId",a.getId());
				json.put("addressAccountId",a.getAccountId());
				json.put("addressEstablishmentId",a.getEstablishmentId());
				json.put("addressZipCode",a.getZipCode());
				json.put("addressStreet",a.getStreet());
				json.put("addressCity",a.getCity());
				json.put("addressState",a.getState());
				json.put("addressNumber;",a.getNumber()); 
				json.put("addressPremise",a.getPremise());
				json.put("addressCountry",a.getCountry());
				json.put("addressLatitude",a.getLatitude());
				json.put("addressLongitude",a.getLongitude());
				json.put("addressRadius",a.getRadius());
				out.println(json.toString());
				
			}
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
