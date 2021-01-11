package ebim.com.sgre.servicio;

import java.util.List;

import ebim.com.sgre.modelo.Doad;

public interface DoadServicio {
	
	public Doad obtDoad(Integer doad_id);
	public Doad mantenerDoad(Doad Doad);
	public void mantenerDoads(List<Doad> lstDoad);
	public List<Doad> lstDoad(Integer requ_id, String tipo);
	public void eliminarDoad(Doad doad);
}
