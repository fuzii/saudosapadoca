package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import util.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.AccountDao;
import dao.EstablishmentDao;
import dao.SessionDao;
import dao.UserDao;
import formatter.GenerateJSON;
import model.User;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet{
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{ 
			
			// request
			User user = new User();
			user.setUserLogin(request.getParameter("login"));
			user.setUserPassword(request.getParameter("password").toCharArray());
			user = UserDao.Login(user); 
			
			HttpSession session = request.getSession(true);
			
			if(user.getUserId()!=null){
				
				// inicializa as variaveis de sessão
				Map<String,String> map = SessionDao.GetSessionParameters(user);
				
				for(String key: map.keySet())
					session.setAttribute(key, map.get(key));
				
				// response ok
				response.addHeader("Access-Control-Allow-Origin","*");
				response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
				response.addHeader("Access-Control-Max-Age","3600");
				response.addHeader("Access-Control-Allow-Headers","x-requested-with");
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				response.setStatus(HttpServletResponse.SC_OK);
				
				// response JSON
				String establishment_id = String.valueOf(session.getAttribute("establishment_id")); 
				String account_id = String.valueOf(session.getAttribute("account_id")); 
				JSONObject jsonMain = new JSONObject();
				PrintWriter out = response.getWriter();
				out.print(jsonMain.put("user",GenerateJSON.GetUserJSON(user)));
				if(!Util.IsEmpty(establishment_id))
					out.print(jsonMain.put("establishment",GenerateJSON.GetEstablishmentJSON(EstablishmentDao.GetEstablishmentsById(Long.parseLong(establishment_id)))));
				else
					out.print(jsonMain.put("account",GenerateJSON.GetAccountJSON(AccountDao.GetAccountsById(Long.parseLong(account_id)))));
				
				
			}else{
				
				// response nok
				response.addHeader("Access-Control-Allow-Origin","*");
				response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
				response.addHeader("Access-Control-Max-Age","3600");
				response.addHeader("Access-Control-Allow-Headers","x-requested-with");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
	

	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
			
	}
	
}
