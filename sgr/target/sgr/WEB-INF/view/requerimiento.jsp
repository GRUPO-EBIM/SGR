<%@ include file="/WEB-INF/view/body/head.jsp"%>
<body>

	<%@ include file="/WEB-INF/view/body/header.jsp"%>
	<div class="loader" id="employee_tracking"></div>

	<div class="row contenido-co">

		<%@ include file="/WEB-INF/view/body/menu.jsp"%>
		
		<div class="btnRanura d-none d-lg-block">
			<a href="#"><img alt="ocultar" class="btnocu" src="${contextPath}/assets/imgs/icon6.png" /></a>
		</div>
		
		<div class="col-12 col-lg-10 bg-light contenido-co">
		
			<%@ include file="/WEB-INF/view/modal/modalNuevoRequerimiento.jsp"%>

			<input type="hidden" id="usua_role_id" value="${usua.cl_usua_role_id}" />
			<div class="row">
				<div class="col-12">
					<div class="row mt-3">
						<div class="ml-2 col-5 d-block d-lg-none text-left" id="btn-toggle-menureq">
							<a href="#"><span class="text-gray text-decoration-none"><i class="fa fa-bars"></i></span></a>
							<label class="mx-2 text-gray glight">Menu</label>
						</div>
						<!-- Inicio contenedor editar requerimiento -->
						<div id="editar-req" class="col-12">
							<div class="col-12 text-right">
								<input type="button"
									class="mx-2 mb-2 text-white btn btn-success btn-block-xs-only btn_req"
									id="btn_enviar_req" value="Estimar req." />
								<c:if test="${usua.cl_usua_role_id eq 3}">
									<input type="button"
										class="mx-2 mb-2 text-white btn btn-danger btn-block-xs-only btn_req"
										id="btn_rechazar_req" value="Rechazar" />
								</c:if>
								<c:if test="${usua.cl_usua_role_id eq 4}">
									<input type="button"
										class="mx-2 mb-2 text-white btn btn-danger btn-block-xs-only btn_req"
										id="btn_observar_req" value="Observar" />
								</c:if>	
								<input type="button"
									class="mx-2 mb-2 text-white btn btn-primary btn-block-xs-only btn_req"
									id="btn_guardar_req" value="Guardar" />
								<input type="button"
									class="mx-2 mb-2 text-white btn btn-danger btn-block-xs-only"
									id="btn_cancelar_req" value="Cancelar" />
							</div>
							<div class="bg-light">
								<div class="col-12 mt-2">
									<div class="h5 pb-2 text-primary font-weight-bold mb-primary-underline nuevo-req">Nuevo Requerimiento</div>
									<div class="h5 pb-2 text-primary font-weight-bold mb-primary-underline editar-req">Editar Requerimiento</div>
								</div>
							</div>
							<div class="bg-light">
								<div class="col-12 mt-4 bg-light">
									<p class="mb-1 h5 titulo-nuevoreq"></p>
									<div></div>
									<div class="row">
									
										<input type="hidden" id="fren_indice">
										<input type="hidden" id="requ_id">
										<input type="hidden" id="clie_ruc"> 
										<input type="hidden" id="clie_codigo">
										<input type="hidden" id="fren_id"> 
										<input type="hidden" id="fren_nombre"> 
										<input type="hidden" id="sfre_id">
										<input type="hidden" id="sfre_nombre">
										<input type="hidden" id="requ_tipo">
										<input type="hidden" id="obse_observacion">
										
										<div class="col-12 col-md-6">
											<div class="row mt-2">
												<label class="col-12 col-md-3 font-weight-bold">Titulo</label>
												<input type="text" class="col-12 col-md-9 form-control"
													id="requ_titulo" maxlength="40" required>
											</div>
											<div class="row mt-2">
												<label class="col-12 font-weight-bold">Detalle</label>
												<textarea class="col-12 form-control" rows="4"
													id="requ_detalle" maxlength="1000"></textarea>
											</div>
											<!-- Segunda columna del formulario de detalle de req -->
										</div>
										<div class="col-12 col-md-6">
											<div class="row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">Estado</label>
												<input type="text" class="mx-2 col-12 col-md form-control" id="requ_estado" required>
											</div>
											<div class="row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">FecCreación</label>
												<input type="date" class="mx-2 col-12 col-md form-control" id="requ_fechacrea" required>
											</div>
											<div class="row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">Doc.Requerimiento</label>
												<div class="col-12 col-md requ_if requ_espfunuri_u">
													<input type="file" name="requ_espfunuri" id="requ_espfunuri" class="mx-2 custom-file-input" />
													<label for="requ_espfunuri" class="mx-2 text-center custom-file-label">Seleccionar archivos</label>
												</div>
												<div class="col-12">
													<a id="requ_espfunuri_u" class="mx-2 text-center"></a> 
													<a href="#" class="mx-2 text-center requ_if requ_espfunuri_a" onclick="fnActualizarIF('requ_espfunuri')"><span class="badge badge-success">Actualizar</span></a>
												</div>
											</div>
											<div class="row mt-2">
												<label class="col-12 col-md-12 font-weight-bold">Archivos adicionales</label>
												<div class="col-12 col-md requ_if requ_docadiuri_u">
													<input type="file" name="requ_docadiuri" id="requ_docadiuri" class="mx-2 custom-file-input" multiple="multiple"/> 
													<label for="requ_docadiuri" class="mx-2 text-primary font-weight-bold border-0 custom-file-label">Subir archivos adicionales</label>
												</div>
												<div class="col-12">
													<a href="#" class="mx-2 text-center requ_if requ_docadiuri_a" onclick="fnActualizarIF('requ_docadiuri')"><span class="badge badge-success">Agregar Archivos</span></a>
													<table id="tdocadi" class="table table-sm">
														<thead>
															<tr>
																<th>Documento</th>
																<th>Elim.</th>
															</tr>
														</thead>
														<tbody></tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="bg-light editar-req">
								<div class="col-12 mt-2">
									<div class="h5 pb-2 text-primary font-weight-bold mb-primary-underline">Estimación GEP</div>
								</div>
							</div>
							<div class="bg-light editar-req">
								<div class="col-12 mt-3 bg-light">
									<div class="row">
										<div class="col-12 col-md-6">
											<div class="row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">DFT</label>
												<div class="col-12 col-md requ_if requ_dfturi_u">
													<input type="file" name="requ_dfturi" id="requ_dfturi" class="mx-2 custom-file-input" /> 
													<label for="requ_dfturi" class="mx-2 text-center custom-file-label">Seleccionar archivos</label>
												</div>
												<div class="col-12">
													<a id="requ_dfturi_u" class="mx-2 text-center"></a> 
													<a href="#" class="mx-2 text-center requ_if requ_dfturi_a" onclick="fnActualizarIF('requ_dfturi')"><span class="badge badge-success">Actualizar</span></a>
												</div>
											</div>
											<div class="row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">Cronograma</label>
												<div class="col-12 col-md requ_if requ_espfunuricoo_u">
													<input type="file" name="requ_espfunuricoo" id="requ_espfunuricoo" class="mx-2 custom-file-input" /> 
													<label for="requ_espfunuricoo" class="mx-2 text-center custom-file-label">Seleccionar archivos</label>
												</div>
												<div class="col-12">
													<a id="requ_espfunuricoo_u" class="mx-2 text-center"></a> 
													<a href="#" class="mx-2 text-center requ_if requ_espfunuricoo_a" onclick="fnActualizarIF('requ_espfunuricoo')"><span class="badge badge-success">Actualizar</span></a>
												</div>
											</div>
											<div class="row mt-2">
												<label class="col-12 col-md-12 font-weight-bold">Archivos adicionales</label>
												<div class="col-12 col-md requ_if requ_docadiuricoo_u">
													<input type="file" name="requ_docadiuricoo" id="requ_docadiuricoo" class="mx-2 custom-file-input" multiple="multiple"/> 
													<label for="requ_docadiuricoo" class="mx-2 text-primary font-weight-bold border-0 custom-file-label">Subir archivos adicionales</label>
												</div>
												<div class="col-12">
													<a href="#" class="mx-2 text-center requ_if requ_docadiuricoo_a" onclick="fnActualizarIF('requ_docadiuricoo')"><span class="badge badge-success">Agregar Archivos</span></a>
													<table id="tdocadicoo" class="table table-sm">
														<thead>
															<tr>
																<th>Documento</th>
																<th>Elim.</th>
															</tr>
														</thead>
														<tbody></tbody>
													</table>
												</div>
											</div>
										</div>
										<div class="col-12 col-md-6">
											<div class="form-row mt-2" id="divedit-esth">
												<label class="col-12 col-md-4 font-weight-bold">Estimación</label>
												<input class="col-12 col-md-2" id="requ_numeroest" type="text" />
												<select class="col-12 col-md-4 mx-2" id="requ_unidadest">
													<option value="hrs" selected>Horas</option>
												</select>
											</div>
											<div class="form-row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">FecInicio</label>
												<input type="date" class="mx-2 col-12 col-md form-control" id="requ_fechainicio" required>
											</div>
											<div class="form-row mt-2">
												<label class="col-12 col-md-4 font-weight-bold">FecFin</label>
												<input type="date" class="mx-2 col-12 col-md form-control" id="requ_fechafin" required>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Fin contenedor editar requermiento -->
						
						<!-- Contenedor del sistema de requerimiento -->
						<div id="sist-req" class="col-12 pl-0">
							<div class="col-12 col-lg-12 text-right">
								<c:if test="${usua.cl_usua_role_id eq 3}">
									<input type="button" class="mb-2 mx-2 text-white btn-primary btn-block-xs-only" id="btn_nuevo_req" value="Nuevo Requerimiento" />
								</c:if>
							</div>
							<div class="col-12 col-lg-12 pl-1 bg-light">
								<div class="col-12 mt-2">
									<!-- tabs -->
									<div class="tabs-container mb-info-underline">
										<div id="tab1" class="tab js-tab h5 p-1 p-sm-2 mb-0"
											onclick="changeContent(1)">Bandeja de Entrada</div>
										<div id="tab2" class="tab js-tab h5 p-1 p-sm-2 mb-0"
											onclick="changeContent(2)">Historial</div>
									</div>
								</div>
							</div>
							<div class="bg-light">

								<div class="col-12 mt-2 bg-light">

									<div id="tab-body1" class="px-2 tab-body">
										<p class="mb-1 h5 titulo-req"></p>
										<table id="tbrequerimiento" class="display nowrap"
											style="width: 100%">
											<thead>
												<tr>
													<th>Cod.Req</th>
													<th>Titulo</th>
													<th>Estado</th>
													<th>Cliente</th>
													<th>Fe.Inicio</th>
													<th>Fe.Fin</th>
													<th>Estimación</th>
													<th>Editar</th>
												</tr>
											</thead>
											<tbody>

											</tbody>
											<tfoot>
												<tr class="table-info">
													<th>Cod.Req</th>
													<th>Titulo</th>
													<th>Estado</th>
													<th>Cliente</th>
													<th>Fe.Inicio</th>
													<th>Fe.Fin</th>
													<th>Estimación</th>
													<th>Editar</th>
												</tr>
											</tfoot>
										</table>
									</div>

									<div id="tab-body2" class="px-2 tab-body">
										<p class="mb-1 h5 titulo-his"></p>
										<table id="tbhistorial" class="display nowrap"
											style="width: 100%">
											<thead>
												<tr>
													<th>Cod.Req</th>
													<th>Titulo</th>
													<th>Estado</th>
													<th>Cliente</th>
													<th>Fe.Inicio</th>
													<th>Fe.Fin</th>
													<th>Estimación</th>
												</tr>
											</thead>
											<tbody>

											</tbody>
											<tfoot>
												<tr class="table-info">
													<th>Cod.Req</th>
													<th>Titulo</th>
													<th>Estado</th>
													<th>Cliente</th>
													<th>Fe.Inicio</th>
													<th>Fe.Fin</th>
													<th>Estimación</th>
												</tr>
											</tfoot>
										</table>
									</div>

									<div id="tab-body3  " class="px-2 tab-body"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Ejemplo de menu flotante con JQuery -->

	<!-- Fin Ejemplo de menu flotante con JQuery -->

	<%@ include file="/WEB-INF/view/body/footer.jsp"%>
	<%@ include file="/WEB-INF/view/body/scripts.jsp"%>
	<script type="text/javascript"
		src="${contextPath}/assets/js/view/requerimiento.js"></script>
	<script type="text/javascript"
		src="${contextPath}/assets/js/ajax/ajax.js"></script>

	<script>
		var flagsesion = true

		function changeContent(id) {
			$('.js-tab').removeClass('active');
			$('.tab-body').removeClass('active');
			$('#tab-body' + id).addClass('active');
			$('#tab' + id).addClass('active');
		}

		$(document).ready(function() {
			fnVerificarSesion();
		})

		function cargaInicial() {
			CONTEXTO = '${contextPath}';
			role_id = $("#usua_role_id").val();

			changeContent(1);
			fnCargarMenuFrente();
		}
	</script>

</body>
</html>
