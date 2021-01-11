package ebim.com.sgre.servicio;

import ebim.com.sgre.modelo.Usua;

public interface UsuaServicio {
	
	public Usua obtUsua(Integer usua_id);
	public Usua validarUsuario(String usuario, String clave);
	public Usua mantenerUsua(Usua usua);
	public Usua obtenerCoordinadorxFrente(Integer fren_id, Integer sfre_id, String clie_ruc);
	
}
