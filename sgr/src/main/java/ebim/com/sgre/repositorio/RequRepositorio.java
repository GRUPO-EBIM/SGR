package ebim.com.sgre.repositorio;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ebim.com.sgre.modelo.Requ;

@Repository
public interface RequRepositorio extends JpaRepository<Requ, Long>{
	
	@Query(value= "select * "+
			"from tb_requ "+
			"where cl_requ_id = :requ_id", nativeQuery=true)
	public Requ obtRequerimiento(@Param("requ_id") Integer requ_id);
	
	@Query(value= "select fren.cl_fren_id,"+ 
			"fren.cl_fren_nombre,"+ 
			"sfre.cl_sfre_id,"+ 
			"sfre.cl_sfre_nombre,"+
			"clie.cl_clie_id,"+
			"clie.cl_clie_ruc,"+
			"clie.cl_clie_codigo,"+
			"clie.cl_clie_razonsoc,"+
			"(select count(cl_requ_id) from tb_requ requ "+
			"where requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
			"and requ.cl_requ_flagleido = 'A') as cl_requ_c_clie,"+
			"(select count(cl_requ_id) from tb_requ requ "+
		    "where requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
		    "and requ.cl_requ_fren_id = fren.cl_fren_id "+
		    "and requ.cl_requ_flagleido = 'A') as cl_requ_c_fren,"+
			"(select count(cl_requ_id) from tb_requ requ "+
		    "where requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
		    "and requ.cl_requ_fren_id = fren.cl_fren_id "+
		    "and requ.cl_requ_sfre_id = sfre.cl_sfre_id "+
		    "and requ.cl_requ_flagleido = 'A') as cl_requ_c_sfre "+
			"from tb_anli anli "+ 
			"inner join tb_usua usua "+ 
			"on anli.cl_anli_usua_id = usua.cl_usua_id "+ 
			"inner join tb_fren fren "+ 
			"on anli.cl_anli_fren_id = fren.cl_fren_id "+ 
			"inner join tb_sfre sfre "+ 
			"on anli.cl_anli_sfre_id = sfre.cl_sfre_id "+
			"inner join tb_clie clie "+
			"on anli.cl_anli_clie_ruc = clie.cl_clie_ruc "+
			"where anli.cl_anli_usua_id = :usua_id "+
			"order by fren.cl_fren_id", nativeQuery=true)
	public List<Map<String, Object>> obtenerMenuReqAnli(@Param("usua_id") Integer usua_id);
	
	@Query(value= "select fren.cl_fren_id,"+ 
			"fren.cl_fren_nombre,"+ 
			"sfre.cl_sfre_id,"+ 
			"sfre.cl_sfre_nombre,"+
			"clie.cl_clie_id,"+
			"clie.cl_clie_ruc,"+
			"clie.cl_clie_codigo,"+
			"clie.cl_clie_razonsoc,"+
			"(select count(cl_requ_id) from tb_requ requ "+
			"where requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
			"and requ.cl_requ_flagleido = 'C') as cl_requ_c_clie,"+
			"(select count(cl_requ_id) from tb_requ requ "+
			"where requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
			"and requ.cl_requ_fren_id = fren.cl_fren_id "+
			"and requ.cl_requ_flagleido = 'C') as cl_requ_c_fren,"+
			"(select count(cl_requ_id) from tb_requ requ "+
			"where requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
			"and requ.cl_requ_fren_id = fren.cl_fren_id "+
			"and requ.cl_requ_sfre_id = sfre.cl_sfre_id "+
			"and requ.cl_requ_flagleido = 'C') as cl_requ_c_sfre "+
			"from tb_coor coor "+ 
			"inner join tb_usua usua "+ 
			"on coor.cl_coor_usua_id = usua.cl_usua_id "+ 
			"inner join tb_fren fren "+
			"on coor.cl_coor_fren_id = fren.cl_fren_id "+ 
			"inner join tb_sfre sfre "+ 
			"on coor.cl_coor_sfre_id = sfre.cl_sfre_id "+
			"inner join tb_clie clie "+
			"on coor.cl_coor_clie_ruc = clie.cl_clie_ruc "+
			"where coor.cl_coor_usua_id = :usua_id "+
			"order by fren.cl_fren_id", nativeQuery=true)
	public List<Map<String, Object>> obtenerMenuReqCoor(@Param("usua_id") Integer usua_id);
	
	@Query(value= "select requ.*, "+
			"clie.* "+
			"from tb_requ requ "+
			"inner join tb_clie clie "+
			"on requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
			"where requ.cl_requ_clie_ruc = :clie_ruc "+
			"and requ.cl_requ_fren_id = :fren_id "+
			"and requ.cl_requ_sfre_id = :sfre_id "+
			"and requ.cl_requ_estado = 'X' "+
			"order by requ.cl_requ_flagleido asc",nativeQuery=true)
	public List<Map<String, Object>> obtenerRequerimientoAnli(@Param("fren_id") Integer fren_id,
			@Param("sfre_id") Integer sfre_id,
			@Param("clie_ruc") String clie_ruc);
	
	@Query(value= "select requ.*, "+
			"clie.* "+
			"from tb_requ requ "+
			"inner join tb_clie clie "+
			"on requ.cl_requ_clie_ruc = clie.cl_clie_ruc "+
			"where requ.cl_requ_clie_ruc = :clie_ruc "+
			"and requ.cl_requ_fren_id = :fren_id "+
			"and requ.cl_requ_sfre_id = :sfre_id "+
			"and requ.cl_requ_estado = 'X' "+
			"and requ.cl_requ_estadoreq <> 'Guardado' "+
			"order by requ.cl_requ_flagleido asc",nativeQuery=true)
	public List<Map<String, Object>> obtenerRequerimientoCoor(@Param("fren_id") Integer fren_id,
			@Param("sfre_id") Integer sfre_id,
			@Param("clie_ruc") String clie_ruc);
	
}
