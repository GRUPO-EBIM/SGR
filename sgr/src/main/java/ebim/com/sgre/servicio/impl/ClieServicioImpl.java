package ebim.com.sgre.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Clie;
import ebim.com.sgre.repositorio.ClieRepositorio;
import ebim.com.sgre.servicio.ClieServicio;

@Service
public class ClieServicioImpl implements ClieServicio{
	
	@Autowired
	private ClieRepositorio clieRepositorio;
	
	public Clie obtClie(Integer clie_id) {
		return clieRepositorio.obtClie(clie_id);
	}
	
	public Clie obtenerCliexRUC(String clie_ruc) {
		return clieRepositorio.obtenerCliexRUC(clie_ruc);
	}
	
	
}
