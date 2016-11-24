package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import model.Account;
import model.Address;

@WebServlet("/getAccount")
public class GetAccountServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		List<Account> accounts = new ArrayList<Account>();
		String param = request.getParameter("param");
		String value = request.getParameter("value");
	
		if(param!=null && param!="")
			accounts = AccountDao.GetAccountsByParameter(param, value);
		else
			accounts = AccountDao.GetAccounts();
		
		// response
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		for(Account account : accounts){
			
			out.println("<br/>Account<br/>");
			out.print("Id:"+account.getId()+";");
			out.print("Name:"+account.getName()+";");
			out.print("Email:"+account.getEmail()+";");
			
			for(Address address : account.getAddress()){
				out.println("<br/>Address<br/>");
				out.print("AccountId:"+address.getAccountId()+";");
				out.print("ZipCode:"+address.getZipCode()+";");
				out.print("Street:"+address.getStreet()+";");
				out.print("City:"+address.getCity()+";");
				out.print("State:"+address.getState()+";");
				out.print("Number:"+address.getNumber()+";");
				out.print("Premise:"+address.getPremise()+";");
				out.print("Country:"+address.getCountry()+";");
				out.print("Latitude:"+address.getLatitude()+";");
				out.print("Longitude:"+address.getLongitude()+";<br/>");
			}
			out.println("<br/>");
			
		}
		
		
		out.println("</body>");
		out.println("</html>");
	}
}