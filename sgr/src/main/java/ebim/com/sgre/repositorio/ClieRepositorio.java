package ebim.com.sgre.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Clie;

@Repository
public interface ClieRepositorio extends JpaRepository<Clie, Long> {
	
	@Query(value= "select * from tb_clie "+
			   "where cl_clie_id = :clie_id", nativeQuery=true)
	public Clie obtClie(@Param("clie_id") Integer clie_id);
	
	@Query(value= "select * from tb_clie "+
			   "where cl_clie_ruc = :clie_ruc", nativeQuery=true)
	public Clie obtenerCliexRUC(@Param("clie_ruc") String clie_ruc);
}
