package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Util {

    public static boolean IsEmpty(String s) {
    	  
        return !(s != null && !s.isEmpty());
        
    }
    
    @SuppressWarnings("rawtypes")
	public static List IsEmptyList(List other) {
    
    	return other == null ? Collections.EMPTY_LIST : other;

    }
	
    public static String CalendarToString(Calendar calendar){
    	
    	SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		return calendar == null ? null : s.format(calendar.getTime());

    }
    
}
