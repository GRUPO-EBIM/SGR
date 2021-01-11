package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_fren")
public class Fren {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_fren_id;
	private String cl_fren_nombre;
	
	public Integer getCl_fren_id() {
		return cl_fren_id;
	}
	public void setCl_fren_id(Integer cl_fren_id) {
		this.cl_fren_id = cl_fren_id;
	}
	public String getCl_fren_nombre() {
		return cl_fren_nombre;
	}
	public void setCl_fren_nombre(String cl_fren_nombre) {
		this.cl_fren_nombre = cl_fren_nombre;
	}
	
}
