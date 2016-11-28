package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstablishmentDao;
import model.Establishment;

@WebServlet("/addEstablishment")
public class AddEstablishmentServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		// request
		Establishment establishment = new Establishment();		
		establishment.setName(request.getParameter("name"));
		establishment.setAlias(request.getParameter("alias"));
		establishment.setRegisterNumber(Long.parseLong(request.getParameter("registerNumber")));
		EstablishmentDao.Insert(establishment);

		// response
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Empresa adicionada com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}