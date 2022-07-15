<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div class="modal fade" id="modalEditarGrupo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Editar grupo</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formEditarGrupo" action="${pageContext.request.contextPath}/grupo?accion=edit2"
                  method="post" class="was-validated">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6 mb-3">
                            <label for="grupo" class="form-label">Grupo</label>
                            <select class="form-control" id="grupo" name="grupo" placeholder="Ingrese un Grupo" required>
                                <c:forEach items="${listaGrupos}" var="grupo">
                                    <option value="${grupo.idGrupo}">${grupo.descGrupo}</option>
                                </c:forEach>
                            </select>                    
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="descGrupoNuevo" class="form-label">Nueva Descripcion</label>
                            <input type="text" class="form-control" id="descGrupoNuevo" name="descGrupoNuevo" required>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-success">Aceptar</button>
                </div>
            </form>
        </div>
    </div>
</div>
