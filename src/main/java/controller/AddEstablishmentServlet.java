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
import dao.EstablishmentDao;
import model.Address;
import model.Establishment;
import util.Geolocation;

@WebServlet("/addEstablishment")
public class AddEstablishmentServlet extends HttpServlet{ 
	
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
		address.setRadius(Integer.parseInt(request.getParameter("radius"))); 
		
		// create address list
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		
		// create establishment object and insert
		Establishment establishment = new Establishment();		
		establishment.setName(request.getParameter("name"));
		establishment.setAlias(request.getParameter("alias"));
		establishment.setRegisterNumber(Long.parseLong(request.getParameter("registerNumber")));
		establishment.setAddress(addresses);
		establishment = EstablishmentDao.Insert(establishment);
		
		// response
		response.addHeader("Access-Control-Allow-Origin","*");
		response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
	    response.addHeader("Access-Control-Max-Age","3600");
	    response.addHeader("Access-Control-Allow-Headers","x-requested-with");
	    response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		out.print(Geolocation.GetAccountsJSON(address));
		
	}
	
}
