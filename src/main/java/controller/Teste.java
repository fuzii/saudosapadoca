package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import dao.EstablishmentDao;
import model.Address;
import model.Establishment;

@WebServlet("/Teste")
public class Teste extends HttpServlet{
	
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    	InputStream is = new URL(url).openStream();
    	try {
    		BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
    		String jsonText = readAll(rd);
    		JSONObject json = new JSONObject(jsonText);
    		return json;
    	} finally {
    		is.close();
    	}
    }
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	String client_id = "W4FHVCUFSIWDKKO4AS5VZ322DU1BMYNZMYCRAGCTKWXD5NTW";
    	String client_secret = "UEZ2AWYSHAICCL4IGYPFOA3C511VW2UG4XCYZFHH0RLV1KIQ";
    	String latitude = "-23.549649";
    	String longitude = "-46.6562226";
    	
    	String url = "https://api.foursquare.com/v2/venues/search?client_id=" + client_id + "&client_secret=" + client_secret + "&ll=" + latitude + "," + longitude + "&radius=1000&section=food&query=padaria&v=20161123";

    	JSONObject json;
		try {
			json = readJsonFromUrl(url);

			// response
			PrintWriter out = response.getWriter();
			out.println(json.toString());
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	
	}
}
