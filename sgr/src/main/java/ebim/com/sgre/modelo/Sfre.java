package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_sfre")
public class Sfre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_sfre_id;
	private Integer cl_sfre_fren_id;
	private String cl_sfre_nombre;
	
	public Integer getCl_sfre_id() {
		return cl_sfre_id;
	}
	public void setCl_sfre_id(Integer cl_sfre_id) {
		this.cl_sfre_id = cl_sfre_id;
	}
	public Integer getCl_sfre_fren_id() {
		return cl_sfre_fren_id;
	}
	public void setCl_sfre_fren_id(Integer cl_sfre_fren_id) {
		this.cl_sfre_fren_id = cl_sfre_fren_id;
	}
	public String getCl_sfre_nombre() {
		return cl_sfre_nombre;
	}
	public void setCl_sfre_nombre(String cl_sfre_nombre) {
		this.cl_sfre_nombre = cl_sfre_nombre;
	}
	
	
}
