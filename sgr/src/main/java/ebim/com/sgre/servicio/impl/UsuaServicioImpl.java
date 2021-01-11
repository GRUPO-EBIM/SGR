package ebim.com.sgre.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Usua;
import ebim.com.sgre.repositorio.UsuaRepositorio;
import ebim.com.sgre.servicio.UsuaServicio;

@Service
public class UsuaServicioImpl implements UsuaServicio{
	
	@Autowired
	private UsuaRepositorio usuaRepositorio;
	
	public Usua obtUsua(Integer usua_id) {
		return usuaRepositorio.obtUsua(usua_id);
	}
	
	public Usua validarUsuario(String usuario, String clave) {
		return usuaRepositorio.validarUsuario(usuario, clave);
	}
	
	public Usua mantenerUsua(Usua usua) {
		return usuaRepositorio.save(usua);
	}
	
	public Usua obtenerCoordinadorxFrente(Integer fren_id, Integer sfre_id, String clie_ruc) {
		return usuaRepositorio.obtenerCoordinadorxFrente(fren_id, sfre_id, clie_ruc);
	}

}
