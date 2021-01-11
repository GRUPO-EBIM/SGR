package ebim.com.sgre.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Esad;
import ebim.com.sgre.repositorio.EsadRepositorio;
import ebim.com.sgre.servicio.EsadServicio;

@Service
public class EsadServicioImpl implements EsadServicio{
	
	@Autowired
	private EsadRepositorio esadRepositorio;
	
	public Esad mantenerEsad(Esad esad) {
		return esadRepositorio.save(esad);
	}
	
	public List<Esad> lstEsad(Integer requ_id) {
		return esadRepositorio.lstEsad(requ_id);
	}

}
