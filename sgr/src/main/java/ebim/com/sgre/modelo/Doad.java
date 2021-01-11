package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_doad")
public class Doad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_doad_id;
	private Integer cl_doad_requ_id;
	private String cl_doad_version;
	private String cl_doad_uri;
	private String cl_doad_tipo;
	
	public Integer getCl_doad_id() {
		return cl_doad_id;
	}
	public void setCl_doad_id(Integer cl_doad_id) {
		this.cl_doad_id = cl_doad_id;
	}
	public Integer getCl_doad_requ_id() {
		return cl_doad_requ_id;
	}
	public void setCl_doad_requ_id(Integer cl_doad_requ_id) {
		this.cl_doad_requ_id = cl_doad_requ_id;
	}
	public String getCl_doad_version() {
		return cl_doad_version;
	}
	public void setCl_doad_version(String cl_doad_version) {
		this.cl_doad_version = cl_doad_version;
	}
	public String getCl_doad_uri() {
		return cl_doad_uri;
	}
	public void setCl_doad_uri(String cl_doad_uri) {
		this.cl_doad_uri = cl_doad_uri;
	}
	public String getCl_doad_tipo() {
		return cl_doad_tipo;
	}
	public void setCl_doad_tipo(String cl_doad_tipo) {
		this.cl_doad_tipo = cl_doad_tipo;
	}
}
