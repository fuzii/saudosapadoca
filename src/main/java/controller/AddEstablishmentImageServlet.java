package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.cloudinary.Cloudinary;
import model.Establishment;
import dao.EstablishmentDao;

@WebServlet("/addEstablishmentImage")
public class AddEstablishmentImageServlet extends HttpServlet{
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try{
                    HttpSession session = request.getSession(true);
                    if(session.isNew()){
                        // response nok
                        response.addHeader("Access-Control-Allow-Origin","*");
                        response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
                        response.addHeader("Access-Control-Max-Age","3600");
                        response.addHeader("Access-Control-Allow-Headers","x-requested-with");
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        return;
                    }

                    Establishment establishment = (model.Establishment)session.getAttribute("establishment");
                    //update photo_url
                    if(request.getParameter("photo_url") != null)
                    {
                        establishment.setPhotoUrl(request.getParameter("photo_url"));
                        EstablishmentDao.Update(establishment);
                        
                        response.addHeader("Access-Control-Allow-Origin","*");
                        response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
                        response.addHeader("Access-Control-Max-Age","3600");
                        response.addHeader("Access-Control-Allow-Headers","x-requested-with");
                        response.setStatus(HttpServletResponse.SC_OK);
                        return;
                    }
                    else if(establishment.getPhotoUrl() == null || establishment.getPhotoUrl() == "")
                    {
                        establishment.setPhotoUrl("logo_photo_" + establishment.getId() + "_" + establishment.getName());
                    }
                    //set session
                    session.setAttribute("establishment", establishment);
                    
                    String timestamp = (new Long(System.currentTimeMillis() / 1000L)).toString();
                    Cloudinary cloudinary = new Cloudinary();
                    Map<String, Object> params = new HashMap<String, Object>();
                    String apiSecret = "yg8sXtz0L06J1ZpptMXf2rGteb4";

                    //params.put("callback", "http://localhost:8080/cloudinary_cors.html");
                    params.put("timestamp", timestamp);
                    if(establishment.getPhotoUrl().lastIndexOf('.') != -1)
                    {
                        params.put("public_id", establishment.getPhotoUrl().substring(establishment.getPhotoUrl().lastIndexOf('/')+1, establishment.getPhotoUrl().lastIndexOf('.')));
                    }
                    else {
                        params.put("public_id", establishment.getPhotoUrl());
                    }
                    //params.put("api_key", "134197474555447");
                    String signature = cloudinary.apiSignRequest(params, apiSecret);

                    // response
                    response.addHeader("Access-Control-Allow-Origin","*");
                    response.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");
                    response.addHeader("Access-Control-Max-Age","3600");
                    response.addHeader("Access-Control-Allow-Headers","x-requested-with");
                    response.setContentType("application/json");
                    response.setCharacterEncoding("utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);

                    JSONObject jsonMain = new JSONObject();
                    jsonMain.put("timestamp", params.get("timestamp"));
                    jsonMain.put("public_id", params.get("public_id"));
                    jsonMain.put("api_key", "134197474555447");
                    jsonMain.put("cloud_name", "hasuevmrn");
                    jsonMain.put("signature", signature);
                    PrintWriter out = response.getWriter();
                    out.print(jsonMain);
			
		} catch (Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}		
	}	
}