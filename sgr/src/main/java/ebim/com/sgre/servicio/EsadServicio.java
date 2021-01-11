package ebim.com.sgre.servicio;

import java.util.List;

import ebim.com.sgre.modelo.Esad;

public interface EsadServicio {
	
	public Esad mantenerEsad(Esad esad);
	public List<Esad> lstEsad(Integer requ_id);
	
}
