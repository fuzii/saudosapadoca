package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import model.Account;

@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// busca o writer
		PrintWriter out = response.getWriter();

		// buscando os parâmetros no request
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// monta um objeto account
		Account account = new Account();
		account.setName(name);
		account.setEmail(email);
		
		// salva account
		AccountDao.Insert(account);

		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Conta " + account.getName() + " adicionada com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}