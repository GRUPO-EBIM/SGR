package ebim.com.sgre.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_obse")
public class Obse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_obse_id;
	private Integer cl_obse_requ_id;
	private String cl_obse_observacion;
	private String cl_obse_flagleido;
	private String cl_obse_estadoreq;
	private String cl_obse_estado;
	private String cl_obse_usuacrea;
	private Date cl_obse_fechacrea;
	private String cl_obse_usuamodi;
	private Date cl_obse_fechamodi;
	
	public Integer getCl_obse_id() {
		return cl_obse_id;
	}
	public void setCl_obse_id(Integer cl_obse_id) {
		this.cl_obse_id = cl_obse_id;
	}
	public Integer getCl_obse_requ_id() {
		return cl_obse_requ_id;
	}
	public void setCl_obse_requ_id(Integer cl_obse_requ_id) {
		this.cl_obse_requ_id = cl_obse_requ_id;
	}
	public String getCl_obse_observacion() {
		return cl_obse_observacion;
	}
	public void setCl_obse_observacion(String cl_obse_observacion) {
		this.cl_obse_observacion = cl_obse_observacion;
	}
	public String getCl_obse_flagleido() {
		return cl_obse_flagleido;
	}
	public void setCl_obse_flagleido(String cl_obse_flagleido) {
		this.cl_obse_flagleido = cl_obse_flagleido;
	}
	public String getCl_obse_estadoreq() {
		return cl_obse_estadoreq;
	}
	public void setCl_obse_estadoreq(String cl_obse_estadoreq) {
		this.cl_obse_estadoreq = cl_obse_estadoreq;
	}
	public String getCl_obse_estado() {
		return cl_obse_estado;
	}
	public void setCl_obse_estado(String cl_obse_estado) {
		this.cl_obse_estado = cl_obse_estado;
	}
	public String getCl_obse_usuacrea() {
		return cl_obse_usuacrea;
	}
	public void setCl_obse_usuacrea(String cl_obse_usuacrea) {
		this.cl_obse_usuacrea = cl_obse_usuacrea;
	}
	public Date getCl_obse_fechacrea() {
		return cl_obse_fechacrea;
	}
	public void setCl_obse_fechacrea(Date cl_obse_fechacrea) {
		this.cl_obse_fechacrea = cl_obse_fechacrea;
	}
	public String getCl_obse_usuamodi() {
		return cl_obse_usuamodi;
	}
	public void setCl_obse_usuamodi(String cl_obse_usuamodi) {
		this.cl_obse_usuamodi = cl_obse_usuamodi;
	}
	public Date getCl_obse_fechamodi() {
		return cl_obse_fechamodi;
	}
	public void setCl_obse_fechamodi(Date cl_obse_fechamodi) {
		this.cl_obse_fechamodi = cl_obse_fechamodi;
	}
	
}
