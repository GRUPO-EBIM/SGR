<%@ include file="/WEB-INF/view/body/include.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="msapplication-tap-highlight" content="no">
	<meta name="description" content="Materialize is a Material Design Admin Template,It's modern, responsive and based on Material Design by Google. ">
	<meta name="keywords" content="materialize, admin template, dashboard template, flat admin template, responsive admin template,">
	<title>Bienvenido | SGR</title>
	
	<!-- FAVICONS -->
	<link rel="icon" href="${contextPath}/assets/imgs/favicon.png" sizes="32x32">
	
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/bootstrap.css" media="screen,projection">
	<link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/main.css" media="screen,projection">
</head>

<body class="bg-login">
	<div class="container-login">
		<div class="container-login bg-login-p1">
	        <div class="container-login bg-login-p2">
		        <div class="d-flex align-items-center bg-login-p3">
			        <div class="login-form">
			            <div class="form-group">
				            <div class="d-flex d-flex-row">
				            	<img class="imglogin" alt="sgr" src="${contextPath}/assets/imgs/favicon.png">
				                <label class="titlogin">Sistema de Gestión de Requerimientos</label>
				            </div>
			            </div>
			            <div class="form-group mt-4">
			                <p class="mb-0 h5 text-left">LOGIN</p>
			            </div>
			            <form method="post" action="${contextPath}/login" id="sesionForm">
		                <div class="form-group">
		                    <input type="text" class="form-control" name="usuario" id="usuario" placeholder="Usuario"
		                    onkeydown="if(event.keyCode == 13){fn_validarIngreso();}">
		                </div>
		                <div class="form-group">
		                    <input type="password" class="form-control" name="clave" id="clave" placeholder="Contraseña"
		                    onkeydown="if(event.keyCode == 13){fn_validarIngreso();}">
		                </div>
			            </form>
			            <div class="d-flex justify-content-start align-items-center form-group login-form-2">
			                <input type="button" class="btn-login" onclick="fn_validarIngreso()" value="Ingresar">
			            </div>
			            <div class="d-flex justify-content-start align-items-center form-group login-form-2">
			                <label class="mjsError">${v_message}</label>
			            </div>
			        </div>
		        </div>
	        </div>
		</div>
	</div>
  
  <script type="text/javascript" src="${contextPath}/assets/js/jquery-3.4.1.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/popper.min.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/bootstrap.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/sweetalert.min.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/view/login.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  
  <script type="text/javascript">
	
  </script>
  
</body>

</html>