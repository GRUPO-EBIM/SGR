package ebim.com.sgre.rest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ebim.com.sgre.constante.Constantes;
import ebim.com.sgre.modelo.Clie;
import ebim.com.sgre.modelo.Conf;
import ebim.com.sgre.modelo.Doad;
import ebim.com.sgre.modelo.Esad;
import ebim.com.sgre.modelo.Obse;
import ebim.com.sgre.modelo.Requ;
import ebim.com.sgre.modelo.Usua;
import ebim.com.sgre.servicio.ClieServicio;
import ebim.com.sgre.servicio.ConfServicio;
import ebim.com.sgre.servicio.DoadServicio;
import ebim.com.sgre.servicio.EmailServicio;
import ebim.com.sgre.servicio.EsadServicio;
import ebim.com.sgre.servicio.ObseServicio;
import ebim.com.sgre.servicio.RequServicio;
import ebim.com.sgre.servicio.UsuaServicio;
import ebim.com.sgre.util.UtilCorreo;
import ebim.com.sgre.util.UtilTiempo;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/req")
public class RequRestControlador {
	
	@Autowired
	private UsuaServicio usuaServicio;
	
	@Autowired
	private RequServicio requServicio;
	
	@Autowired
	private ClieServicio clieServicio;
	
	@Autowired
	private EmailServicio emailServicio;
	
	@Autowired
	private DoadServicio doadServicio;
	
	@Autowired
	private EsadServicio esadServicio;
	
	@Autowired
	private ObseServicio obseServicio;
	
	@Autowired
	private ConfServicio confServicio;
	
