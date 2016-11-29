package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class Foursquare{
	
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }
    
	public static JSONObject GetFoursquareJSON (String latitude, String longitude) throws IOException {

    	String url = "https://api.foursquare.com/v2/venues/search?client_id=" + System.getenv("FOURSQUARE_CLIENT_ID") + "&client_secret=" + System.getenv("FOURSQUARE_CLIENT_SECRET") + "&ll=" + latitude + "," + longitude + "&radius=100&section=food&query=padaria&v=20161123";
    	InputStream is = null;
    	JSONObject json = null;
    	
		try {

			is = new URL(url).openStream();
   			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
       		String jsonText = readAll(rd);
       		json = new JSONObject(jsonText);
			
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
    		is.close();
    	}
		
		return json;
    	
	}
	
}
