<%@ include file="/WEB-INF/view/body/include.jsp"%>
<div class="d-flex flex-row barra-encabezado">
	<div
		class="d-none d-md-block col-12 col-md-2 pl-1 text-center align-self-center raya-blanca">
		<img src="${contextPath}/assets/imgs/logoge_blanco.png"
			class="logo-encabezado">
	</div>
	<div
		class="d-none d-md-block col-12 col-md-5 pl-1 text-center text-md-left">
		<p class="mb-0 pt-4 pb-4 pl-1 h5 text-left text-white">Sistema de
			Gestión de Requerimientos</p>
	</div>
	<div class="d-none d-md-block col-8 col-md-4 text-right">
		<p class="mb-0 pt-4 pb-4 h5 text-right text-white">Bienvenido,
			${usua.cl_usua_nombre}</p>
	</div>
	<div
		class="d-none d-md-block col-4 col-md-1 text-white text-right text-md-center btn-toogle-menu">
		<div class="mb-0 pt-4 pb-4 align-self-center">
			<span class="h3 text-decoration-none"><i class="fa fa-bars"></i></span>
		</div>
	</div>

	<!-- aqui va el menu flotante -->
	<div class="barra-encabezado d-none d-md-block menu-float mt-3 py-2 px-3 py-sm-3">
		<ul class="list-unstyled text-right">
			<li><a class="h5 text-decoration-none text-white" href="#"
				onclick="changeContent(3)">Mi Perfil</a></li>
			<li><hr class="border-white my-2"></li>
			<li><a class="h5 text-decoration-none text-white"
				href="${contextPath}/logout">Salir</a></li>
		</ul>
	</div>

</div>
<!-- Vista para pantallas pequeñas -->
<div class="d-flex d-md-none flex-column barra-encabezado">
	<div class="column justify-content-center">
		<div class="col-12 pt-3 pb-3 text-center">
			<img src="${contextPath}/assets/imgs/logoge_blanco.png"
				class="logo-encabezado">
		</div>
	</div>
	<div class="row justify-content-center">
		<div class="col-8 text-center">
			<p class="mb-0 pt-3 pb-3 h5 text-center text-white">Bienvenido,
				${usua.cl_usua_nombre}</p>
		</div>
		<div class="col-4 text-white text-center text-md-center btn-toogle-menu">
			<div class="mb-0 pt-3 pb-3 align-self-center">
				<span class="h3 text-decoration-none"><i class="fa fa-bars"></i></span>
			</div>
		</div>
	</div>
	<div class="mt-5 pt-3 barra-encabezado menu-float px-3 py-sm-3">
		<ul class="list-unstyled text-right">
			<li><a class="h5 text-decoration-none text-white" href="#"
				onclick="changeContent(3)">Mi Perfil</a></li>
			<li><hr class="border-white my-2"></li>
			<li><a class="h5 text-decoration-none text-white"
				href="${contextPath}/logout">Salir</a></li>
		</ul>
	</div>

</div>