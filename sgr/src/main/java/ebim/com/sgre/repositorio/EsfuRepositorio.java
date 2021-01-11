package ebim.com.sgre.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Esfu;

@Repository
public interface EsfuRepositorio extends JpaRepository<Esfu, Long>{
	
	@Query(value= "select * "+
			"from tb_esfu "+
			"where cl_esfu_id = :esfu_id", nativeQuery=true)
	public Esfu obtEsfu(@Param("esfu_id") Integer esfu_id);
	
}
