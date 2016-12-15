package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.EstablishmentDao;
import json.EstablishmentJSON;
import model.Establishment;
import util.Util;

@WebServlet("/addEstablishment")
public class AddEstablishmentServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
		
			// establishment
			Establishment establishment = new Establishment();		
			establishment.setName(request.getParameter("name"));
			establishment.setAlias(request.getParameter("alias"));
			establishment.setEmail(request.getParameter("email"));
			establishment.setRegisterNumber(Long.parseLong(request.getParameter("register_number")));
			establishment.setRadius(Integer.parseInt(request.getParameter("radius")));
			establishment.setResponsibleName(request.getParameter("responsible_name"));
			establishment.setResponsibleEmail(request.getParameter("responsible_email"));
			establishment.setResponsiblePhone(request.getParameter("responsible_phone"));
			establishment.setUserLogin(request.getParameter("email"));
			establishment.setUserPassword(request.getParameter("password").toCharArray());			
			
			if(!Util.IsEmpty(request.getParameter("rate")))
				establishment.setRate(Integer.parseInt(request.getParameter("rate")));
			
			if(!Util.IsEmpty(request.getParameter("phone")))
				establishment.setPhone(request.getParameter("phone"));
			
			establishment = EstablishmentDao.Insert(establishment);
			
			
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
			out.print(jsonMain.put("establishment",EstablishmentJSON.GetEstablishmentJSON(establishment)));
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
			
	}
	
}
