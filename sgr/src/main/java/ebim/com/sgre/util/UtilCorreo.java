package ebim.com.sgre.util;

public class UtilCorreo {
	
	public static String obtenerCabeceraCorreoHtml(String titulo) {
		String texto = "";
		StringBuilder sbMsg = new StringBuilder();
		sbMsg.append("<!DOCTYPE html>");
		sbMsg.append("<html>");
		sbMsg.append("<head><meta charset=\"utf-8\">");
		sbMsg.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"></head>");
		sbMsg.append("<body style=\"font-family:arial !important; font-size:12px\">");
		sbMsg.append("<section style=\"max-width:480px; margin:auto\">");
		sbMsg.append("<div style=\"width:100%; height:75px; ");
		sbMsg.append("background-image:url('https://lh3.google.com/u/0/d/1c_ZdlQmJyaiSB3yUnhKbmEfJkTXIGtgp=w1366-h625-iv1'); ");
		sbMsg.append("background-size:100% 100%\">");
		sbMsg.append("<label style=\"width:35%; height:75%;  margin:5% 5% 0px 0px; float:right\"><H2>");
		sbMsg.append(titulo);
		sbMsg.append("</H2></label>");
		sbMsg.append("</div>");
		texto = sbMsg.toString();
		return texto;
	}
	
	public static String obtenerPiePaginaCorreoHtml() {
		String texto = "";
		StringBuilder sbMsg = new StringBuilder();
		sbMsg.append("</section><footer style=\"max-width:480px; margin:auto\">");
		sbMsg.append("<div style=\"width:100%; height:50px\">");
		sbMsg.append("<a href=\"https://www.facebook.com/ebimtech/\"");
		sbMsg.append("<img src=\"https://lh3.google.com/u/0/d/1A7Ma9YtvOIU1Q6SgozxLbzd6oVQV4YDC=w868-h625-iv1\" ");
		sbMsg.append("style=\"width:34px; height:34px; margin:8px 4px; float:right\">");
		sbMsg.append("</a>");
		/*sbMsg.append("<img src=\"https://lh3.google.com/u/0/d/1KQEQKhNXqe27kbo7PfV5Y0gfGpkjxAi9=w868-h625-iv1\" ");
		sbMsg.append("style=\"width:34px; height:34px; margin:8px 4px; float:right\">");
		sbMsg.append("<img src=\"https://lh3.google.com/u/0/d/1ZlSXfU8LIvOw5a4-W8IyUP9ZeFeUJD5c=w868-h625-iv1\" ");
		sbMsg.append("style=\"width:34px; height:34px; margin:8px 4px; float:right\">");*/
		sbMsg.append("</div>");
		sbMsg.append("<div style=\"width:100%; height:50px; color:#fff; ");
		sbMsg.append("background-image:url('https://i2.wp.com/www.circulomarisqueria.com/wp-content/uploads/2014/12/RECTANGULO-AZUL.jpg?ssl=1'); ");
		sbMsg.append("background-size:100% 100%\">");
		sbMsg.append("<div style=\"height:auto; padding:15px 10px\">Todos los derechos reservados</div></div>");
		sbMsg.append("</footer></body>");
		sbMsg.append("</html>");
		texto = sbMsg.toString();
		return texto;
	}
	
	public static String mensajeHtmlRequerimiento(
			String coordinador,
			String funcional,
			String razonsoc,
			String requ_nombre,
			String logo) {
		
		String texto = "";
		
		StringBuilder sbMsg = new StringBuilder();
		
		//sbMsg.append(obtenerCabeceraCorreoHtml(logo));
		sbMsg.append("<div style=\"margin:5px\">");
		sbMsg.append("<p align=\"justify\"><h3><strong>Estimado ");
		sbMsg.append(coordinador);
		sbMsg.append(",</strong></h3></p>");
		sbMsg.append("<p align=\"justify\">El funcional ");
		sbMsg.append(funcional);
		sbMsg.append(" de la empresa ");
		sbMsg.append(razonsoc);
		sbMsg.append(" ha enviado el requerimiento ");
		sbMsg.append(requ_nombre);
		sbMsg.append(" para su respectiva estimación.</p><p align=\"justify\">");
		sbMsg.append("Atentamente,<br>");
		sbMsg.append(logo);
		sbMsg.append("</p><p align=\"justify\">");
		sbMsg.append("---------------------------------------</p>");
		sbMsg.append("</div>");
		//sbMsg.append(obtenerPiePaginaCorreoHtml());
		
		texto = sbMsg.toString();
		
		return texto;
	}
	
	public static String mensajeHtmlEstimacion(
			String funcional,
			String coordinador,
			String razonsoc,
			String requ_nombre,
			String coor_celular,
			String logo) {
		
		String texto = "";
		
		StringBuilder sbMsg = new StringBuilder();
		
		//sbMsg.append(obtenerCabeceraCorreoHtml(logo));
		sbMsg.append("<div style=\"margin:5px\">");
		sbMsg.append("<p align=\"justify\"><h3><strong>Estimado ");
		sbMsg.append(funcional);
		sbMsg.append(",</strong></h3></p>");
		sbMsg.append("<p align=\"justify\"> El coordinador ");
		sbMsg.append(coordinador);
		sbMsg.append(" de GRUPO EBIM, ha enviado su estimación y respectiva documentación adjunta del requerimiento ");
		sbMsg.append(requ_nombre);
		sbMsg.append(" para su respectiva aprobación.</p><p align=\"justify\">");
		sbMsg.append("<p align=\"justify\"> Num. de contacto del coordinador: ");
		sbMsg.append(coor_celular);
		sbMsg.append(".</p><p align=\"justify\">");
		sbMsg.append("Atentamente,<br>");
		sbMsg.append(logo);
		sbMsg.append("</p><p align=\"justify\">");
		sbMsg.append("---------------------------------------</p>");
		sbMsg.append("</div>");
		//sbMsg.append(obtenerPiePaginaCorreoHtml());
		
		texto = sbMsg.toString();
		
		return texto;
	}
	
	public static String mensajeHtmlAprobacion(
			String coordinador,
			String funcional,
			String razonsoc,
			String requ_nombre,
			String logo) {
		
		String texto = "";
		
		StringBuilder sbMsg = new StringBuilder();
		
		//sbMsg.append(obtenerCabeceraCorreoHtml(logo));
		sbMsg.append("<div style=\"margin:5px\">");
		sbMsg.append("<p align=\"justify\"><h3><strong>Estimado ");
		sbMsg.append(coordinador);
		sbMsg.append(",</strong></h3></p>");
		sbMsg.append("<p align=\"justify\">El funcional ");
		sbMsg.append(funcional);
		sbMsg.append(" de la empresa ");
		sbMsg.append(razonsoc);
		sbMsg.append(" ha aprobado el requerimiento ");
		sbMsg.append(requ_nombre);
		sbMsg.append(" para su respectiva ejecución.</p><p align=\"justify\">");
		sbMsg.append("Atentamente,<br>");
		sbMsg.append(logo);
		sbMsg.append("</p><p align=\"justify\">");
		sbMsg.append("---------------------------------------</p>");
		sbMsg.append("</div>");
		//sbMsg.append(obtenerPiePaginaCorreoHtml());
		
		texto = sbMsg.toString();
		
		return texto;
	}

	
}
