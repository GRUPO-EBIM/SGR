package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_anli")
public class Anli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_anli_id;
	private Integer cl_anli_usua_id;
	private String cl_anli_clie_ruc;
	private Integer cl_anli_fren_id;
	private Integer cl_anli_sfre_id;
	
	public Integer getCl_anli_id() {
		return cl_anli_id;
	}
	public void setCl_anli_id(Integer cl_anli_id) {
		this.cl_anli_id = cl_anli_id;
	}
	public Integer getCl_anli_usua_id() {
		return cl_anli_usua_id;
	}
	public void setCl_anli_usua_id(Integer cl_anli_usua_id) {
		this.cl_anli_usua_id = cl_anli_usua_id;
	}
	public String getCl_anli_clie_ruc() {
		return cl_anli_clie_ruc;
	}
	public void setCl_anli_clie_ruc(String cl_anli_clie_ruc) {
		this.cl_anli_clie_ruc = cl_anli_clie_ruc;
	}
	public Integer getCl_anli_fren_id() {
		return cl_anli_fren_id;
	}
	public void setCl_anli_fren_id(Integer cl_anli_fren_id) {
		this.cl_anli_fren_id = cl_anli_fren_id;
	}
	public Integer getCl_anli_sfre_id() {
		return cl_anli_sfre_id;
	}
	public void setCl_anli_sfre_id(Integer cl_anli_sfre_id) {
		this.cl_anli_sfre_id = cl_anli_sfre_id;
	}  
	
}
