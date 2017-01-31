package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout") 
public class LogoutServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try { 
            HttpSession session = request.getSession(true);
            
            if (session != null)
                session.invalidate();

            // response ok
            response.addHeader("Access-Control-Allow-Origin","*");
            response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
            response.addHeader("Access-Control-Max-Age","3600");
            response.addHeader("Access-Control-Allow-Headers","x-requested-with");
            response.setStatus(HttpServletResponse.SC_OK);
            
            response.sendRedirect("/home.jsp");
        }
        catch (Exception e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
        }	
    }	
}
