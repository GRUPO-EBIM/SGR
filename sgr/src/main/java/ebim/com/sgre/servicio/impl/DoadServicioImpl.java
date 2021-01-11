package ebim.com.sgre.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Doad;
import ebim.com.sgre.repositorio.DoadRepositorio;
import ebim.com.sgre.servicio.DoadServicio;

@Service
public class DoadServicioImpl implements DoadServicio{
	
	@Autowired
	private DoadRepositorio doadRepositorio;
	
	public Doad obtDoad(Integer doad_id) {
		return doadRepositorio.obtDoad(doad_id);
	}
	
	public Doad mantenerDoad(Doad Doad) {
		return doadRepositorio.save(Doad);
	}
	
	public void mantenerDoads(List<Doad> lstDoad) {
		doadRepositorio.saveAll(lstDoad);
	}
	
	public List<Doad> lstDoad(Integer requ_id, String tipo) {
		return doadRepositorio.lstDoad(requ_id, tipo);
	}
	
	public void eliminarDoad(Doad doad) {
		doadRepositorio.delete(doad);
	}
	
}
