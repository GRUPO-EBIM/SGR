package ebim.com.sgre.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Usua;

@Repository
public interface UsuaRepositorio extends JpaRepository<Usua, Long>{
	
	@Query(value= "select * from tb_usua "+
			   "where cl_usua_id = :usua_id", nativeQuery=true)
	public Usua obtUsua(@Param("usua_id") Integer usua_id);
	
	@Query(value= "select * from tb_usua "+
			   "where cl_usua_usuario = :usuario "+
			   "and cl_usua_clave = :clave", nativeQuery=true)
	public Usua validarUsuario(@Param("usuario") String usuario, 
			@Param("clave") String clave);
	
	@Query(value= "select usua.* "+ 
			"from tb_usua usua "+ 
			"inner join tb_coor coor "+ 
			"on usua.cl_usua_id = coor.cl_coor_usua_id "+ 
			"where coor.cl_coor_clie_ruc = :clie_ruc "+ 
			"and coor.cl_coor_fren_id = :fren_id "+ 
			"and coor.cl_coor_sfre_id = :sfre_id", nativeQuery=true)
	public Usua obtenerCoordinadorxFrente(@Param("fren_id") Integer fren_id,
			@Param("sfre_id") Integer sfre_id,
			@Param("clie_ruc") String clie_ruc);
	
}
