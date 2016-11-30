package util;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.AccountDao;
import dao.EstablishmentDao;
import model.Account;
import model.Address;
import model.Establishment;

public class Geolocation {

	public static int Distance(double lat1, double lon1, double lat2, double lon2){
		
		final int R = 6371; // Radius of the earth
		Double latDistance = Deg2rad(lat2 - lat1);
		Double lonDistance = Deg2rad(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Deg2rad(lat1)) * Math.cos(Deg2rad(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters
		
		Long distanceLong = Math.round(distance);
		return distanceLong.intValue();

	}
	
	private static double Deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	public static JSONObject GetEstablishmentsJSON (Address accountAddress){
		
		List<Address> addresses = EstablishmentDao.GetEstablishmentsAddressesByLocation(accountAddress);
		JSONArray jsonArrayEstablishment = new JSONArray();
		JSONObject jsonMain = null;
		
		try {

			for(Address a : addresses){

				Establishment establishment = EstablishmentDao.GetEstablishmentsById(a.getEstablishmentId());
				JSONObject jsonEstablishment = new JSONObject();
				
				// establishment
				jsonEstablishment.put("Id",establishment.getId());
				jsonEstablishment.put("Name",establishment.getName());
				jsonEstablishment.put("Alias",establishment.getAlias());
				jsonEstablishment.put("RegisterNumber",establishment.getRegisterNumber());

				// address
				JSONObject jsonAddress = new JSONObject();
				jsonAddress.put("Id",a.getId());
				jsonAddress.put("AccountId",a.getAccountId());
				jsonAddress.put("EstablishmentId",a.getEstablishmentId());
				jsonAddress.put("ZipCode",a.getZipCode());
				jsonAddress.put("Street",a.getStreet());
				jsonAddress.put("City",a.getCity());
				jsonAddress.put("State",a.getState());
				jsonAddress.put("Number;",a.getNumber()); 
				jsonAddress.put("Premise",a.getPremise());
				jsonAddress.put("Country",a.getCountry());
				jsonAddress.put("Latitude",a.getLatitude());
				jsonAddress.put("Longitude",a.getLongitude());
				jsonAddress.put("Radius",a.getRadius());

				jsonEstablishment.put("address", jsonAddress);
				jsonArrayEstablishment.put(jsonEstablishment);

			}

			JSONObject jsonEstablishments = new JSONObject();
			jsonEstablishments.put("establishment", jsonArrayEstablishment);

			jsonMain = new JSONObject();
			jsonMain.put("establishments", jsonEstablishments);


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonMain;

	}

	public static JSONObject GetAccountsJSON (Address establishmentAddress){
		
		List<Address> addresses = AccountDao.GetAccountsAddressesByLocation(establishmentAddress);
		JSONArray jsonArrayAccount = new JSONArray();
		JSONObject jsonMain = null;
		
		try {

			for(Address a : addresses){

				Account account = AccountDao.GetAccountsById(a.getAccountId());
				JSONObject jsonAccount = new JSONObject();
				
				// establishment
				jsonAccount.put("Id",account.getId());
				jsonAccount.put("Name",account.getName());
				jsonAccount.put("Email",account.getEmail());				
				
				// address
				JSONObject jsonAddress = new JSONObject();
				jsonAddress.put("Id",a.getId());
				jsonAddress.put("AccountId",a.getAccountId());
				jsonAddress.put("EstablishmentId",a.getEstablishmentId());
				jsonAddress.put("ZipCode",a.getZipCode());
				jsonAddress.put("Street",a.getStreet());
				jsonAddress.put("City",a.getCity());
				jsonAddress.put("State",a.getState());
				jsonAddress.put("Number;",a.getNumber()); 
				jsonAddress.put("Premise",a.getPremise());
				jsonAddress.put("Country",a.getCountry());
				jsonAddress.put("Latitude",a.getLatitude());
				jsonAddress.put("Longitude",a.getLongitude());
				jsonAddress.put("Radius",a.getRadius());
				
				jsonAccount.put("address", jsonAddress);
				jsonArrayAccount.put(jsonAccount);

			}

			JSONObject jsonAccounts = new JSONObject();
			jsonAccounts.put("account", jsonArrayAccount);

			jsonMain = new JSONObject();
			jsonMain.put("accounts", jsonAccounts);


		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonMain;

	}
	
}
