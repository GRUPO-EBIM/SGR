package ebim.com.sgre.servicio;

import java.util.List;

import ebim.com.sgre.modelo.Ortr;

public interface OrtrServicio {
	
	public Ortr obtEsfu(Integer ortr_id);
	public Ortr mantenerOrtr(Ortr ortr);
	public void mantenerOrtrs(List<Ortr> lstOrtr);
}
