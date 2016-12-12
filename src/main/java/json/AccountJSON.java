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
			jsonAccount.put("Id",account.getId());
			jsonAccount.put("Name",account.getName());
			jsonAccount.put("Email",account.getEmail());
			jsonAccount.put("Phone",account.getPhone());
			jsonAccount.put("Created",account.getCreated());


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonAccount;
	
	}
	
}