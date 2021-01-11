package ebim.com.sgre.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ebim.com.sgre.constante.Constantes;
import ebim.com.sgre.modelo.Usua;
import ebim.com.sgre.servicio.UsuaServicio;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/usu")
public class UsuaRestControlador {
	
	@Autowired
	private UsuaServicio usuaServicio;
	
	@PostMapping("/verificarSesion")
	public Map<String, Object> verificarSesion(HttpSession session){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		
		String typeMsg = "";
		String message = "";
		
		try {
			if (session.getAttribute("usua")!=null) {
				typeMsg = Constantes.TYPE_MSG_SUCCESS;
			}else {
				typeMsg = Constantes.TYPE_MSG_ERROR;
			}
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;
			message = Constantes.msg_error_general;
		}
		
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
	@PostMapping("/mantenerUsuario")
	public Map<String, Object> mantenerUsuario(HttpSession session,
			@RequestBody String vsc_data){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		JsonObject jsonObject = new JsonParser().parse(vsc_data).getAsJsonObject();
		StringBuilder sbMsg = new StringBuilder();
		String typeMsg = "";
		String message = "";
		
		try {
			
			Integer doad_id = jsonObject.get("doad_id").getAsInt();
			
			Usua usua = new Usua();
			usuaServicio.mantenerUsua(usua);
			
			typeMsg = Constantes.TYPE_MSG_SUCCESS;
			sbMsg.append("Actualizado");
			
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;;
			sbMsg.append(Constantes.msg_error_general);
		}
		
		message = sbMsg.toString();
		
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
}
