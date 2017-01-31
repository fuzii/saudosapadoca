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

import dao.OrderDao;
import formatter.GenerateJSON;
import model.Order;

@WebServlet("/getOrder")
public class GetOrderServlet extends HttpServlet{ 
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			HttpSession session = request.getSession(true);
			//only account can insert orders
			if(session.isNew() || session.getAttribute("isAuthenticated") == null || !(Boolean)session.getAttribute("isAuthenticated")){
				// response nok
				response.addHeader("Access-Control-Allow-Origin","*");
				response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
				response.addHeader("Access-Control-Max-Age","3600");
				response.addHeader("Access-Control-Allow-Headers","x-requested-with");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}			
			// order
                        Order order = OrderDao.GetOrderByAccountId(Long.parseLong(session.getAttribute("account_id").toString()));
			
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
			out.print(jsonMain.put("order",GenerateJSON.GetOrderJSON(order)));
			// set session
                        if(String.valueOf(session.getAttribute("user_type")) != "establishment")
                            session.setAttribute("order", order);	
                        
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
