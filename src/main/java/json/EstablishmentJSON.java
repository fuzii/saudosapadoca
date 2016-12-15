package json;

import org.json.JSONException;
import org.json.JSONObject;
import model.Establishment;

public class EstablishmentJSON {
	
	public static JSONObject GetEstablishmentJSON (Establishment establishment){
		
		
		JSONObject jsonEstablishment = null;
				
		try {

			// establishment
			jsonEstablishment = new JSONObject();			
			jsonEstablishment.put("id",establishment.getId());
			jsonEstablishment.put("name",establishment.getName());
			jsonEstablishment.put("alias",establishment.getAlias());
			jsonEstablishment.put("email",establishment.getEmail());
			jsonEstablishment.put("registerNumber",establishment.getRegisterNumber());
			jsonEstablishment.put("phone",establishment.getPhone());
			jsonEstablishment.put("radius",establishment.getRadius());
			jsonEstablishment.put("responsibleName",establishment.getResponsibleName());
			jsonEstablishment.put("responsibleEmail",establishment.getResponsibleEmail());
			jsonEstablishment.put("responsiblePhone",establishment.getResponsiblePhone());
			jsonEstablishment.put("rate",establishment.getRate());
			jsonEstablishment.put("created",establishment.getCreated());
			

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonEstablishment;
	
	}
	
}