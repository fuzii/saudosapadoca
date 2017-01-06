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
import dao.PriceListDao;
import formatter.GenerateJSON;
import formatter.GenerateObject;
import model.PriceList;

@WebServlet("/addPriceList")
public class AddPriceListServlet extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			HttpSession session = request.getSession(true);			

			if(session.isNew()){
				request.getRequestDispatcher("login.jsp").include(request, response); 
				return;
			}
			
			request.setAttribute("establishment_id", session.getAttribute("establishment_id"));
			
			
			// price list
			PriceList priceList = GenerateObject.GetPriceList(request);
			PriceListDao.Insert(priceList);
	
			
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
			out.print(jsonMain.put("priceList",GenerateJSON.GetPriceListJSON(priceList)));
			
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
