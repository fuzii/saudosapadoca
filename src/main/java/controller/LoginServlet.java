	package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.SessionDao;
import dao.UserDao;
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
				response.setStatus(HttpServletResponse.SC_OK);
				
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
