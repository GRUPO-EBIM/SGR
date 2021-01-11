package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_coor")
public class Coor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_coor_id;
	private Integer cl_coor_usua_id;
	private String cl_coor_ruc;
	private Integer cl_coor_fren_id;
	private Integer cl_coor_sfre_id;
	
	public Integer getCl_coor_id() {
		return cl_coor_id;
	}
	public void setCl_coor_id(Integer cl_coor_id) {
		this.cl_coor_id = cl_coor_id;
	}
	public Integer getCl_coor_usua_id() {
		return cl_coor_usua_id;
	}
	public void setCl_coor_usua_id(Integer cl_coor_usua_id) {
		this.cl_coor_usua_id = cl_coor_usua_id;
	}
	public String getCl_coor_ruc() {
		return cl_coor_ruc;
	}
	public void setCl_coor_ruc(String cl_coor_ruc) {
		this.cl_coor_ruc = cl_coor_ruc;
	}
	public Integer getCl_coor_fren_id() {
		return cl_coor_fren_id;
	}
	public void setCl_coor_fren_id(Integer cl_coor_fren_id) {
		this.cl_coor_fren_id = cl_coor_fren_id;
	}
	public Integer getCl_coor_sfre_id() {
		return cl_coor_sfre_id;
	}
	public void setCl_coor_sfre_id(Integer cl_coor_sfre_id) {
		this.cl_coor_sfre_id = cl_coor_sfre_id;
	}
	
}
