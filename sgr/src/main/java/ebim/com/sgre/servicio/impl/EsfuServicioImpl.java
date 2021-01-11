package ebim.com.sgre.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Esfu;
import ebim.com.sgre.repositorio.EsfuRepositorio;
import ebim.com.sgre.servicio.EsfuServicio;

@Service
public class EsfuServicioImpl implements EsfuServicio{
	
	@Autowired
	private EsfuRepositorio esfuRepositorio;
	
	public Esfu obtEsfu(Integer esfu_id) {
		return esfuRepositorio.obtEsfu(esfu_id);
	}
	
	public Esfu mantenerEsfu(Esfu esfu) {
		return esfuRepositorio.save(esfu);
	}
	
	public void mantenerEsfus(List<Esfu> lstEsfu) {
		esfuRepositorio.saveAll(lstEsfu);
	}
	
	
}
