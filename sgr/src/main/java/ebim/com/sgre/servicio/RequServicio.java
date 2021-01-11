package ebim.com.sgre.servicio;

import java.util.List;
import java.util.Map;

import ebim.com.sgre.modelo.Requ;

public interface RequServicio {
	
	public Requ obtRequerimiento(Integer requ_id);
	public List<Map<String, Object>> obtenerMenuReq(Integer usua_id, Integer role_id);
	public List<Map<String, Object>> obtenerRequerimiento(Integer fren_id, Integer sfre_id, String clie_ruc, Integer role_id);
	public Requ mantenerRequ(Requ requ);
}
