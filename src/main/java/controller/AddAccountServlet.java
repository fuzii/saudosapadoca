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

import dao.AccountDao;
import model.Account;
import model.Address;
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
		response.sendRedirect("getEstablishmentByLocation?id="+address.getId());
		
	}
}
