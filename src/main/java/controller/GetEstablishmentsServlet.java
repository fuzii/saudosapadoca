package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.EstablishmentDao;
import model.Address;
import model.Establishment;

@WebServlet("/getEstablishments")
public class GetEstablishmentsServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		List<Establishment> establishments = EstablishmentDao.GetEstablishments();
		
		// response
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		for(Establishment establishment : establishments){
			
			out.print("<br/><br/>EstablishmentId:"+establishment.getId()+";");
			out.print("Name:"+establishment.getName()+";");
			out.print("Alias:"+establishment.getAlias()+";");
			out.print("RegisterNumber:"+establishment.getRegisterNumber()+";");
			
			for(Address address : establishment.getAddress()){
				out.print("<br/>AddressId:"+address.getId()+";");
				out.print("EstablishmentId:"+address.getEstablishmentId()+";");
				out.print("ZipCode:"+address.getZipCode()+";");
				out.print("Street:"+address.getStreet()+";");
				out.print("City:"+address.getCity()+";");
				out.print("State:"+address.getState()+";");
				out.print("Number:"+address.getNumber()+";");
				out.print("Premise:"+address.getPremise()+";");
				out.print("Country:"+address.getCountry()+";");
				out.print("Latitude:"+address.getLatitude()+";");
				out.print("Longitude:"+address.getLongitude()+";");
				out.print("Radius:"+address.getRadius()+";");
			}
			
		}
		out.println("</body>");
		out.println("</html>");
	}
}
