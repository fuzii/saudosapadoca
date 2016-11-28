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
import util.SendGridEmail;

@WebServlet("/addAccount")
public class AddAccountServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		Account account = new Account();
		account.setName(request.getParameter("name"));
		account.setEmail(request.getParameter("email"));
		AccountDao.Insert(account);

		// send confirmation mail
		String from = "contato@saudosapadoca.com.br";
		String subject = "[Saudosa Padoca] - Confirmacao de cadastro";
		String content = "Obrigado por se cadastrar no...";
		String to = account.getEmail();
		SendGridEmail.Send(from, to, subject, content);

		// response		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Conta " + account.getName() + " adicionada com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}