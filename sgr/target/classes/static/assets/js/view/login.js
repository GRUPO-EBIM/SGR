function fn_validarIngreso(){
	var usuario = $("#usuario").val();
	var clave = $("#clave").val();
	
	if(usuario!=""){
		if(clave!=""){
			$("#sesionForm").submit();
		}else{
			$(".mjsError").text("Ingrese clave");
		}
	}else{
		$(".mjsError").text("Ingrese Usuario");
	}
}