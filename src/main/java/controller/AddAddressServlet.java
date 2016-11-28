package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDao;
import model.Address;

@WebServlet("/addAddress")
public class AddAddressServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		// request
		Address address = new Address();
		//address.setAccountId(Long.parseLong(request.getParameter("accountId")));
		address.setAccountId((request.getParameter("accountId")=="" || request.getParameter("accountId")==null)?null:Long.parseLong(request.getParameter("accountId")));
		address.setEstablishmentId(Long.parseLong(request.getParameter("establishmentId")));
		address.setZipCode(request.getParameter("zipCode"));
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setNumber(Integer.parseInt(request.getParameter("number"))); 
		address.setRadius(Integer.parseInt(request.getParameter("radius"))); 
		address.setPremise(request.getParameter("premise"));
		address.setCountry(request.getParameter("country"));
		address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
		address.setLongitude(Double.parseDouble(request.getParameter("longitude")));
		
		AddressDao.Insert(address);

		// response
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Endereço adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}
