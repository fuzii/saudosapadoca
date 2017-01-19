package controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.AccountDao;
import dao.AddressDao;
import dao.EstablishmentDao;
import dao.PriceListDao;
import dao.ScheduleDao;
import dao.SessionDao;
import dao.UserDao;
import model.Account;
import model.Establishment;
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
				
				// init session ids
				Map<String,String> map = SessionDao.GetSessionParameters(user);
				for(String key: map.keySet())
					session.setAttribute(key, map.get(key));

				// establishment session
				if(String.valueOf(session.getAttribute("user_type"))=="establishment"){
					Establishment establishment = EstablishmentDao.GetEstablishmentsById(Long.parseLong(String.valueOf(session.getAttribute("establishment_id")))); 
					session.setAttribute("isAuthenticated", true);
					session.setAttribute("establishment", establishment);
					session.setAttribute("schedule", ScheduleDao.GetSchedulesByEstablishment(establishment));
					session.setAttribute("priceList", PriceListDao.GetPriceListByEstablishment(establishment).get(0));
					session.setAttribute("address", AddressDao.GetAddressByEstablishment(establishment));
				// account session
				}else{
					Account account = AccountDao.GetAccountsById(Long.parseLong(String.valueOf(session.getAttribute("account_id"))));
					session.setAttribute("account", account);
					session.setAttribute("address", AddressDao.GetAddressesByAccount(account));
				}
				
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
