package ebim.com.sgre.servicio;

import ebim.com.sgre.modelo.Clie;

public interface ClieServicio {
	
	public Clie obtClie(Integer clie_id);
	public Clie obtenerCliexRUC(String clie_ruc);

}
