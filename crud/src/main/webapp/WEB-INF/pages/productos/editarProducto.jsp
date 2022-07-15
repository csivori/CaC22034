
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../comunes/inicioHtml.jsp"/>

<jsp:include page="../comunes/inicioHead.jsp"/>
<title>Editando a ${productoAEditar.descripcion}</title>
<jsp:include page="../comunes/finHead.jsp"/>

<jsp:include page="../comunes/nav.jsp"/>

<section class="py-3">
    <div class="container">
        <div class="row">
            <h1 class="h3">Editando producto</h1>
            <p class="lead">Estás a punto de editar a ${productoAEditar.descripcion}. Asegurate de hacer click en "Confirmar cambios".</p>
        </div>
    </div>
    <div class="container px-4 mt-3">
        <div class="row align-items-center">
            <div class="col-md-5 col-lg-4" >
                <div class="card border p-4 rounded-3 bg-light">
                    <img class="card-img-top" id="imagenProducto" src="${productoAEditar.foto}" alt="Foto de ${productoAEditar.descripcion}" />
                    <div class="card-body pb-0">
                        <div class="text-center">
                            <h5 class="fw-bolder">${productoAEditar.descripcion}</h5>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-7 col-lg-8" >
                <form id="formAgregarProducto" action="${pageContext.request.contextPath}/app?accion=edit2&id=${productoAEditar.id}"
                      method="post" class="was-validated border p-4 rounded-3 bg-light">
                    <div class="row">
                        <div class="col-sm-12 mb-3">
                            <label for="grupo" class="form-label">Grupo</label>
                            <select class="form-control" id="grupo" name="grupo" placeholder="Ingrese un Grupo" required>
                                <c:forEach items="${listaGrupos}" var="grupo">
                                    <c:choose>
                                        <c:when test="${grupo.idGrupo == productoAEditar.grupo}"> 
                                            <option value="${grupo.idGrupo}" selected >${grupo.descGrupo}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${grupo.idGrupo}">${grupo.descGrupo}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="descripcion" class="form-label">Descripcion</label>
                            <input type="text" class="form-control" id="descripcion" name="descripcion" value="${productoAEditar.descripcion}" required>
                        </div>
                        <div class="col-sm-6 mb-3">
                            <label for="stock" class="form-label">Stock</label>
                            <input type="number" min="0" pattern="[0-9]" class="form-control" id="stock" name="stock" value="${productoAEditar.stock}" required>
                        </div>
                        <div class="col-12 mb-3">
                            <label for="foto" class="form-label">
                                <c:choose>
                                    <c:when test="${yaTieneFoto}">Modificar</c:when>
                                    <c:otherwise>Agregar</c:otherwise>
                                </c:choose>
                                foto
                            </label>
                            <input type="file" class="form-control" id="inputFoto" name="foto">
                            <input type="hidden" id="fotoBase64" name="fotoBase64" value="${productoAEditar.foto}">
                        </div>
                    </div>
                    <div class="row justify-content-end mt-2">
                        <div class="col-12">
                            <div class="float-end">
                                <a href="${pageContext.request.contextPath}/app" class="btn btn-secondary">Volver atrás</a>
                                <button type="submit" class="btn btn-warning">Confirmar cambios</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<script src="scripts/fotobase64.js"></script>
<jsp:include page="../comunes/footer.jsp"/>
<jsp:include page="../comunes/finHtml.jsp"/>


