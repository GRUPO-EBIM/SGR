package ebim.com.sgre.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Ortr;

@Repository
public interface OrtrRepositorio extends JpaRepository<Ortr, Long>{
	
	@Query(value= "select * "+
			"from tb_ortr "+
			"where cl_ortr_id = :ortr_id", nativeQuery=true)
	public Ortr obtOrtr(@Param("ortr_id") Integer ortr_id);
}
