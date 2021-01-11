package ebim.com.sgre.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UtilTiempo {
	
	public static String convStrFechaAStrFecha(String strFecha, String fmt, String fmtInit) {
		String conv = "";
		if(!strFecha.equals("") && strFecha!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat(fmt, new Locale("ES", "PE"));
			Date fecha = convStrFechaAFecha(strFecha, fmtInit);
			if(fecha!=null){
				conv = sdf.format(fecha);
			}
		}
		return conv;
	}
	
	public static Date convStrFechaAFecha(String strFecha, String fmt){		
		Date fecha = null;
		if(!strFecha.equals("") && strFecha!=null) {
			try{
				SimpleDateFormat sdf = new SimpleDateFormat(fmt); 
				fecha = sdf.parse(strFecha);
			}catch(ParseException e){
				System.out.println(e.toString());
			}
		}
		return fecha;
	}
	
	public static String convFechaAStrFecha(Date fecha, String fmt){
		String conv = "";
		SimpleDateFormat sdf = new SimpleDateFormat(fmt, new Locale("ES", "PE"));
		if(fecha!=null){
			conv = sdf.format(fecha);
		}
		return conv;
	}
	
	public static Date sumarDiasAFecha(Date fecha, int dias){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}
	
}
