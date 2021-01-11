<%@ include file="/WEB-INF/view/body/include.jsp" %>
<!-- modalEnviarObservacion -->
<div class="modal fade" id="modalEnviarObservacion" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog expandido" role="document">
    
        <div class="modal-content">
            <div class="modal-header borderh bg-info">
                <div class="modal-wrapper">
                    <div class="modal-text">
                        <p class="mb-0 h5 text-white">Sistema de Gestión de Requerimiento</p>
                    </div>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body form-bordered mb-info-underline">
                <div class="row">
                	<div class="col-12 mb-1">
                        <p class="gbold h4 mb-0">Rechazo</p>
                    </div>
                    <div class="col-12 mb-1">
                        <p class="gbold h4 mb-0">Observación</p>
                    </div>
                </div> 

                <div class="row">
					<textarea class="col-12 form-control" rows="4" id="obse_observacion" maxlength="200"></textarea>    
                </div>
                
                <div class="row">
                    <div class="col-12">
                        <div class="lstObservacion">
                        	
                        </div>
                    </div>      
                </div>
                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
        
    </div>
</div>
<!-- Fin modalEnviarObservacion -->

<!-- modalEstadoRequ -->
<div class="modal fade" id="modalEstadoRequ" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog expandido" role="document">
    
        <div class="modal-content">
            <div class="modal-header borderh bg-info">
                <div class="modal-wrapper">
                    <div class="modal-text">
                        <p class="mb-0 h5 text-white">Sistema de Gestión de Requerimiento</p>
                    </div>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body form-bordered mb-info-underline">
                <div class="row">
                	<div class="col-12 mb-1">
                        <p class="gbold h4 mb-0">Estados</p>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-12">
                        <div class="lstObservacion">
                             <table id="tEstadoRequ" class="table table-bordered" style="width:100%">
                                <thead>
                                    <tr class="table-info">
                                        <th>#</th>
                                        <th>Estado</th>
                                        <th>Fecha</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	
                                </tbody>
                            </table>
                        </div>
                    </div>      
                </div>
                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
        
    </div>
</div>
<!-- Fin modalEstadoRequ -->
