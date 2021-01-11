package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_esfu")
public class Esfu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_esfu_id;
	private Integer cl_esfu_requ_id;
	private String cl_esfu_version;
	private String cl_esfu_uri;
	
	public Integer getCl_esfu_id() {
		return cl_esfu_id;
	}
	public void setCl_esfu_id(Integer cl_esfu_id) {
		this.cl_esfu_id = cl_esfu_id;
	}
	public Integer getCl_esfu_requ_id() {
		return cl_esfu_requ_id;
	}
	public void setCl_esfu_requ_id(Integer cl_esfu_requ_id) {
		this.cl_esfu_requ_id = cl_esfu_requ_id;
	}
	public String getCl_esfu_version() {
		return cl_esfu_version;
	}
	public void setCl_esfu_version(String cl_esfu_version) {
		this.cl_esfu_version = cl_esfu_version;
	}
	public String getCl_esfu_uri() {
		return cl_esfu_uri;
	}
	public void setCl_esfu_uri(String cl_esfu_uri) {
		this.cl_esfu_uri = cl_esfu_uri;
	}
	
}
