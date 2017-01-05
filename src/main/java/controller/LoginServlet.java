package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import model.User;

@WebServlet("/login") 
public class LoginServlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		User user = new User();
		user.setUserLogin(request.getParameter("login"));
		user.setUserPassword(request.getParameter("password").toCharArray());
		
		// response
		PrintWriter out = response.getWriter();
		
		if(UserDao.Login(user)){
			Cookie loginCookie = new Cookie("user", user.getUserLogin());
			loginCookie.setMaxAge(30*60); //setting cookie to expiry in 30 mins
			response.addCookie(loginCookie);
			out.println("sucesso");
		}else{
			out.println("não logou");
		}
		
	}
	
}
