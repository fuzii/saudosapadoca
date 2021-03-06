package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import dao.AddressDao;
import dao.EstablishmentDao;
import formatter.GenerateJSON;
import formatter.GenerateObject;
import model.Address;
import model.Establishment;

@WebServlet("/addEstablishment")
public class AddEstablishmentServlet extends HttpServlet{
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
		
			Establishment establishment = GenerateObject.GetEstablishment(request);
			establishment = EstablishmentDao.Insert(establishment);
			
			Address address = GenerateObject.GetAddress(request);
			address.setEstablishmentId(establishment.getId());
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
			out.print(jsonMain.put("establishment",GenerateJSON.GetEstablishmentJSON(establishment)));
			
			// set session
			HttpSession session = request.getSession(true);
			session.setAttribute("establishment", establishment);
			session.setAttribute("address", address);
			
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
			
	}
	
}
