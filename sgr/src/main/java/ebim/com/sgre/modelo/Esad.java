package ebim.com.sgre.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_esad")
public class Esad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_esad_id;
	private Integer cl_esad_requ_id;
	private String cl_esad_estadoreq;
	private String cl_esad_estado;
	private String cl_esad_usuacrea;
	private Date cl_esad_fechacrea;
	private String cl_esad_usuamodi;
	private Date cl_esad_fechamodi;
	
	public Integer getCl_esad_id() {
		return cl_esad_id;
	}
	public void setCl_esad_id(Integer cl_esad_id) {
		this.cl_esad_id = cl_esad_id;
	}
	public Integer getCl_esad_requ_id() {
		return cl_esad_requ_id;
	}
	public void setCl_esad_requ_id(Integer cl_esad_requ_id) {
		this.cl_esad_requ_id = cl_esad_requ_id;
	}
	public String getCl_esad_estadoreq() {
		return cl_esad_estadoreq;
	}
	public void setCl_esad_estadoreq(String cl_esad_estadoreq) {
		this.cl_esad_estadoreq = cl_esad_estadoreq;
	}
	public String getCl_esad_estado() {
		return cl_esad_estado;
	}
	public void setCl_esad_estado(String cl_esad_estado) {
		this.cl_esad_estado = cl_esad_estado;
	}
	public String getCl_esad_usuacrea() {
		return cl_esad_usuacrea;
	}
	public void setCl_esad_usuacrea(String cl_esad_usuacrea) {
		this.cl_esad_usuacrea = cl_esad_usuacrea;
	}
	public Date getCl_esad_fechacrea() {
		return cl_esad_fechacrea;
	}
	public void setCl_esad_fechacrea(Date cl_esad_fechacrea) {
		this.cl_esad_fechacrea = cl_esad_fechacrea;
	}
	public String getCl_esad_usuamodi() {
		return cl_esad_usuamodi;
	}
	public void setCl_esad_usuamodi(String cl_esad_usuamodi) {
		this.cl_esad_usuamodi = cl_esad_usuamodi;
	}
	public Date getCl_esad_fechamodi() {
		return cl_esad_fechamodi;
	}
	public void setCl_esad_fechamodi(Date cl_esad_fechamodi) {
		this.cl_esad_fechamodi = cl_esad_fechamodi;
	}

}
