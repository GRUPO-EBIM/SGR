package ebim.com.sgre.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_usua")
public class Usua {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_usua_id;
	private String cl_usua_usuario;
	private String cl_usua_clave;
	private String cl_usua_nombre;
	private String cl_usua_email;
	private String cl_usua_celular;
	private Date cl_usua_fechanac;
	private Integer cl_usua_role_id;
	private String cl_usua_estado;
	private String cl_usua_usuacrea;
	private Date cl_usua_fechacrea;
	private String cl_usua_usuamodi;
	private Date cl_usua_fechamodi;
	
	public Integer getCl_usua_id() {
		return cl_usua_id;
	}
	public void setCl_usua_id(Integer cl_usua_id) {
		this.cl_usua_id = cl_usua_id;
	}
	public String getCl_usua_usuario() {
		return cl_usua_usuario;
	}
	public void setCl_usua_usuario(String cl_usua_usuario) {
		this.cl_usua_usuario = cl_usua_usuario;
	}
	public String getCl_usua_clave() {
		return cl_usua_clave;
	}
	public void setCl_usua_clave(String cl_usua_clave) {
		this.cl_usua_clave = cl_usua_clave;
	}
	public String getCl_usua_nombre() {
		return cl_usua_nombre;
	}
	public void setCl_usua_nombre(String cl_usua_nombre) {
		this.cl_usua_nombre = cl_usua_nombre;
	}
	public String getCl_usua_email() {
		return cl_usua_email;
	}
	public void setCl_usua_email(String cl_usua_email) {
		this.cl_usua_email = cl_usua_email;
	}
	public String getCl_usua_celular() {
		return cl_usua_celular;
	}
	public void setCl_usua_celular(String cl_usua_celular) {
		this.cl_usua_celular = cl_usua_celular;
	}
	public Date getCl_usua_fechanac() {
		return cl_usua_fechanac;
	}
	public void setCl_usua_fechanac(Date cl_usua_fechanac) {
		this.cl_usua_fechanac = cl_usua_fechanac;
	}
	public Integer getCl_usua_role_id() {
		return cl_usua_role_id;
	}
	public void setCl_usua_role_id(Integer cl_usua_role_id) {
		this.cl_usua_role_id = cl_usua_role_id;
	}
	public String getCl_usua_estado() {
		return cl_usua_estado;
	}
	public void setCl_usua_estado(String cl_usua_estado) {
		this.cl_usua_estado = cl_usua_estado;
	}
	public String getCl_usua_usuacrea() {
		return cl_usua_usuacrea;
	}
	public void setCl_usua_usuacrea(String cl_usua_usuacrea) {
		this.cl_usua_usuacrea = cl_usua_usuacrea;
	}
	public Date getCl_usua_fechacrea() {
		return cl_usua_fechacrea;
	}
	public void setCl_usua_fechacrea(Date cl_usua_fechacrea) {
		this.cl_usua_fechacrea = cl_usua_fechacrea;
	}
	public String getCl_usua_usuamodi() {
		return cl_usua_usuamodi;
	}
	public void setCl_usua_usuamodi(String cl_usua_usuamodi) {
		this.cl_usua_usuamodi = cl_usua_usuamodi;
	}
	public Date getCl_usua_fechamodi() {
		return cl_usua_fechamodi;
	}
	public void setCl_usua_fechamodi(Date cl_usua_fechamodi) {
		this.cl_usua_fechamodi = cl_usua_fechamodi;
	}
	
}
