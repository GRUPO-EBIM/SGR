package ebim.com.sgre.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Esad;

@Repository
public interface EsadRepositorio extends JpaRepository<Esad, Long>{
	
	@Query(value= "select * "+
			"from tb_esad "+
			"where cl_esad_requ_id = :requ_id "+
			"order by cl_esad_id desc", nativeQuery=true)
	public List<Esad> lstEsad(@Param("requ_id") Integer requ_id);
	
}
