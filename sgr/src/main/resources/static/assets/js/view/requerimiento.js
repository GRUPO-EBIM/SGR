var VSC_FRENTE = [];
var VSC_REQUERIMIENTOS = [];
var role_id = 0;
var CONTEXTO = "";
//var ctx = 'http://ebim.myddns.me:8080/adjsgr/';
var ctx = 'http://localhost:8082/adjsgr/';
var indice = 0;

var langu = {
	"sProcessing": "Procesando...",
	"sLengthMenu": "Mostrar _MENU_ registros",
	"sZeroRecords": "No se encontraron resultados",
	"sEmptyTable": "Datos no disponibles en esta tabla",
	"sInfo": "Mostrando del _START_ al _END_ de un total de _TOTAL_ registros",
	"sInfoEmpty": "Mostrando del 0 al 0 de un total de 0 registros",
	"sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	"sInfoPostFix": "",
	"sSearch": "Buscar:",
	"sUrl": "",
	"sInfoThousands": ",",
	"sLoadingRecords": "Cargando...",
	"oPaginate": {
		"sFirst": "Primero",
		"sLast": "Ultimo",
		"sNext": "Siguiente",
		"sPrevious": "Anterior"
	},
	"oAria": {
		"sSortAscending": ": Activar para ordenar la columna de manera ascendente",
		"sSortDescending": ": Activar para ordenar la columna de manera descendente"
	}
};

