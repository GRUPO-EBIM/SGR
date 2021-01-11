package ebim.com.sgre.servicio.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Requ;
import ebim.com.sgre.repositorio.RequRepositorio;
import ebim.com.sgre.servicio.RequServicio;

@Service
public class RequServicioImpl implements RequServicio{

	@Autowired
	private RequRepositorio requRepositorio;
	
	public Requ obtRequerimiento(Integer requ_id) {
		return requRepositorio.obtRequerimiento(requ_id);
	}
	
	public List<Map<String, Object>> obtenerMenuReq(Integer usua_id, Integer role_id) {
		if(role_id==3){
			return requRepositorio.obtenerMenuReqAnli(usua_id);
		}else{
			return requRepositorio.obtenerMenuReqCoor(usua_id);
		}
		
	}
	
	public List<Map<String, Object>> obtenerRequerimiento(Integer fren_id, Integer sfre_id, String clie_ruc, Integer role_id) {
		if(role_id==3){
			return requRepositorio.obtenerRequerimientoAnli(fren_id, sfre_id, clie_ruc);
		}else{
			return requRepositorio.obtenerRequerimientoCoor(fren_id, sfre_id, clie_ruc);
		}
	}
	
	public Requ mantenerRequ(Requ requ) {
		return requRepositorio.save(requ);
	}

}
