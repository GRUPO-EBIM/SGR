package ebim.com.sgre.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ebim.com.sgre.constante.Constantes;
import ebim.com.sgre.modelo.Usua;
import ebim.com.sgre.servicio.UsuaServicio;
import ebim.com.sgre.util.UtilCampo;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuaControlador {
	
	@Autowired
	private UsuaServicio usuaServicio;
	
	@GetMapping({"/login","/"})
	public String login(Model model){
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session,
			Model model,
			@RequestParam("usuario") String usuario,
			@RequestParam("clave") String clave){
		
		StringBuilder sbmsg = new StringBuilder();
		String url = "login";
		String t_message = "";
		String v_message = "";
		Usua usua = usuaServicio.validarUsuario(usuario, UtilCampo.cadenaEncoderBase64(clave));
		
		if(usua!=null){
			t_message = Constantes.TYPE_MSG_SUCCESS;
			session.setAttribute("usua", usua);
			session.setAttribute("rol", usua.getCl_usua_role_id());
			url = "redirect:/requerimiento";
		}else{
			t_message = Constantes.TYPE_MSG_ERROR;
			sbmsg.append("Usuario o clave incorrecta");
		}
		
		v_message = sbmsg.toString();
		
		model.addAttribute("t_message", t_message);
		model.addAttribute("v_message", v_message);
		
		return url;
	}
	
	@GetMapping("/requerimiento")
	public String requerimiento(HttpSession session,
			Model model){
		if (session.getAttribute("usua")!=null) {
			Usua usuaSesion = (Usua)session.getAttribute("usua");
			
			model.addAttribute("usua", usuaSesion);
			return "requerimiento";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		if (session.getAttribute("usua")!=null) {
			session.invalidate();
			return "redirect:/login";
		}
		return "redirect:/login";
	}
}
