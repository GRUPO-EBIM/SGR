package ebim.com.sgre.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Conf;

@Repository
public interface ConfRepositorio extends JpaRepository<Conf, Long>{
	
	@Query(value= "select * "+
			"from tb_conf ", nativeQuery=true)
	public Conf obtConf();
	
}
