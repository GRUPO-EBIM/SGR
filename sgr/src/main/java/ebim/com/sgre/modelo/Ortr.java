package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_fren")
public class Ortr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_ortr_id;
	private Integer cl_ortr_requ_id;
	private String cl_ortr_nombre;
	
	public Integer getCl_ortr_id() {
		return cl_ortr_id;
	}
	public void setCl_ortr_id(Integer cl_ortr_id) {
		this.cl_ortr_id = cl_ortr_id;
	}
	public Integer getCl_ortr_requ_id() {
		return cl_ortr_requ_id;
	}
	public void setCl_ortr_requ_id(Integer cl_ortr_requ_id) {
		this.cl_ortr_requ_id = cl_ortr_requ_id;
	}
	public String getCl_ortr_nombre() {
		return cl_ortr_nombre;
	}
	public void setCl_ortr_nombre(String cl_ortr_nombre) {
		this.cl_ortr_nombre = cl_ortr_nombre;
	}

}
