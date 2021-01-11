package ebim.com.sgre.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Obse;
import ebim.com.sgre.repositorio.ObseRepositorio;
import ebim.com.sgre.servicio.ObseServicio;

@Service
public class ObseServicioImpl implements ObseServicio{
	
	@Autowired
	private ObseRepositorio obseRepositorio;
	
	public Obse mantenerEsad(Obse esad) {
		return obseRepositorio.save(esad);
	}
	
	public List<Obse> lstObse(Integer requ_id) {
		return obseRepositorio.lstObse(requ_id);
	}

}
