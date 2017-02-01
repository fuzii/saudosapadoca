package controller;

import formatter.GenerateJSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;


@WebServlet("/getAccounts") 
public class GetAccountsServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            HttpSession session = request.getSession(true);
            if(session.isNew() || session.getAttribute("isAuthenticated") == null || !(Boolean)session.getAttribute("isAuthenticated")){
                    // response nok
                    response.addHeader("Access-Control-Allow-Origin","*");
                    response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
                    response.addHeader("Access-Control-Max-Age","3600");
                    response.addHeader("Access-Control-Allow-Headers","x-requested-with");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
            }
            List<Account> accounts = new ArrayList<Account>();
            if(String.valueOf(session.getAttribute("user_type")) == "establishment")
            {
                if(request.getParameter("account_id") != null)
                {
                    accounts.add(dao.AccountDao.GetAccountById(Long.parseLong(request.getParameter("account_id"))));
                }
                else 
                {
                    accounts = dao.AccountDao.GetAccountsByEstablishmentId(Long.parseLong(session.getAttribute("establishment_id").toString()));
                }
            }

            // response
            PrintWriter out = response.getWriter();
            out.print(GenerateJSON.GetAccountsJSON(accounts).toString());

	}
	
}
