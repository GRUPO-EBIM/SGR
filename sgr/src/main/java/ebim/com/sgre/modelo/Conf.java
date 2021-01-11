package ebim.com.sgre.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_conf")
public class Conf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cl_conf_id;
	private Integer cl_conf_minidiasproy;
	
	public Integer getCl_conf_id() {
		return cl_conf_id;
	}
	public void setCl_conf_id(Integer cl_conf_id) {
		this.cl_conf_id = cl_conf_id;
	}
	public Integer getCl_conf_minidiasproy() {
		return cl_conf_minidiasproy;
	}
	public void setCl_conf_minidiasproy(Integer cl_conf_minidiasproy) {
		this.cl_conf_minidiasproy = cl_conf_minidiasproy;
	}
	
	
}