	@PostMapping("/listarFrente")
	public Map<String, Object> listarFrente(HttpSession session){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		
		Usua usuaSesion = (Usua)session.getAttribute("usua");
		
		String typeMsg = "";
		String message = "";
		
		List<Map<String, Object>> lstFrenteMenu  = new ArrayList<Map<String,Object>>();
		
		try {
			lstFrenteMenu = requServicio.obtenerMenuReq(usuaSesion.getCl_usua_id(),usuaSesion.getCl_usua_role_id());
			typeMsg = Constantes.TYPE_MSG_SUCCESS;
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;
			message = Constantes.msg_error_general;
		}
		
		rpta.put("lstFrenteMenu", lstFrenteMenu);
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
	@PostMapping("/listarRequerimiento")
	public Map<String, Object> listarRequerimiento(HttpSession session,
			@RequestBody String vsc_data){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		JsonObject jsonObject = new JsonParser().parse(vsc_data).getAsJsonObject();
		
		Usua usuaSesion = (Usua)session.getAttribute("usua");
		Integer fren_id = jsonObject.get("fren_id").getAsInt();
		Integer sfre_id = jsonObject.get("sfre_id").getAsInt();
		String clie_ruc = jsonObject.get("clie_ruc").getAsString();
		
		String typeMsg = "";
		String message = "";
		
		List<Map<String, Object>> lstRequAux  = new ArrayList<Map<String,Object>>();
		List<Map<String, Object>> lstRequ  = new ArrayList<Map<String,Object>>();
		
		try {
			lstRequAux = requServicio.obtenerRequerimiento(fren_id, sfre_id, clie_ruc, usuaSesion.getCl_usua_role_id());
			for(int i=0;i<lstRequAux.size();i++){
				List<Doad> lstDoad = new ArrayList<Doad>();
				List<Doad> lstDoadCoo = new ArrayList<Doad>();
				List<Esad> lstEsad = new ArrayList<Esad>();
				List<Obse> lstObse = new ArrayList<Obse>();
				Map<String, Object> requObjAux = new HashMap<String, Object>();
				
				Map<String, Object> requObj = lstRequAux.get(i);
				lstDoad = doadServicio.lstDoad((Integer)requObj.get("cl_requ_id"),"A");
				lstDoadCoo = doadServicio.lstDoad((Integer)requObj.get("cl_requ_id"),"C");
				lstEsad = esadServicio.lstEsad((Integer)requObj.get("cl_requ_id"));
				lstObse = obseServicio.lstObse((Integer)requObj.get("cl_requ_id"));
				
				requObjAux.put("lstDoad", lstDoad);
				requObjAux.put("lstDoadCoo", lstDoadCoo);
				requObjAux.put("lstEsad", lstEsad);
				requObjAux.put("lstObse", lstObse);
				requObjAux.putAll(requObj);
				lstRequ.add(requObjAux);
			}
			
			typeMsg = Constantes.TYPE_MSG_SUCCESS;
			
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;
			message = Constantes.msg_error_general;
		}
		
		rpta.put("lstRequ", lstRequ);
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
	@PostMapping("/mantenerRequerimiento")
	public Map<String, Object> mantenerRequerimiento(HttpSession session,
			@RequestParam("data") String vsc_data, 
			@RequestParam(value="requ_espfunuri",required=false) MultipartFile espfunuriFile,
			@RequestParam(value="requ_dfturi",required=false) MultipartFile dfturiFile,
			@RequestParam(value="requ_espfunuricoo",required=false) MultipartFile espfunuricooFile,
			@RequestParam(value="requ_docadiuri",required=false) MultipartFile[] lstDocadiuriFile,
			@RequestParam(value="requ_docadiuricoo",required=false) MultipartFile[] lstDocadiuricooFile){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		JsonObject jsonObject = new JsonParser().parse(vsc_data).getAsJsonObject();
		StringBuilder sbMsg = new StringBuilder();
		String typeMsg = "";
		String message = "";
		String instruc = "";
		Boolean flag = true;
		
		try {
			Usua usuaSesion = (Usua)session.getAttribute("usua");
			Integer id_role = usuaSesion.getCl_usua_role_id();
			
			String indicador = jsonObject.get("indicador").getAsString();
			Integer requ_id = jsonObject.get("cl_requ_id").getAsInt();
			String clie_ruc = jsonObject.get("cl_clie_ruc").getAsString();
			String clie_codigo = jsonObject.get("cl_clie_codigo").getAsString();
        	Integer fren_id = jsonObject.get("cl_fren_id").getAsInt();
        	String fren_nombre = jsonObject.get("cl_fren_nombre").getAsString();
        	Integer sfre_id = jsonObject.get("cl_sfre_id").getAsInt();
        	String sfre_nombre = jsonObject.get("cl_sfre_nombre").getAsString();
        	String obse_observacion = jsonObject.get("cl_obse_observacion").getAsString();
        	
        	String requ_espfunuri = "";
        	String requ_dfturi = "";
        	String requ_espfunuricoo = "";
        	String requ_docadiuri = "";
        	String requ_docadiuricoo = "";
        	String requ_codigo = "";
        			
        	String sufijo = UtilTiempo.convFechaAStrFecha(new Date(), Constantes.DATE_SUFIJO);
        	String urictx = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\adjsgr\\";
        	//String urictx = "C:\\data\\sgr\\";
        	
        	List<String> lstNfiles = new ArrayList<String>();
        	
        	Requ requ = new Requ();
			requ = requServicio.obtRequerimiento(requ_id);
			List<Doad> lstDoad = new ArrayList<Doad>();
			List<Doad> lstDoadCoo = new ArrayList<Doad>();
			List<Doad> lstDoadAux = new ArrayList<Doad>();
			lstDoad = doadServicio.lstDoad(requ_id,"A");
			lstDoadCoo = doadServicio.lstDoad(requ_id,"C");
			
			Obse obse = new Obse();
			Esad esad = new Esad();
			
			if(requ!=null){
				instruc = "U";
				requ_codigo = requ.getCl_requ_codigo();
			}else{
				instruc = "I";
				requ_codigo = clie_codigo+"-"+fren_nombre+sfre_nombre+"-"+sufijo;
			}
			
        	if(id_role==3){
        		if(espfunuriFile!=null){
            		requ_espfunuri = espfunuriFile.getOriginalFilename().replace(" ", "_");
            		String urifile = urictx+requ_codigo+"-EFU-"+requ_espfunuri;
        			File convFile = new File(urifile);
        			espfunuriFile.transferTo(convFile);
            	}
        		if(lstDocadiuriFile.length>0){
            		for(int i=0;i<lstDocadiuriFile.length;i++){
            			MultipartFile docadiuriFile = lstDocadiuriFile[i];
            			requ_docadiuri = docadiuriFile.getOriginalFilename().replace(" ", "_");;
                		String urifile = urictx+requ_codigo+"-DAD-"+requ_docadiuri;
                		File convFile = new File(urifile);
                		docadiuriFile.transferTo(convFile);
                		
                		Boolean flagdoad = true;
                		
                		if(lstDoad.size()>0) {
                			for(int j=0; j<lstDoad.size(); j++){
                				Doad doadAux = lstDoad.get(i);
                				if(requ_docadiuri.equals(doadAux.getCl_doad_uri())){
                					doadAux.setCl_doad_uri(requ_docadiuri);
                					doadAux.setCl_doad_version("V2");
                					doadAux.setCl_doad_tipo("A");
                					lstDoadAux.add(doadAux);
                					flagdoad = false;
                					j = lstDoad.size();
                				}
							}
                		}
                		
                		if(flagdoad){
                			Doad doadAux = new Doad();
                			doadAux.setCl_doad_uri(requ_docadiuri);
                			doadAux.setCl_doad_version("V1");
                			doadAux.setCl_doad_tipo("A");
                			lstDoadAux.add(doadAux);
                		}
					}
            	}
			}else{
				if(dfturiFile!=null){
            		requ_dfturi = dfturiFile.getOriginalFilename().replace(" ", "_");;
            		String urifile = urictx+requ_codigo+"-DFT-"+requ_dfturi;
            		File convFile = new File(urifile);
        			dfturiFile.transferTo(convFile);
            	}
            	
            	if(espfunuricooFile!=null){
            		requ_espfunuricoo = espfunuricooFile.getOriginalFilename().replace(" ", "_");;
            		String urifile = urictx+requ_codigo+"-EFC-"+requ_espfunuricoo;
            		File convFile = new File(urifile);
        			espfunuricooFile.transferTo(convFile);
            	}
            	
            	if(lstDocadiuricooFile.length>0){
            		for(int i=0;i<lstDocadiuricooFile.length;i++){
            			MultipartFile docadiuricooFile = lstDocadiuricooFile[i];
            			requ_docadiuricoo = docadiuricooFile.getOriginalFilename().replace(" ", "_");;
                		String urifile = urictx+requ_codigo+"-DAC-"+requ_docadiuricoo;
                		File convFile = new File(urifile);
                		docadiuricooFile.transferTo(convFile);
                		
                		Boolean flagdoad = true;
                		
                		if(lstDoadCoo.size()>0) {
                			for(int j=0; j<lstDoadCoo.size(); j++){
                				Doad doadAux = lstDoadCoo.get(i);
                				if(requ_docadiuricoo.equals(doadAux.getCl_doad_uri())){
                					doadAux.setCl_doad_uri(requ_docadiuricoo);
                					doadAux.setCl_doad_version("V2");
                					doadAux.setCl_doad_tipo("C");
                					lstDoadAux.add(doadAux);
                					flagdoad = false;
                					j = lstDoadCoo.size();
                				}
							}
                		}
                		
                		if(flagdoad){
                			Doad doadAux = new Doad();
                			doadAux.setCl_doad_uri(requ_docadiuricoo);
                			doadAux.setCl_doad_version("V1");
                			doadAux.setCl_doad_tipo("C");
                			lstDoadAux.add(doadAux);
                		}
					}
            	}
			}
			
			if(instruc.equals("I")){
				requ = new Requ();
				requ.setCl_requ_usua_id(usuaSesion.getCl_usua_id());
				requ.setCl_requ_clie_ruc(clie_ruc);
				requ.setCl_requ_fren_id(fren_id);
				requ.setCl_requ_sfre_id(sfre_id);
				requ.setCl_requ_codigo(requ_codigo);
				requ.setCl_requ_usuacrea(usuaSesion.getCl_usua_usuario());
				requ.setCl_requ_fechacrea(new Date());
				requ.setCl_requ_estado("X");
			}else if(instruc.equals("U")){
				requ.setCl_requ_usuamodi(usuaSesion.getCl_usua_usuario());
				requ.setCl_requ_fechamodi(new Date());
			}
			
			if(flag){
				
				esad.setCl_esad_usuacrea(usuaSesion.getCl_usua_usuario());
				esad.setCl_esad_fechacrea(new Date());
				
				if(id_role==3) {
					if(indicador.equals("G")){
						if(instruc.equals("I")){
							requ.setCl_requ_estadoreq("Guardado");
							esad.setCl_esad_estadoreq("Guardado");
						}
					}else if(indicador.equals("E")){
						if(instruc.equals("I")){
							requ.setCl_requ_estadoreq("Enviado a Estimar");
							esad.setCl_esad_estadoreq("Enviado a Estimar");
						}else{
							if(requ.getCl_requ_estadoreq().equals("Guardado") || requ.getCl_requ_estadoreq().equals("Observado")) {
								requ.setCl_requ_estadoreq("Enviado a Estimar");
								esad.setCl_esad_estadoreq("Enviado a Estimar");
							}else if(requ.getCl_requ_estadoreq().equals("Estimado")){
								requ.setCl_requ_estadoreq("Aprobado");
								esad.setCl_esad_estadoreq("Aprobado");
							}
						}
						requ.setCl_requ_flagleido("C");
					}else if(indicador.equals("R")) {
						requ.setCl_requ_estadoreq("Rechazado");
						requ.setCl_requ_flagleido("C");
						esad.setCl_esad_estadoreq("Rechazado");
						
						obse.setCl_obse_flagleido("C");
						obse.setCl_obse_observacion(obse_observacion);
						obse.setCl_obse_estadoreq("Rechazado");
						obse.setCl_obse_usuacrea(usuaSesion.getCl_usua_usuario());
						obse.setCl_obse_fechacrea(new Date());
						
					}
				}else {
					if(indicador.equals("E")){
						if(requ.getCl_requ_estadoreq().equals("Enviado a Estimar") || requ.getCl_requ_estadoreq().equals("Rechazado")) {
							requ.setCl_requ_estadoreq("Estimado");
							esad.setCl_esad_estadoreq("Estimado");
						}else if(requ.getCl_requ_estadoreq().equals("Aprobado")){
							requ.setCl_requ_estadoreq("Iniciado");
							esad.setCl_esad_estadoreq("Iniciado");
						}
						requ.setCl_requ_flagleido("A");
					}else if(indicador.equals("O")){
						requ.setCl_requ_estadoreq("Observado");
						requ.setCl_requ_flagleido("A");
						esad.setCl_esad_estadoreq("Observado");
						
						obse.setCl_obse_flagleido("A");
						obse.setCl_obse_observacion(obse_observacion);
						obse.setCl_obse_estadoreq("Observado");
						obse.setCl_obse_usuacrea(usuaSesion.getCl_usua_usuario());
						obse.setCl_obse_fechacrea(new Date());
					}
				}
				
				requ.setCl_requ_tipo(jsonObject.get("cl_requ_tipo").getAsString());
				requ.setCl_requ_titulo(jsonObject.get("cl_requ_titulo").getAsString());
				requ.setCl_requ_detalle(jsonObject.get("cl_requ_detalle").getAsString());
				if(!requ_espfunuri.equals("")){
					requ.setCl_requ_espfunuri(requ_espfunuri);
				}
				requ.setCl_requ_fechainicio(UtilTiempo.convStrFechaAFecha(jsonObject.get("cl_requ_fechainicio").getAsString(), Constantes.DATE_UTIL));
				requ.setCl_requ_fechafin(UtilTiempo.convStrFechaAFecha(jsonObject.get("cl_requ_fechafin").getAsString(), Constantes.DATE_UTIL));
				
				if(!requ_dfturi.equals("")) {
					requ.setCl_requ_dfturi(requ_dfturi);
				}
				if(!requ_espfunuricoo.equals("")) {
					requ.setCl_requ_espfunuricoo(requ_espfunuricoo);
				}
				requ.setCl_requ_numeroest(jsonObject.get("cl_requ_numeroest").getAsInt());
				requ.setCl_requ_unidadest(jsonObject.get("cl_requ_unidadest").getAsString());
				
				if(requ.getCl_requ_fechainicio()!=null) {
					Conf conf = confServicio.obtConf();
					
					/*long inicio = requ.getCl_requ_fechainicio().getTime();
					long fin = requ.getCl_requ_fechafin().getTime();
					int dias = (int)(fin-inicio/(1000*60*60*24));*/
					if(requ.getCl_requ_unidadest().equals("dias")) {
						if(requ.getCl_requ_numeroest()>=conf.getCl_conf_minidiasproy()) {
							requ.setCl_requ_tipo("Proyecto");
						}
					}
				}
				
				requ = requServicio.mantenerRequ(requ);
				
				if(esad.getCl_esad_estadoreq()!=null) {
					esad.setCl_esad_requ_id(requ.getCl_requ_id());
					esad = esadServicio.mantenerEsad(esad);
				}
				
				if(indicador.equals("R") || indicador.equals("O")) {
					obse.setCl_obse_requ_id(requ.getCl_requ_id());
					obse = obseServicio.mantenerEsad(obse);
				}
				
				if(lstDoadAux.size()>0) {
					for(int i=0;i<lstDoadAux.size();i++){
						lstDoadAux.get(i).setCl_doad_requ_id(requ.getCl_requ_id());
					}
					doadServicio.mantenerDoads(lstDoadAux);
				}
				
				Usua usuaAux = new Usua();
				Clie clie = new Clie();
				
				String logoaux = "SGR";
				
				if(id_role==3) {
					
					if(indicador.equals("E") && requ.getCl_requ_estadoreq().equals("Enviado a Estimar")) {
						
						clie = clieServicio.obtenerCliexRUC(clie_ruc);
						usuaAux = usuaServicio.obtenerCoordinadorxFrente(fren_id, sfre_id, clie_ruc);
						
						if(!usuaAux.getCl_usua_email().equals("")){
							
							if(requ.getCl_requ_espfunuri()!=null && !requ.getCl_requ_espfunuri().equals("")){
								lstNfiles.add(urictx+requ_codigo+"-EFU-"+requ.getCl_requ_espfunuri());
							}
							
							String de = "comercial@gmail.com";
							String para = usuaAux.getCl_usua_email();
							String asunto = "RE:"+logoaux+" - Solicita Estimación:";
							String texto = UtilCorreo.mensajeHtmlRequerimiento(
									usuaAux.getCl_usua_nombre(), 
									usuaSesion.getCl_usua_nombre(), 
									clie.getCl_clie_razonsoc(), 
									requ.getCl_requ_codigo(), 
									logoaux);
							emailServicio.enviarMensajeCorreoVariosAdjunto(de, para, asunto, texto, lstNfiles);
						}
					}else if(indicador.equals("E") && requ.getCl_requ_estadoreq().equals("Aprobado")) {
						
						clie = clieServicio.obtenerCliexRUC(clie_ruc);
						usuaAux = usuaServicio.obtenerCoordinadorxFrente(fren_id, sfre_id, clie_ruc);
						
						if(!usuaAux.getCl_usua_email().equals("")){
							String de = "comercial@gmail.com";
							String para = usuaAux.getCl_usua_email();
							String asunto = "RE:"+logoaux+" - Requerimiento Aprobado:";
							String texto = UtilCorreo.mensajeHtmlAprobacion(
									usuaAux.getCl_usua_nombre(), 
									usuaSesion.getCl_usua_nombre(), 
									clie.getCl_clie_razonsoc(),
									requ.getCl_requ_codigo(), 
									logoaux);
							emailServicio.enviarMensajeCorreoVariosAdjunto(de, para, asunto, texto, lstNfiles);
						}
					}
				}else {
					usuaAux = usuaServicio.obtUsua(requ.getCl_requ_usua_id());
					if(indicador.equals("E") && requ.getCl_requ_estadoreq().equals("Estimado")) {
						
						clie = clieServicio.obtenerCliexRUC(clie_ruc);
						usuaAux = usuaServicio.obtenerCoordinadorxFrente(fren_id, sfre_id, clie_ruc);
						
						if(!usuaAux.getCl_usua_email().equals("")){
							
							if(requ.getCl_requ_dfturi()!=null && !requ.getCl_requ_dfturi().equals("")){
								lstNfiles.add(urictx+requ_codigo+"-DFT-"+requ.getCl_requ_dfturi());
							}
							if(requ.getCl_requ_espfunuricoo()!=null && !requ.getCl_requ_espfunuricoo().equals("")){
								lstNfiles.add(urictx+requ_codigo+"-EFC-"+requ.getCl_requ_espfunuricoo());
							}
							
							List<Doad >lstDoadTEmp = doadServicio.lstDoad(requ_id,"A");
							
							if(lstDoadTEmp.size()>0){
								for(int i=0;i<lstDoadTEmp.size();i++){
									lstNfiles.add(urictx+requ_codigo+"-DAD-"+lstDoadTEmp.get(i).getCl_doad_uri());
								}
							}
							
							List<Doad >lstDoadCooTEmp = doadServicio.lstDoad(requ_id,"C");
							
							if(lstDoadCooTEmp.size()>0){
								for(int i=0;i<lstDoadCooTEmp.size();i++){
									lstNfiles.add(urictx+requ_codigo+"-DAC-"+lstDoadCooTEmp.get(i).getCl_doad_uri());
								}
							}
							
							String de = "comercial@gmail.com";
							String para = usuaAux.getCl_usua_email();
							String asunto = "RE:"+logoaux+" - EStimación:";
							String texto = UtilCorreo.mensajeHtmlEstimacion(
									usuaAux.getCl_usua_nombre(), 
									usuaSesion.getCl_usua_nombre(), 
									clie.getCl_clie_razonsoc(), 
									requ.getCl_requ_codigo(), 
									usuaSesion.getCl_usua_celular(), 
									logoaux);
							emailServicio.enviarMensajeCorreoVariosAdjunto(de, para, asunto, texto, lstNfiles);
						}
					}
				}
			}
			
			typeMsg = Constantes.TYPE_MSG_SUCCESS;
			sbMsg.append("Guardado Correctamente");
			
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;;
			sbMsg.append(Constantes.msg_error_general);
		}
		
		message = sbMsg.toString();
		
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
	@PostMapping("/leerRequerimiento")
	public Map<String, Object> leerRequerimiento(HttpSession session,
			@RequestBody String vsc_data){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		JsonObject jsonObject = new JsonParser().parse(vsc_data).getAsJsonObject();
		StringBuilder sbMsg = new StringBuilder();
		String typeMsg = "";
		String message = "";
		
		try {
			
			Integer requ_id = jsonObject.get("requ_id").getAsInt();
			
			Requ requ = new Requ();
			requ = requServicio.obtRequerimiento(requ_id);
			
			if(requ!=null){
				requ.setCl_requ_flagleido("");
				requ = requServicio.mantenerRequ(requ);
			}
			
			typeMsg = Constantes.TYPE_MSG_SUCCESS;
			sbMsg.append("Actualizado");
			
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;;
			sbMsg.append(Constantes.msg_error_general);
		}
		
		message = sbMsg.toString();
		
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
	@PostMapping("/eliminarDoad")
	public Map<String, Object> eliminarDoad(HttpSession session,
			@RequestBody String vsc_data){
		
		Map<String, Object> rpta = new HashMap<String, Object>();
		JsonObject jsonObject = new JsonParser().parse(vsc_data).getAsJsonObject();
		StringBuilder sbMsg = new StringBuilder();
		String typeMsg = "";
		String message = "";
		
		try {
			
			Integer doad_id = jsonObject.get("doad_id").getAsInt();
			
			Doad doad = new Doad();
			doad.setCl_doad_id(doad_id);
			doadServicio.eliminarDoad(doad);
			
			typeMsg = Constantes.TYPE_MSG_SUCCESS;
			sbMsg.append("Actualizado");
			
		} catch (Exception e) {
			typeMsg = Constantes.TYPE_MSG_ERROR;;
			sbMsg.append(Constantes.msg_error_general);
		}
		
		message = sbMsg.toString();
		
		rpta.put("v_type_message", typeMsg);
		rpta.put("v_message", message);
		
		return rpta;
	}
	
}
