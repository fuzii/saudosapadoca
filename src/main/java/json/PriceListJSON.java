package json;

import org.json.JSONException;
import org.json.JSONObject;
import model.PriceList;

public class PriceListJSON {
	
	public static JSONObject GetPriceListJSON (PriceList priceList){
		
		
		JSONObject jsonPriceList = null;
				
		try {

			// priceList
			jsonPriceList = new JSONObject();			
			jsonPriceList.put("id",priceList.getId());
			jsonPriceList.put("establishmentId",priceList.getEstablishment().getId());
			jsonPriceList.put("productId",priceList.getProduct().getId());
			jsonPriceList.put("price",priceList.getPrice());
			jsonPriceList.put("unit",priceList.getUnit());

			
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonPriceList;
	
	}
	
}