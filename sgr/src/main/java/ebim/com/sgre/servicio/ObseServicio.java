package ebim.com.sgre.servicio;

import java.util.List;

import ebim.com.sgre.modelo.Obse;

public interface ObseServicio {
	
	public Obse mantenerEsad(Obse esad);
	public List<Obse> lstObse(Integer requ_id);
	
}
