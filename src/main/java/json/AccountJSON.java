package json;

import org.json.JSONException;
import org.json.JSONObject;
import model.Account;

public class AccountJSON {
	
	public static JSONObject GetAccountJSON (Account account){
		
		
		JSONObject jsonAccount = null;
				
		try {

			// account
			jsonAccount = new JSONObject();			
			jsonAccount.put("id",account.getId());
			jsonAccount.put("name",account.getName());
			jsonAccount.put("email",account.getEmail());
			jsonAccount.put("phone",account.getPhone());
			jsonAccount.put("created",account.getCreated());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonAccount;
	
	}
	
}