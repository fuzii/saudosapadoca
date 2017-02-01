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

import dao.OrderItemDao;
import formatter.GenerateJSON;
import model.OrderItem;

@WebServlet("/getOrderItem")
public class GetOrderItemServlet extends HttpServlet{ 
	 
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
                        if(request.getParameter("id") == null) {
                            return;
                            
                        }
                        // order
                        OrderItem orderItem = OrderItemDao.GetOrderItemById(Long.parseLong(request.getParameter("id")));
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
			out.print(jsonMain.put("orderItem",GenerateJSON.GetOrderItemJSON(orderItem)));	
                        
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}
