package ebim.com.sgre.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Obse;

@Repository
public interface ObseRepositorio extends JpaRepository<Obse, Long>{
	
	@Query(value= "select * "+
			"from tb_obse "+
			"where cl_obse_requ_id = :requ_id "+
			"order by cl_obse_id desc", nativeQuery=true)
	public List<Obse> lstObse(@Param("requ_id") Integer requ_id);

}
