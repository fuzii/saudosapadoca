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

@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			// address
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
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address);
			
			// account
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
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
