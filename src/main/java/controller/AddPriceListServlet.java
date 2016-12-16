package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import dao.EstablishmentDao;
import dao.PriceListDao;
import dao.ProductDao;
import json.PriceListJSON;
import model.PriceList;

@WebServlet("/addPriceList")
public class AddPriceListServlet extends HttpServlet{ 
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{
			
			// price list
			PriceList priceList = new PriceList(); 
			priceList.setEstablishment(EstablishmentDao.GetEstablishmentsById(Long.parseLong(request.getParameter("establishment_id"))));
			priceList.setProduct(ProductDao.GetProductById(Long.parseLong(request.getParameter("product_id"))));
			priceList.setPrice(Double.parseDouble(request.getParameter("price")));
			priceList.setUnit(request.getParameter("unit"));
			PriceListDao.Insert(priceList);
	
			
			// response
			response.addHeader("Access-Control-Allow-Origin","*");
			response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
			response.addHeader("Access-Control-Max-Age","3600");
			response.addHeader("Access-Control-Allow-Headers","x-requested-with");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			
			JSONObject jsonMain = new JSONObject();
			PrintWriter out = response.getWriter();
			out.print(jsonMain.put("priceList",PriceListJSON.GetPriceListJSON(priceList)));
			
	
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
		
	}
}