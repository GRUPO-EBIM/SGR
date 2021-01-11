const obtFechaActual=()=>{
	var d = new Date();

	var month = d.getMonth()+1;
	var day = d.getDate();

	var output = d.getFullYear() + '-' +
	    (month<10 ? '0' : '') + month + '-' +
	    (day<10 ? '0' : '') + day;
	
	return output;
}

const obtPrimerDiaMes=()=>{
	var d = new Date();

	var month = d.getMonth()+1;

	var output = d.getFullYear() + '-' +
	    (month<10 ? '0' : '') + month + '-' +
	    '01';
	
	return output;
}

const obtHoraActual=()=>{
	var d = new Date();

	var minutes = d.getMinutes();
	var seconds = d.getSeconds();

	var output = d.getHours() +':'+
	    minutes +':'+
	    seconds;
	
	return output;
}

function restoFechas(f1,f2){
    var aFecha1 = f1.split('-');
    var aFecha2 = f2.split('-');
    var fFecha1 = Date.UTC(aFecha1[0],aFecha1[1]-1,aFecha1[2]);
    var fFecha2 = Date.UTC(aFecha2[0],aFecha2[1]-1,aFecha2[2]);
    var dif = fFecha2 - fFecha1;
    var dias = Math.floor(dif / (1000 * 60 * 60 * 24));
    return dias;
}

function formatoFecha(strfecha,separador){
	var strfechafmt = "";
	strfecha = strfecha.substring(0, 10);
    var ffecha = strfecha.split('-');
    strfechafmt = ffecha[2]+separador+ffecha[1]+separador+ffecha[0]
    return strfechafmt;
}

function fn_replicarObjetoJson(vco_estructura){
    var nuevaFilaJSON = null;
        nuevaFilaJSON = $.extend(nuevaFilaJSON, vco_estructura);    
    return nuevaFilaJSON;
}

function fn_replicarArrayJson(vco_array){
    var temp = JSON.stringify(vco_array);
    var rpta = JSON.parse(temp);
    return rpta;
}

function fn_buscarIndiceArrayJsonxIdValor(vco_array,nombreAtrib,valor){
    var ind =-1;
    var temp = fn_replicarArrayJson(vco_array);
    if(temp.length>0){
        for(var i=0;i<temp.length;i++){
            var objJson=fn_replicarObjetoJson(temp[i]);
            if(objJson[nombreAtrib]==valor){
                ind=i;
                break;
            }
        }
    }
    return ind; 
}

function fn_convertirFormatoJson(s){
    s = s.replace(/\\n/g, "\\n")
    .replace(/\\&/g, "\\&")
    .replace(/\\r/g, "\\r")
    .replace(/\\t/g, "\\t")
    .replace(/\\b/g, "\\b")
    .replace(/\\f/g, "\\f");
    s = s.replace(/[\u0000-\u0019]+/g,"");
    return s;
}

function ordenarPorClave(array, key) {
    return array.sort(function(a, b) {
        var x = a[key]; var y = b[key];
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    });
}