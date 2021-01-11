package ebim.com.sgre.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_requ")
public class Requ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_requ_id;
	private Integer cl_requ_usua_id;
	private String cl_requ_clie_ruc;
	private String cl_requ_codigo;
	private String cl_requ_titulo;
	private String cl_requ_detalle;
	private Integer cl_requ_fren_id;
	private Integer cl_requ_sfre_id;
	private String cl_requ_espfunuri;
	private String cl_requ_dfturi;
	private String cl_requ_espfunuricoo;
	private String cl_requ_tipo;
	private Date cl_requ_fechainicio;
	private Date cl_requ_fechafin;
	private Integer cl_requ_numeroest;
	private String cl_requ_unidadest;
	private String cl_requ_flagleido;
	private String cl_requ_estadoreq;
	private String cl_requ_estado;
	private String cl_requ_usuacrea;
	private Date cl_requ_fechacrea;
	private String cl_requ_usuamodi;
	private Date cl_requ_fechamodi;
	
	public Integer getCl_requ_id() {
		return cl_requ_id;
	}
	public void setCl_requ_id(Integer cl_requ_id) {
		this.cl_requ_id = cl_requ_id;
	}
	public Integer getCl_requ_usua_id() {
		return cl_requ_usua_id;
	}
	public void setCl_requ_usua_id(Integer cl_requ_usua_id) {
		this.cl_requ_usua_id = cl_requ_usua_id;
	}
	public String getCl_requ_clie_ruc() {
		return cl_requ_clie_ruc;
	}
	public void setCl_requ_clie_ruc(String cl_requ_clie_ruc) {
		this.cl_requ_clie_ruc = cl_requ_clie_ruc;
	}
	public String getCl_requ_codigo() {
		return cl_requ_codigo;
	}
	public void setCl_requ_codigo(String cl_requ_codigo) {
		this.cl_requ_codigo = cl_requ_codigo;
	}
	public String getCl_requ_titulo() {
		return cl_requ_titulo;
	}
	public void setCl_requ_titulo(String cl_requ_titulo) {
		this.cl_requ_titulo = cl_requ_titulo;
	}
	public String getCl_requ_detalle() {
		return cl_requ_detalle;
	}
	public void setCl_requ_detalle(String cl_requ_detalle) {
		this.cl_requ_detalle = cl_requ_detalle;
	}
	public Integer getCl_requ_fren_id() {
		return cl_requ_fren_id;
	}
	public void setCl_requ_fren_id(Integer cl_requ_fren_id) {
		this.cl_requ_fren_id = cl_requ_fren_id;
	}
	public Integer getCl_requ_sfre_id() {
		return cl_requ_sfre_id;
	}
	public void setCl_requ_sfre_id(Integer cl_requ_sfre_id) {
		this.cl_requ_sfre_id = cl_requ_sfre_id;
	}
	public String getCl_requ_espfunuri() {
		return cl_requ_espfunuri;
	}
	public void setCl_requ_espfunuri(String cl_requ_espfunuri) {
		this.cl_requ_espfunuri = cl_requ_espfunuri;
	}
	public String getCl_requ_dfturi() {
		return cl_requ_dfturi;
	}
	public void setCl_requ_dfturi(String cl_requ_dfturi) {
		this.cl_requ_dfturi = cl_requ_dfturi;
	}
	public String getCl_requ_espfunuricoo() {
		return cl_requ_espfunuricoo;
	}
	public void setCl_requ_espfunuricoo(String cl_requ_espfunuricoo) {
		this.cl_requ_espfunuricoo = cl_requ_espfunuricoo;
	}
	public String getCl_requ_tipo() {
		return cl_requ_tipo;
	}
	public void setCl_requ_tipo(String cl_requ_tipo) {
		this.cl_requ_tipo = cl_requ_tipo;
	}
	public Date getCl_requ_fechainicio() {
		return cl_requ_fechainicio;
	}
	public void setCl_requ_fechainicio(Date cl_requ_fechainicio) {
		this.cl_requ_fechainicio = cl_requ_fechainicio;
	}
	public Date getCl_requ_fechafin() {
		return cl_requ_fechafin;
	}
	public void setCl_requ_fechafin(Date cl_requ_fechafin) {
		this.cl_requ_fechafin = cl_requ_fechafin;
	}
	public Integer getCl_requ_numeroest() {
		return cl_requ_numeroest;
	}
	public void setCl_requ_numeroest(Integer cl_requ_numeroest) {
		this.cl_requ_numeroest = cl_requ_numeroest;
	}
	public String getCl_requ_unidadest() {
		return cl_requ_unidadest;
	}
	public void setCl_requ_unidadest(String cl_requ_unidadest) {
		this.cl_requ_unidadest = cl_requ_unidadest;
	}
	public String getCl_requ_flagleido() {
		return cl_requ_flagleido;
	}
	public void setCl_requ_flagleido(String cl_requ_flagleido) {
		this.cl_requ_flagleido = cl_requ_flagleido;
	}
	public String getCl_requ_estadoreq() {
		return cl_requ_estadoreq;
	}
	public void setCl_requ_estadoreq(String cl_requ_estadoreq) {
		this.cl_requ_estadoreq = cl_requ_estadoreq;
	}
	public String getCl_requ_estado() {
		return cl_requ_estado;
	}
	public void setCl_requ_estado(String cl_requ_estado) {
		this.cl_requ_estado = cl_requ_estado;
	}
	public String getCl_requ_usuacrea() {
		return cl_requ_usuacrea;
	}
	public void setCl_requ_usuacrea(String cl_requ_usuacrea) {
		this.cl_requ_usuacrea = cl_requ_usuacrea;
	}
	public Date getCl_requ_fechacrea() {
		return cl_requ_fechacrea;
	}
	public void setCl_requ_fechacrea(Date cl_requ_fechacrea) {
		this.cl_requ_fechacrea = cl_requ_fechacrea;
	}
	public String getCl_requ_usuamodi() {
		return cl_requ_usuamodi;
	}
	public void setCl_requ_usuamodi(String cl_requ_usuamodi) {
		this.cl_requ_usuamodi = cl_requ_usuamodi;
	}
	public Date getCl_requ_fechamodi() {
		return cl_requ_fechamodi;
	}
	public void setCl_requ_fechamodi(Date cl_requ_fechamodi) {
		this.cl_requ_fechamodi = cl_requ_fechamodi;
	}
	
}
