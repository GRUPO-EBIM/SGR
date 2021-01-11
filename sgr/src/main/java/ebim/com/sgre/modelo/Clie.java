package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_clie")
public class Clie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_clie_id;
	private String cl_clie_ruc;
	private String cl_clie_razonsoc;
	private String cl_clie_direccion;
	
	public Integer getCl_clie_id() {
		return cl_clie_id;
	}
	public void setCl_clie_id(Integer cl_clie_id) {
		this.cl_clie_id = cl_clie_id;
	}
	public String getCl_clie_ruc() {
		return cl_clie_ruc;
	}
	public void setCl_clie_ruc(String cl_clie_ruc) {
		this.cl_clie_ruc = cl_clie_ruc;
	}
	public String getCl_clie_razonsoc() {
		return cl_clie_razonsoc;
	}
	public void setCl_clie_razonsoc(String cl_clie_razonsoc) {
		this.cl_clie_razonsoc = cl_clie_razonsoc;
	}
	public String getCl_clie_direccion() {
		return cl_clie_direccion;
	}
	public void setCl_clie_direccion(String cl_clie_direccion) {
		this.cl_clie_direccion = cl_clie_direccion;
	}
	
	
}