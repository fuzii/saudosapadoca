package util;

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

	
}
