function fnVerificarSesion(){
	axios.post('api/usu/verificarSesion',{},{
    	headers: {
       		'Content-Type': 'application/json',
   		}
    },{
	}).then((response)=>{
		if(response.data.v_type_message == 'S'){
			cargaInicial();
		}else{
			window.location.href = "login"
		}
	})
}