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
import org.json.JSONObject;
import com.cloudinary.Cloudinary;

@WebServlet("/addEstablishmentImage")
public class AddEstablishmentImageServlet extends HttpServlet{
	 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try{      
			
            String timestamp = (new Long(System.currentTimeMillis() / 1000L)).toString();
            Cloudinary cloudinary = new Cloudinary();
            Map<String, Object> params = new HashMap<String, Object>();
            String apiSecret = "yg8sXtz0L06J1ZpptMXf2rGteb4";
            
            //params.put("callback", "http://localhost:8080/cloudinary_cors.html");
            params.put("timestamp", timestamp);
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
