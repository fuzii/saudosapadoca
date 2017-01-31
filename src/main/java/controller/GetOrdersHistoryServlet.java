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
import java.util.ArrayList;
import java.util.List;
import model.Order;

@WebServlet("/getOrdersHistory")
public class GetOrdersHistoryServlet extends HttpServlet{ 
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
            List<Order> orders;
            if(String.valueOf(session.getAttribute("user_type")) != "establishment")
                 orders = OrderDao.GetOrdersByAccountId(Long.parseLong(session.getAttribute("account_id").toString()));
            else
                orders = OrderDao.GetOrdersByEstablishmentId(Long.parseLong(session.getAttribute("establishment_id").toString()));

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
            out.print(jsonMain.put("orders", GenerateJSON.GetListOrderJSON(orders)));
            // set session	

        } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
        }
    }
}
