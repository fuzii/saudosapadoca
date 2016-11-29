package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.AccountDao;
import dao.AddressDao;
import dao.EstablishmentDao;
import model.Account;
import model.Address;
import model.Establishment;
import util.SendGridEmail;

@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// create address object
		Address address = new Address();
		address.setZipCode(request.getParameter("zipCode"));
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setNumber(Integer.parseInt(request.getParameter("number"))); 
		address.setPremise(request.getParameter("premise"));
		address.setCountry(request.getParameter("country"));
		address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		address.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		
		// create address list
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		
		// create account object and insert
		Account account = new Account();
		account.setName(request.getParameter("name"));
		account.setEmail(request.getParameter("email"));
		account.setAddress(addresses);
		account = AccountDao.Insert(account);

		// send confirmation mail
		if(System.getenv("SENDGRID_ACTIVE")=="On"){
			String from = System.getenv("SENDGRID_FROM");
			String subject = "[Saudosa Padoca] - Confirmacao de cadastro";
			String content = "Obrigado por se cadastrar no...";
			String to = account.getEmail();
			SendGridEmail.Send(from, to, subject, content);
		}

		// response
		response.addHeader("Access-Control-Allow-Origin","*");
		response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
	    response.addHeader("Access-Control-Max-Age","3600");
	    response.addHeader("Access-Control-Allow-Headers","x-requested-with");
		
	    //response.sendRedirect("getEstablishmentByLocation?id="+address.getId());
	    
//-----------------------------------------------------------------INICIO DO TESTE
	    
	    
		// request
		List<Address> addresses2 = EstablishmentDao.GetEstablishmentsAddressesByLocation(address);
		
		// response
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		JSONArray jsonArrayEstablishment = new JSONArray();
		
		try {
			
			for(Address a : addresses2){
				
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
		
//-----------------------------------------------------------------FIM DO TESTE
	    
	    
	    
		
	}
}
