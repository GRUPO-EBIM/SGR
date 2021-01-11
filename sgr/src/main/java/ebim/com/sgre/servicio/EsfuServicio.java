package ebim.com.sgre.servicio;

import java.util.List;

import ebim.com.sgre.modelo.Esfu;

public interface EsfuServicio {
	
	public Esfu obtEsfu(Integer esfu_id);
	public Esfu mantenerEsfu(Esfu esfu);
	public void mantenerEsfus(List<Esfu> lstEsfu);
}
