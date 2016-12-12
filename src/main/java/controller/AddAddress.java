package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.AddressDao;
import json.AddressJSON;
import model.Address;
import util.Util;

@WebServlet("/addAddress")
public class AddAddress extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			// address
			Address address = new Address();
			address.setZipCode(request.getParameter("zipCode"));
			
			if(!Util.IsEmpty(request.getParameter("street")))
				address.setStreet(request.getParameter("street"));
			
			if(!Util.IsEmpty(request.getParameter("city")))
				address.setCity(request.getParameter("city"));
			
			if(!Util.IsEmpty(request.getParameter("state")))
				address.setState(request.getParameter("state"));			
			
			if(!Util.IsEmpty(request.getParameter("country")))
				address.setCountry(request.getParameter("country"));
			
			if(!Util.IsEmpty(request.getParameter("latitude")))
				address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
			
			if(!Util.IsEmpty(request.getParameter("longitude")))
				address.setLongitude(Double.parseDouble(request.getParameter("longitude")));

			if(!Util.IsEmpty(request.getParameter("number")))
				address.setNumber(Integer.parseInt(request.getParameter("number")));
			
			if(!Util.IsEmpty(request.getParameter("premise")))
				address.setPremise(request.getParameter("premise"));
			
			if(!Util.IsEmpty(request.getParameter("account_id")))
				address.setAccountId(Long.parseLong(request.getParameter("account_id")));
			
			if(!Util.IsEmpty(request.getParameter("establishment_id")))
				address.setEstablishmentId(Long.parseLong(request.getParameter("establishment_id")));

			address = AddressDao.Insert(address);
			
			
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
			out.print(jsonMain.put("address",AddressJSON.GetAddressJSON(address)));
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
