package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.SendGridEmail;

@WebServlet("/sendGrid")
public class SendGridServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// request
		String from = request.getParameter("from");
		String subject = request.getParameter("subject");
		String to = request.getParameter("to");
		String content = request.getParameter("content");
		SendGridEmail.Send(from, to, subject, content);

		// response
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Email enviado com sucesso");
		out.println("</body>");
		out.println("</html>");
		
	}
}