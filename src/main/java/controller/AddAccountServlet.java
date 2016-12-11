package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AccountDao;
import model.Account;
import model.Address;
import util.SendGridEmail;
import util.Util;

@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
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
			
			if(!Util.isEmpty(request.getParameter("premise")))
				address.setPremise(request.getParameter("premise"));
			
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address);
			
			
			// account
			Account account = new Account(); 
			account.setName(request.getParameter("name"));
			account.setEmail(request.getParameter("email"));
			account.setPhone(request.getParameter("phone"));
			
			account.setUserLogin(request.getParameter("email"));
			account.setUserPassword(request.getParameter("password").toCharArray());
			
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
			response.setStatus(HttpServletResponse.SC_OK);
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
