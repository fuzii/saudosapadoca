package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Address;
import util.Foursquare;
import util.Util;

@WebServlet("/getFoursquare") 
public class GetFoursquareServlet extends HttpServlet{
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		
		
		if(!Util.IsEmpty(request.getParameter("near")))
			out.print(Foursquare.GetFoursquareJSON(request.getParameter("near")).toString());
			
		else{			
			Address address = new Address();
			address.setLatitude(Double.parseDouble(request.getParameter("latitude")));
			address.setLongitude(Double.parseDouble(request.getParameter("longitude")));
			out.print(Foursquare.GetFoursquareJSON(address).toString());
		}
		
	}
}
