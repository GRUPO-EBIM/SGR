package ebim.com.sgre.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

public class UtilCampo {
	
	public static String editarCampoBusq(String campo) {
		String campobusq = "";
		StringBuilder sb = new StringBuilder();
		
		sb.append("%");
		sb.append(campo);
		sb.append("%");
		campobusq= sb.toString();
		
		return campobusq;
	}
	
	
	public static Integer convertirStringAInteger(String cadena) {
		Integer entero = null;
		if(!cadena.equals("") && cadena!=null) {
			entero = Integer.parseInt(cadena);
		}
		return entero;
	}
	
	public static Double convertirStringADouble(String cadena) {
		Double numero = 0.0;
		if(!cadena.equals("") && cadena!=null) {
			numero = Double.parseDouble(cadena);
		}
		return numero;
	}
	
	public static String generarString(Random rng, String characters, int length){
	    char[] text = new char[length];
	    
	    for (int i=0;i<length;i++){
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	public static String correlativoStrTOStr(String cadena) {
		String cor = "";
		if(!cadena.equals("") && cadena!=null) {
			Long lon = null;
			try {
				lon = Long.parseLong(cadena);
				lon = lon+1;
				cor = String.valueOf(lon);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return cor;
	}
	
	public static String formatoStrMoneda(Double numero){
		String mon ="0.00"; 
		if(numero!=null){
			DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
		    simbolo.setDecimalSeparator('.');
		    simbolo.setGroupingSeparator(',');
			DecimalFormat formato = new DecimalFormat("###,###.00",simbolo);
			mon = formato.format(numero);
		}
		return mon;
	}
	
	public static Double formatearDecimales(Double numero, Integer numeroDecimales) {
	    return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}
	
	public static String cadenaEncoderBase64(String cadena){
		String strEncoder =""; 
		if(cadena!=null && !cadena.equals("")){
			strEncoder = DatatypeConverter.printBase64Binary(cadena.getBytes());
		}
		return strEncoder;
	}
	
	public static String cadenaDecoderBase64(String cadena){
		String strDecoder =""; 
		if(cadena!=null && !cadena.equals("")){
			strDecoder = new String(DatatypeConverter.parseBase64Binary(cadena));
		}
		return strDecoder;
	}
	
}
