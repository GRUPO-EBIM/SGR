package ebim.com.sgre.servicio;

import java.io.File;
import java.util.List;

public interface EmailServicio {
	
	public void enviarMensajeCorreo(
			String de,
			String para,
			String asunto,
			String texto);
	
	public void enviarMensajeCorreoAdjunto(
			String de,
			String para, 
			String asunto, 
			String texto,
			File adjunto);
	
	public void enviarMensajeCorreoVariosAdjunto(
			String de,
			String para, 
			String asunto, 
			String texto,
			List<String> lstNFile);
}
