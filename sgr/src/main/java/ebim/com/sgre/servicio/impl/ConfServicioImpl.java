package ebim.com.sgre.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebim.com.sgre.modelo.Conf;
import ebim.com.sgre.repositorio.ConfRepositorio;
import ebim.com.sgre.servicio.ConfServicio;

@Service
public class ConfServicioImpl implements ConfServicio{
	
	@Autowired
	private ConfRepositorio confRepositorio;
	
	public Conf obtConf() {
		return confRepositorio.obtConf();
	}

}
