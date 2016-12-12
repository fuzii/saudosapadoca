package json;

import org.json.JSONException;
import org.json.JSONObject;
import model.Address;

public class AddressJSON {
	
	public static JSONObject GetAddressJSON (Address address){
		
		JSONObject jsonAddress = null;
		
		try {

			// address
			jsonAddress = new JSONObject();
			jsonAddress.put("id",address.getId());
			jsonAddress.put("accountId",address.getAccountId());
			jsonAddress.put("establishmentId",address.getEstablishmentId());
			jsonAddress.put("zipCode",address.getZipCode());
			jsonAddress.put("street",address.getStreet());
			jsonAddress.put("city",address.getCity());
			jsonAddress.put("state",address.getState());
			jsonAddress.put("number;",address.getNumber()); 
			jsonAddress.put("premise",address.getPremise());
			jsonAddress.put("country",address.getCountry());
			jsonAddress.put("latitude",address.getLatitude());
			jsonAddress.put("longitude",address.getLongitude());
			jsonAddress.put("radius",address.getRadius());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonAddress;
	
	}
	
}