$(document).ready(function() {
	
	$("#menureq-float").hide();
	$("#editar-req").hide();
	$("#seg-frente-mov").hide();
	
	$("#btn_rechazar_req").css("display", 'none');
	$("#btn_observar_req").css("display", 'none');
	
	//Inicio Eventos del nuevo requerimiento
	$('#btn_nuevo_req').click(function() {
		fnLimpiarFormReq();
		bloqueoTotalRequForm();
		
		$(".nuevo-req").css("display", 'block');
		$(".editar-req").css("display", 'none');
		$('.requ_espfunuri_u').css("display", 'inline');
		$('.requ_espfunuri_a').css("display", 'none');
		
		$("#requ_fechacrea").val(obtFechaActual());

		$("#requ_espfunuri").css("display", 'block');
		$("#estadoRequ").css("display", 'none');
		$(".alert-obse").css("display", 'none');

		$("#requ_titulo").removeAttr("disabled");
		$("#requ_detalle").removeAttr("disabled");
		$("#requ_espfunuri").removeAttr("disabled");
		$("#requ_docadiuri").removeAttr("disabled");

		$("#btn_guardar_req").css("display", 'inline');
		$("#btn_enviar_req").css("display", 'inline');
		$('#btn_rechazar_req').css("display", 'none');
		$('#btn_observar_req').css("display", 'none');

		$("#btn_enviar_req").text("Estimar Req.");

		var icoadj = '<i class="mx-1 fa fa-question"></i>';

		$("#requ_dfturi_u").append(icoadj + 'Ningun Documento adjunto');
		$('#requ_dfturi_u').attr('href', '#');

		$("#requ_espfunuricoo_u").append(icoadj + 'Ningun Documento adjunto');
		$('#requ_espfunuricoo_u').attr('href', '#');

		$("#tdocadi tbody").empty();
		$("#modalEstadoRequ tbody").empty();
		$("#modalVerDocAdi tbody").empty();
		
		$("#sist-req").hide();
		$("#editar-req").show();
	})
	//Fin Eventos del nuevo requerimiento
	
	$('.btn-toogle-menu').click(function() {
		if ($('.menu-float').hasClass('active')) {
			$('.btn-toogle-menu').removeClass('active');
			$('.menu-float').removeClass('active');
			$(".menureq-float").hide();
		} else {
			$('.btn-toogle-menu').addClass('active');
			$('.menu-float').addClass('active');
			$('.btn-toogle-opcion').removeClass('active');
			$('.menu-float-opcion').removeClass('active');
			$(".menureq-float").show();
		}
	})
	
	$('#btn-toggle-menureq').click(function(){
		$("#seg-frente-mov").css('visibility','visible');
		
		if($("#seg-frente-mov").is(":visible")){
			$("#seg-frente-mov").css('display', 'none');
		}else {
    		$("#seg-frente-mov").css('display', 'block');
  		}
	});
	
	
	$('.inputfile-label').click(function(){
		
		$('.inputfile').change(function() {
			var extension = null;
			var filename = null;		
			var actualizar = null;
			
            filename = $('.inputfile').val().split("\\").pop();
	
			if(filename.toString().trim() == '' ){
				
					$("#label-inputfile").show();
					$("#label-actualizar").hide();
					$(".inputfile-labelF").hide();
					addIconFile(extension);
			}else{
				
				$('.inputfile-labelF').html(filename);
				
				extension = filename.replace(/^.*\./, '');			
				extension = extension.toLowerCase();
				if(extension != null){
					
					addIconFile(extension);
				
					$("#label-actualizar").hide();
					actualizar = '<div id="label-actualizar"><input type="file" name="requ_espfunuri" id="requ_espfunuri" class="inputfile"/>'+
					'<label for="requ_espfunuri" class="col-4 col-md-4 pt-1 pb-1 text-primary text-right actualizar"><u>Actualizar</u></label></div>';
					$('.inputfile-labelF').after(actualizar);
					$("#label-inputfile").hide();
					$(".inputfile-labelF").show();
				}					
			}  
       });
	})
	
	//Para subir archivos adicionales
	$("#requ_docadiuri").click(function(){
		
		$("#requ_docadiuri").change(function() {
			var filename = null;
			var showfile = null;
			filename = $("#requ_docadiuri").val().split("\\").pop();
			console.log("El archivo se llama: "+filename);
			//$('.inputfilesadit-label').html(filename);
			showfile = '<a class="col-6 col-md-8 pt-1 pb-1 text-left text-primary">'+filename+'</a>';
			$('.list-filesadi').after(showfile);
		})
		
	})

	$(".custom-file-input").on("change", function() {
		var fileName = $(this).val().split("\\").pop();
		$(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});

	$('#verdoctec').click(function() {
		$("#modalVerDocTec").modal({ backdrop: 'static', keyboard: false });
		$("#modalVerDocTec").show();
	})
	
	//Fin Eventos shared
	
	//Inicio eventos de detalle de requerimientos
	
	$('#estadoRequ').click(function() {
		$("#modalEstadoRequ").modal({ backdrop: 'static', keyboard: false });
		$("#modalEstadoRequ").show();
	})
	
	$('#btn-cancelar-detreq').click(function(){
		$("#editar-req").hide();
		$("#nuevo-req").show();	
	})
	
	//Fin eventos de detalle de requerimientos
	
	$('#btn_cancelar_req').click(function(){
		$("#editar-req").hide();
		$("#sist-req").show();
	})
	
	$('#btn_estimar_req').click(function(){
		bloqueoTotalRequForm();
		$("#sist-req").hide();
		$("#nuevo-req").hide();
		$("#detalle-req").show();
		
		$("#requ_fechacrea").val(obtFechaActual());
		$("#requ_espfunuri").css("display", 'block');
		$("#requ_espfunuri").removeAttr("disabled");
	})
	
	$('#btn-aprobar-req').click(function(){
		var fec_inicio = null;
		var fec_fin = null;
		
		$("#divedit-fecini").remove();
		$("#divedit-fecfin").remove();
		fec_inicio = '<div id="divedit-fecini" class="form-row mt-2"><label class="col-12 col-md-4 font-weight-bold">Fec. Inicio</label><input id="requ_fechainicio" class="col-12 col-md-8" type="text" disabled/></div>';
		fec_fin = '<div id="divedit-fecini" class="form-row mt-2"><label class="col-12 col-md-4 font-weight-bold">Fec. Fin</label><input id="requ_fechafin" class="col-12 col-md-8" type="text" disabled/></div>';

		$('#divedit-esth').before(fec_inicio);
		$('#divedit-esth').before(fec_fin);
	})
	
	$('#btn_guardar_req').click(function() {
		fnGuardarRequerimiento('G');
	})
	
	$('#btn_enviar_req').click(function() {
		fnGuardarRequerimiento('E');
	})

	$('#btn_rechazar_req').click(function() {
		fnGestionarObservacion('R');
	})

	$('#btn_observar_req').click(function() {
		fnGestionarObservacion('O');
	})

	$('#btn_rechazar_req_env').click(function() {
		fnGuardarRequerimiento('R');
	})

	$('#btn_observar_req_env').click(function() {
		fnGuardarRequerimiento('O');
	})

	$('#alert-obse').click(function() {
		$("#modalListarObservacion").modal({ backdrop: 'static', keyboard: false });
		$("#modalListarObservacion").show();
	})
	
})

function addIconFile(extension){
	
	var icon = null;
	$("#iconfile").remove();
	
	if((extension == 'docx') || (extension == 'doc')){
			icon = '<div class="col-2 col-md-1" id="iconfile"><img src="assets/imgs/icon2.png" width="32" height="32"></div>';			
			$('.inputfile-labelF').before(icon);	
				
	}else if(extension == 'mpp'){
			//icon = '<img id="iconfile" src="assets/imgs/icon1.png" width="32" height="32">';
			icon = '<div class="col-2 col-md-1" id="iconfile"><img src="assets/imgs/icon1.png" width="32" height="32"></div>';
			$('.inputfile-labelF').before(icon);
					
	}else{
		$("#iconfile").remove();
		
	}
	
}

function fnGestionarObservacion(indi) {
	if (indi == 'R') {
		$(".mo_rechazo").css("display", 'block');
		$(".mo_observacion").css("display", 'none');
	} else {
		$(".mo_rechazo").css("display", 'none');
		$(".mo_observacion").css("display", 'block');
	}
	$("#modalEnviarObservacion").modal({ backdrop: 'static', keyboard: false });
	$("#modalEnviarObservacion").show();
}

function fnLeerRequerimiento(requ_id) {
	axios.post('api/req/leerRequerimiento', {
		"requ_id": requ_id
	}, {
		headers: {
			'Content-Type': 'application/json',
		}
	}, {
	}).then((response) => {
		fnCargarMenuFrente();
	})
}

function fnCargarMenuFrente() {
	axios.post('api/req/listarFrente', {}, {
		headers: {
			'Content-Type': 'application/json',
		}
	}, {
	}).then((response) => {
		VSC_FRENTE = [];
		VSC_FRENTE = response.data.lstFrenteMenu;
		mostrarFrente();
	})
}

function mostrarFrente() {

	var cliente = 0;
	var frente = 0;
	var contenido = "";
	var contenido_mov = "";
	$("#seg-frente").empty();
	$("#seg-frente-mov").empty();

	if (VSC_FRENTE.length > 0) {
		if (role_id == 3) {
			for (var i = 0; i < VSC_FRENTE.length; i++) {
				
				var html_clie = '';
				var html_fren = '';
				var html_sfre = '';
				if (VSC_FRENTE[i]["cl_clie_id"] != cliente) {
					cliente = VSC_FRENTE[i]["cl_clie_id"];
					frente = VSC_FRENTE[i]["cl_fren_id"];

					if (i != 0) {
						contenido_mov = contenido_mov + '</div>';
						contenido = contenido + '</div></div>';
					}

					if (VSC_FRENTE[i]["cl_requ_c_clie"] != 0) {
						html_clie = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_clie"];
					}
					//Agrega el bloque Farmacias peruanas
					contenido_mov = contenido_mov + '<a href="#" class="col-12 bg-warning pl-2 list-group-item list-group-item-action" ' +
						'onclick="fnVerFrentes(\'fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fas fa-square" style="font-size:90%;"></i>' + VSC_FRENTE[i]["cl_clie_razonsoc"] + html_clie + '</a><div class="list-group">';
						
					contenido = contenido + '<a href="#" class="col-12 bg-warning pl-2 list-group-item list-group-item-action" ' +
						'onclick="fnVerFrentes(\'fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_clie_razonsoc"] + html_clie + '</a><div class="list-group">';

					if (VSC_FRENTE[i]["cl_requ_c_fren"] != 0) {
						html_fren = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_fren"];
					}
					//Boton SAP del menu
					contenido_mov = contenido_mov +'<a href="#" class="col-12 pl-3 list-group-item list-group-item-action list-group-item-secondary "'+
					'onclick="fnVerSubfrentes(\'sfre-'+VSC_FRENTE[i]["cl_clie_id"]+'-'+VSC_FRENTE[i]["cl_fren_id"]+'\')">'+
			        '<i class="mx-1 fas fa-square" style="font-size:90%;color:gray"></i>'+VSC_FRENTE[i]["cl_fren_nombre"]+html_fren+'</a><div class="list-group">';

					contenido = contenido + '<a href="#" class="list-group-item list-group-item-action list-group-item-secondary ' +
						'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fa fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';

					if (VSC_FRENTE[i]["cl_requ_c_sfre"] != 0) {
						html_sfre = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_sfre"];
					}
					contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square" style="font-size:90%;color:gray"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
							
					contenido = contenido + '<a href="#" class="pl-5 list-group-item list-group-item-action ' +
						'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
						'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
				} else {
					if (VSC_FRENTE[i]["cl_fren_id"] != frente) {
						frente = VSC_FRENTE[i]["cl_fren_id"];
						if (i != 0) {
							contenido_mov = contenido_mov + '</div>';
							contenido = contenido + '</div>';
						}

						if (VSC_FRENTE[i]["cl_requ_c_fren"] != 0) {
							html_fren = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_fren"];
						}
						contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-3 list-group-item list-group-item-action list-group-item-secondary ' +
							'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';
							
						contenido = contenido + '<a href="#" class="list-group-item list-group-item-action list-group-item-secondary ' +
							'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';

						if (VSC_FRENTE[i]["cl_requ_c_sfre"] != 0) {
							html_sfre = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_sfre"];
						}
						contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square" style="font-size:90%;color:gray"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
							
						contenido = contenido + '<a href="#" class="pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
					} else {
						if (VSC_FRENTE[i]["cl_requ_c_sfre"] != 0) {
							html_sfre = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_sfre"];
						}
						contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
							
						contenido = contenido + '<a href="#" class="pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
					}
				}
			}
			
		} else {
			//Si role_id = 4

			for (var i = 0; i < VSC_FRENTE.length; i++) {
				
				var html_clie = '';
				var html_fren = '';
				var html_sfre = '';
				if (VSC_FRENTE[i]["cl_clie_id"] != cliente) {
					cliente = VSC_FRENTE[i]["cl_clie_id"];
					frente = VSC_FRENTE[i]["cl_fren_id"];

					if (i != 0) {
						contenido_mov = contenido_mov + '</div>';
						contenido = contenido + '</div></div>';
					}

					if (VSC_FRENTE[i]["cl_requ_c_clie"] != 0) {
						html_clie = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_clie"];
					}
					//Agrega el bloque Farmacias peruanas
					contenido_mov = contenido_mov + '<a href="#" class="col-12 bg-warning pl-2 list-group-item list-group-item-action" ' +
						'onclick="fnVerFrentes(\'fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_clie_razonsoc"] + html_clie + '</a><div class="list-group">';
						
					contenido = contenido + '<a href="#" class="col-12 bg-warning pl-2 list-group-item list-group-item-action" ' +
						'onclick="fnVerFrentes(\'fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_clie_razonsoc"] + html_clie + '</a><div class="list-group">';

					if (VSC_FRENTE[i]["cl_requ_c_fren"] != 0) {
						html_fren = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_fren"];
					}
					//Boton SAP del menu
					contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-3 list-group-item list-group-item-action list-group-item-secondary ' +
						'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fa fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';
						
					contenido = contenido + '<a href="#" class="list-group-item list-group-item-action list-group-item-secondary ' +
						'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
						'<i class="mx-1 fa fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';

					if (VSC_FRENTE[i]["cl_requ_c_sfre"] != 0) {
						html_sfre = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_sfre"];
					}
					contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-5 list-group-item list-group-item-action ' +
						'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
						'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
						
					contenido = contenido + '<a href="#" class="pl-5 list-group-item list-group-item-action ' +
						'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
						'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
				} else {
					if (VSC_FRENTE[i]["cl_fren_id"] != frente) {
						frente = VSC_FRENTE[i]["cl_fren_id"];
						if (i != 0) {
							contenido = contenido + '</div>';
						}

						if (VSC_FRENTE[i]["cl_requ_c_fren"] != 0) {
							html_fren = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_fren"];
						}
						
						contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-3 list-group-item list-group-item-action list-group-item-secondary ' +
							'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';
							
						contenido = contenido + '<a href="#" class="list-group-item list-group-item-action list-group-item-secondary ' +
							'seg-frente fren-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '" onclick="fnVerSubfrentes(\'sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + '\')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_fren_nombre"] + html_fren + '</a><div class="list-group">';

						if (VSC_FRENTE[i]["cl_requ_c_sfre"] != 0) {
							html_sfre = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_sfre"];
						}
						contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
							
						contenido = contenido + '<a href="#" class="pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
					} else {
						if (VSC_FRENTE[i]["cl_requ_c_sfre"] != 0) {
							html_sfre = '<i class="mx-1 fa fa-envelope"></i>' + VSC_FRENTE[i]["cl_requ_c_sfre"];
						}
						contenido_mov = contenido_mov + '<a href="#" class="col-12 pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
							
						contenido = contenido + '<a href="#" class="pl-5 list-group-item list-group-item-action ' +
							'seg-subfrente sfre-' + VSC_FRENTE[i]["cl_clie_id"] + '-' + VSC_FRENTE[i]["cl_fren_id"] + ' sfre-' + i + '" onclick="fnListarReq(' + i + ')">' +
							'<i class="mx-1 fas fa-square"></i>' + VSC_FRENTE[i]["cl_sfre_nombre"] + html_sfre + '</a>';
					}
				}
			}
		}
		if (role_id == 3) {
			contenido = contenido + '</div>';
			contenido_mov = contenido_mov + '</div>';
			$("#seg-frente").append(contenido);
			$("#seg-frente-mov").append(contenido_mov);
			//fnVerFrentes('fren-' + VSC_FRENTE[0]["cl_clie_id"] + '-' + VSC_FRENTE[0]["cl_fren_id"]);
			fnVerSubfrentes('sfre-' + VSC_FRENTE[0]["cl_clie_id"] + '-' + VSC_FRENTE[0]["cl_fren_id"]);
		} else {
			contenido = contenido + '</div></div>';
			contenido_mov = contenido_mov + '</div>';
			$("#seg-frente").append(contenido);
			$("#seg-frente-mov").append(contenido_mov);
			fnVerFrentes('fren-' + VSC_FRENTE[0]["cl_clie_id"] + '-' + VSC_FRENTE[0]["cl_fren_id"]);
			fnVerSubfrentes('sfre-' + VSC_FRENTE[0]["cl_clie_id"] + '-' + VSC_FRENTE[0]["cl_fren_id"]);
		}
	}

	fnListarReq(indice);
}

function fnVerFrentes(idfren) {
	//$(".seg-subfrente").css("display", 'none');
	//$(".seg-frente").css("display", 'none');
	$("." + idfren).css("display", 'block');
}

function fnVerSubfrentes(idsfre) {
	$(".seg-subfrente").css("display", 'none');
	$("." + idsfre).css("display", 'block');
}

function fnListarReq(idc) {

	indice = idc;

	var clie_ruc = VSC_FRENTE[idc]["cl_clie_ruc"];
	var fren_id = VSC_FRENTE[idc]["cl_fren_id"];
	var sfre_id = VSC_FRENTE[idc]["cl_sfre_id"];

	$(".seg-subfrente").removeClass("text-info");
	$(".sfre-" + idc).addClass("text-info");
	
	$(".titulo-req").text(VSC_FRENTE[idc]["cl_clie_razonsoc"] + ' - ' + VSC_FRENTE[idc]["cl_sfre_nombre"]);
	$(".titulo-nuevoreq").text(VSC_FRENTE[idc]["cl_clie_razonsoc"] + ' - ' +VSC_FRENTE[idc]["cl_fren_nombre"]+' - '+VSC_FRENTE[idc]["cl_sfre_nombre"]);

	$("#fren_indice").val(idc);
	$("#clie_ruc").val(clie_ruc);
	$("#clie_codigo").val(VSC_FRENTE[idc]["cl_clie_codigo"]);
	$("#fren_id").val(fren_id);
	$("#fren_nombre").val(VSC_FRENTE[idc]["cl_fren_nombre"]);
	$("#sfre_id").val(sfre_id);
	$("#sfre_nombre").val(VSC_FRENTE[idc]["cl_sfre_nombre"]);

	listarRequ(fren_id, sfre_id, clie_ruc);
}

function fnActivarDT() {
	$('#tbrequerimiento').DataTable({
		rowReorder: {
			selector: 'td:nth-child(2)'
		},
		responsive: true,
		language: langu
	});

	$('#tbhistorial').DataTable({
		rowReorder: {
			selector: 'td:nth-child(2)'
		},
		responsive: true,
		language: langu
	});
}

function fnDesactivarDT() {

	var tbrequerimiento = $('#tbrequerimiento').DataTable();
	tbrequerimiento.destroy();
	var tbhistorial = $('#tbhistorial').DataTable();
	tbhistorial.destroy();
}

function fnCargarForm(indicador) {
	file1 = $("#requ_espfunuri")[0].files[0]; //Para los archivos doc req
	file2 = $("#requ_dfturi")[0].files[0];	//Para los archivos dft
	file3 = $("#requ_espfunuricoo")[0].files[0];
	file4 = $("#requ_docadiuri")[0].files; //Para los archivos archivos adicionales?
	file5 = $("#requ_docadiuricoo")[0].files; //Para los archivos archivos adicionales?

	var requ_tipo = $("#requ_tipo").val();
	var requ_id = $("#requ_id").val();
	var clie_ruc = $("#clie_ruc").val();
	var clie_codigo = $("#clie_codigo").val();
	var fren_id = $("#fren_id").val();
	var fren_nombre = $("#fren_nombre").val();
	var sfre_id = $("#sfre_id").val();
	var sfre_nombre = $("#sfre_nombre").val();
	var requ_titulo = $("#requ_titulo").val();
	var requ_detalle = $("#requ_detalle").val();
	var requ_fechainicio = $("#requ_fechainicio").val();
	var requ_fechafin = $("#requ_fechafin").val();
	var requ_numeroest = $("#requ_numeroest").val();
	var requ_unidadest = $("#requ_unidadest").val();
	var obse_observacion = $("#obse_observacion").val();

	var strcadena = '{' +
		'\'indicador\':\'' + indicador + '\',' +
		'\'cl_requ_tipo\':\'' + requ_tipo + '\',' +
		'\'cl_requ_id\':' + requ_id + ',' +
		'\'cl_clie_ruc\':\'' + clie_ruc + '\',' +
		'\'cl_clie_codigo\':\'' + clie_codigo + '\',' +
		'\'cl_fren_id\':' + fren_id + ',' +
		'\'cl_fren_nombre\':\'' + fren_nombre + '\',' +
		'\'cl_sfre_id\':' + sfre_id + ',' +
		'\'cl_sfre_nombre\':\'' + sfre_nombre + '\',' +
		'\'cl_requ_titulo\':\'' + requ_titulo + '\',' +
		'\'cl_requ_detalle\':\'' + requ_detalle + '\',' +
		'\'cl_requ_fechainicio\':\'' + requ_fechainicio + '\',' +
		'\'cl_requ_fechafin\':\'' + requ_fechafin + '\',' +
		'\'cl_requ_numeroest\':' + requ_numeroest + ',' +
		'\'cl_requ_unidadest\':\'' + requ_unidadest + '\',' +
		'\'cl_obse_observacion\':\'' + obse_observacion + '\'' +
		'}';

	formData = new FormData();
	formData.append("requ_espfunuri", file1);  //Para los archivos doc req
	formData.append("requ_dfturi", file2);			//Para los archivos dft
	formData.append("requ_espfunuricoo", file3);
	if (file4.length) {
		for (var i = 0; i < file4.length; i++) {
			formData.append("requ_docadiuri", file4[i]); //Para los archivos adicionales?
		}
	}
	if (file5.length) {
		for (var i = 0; i < file5.length; i++) {
			formData.append("requ_docadiuricoo", file5[i]); //Para los archivos adicionales?
		}
	}
	formData.append("data", strcadena);
}

function fnLimpiarFormReq() {
	
	$("#requ_titulo").val("");
	
	$("#requ_detalle").val("");
	
	$("#requ_estado").val("");
	$("#requ_fechacrea").val("");
	
	$("#requ_fechainicio").val(obtFechaActual());
	$("#requ_fechafin").val(obtFechaActual());
	$("#requ_numeroest").val("");
	$("#requ_unidadest").val("hrs");
	$("#requ_id").val(0);
	$("#requ_numeroest").val(0);
	$("#requ_espfunuri").val('');
	
	$("#requ_dfturi").val('');
	$("#requ_espfunuricoo").val('');
	$("#requ_docadiuri").val('');
	$("#requ_docadiuricoo").val('');

	$("#requ_espfunuri_u").text("");
	$("#requ_dfturi_u").text("");
	$("#requ_espfunuricoo_u").text("");
}

function fn_validator_req(indicador) {
	if (role_id == 3) {
		if (indicador == "R") {
			if ($("#obse_observacion").val().length == 0) {
				return 'Ingrese motivo.';
			} else {
				return 1;
			}
		} else {
			/*if ($("#requ_tipo").val().length == 0) {
				return 'Campo tipo requerido';
			}*/if ($("#requ_titulo").val().length == 0) {
				return 'Campo titulo requerido';
			} else if ($("#requ_titulo").val().length > 40) {
				return 'Campo titulo limite';
			} else if ($("#requ_detalle").val().length == 0) {
				return 'Campo detalle requerido';
			} else if ($("#requ_detalle").val().length > 1000) {
				return 'Campo detalle limite 1000 caract.';
			} else {
				return 1;
			}
		}
	} else {
		if (indicador == "O") {
			if ($("#obse_observacion").val().length == 0) {
				return 'Ingrese motivo.';
			} else {
				return 1;
			}
		} else if (indicador == "E") {
			if ($("#requ_numeroest").val() == 0) {
				return 'Se requiere estimacion';
			} else if ($("#requ_unidadest").val() == "") {
				return 'Se requiere unidad de est.';
			} else if ($("#requ_fechainicio").val() == "") {
				return 'Se requiere fecha Inicio';
			} else if ($("#requ_fechafin").val() == "") {
				return 'Se requiere fecha Fin';
			} else if ($("#requ_fechainicio").val() != "" || $("#requ_fechafin").val() != "") {
				if ($("#requ_fechafin").val() < $("#requ_fechainicio").val()) {
					return 'Fecha Fin Incorrecto';
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		} else {
			return 1;
		}
	}
}

function fnGuardarRequerimiento(indicador) {
	fnCargarForm(indicador);
	var fren_indice = $("#fren_indice").val();

	var vali = fn_validator_req(indicador);
	if (vali != 1) {
		swal("Estimado usuario !", vali, 'error')
	} else {
		var r = confirm("Desea continuar");
		if (r == true) {
			$("#employee_tracking").css("display", 'block');
			axios.post('api/req/mantenerRequerimiento', formData,
				{
					headers: {
						'Content-Type': 'multipart/form-data'
					}
				},{
			}).then((response) => {
				$("#employee_tracking").css("display", 'none');
				$('#modalEnviarObservacion').modal('hide');
				$("#sist-req").show();
				$("#editar-req").hide();
				fnListarReq(fren_indice);
			}).catch(function(error) {
				$("#employee_tracking").css("display", 'none');
				$('#modalEnviarObservacion').modal('hide');
				$("#sist-req").show();
				$("#editar-req").hide();
				swal("Estimado usuario !", "" + error + "", "error")
			})
		}
	}
}

function listarRequ(fren_id, sfre_id, clie_ruc) {
	axios.post('api/req/listarRequerimiento', {
		"fren_id": fren_id,
		"sfre_id": sfre_id,
		"clie_ruc": clie_ruc
	},
		{
			headers: {
				'Content-Type': 'application/json',
			}
		}, {
	}).then((response) => {
		VSC_REQUERIMIENTOS = [];
		VSC_REQUERIMIENTOS = response.data.lstRequ;
		fnCargarRequ();
	}).catch(function(error) {
		console.log('error', error)
		swal("Estimado usuario !", "" + error + "", "error")
	})
}

function fnCargarRequ() {
	fnDesactivarDT()
	$("#tbrequerimiento tbody").empty();
	$("#tbhistorial tbody").empty();
	var contenido = "";
	if (VSC_REQUERIMIENTOS.length > 0) {

		for (var i = 0; i < VSC_REQUERIMIENTOS.length; i++) {

			var requ_fechainicio = "--";
			var requ_fechafin = "--";

			if (VSC_REQUERIMIENTOS[i]["cl_requ_fechainicio"] != null) {
				requ_fechainicio = formatoFecha(VSC_REQUERIMIENTOS[i]["cl_requ_fechainicio"], '/');
			}
			if (VSC_REQUERIMIENTOS[i]["cl_requ_fechafin"] != null) {
				requ_fechafin = formatoFecha(VSC_REQUERIMIENTOS[i]["cl_requ_fechafin"], '/');
			}

			if ((role_id == 3 && VSC_REQUERIMIENTOS[i]["cl_requ_flagleido"] == 'A') || (role_id == 4 && VSC_REQUERIMIENTOS[i]["cl_requ_flagleido"] == 'C')) {
				contenido = contenido + '<tr class="tr-bold" ondblclick="fnEditarRequ(' + i + ')">';
			} else {
				contenido = contenido + '<tr ondblclick="fnEditarRequ(' + i + ')">';
			}
			
			//Carga datos a las tablas y el icono de editar
			contenido = contenido + '<td>' + VSC_REQUERIMIENTOS[i]["cl_requ_codigo"] + '</td>' +
				'<td>' + VSC_REQUERIMIENTOS[i]["cl_requ_titulo"] + '</td>' +
				'<td>' + VSC_REQUERIMIENTOS[i]["cl_requ_estadoreq"] + '</td>' +
				'<td>' + VSC_REQUERIMIENTOS[i]["cl_clie_razonsoc"] + '</td>' +
				'<td>' + requ_fechainicio + '</td>' +
				'<td>' + requ_fechafin + '</td>' +
				'<td>' + VSC_REQUERIMIENTOS[i]["cl_requ_numeroest"] + ' ' + VSC_REQUERIMIENTOS[i]["cl_requ_unidadest"] + '</td>' +
				'<td class="text-center"><a href="#nuevoRequerimiento" onclick="fnEditarRequ(' + i + ')"><img src="assets/imgs/icon5.png" width="32" height="32"></a></td>' +
				'</tr>';
		}
		$("#tbrequerimiento tbody").append(contenido);
	}
	fnActivarDT();
}

function fnEditarRequ(indi) {
	fnLeerRequerimiento(VSC_REQUERIMIENTOS[indi]["cl_requ_id"]);
	
	fnLimpiarFormReq();
	bloqueoTotalRequForm();
	
	$(".nuevo-req").css("display", 'none');
	$(".editar-req").css("display", 'block');

	$("#requ_id").val(VSC_REQUERIMIENTOS[indi]["cl_requ_id"]);
	$("#requ_titulo").val(VSC_REQUERIMIENTOS[indi]["cl_requ_titulo"]);
	$("#requ_detalle").val(VSC_REQUERIMIENTOS[indi]["cl_requ_detalle"]);
	$("#requ_estado").val(VSC_REQUERIMIENTOS[indi]["cl_requ_estadoreq"]);
	$("#requ_fechacrea").val(VSC_REQUERIMIENTOS[indi]["cl_requ_fechacrea"]);
	if(VSC_REQUERIMIENTOS[indi]["cl_requ_fechainicio"] != null){
		$("#requ_fechainicio").val(formatoFecha(VSC_REQUERIMIENTOS[indi]["cl_requ_fechainicio"], '/'));
	}else{
		$("#requ_fechainicio").val(obtFechaActual());
	}
	if(VSC_REQUERIMIENTOS[indi]["cl_requ_fechafin"] != null){
		$("#requ_fechafin").val(formatoFecha(VSC_REQUERIMIENTOS[indi]["cl_requ_fechafin"], '/'));
	}else{
		$("#requ_fechainicio").val(obtFechaActual());
	}
	$("#requ_numeroest").val(VSC_REQUERIMIENTOS[indi]["cl_requ_numeroest"]);
	$("#requ_unidadest").val(VSC_REQUERIMIENTOS[indi]["cl_requ_unidadest"]);

	var icoadj = '<i class="mx-1 fa fa-file"></i>';
	var icoadj2 = '<i class="mx-1 fa fa-question"></i>';

	if (VSC_REQUERIMIENTOS[indi]["cl_requ_espfunuri"] != null) {
		$("#requ_espfunuri_u").append(icoadj + VSC_REQUERIMIENTOS[indi]["cl_requ_espfunuri"]);
		$('#requ_espfunuri_u').attr('href', ctx + VSC_REQUERIMIENTOS[indi]["cl_requ_codigo"] + '-EFU-' + VSC_REQUERIMIENTOS[indi]["cl_requ_espfunuri"]);
	} else {
		$("#requ_espfunuri_u").append(icoadj2 + 'Ningun Documento adjunto');
		$('#requ_espfunuri_u').attr('href', '#');
	}

	if (VSC_REQUERIMIENTOS[indi]["cl_requ_dfturi"] != null) {
		$("#requ_dfturi_u").append(icoadj + VSC_REQUERIMIENTOS[indi]["cl_requ_dfturi"]);
		$('#requ_dfturi_u').attr('href', ctx + VSC_REQUERIMIENTOS[indi]["cl_requ_codigo"] + '-DFT-' + VSC_REQUERIMIENTOS[indi]["cl_requ_dfturi"]);
	} else {
		$("#requ_dfturi_u").append(icoadj2 + 'Ningun Documento adjunto');
		$('#requ_dfturi_u').attr('href', '#');
	}

	if (VSC_REQUERIMIENTOS[indi]["cl_requ_espfunuricoo"] != null) {
		$("#requ_espfunuricoo_u").append(icoadj + VSC_REQUERIMIENTOS[indi]["cl_requ_espfunuricoo"]);
		$('#requ_espfunuricoo_u').attr('href', ctx + VSC_REQUERIMIENTOS[indi]["cl_requ_codigo"] + '-EFC-' + VSC_REQUERIMIENTOS[indi]["cl_requ_espfunuricoo"]);
	} else {
		$("#requ_espfunuricoo_u").append(icoadj2 + 'Ningun Documento adjunto');
		$('#requ_espfunuricoo_u').attr('href', '#');
	}

	var LSTDOCADI = VSC_REQUERIMIENTOS[indi]["lstDoad"];

	$("#tdocadi tbody").empty();
	if (LSTDOCADI.length > 0) {
		var contenido = "";
		for (var i = 0; i < LSTDOCADI.length; i++) {
			var col = i + 1
			contenido = contenido + '<tr id="doad_id_'+ LSTDOCADI[i]["cl_doad_id"] +'">' +
				'<td><a href="' + ctx + VSC_REQUERIMIENTOS[indi]["cl_requ_codigo"] + '-DAD-' + LSTDOCADI[i]["cl_doad_uri"] + '">' + icoadj + LSTDOCADI[i]["cl_doad_uri"] + '</a></td>' +
				'<td><a href="#"><span class="badge badge-warning btn_req btn-eliminar-doad" onclick="fn_eliminarDoad(' + LSTDOCADI[i]["cl_doad_id"] + ')">Eliminar</span></a></td>' +
				'</tr>';
		}
		$("#tdocadi tbody").append(contenido);
	}
	
	var LSTDOCADICOO = VSC_REQUERIMIENTOS[indi]["lstDoadCoo"];

	$("#tdocadicoo tbody").empty();
	if (LSTDOCADICOO.length > 0) {
		var contenido = "";
		for (var i = 0; i < LSTDOCADICOO.length; i++) {
			var col = i + 1
			contenido = contenido + '<tr id="doad_id_'+ LSTDOCADICOO[i]["cl_doad_id"] +'">' +
				'<td><a href="' + ctx + VSC_REQUERIMIENTOS[indi]["cl_requ_codigo"] + '-DAC-' + LSTDOCADICOO[i]["cl_doad_uri"] + '">' + icoadj + LSTDOCADICOO[i]["cl_doad_uri"] + '</a></td>' +
				'<td><a href="#"><span class="badge badge-warning btn_req btn-eliminar-doadcoo" onclick="fn_eliminarDoad(' + LSTDOCADICOO[i]["cl_doad_id"] + ')">Eliminar</span></a></td>' +
				'</tr>';
		}
		$("#tdocadicoo tbody").append(contenido);
	}

	var LSTESAD = VSC_REQUERIMIENTOS[indi]["lstEsad"];

	$("#tEstadoRequ tbody").empty();
	if (LSTESAD.length > 0) {
		var contenido = "";
		for (var i = 0; i < LSTESAD.length; i++) {
			var col = i + 1
			contenido = contenido + '<tr>' +
				'<td>' + col + '</td>' +
				'<td>' + LSTESAD[i]["cl_esad_estadoreq"] + '</td>' +
				'<td>' + LSTESAD[i]["cl_esad_fechacrea"] + '</td>' +
				'</tr>';
		}
		$("#tEstadoRequ tbody").append(contenido);
	} else {
		$("#estadoRequ").css("display", 'none');
	}

	var LSTOBSE = VSC_REQUERIMIENTOS[indi]["lstObse"];

	$("#lstObservacion").empty();
	if (LSTOBSE.length > 0) {

		if (LSTOBSE[0]["cl_obse_estadoreq"] != '' &&
			(VSC_REQUERIMIENTOS[indi]["cl_requ_estadoreq"] == 'Observado' ||
				VSC_REQUERIMIENTOS[indi]["cl_requ_estadoreq"] == 'Rechazado')) {
			$(".alert-obse").css("display", 'block');
			$("#alert-obse").text(LSTOBSE[0]["cl_obse_estadoreq"]);
		}

		var contenido = "";
		for (var i = 0; i < LSTOBSE.length; i++) {
			var col = i + 1
			contenido = contenido + '<div class="col-12">' +
				'<div class="form-row mt-1">' +
				'<textarea class="col-12 form-control" rows="4" maxlength="200" disabled>' +
				LSTOBSE[i]["cl_obse_observacion"] +
				'</textarea>' +
				'</div>' +
				'</div>';
		}
		$("#lstObservacion").append(contenido);
	} else {
		$(".alert-obse").css("display", 'none');
	}

	fnControlEditaRequ(VSC_REQUERIMIENTOS[indi]["cl_requ_estadoreq"]);
	
	$("#sist-req").hide();
	$("#editar-req").show();
}

function fn_eliminarDoad(doad_id) {
	axios.post('api/req/eliminarDoad', {
		"doad_id": doad_id
	},
		{
			headers: {
				'Content-Type': 'application/json',
			}
		}, {
	}).then((response) => {
		$('#modalNuevoRequerimiento').modal('hide');
		$('#doad_id_'+doad_id).remove();
		fnListarReq(indice);
	}).catch(function(error) {
		console.log('error', error)
		swal("Estimado usuario !", "" + error + "", "error")
	})
}

function bloqueoTotalRequForm() {
	
	$("#editar-req input[type='text']").prop('disabled', true);
	$("#editar-req input[type='date']").prop('disabled', true);
	$("#editar-req input[type='file']").prop('disabled', true);
	$("#editar-req textarea").prop('disabled', true);
	$(".requ_if").css("display", 'none');
	$(".btn_req").css("display", 'none');
}

function fnControlEditaRequ(estado) {
	bloqueoTotalRequForm();
	if(role_id == 3){
		if (estado == 'Guardado' || estado == 'Observado') {
			$('.requ_espfunuri_a').css("display", 'inline');
			$('.requ_docadiuri_a').css("display", 'inline');
			
			$("#requ_tipo").removeAttr("disabled");
			$("#requ_titulo").removeAttr("disabled");
			$("#requ_detalle").removeAttr("disabled");
			$("#requ_espfunuri").removeAttr("disabled");
			$("#requ_docadiuri").removeAttr("disabled");
			
			$("#btn_guardar_req").css("display", 'inline');
			$("#btn_enviar_req").css("display", 'inline');

			$("#btn_enviar_req").val("Estimar Req.");
		} else if (estado == 'Estimado') {
			
			$("#btn_guardar_req").css("display", 'inline');
			$("#btn_enviar_req").css("display", 'inline');
			$("#btn_rechazar_req").css("display", 'inline');

			$("#btn_enviar_req").val("Ejecutar Req.");
		}
		
		$("#btn_observar_req").css("display", 'inline');
		$(".btn-eliminar-doad").css("display", 'inline');
	}else{
		if (estado == 'Enviado a Estimar' || estado == 'Rechazado') {
			$('.requ_dfturi_a').css("display", 'inline');
			$('.requ_espfunuricoo_a').css("display", 'inline');
			$('.requ_docadiuricoo_a').css("display", 'inline');

			$("#requ_fechainicio").removeAttr("disabled");
			$("#requ_fechafin").removeAttr("disabled");
			$("#requ_dfturi").removeAttr("disabled");
			$("#requ_espfunuricoo").removeAttr("disabled");
			$("#requ_docadiuricoo").removeAttr("disabled");  //Para los archivos adicionales?
			$("#requ_numeroest").removeAttr("disabled");
			$("#requ_unidadest").removeAttr("disabled");

			$("#btn_guardar_req").css("display", 'inline');
			$("#btn_enviar_req").css("display", 'inline');
			if (estado != 'Rechazado') {
				$("#btn_observar_req").css("display", 'inline');
			}

			$("#btn_enviar_req").val("Enviar Aprob.");
		} else if (estado == 'Aprobado') {
			$('.requ_dfturi_a').css("display", 'inline');
			$('.requ_espfunuricoo_a').css("display", 'inline');
			$('.requ_docadiuricoo_a').css("display", 'inline');

			$("#requ_espfunuricoo").removeAttr("disabled");
			$("#requ_docadiuricoo").removeAttr("disabled"); //Para los archivos adcionales?
			$("#requ_fechainicio").removeAttr("disabled");
			$("#requ_fechafin").removeAttr("disabled");

			$("#btn_guardar_req").css("display", 'inline');
			$(".btn_enviar_req").css("display", 'block');

			$("#btn_enviar_req").val("Iniciar Req.");
		}
		$("#btn_rechazar_req").css("display", 'none');
		$(".btn-eliminar-doadcoo").css("display", 'inline');
	}
}

function fnActualizarIF(id){
	$("."+id+"_u").css("display", 'inline');
	$("."+id+"_a").css("display", 'none');
}
