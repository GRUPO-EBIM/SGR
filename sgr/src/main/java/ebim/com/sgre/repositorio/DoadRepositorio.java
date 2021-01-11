package ebim.com.sgre.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Doad;

@Repository
public interface DoadRepositorio extends JpaRepository<Doad, Long>{
	
	@Query(value= "select * "+
			"from tb_doad "+
			"where cl_doad_id = :doad_id", nativeQuery=true)
	public Doad obtDoad(@Param("doad_id") Integer doad_id);
	
	@Query(value= "select * "+
			"from tb_doad "+
			"where cl_doad_requ_id = :requ_id "+
			"and cl_doad_tipo = :tipo", nativeQuery=true)
	public List<Doad> lstDoad(@Param("requ_id") Integer requ_id,
			@Param("tipo") String tipo);
	
}
