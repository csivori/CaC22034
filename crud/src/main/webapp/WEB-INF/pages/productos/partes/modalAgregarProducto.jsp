<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="modalAgregarProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formAgregarProducto" action="${pageContext.request.contextPath}/app?accion=add"
                  method="post" class="was-validated">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-12 mb-3">
                            <label for="grupo" class="form-label">Grupo</label>
                            <select class="form-control" id="grupo" name="grupo" placeholder="Ingrese un Grupo" required>
                                <c:forEach items="${listaGrupos}" var="grupo">
                                    <option value="${grupo.idGrupo}">${grupo.descGrupo}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="descripcion" class="form-label">Descripcion</label>
                            <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="stock" class="form-label">Stock</label>
                            <input type="number" min="0" pattern="[0-9]" class="form-control" id="stock" name="stock" required>
                        </div>
                       <div class="col-12 mb-3">
                            <label for="foto" class="form-label">Cargar foto</label>
                            <input type="file" class="form-control" id="inputFoto" name="foto">
                            <input type="hidden" id="fotoBase64" name="fotoBase64">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-success">Agregar</button>
                </div>
            </form>
        </div>
    </div>
</div>
