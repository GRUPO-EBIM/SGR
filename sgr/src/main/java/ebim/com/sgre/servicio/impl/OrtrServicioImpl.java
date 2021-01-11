package ebim.com.sgre.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Ortr;
import ebim.com.sgre.repositorio.OrtrRepositorio;
import ebim.com.sgre.servicio.OrtrServicio;

@Service
public class OrtrServicioImpl implements OrtrServicio{
	
	@Autowired
	private OrtrRepositorio ortrRepositorio;
	
	public Ortr obtEsfu(Integer ortr_id) {
		return ortrRepositorio.obtOrtr(ortr_id);
	}
	
	public Ortr mantenerOrtr(Ortr ortr) {
		return ortrRepositorio.save(ortr);
	}
	
	public void mantenerOrtrs(List<Ortr> lstOrtr) {
		ortrRepositorio.saveAll(lstOrtr);
	}
	
}
