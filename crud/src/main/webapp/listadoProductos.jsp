<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/pages/comunes/inicioHtml.jsp" />
<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp" />
<title>Listado de Productos</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp" />
<jsp:include page="WEB-INF/pages/comunes/nav.jsp" />

<section class="py-3">
    <div class="container">
        <div class="row">
            <h1 class="h3">Listado de Productos</h1>
            <p class="lead">Se listan todos los Productos existentes en la base de datos</p>
            <div>
                <a href="#" class="btn btn-success"
                   data-bs-toggle="modal" data-bs-target="#modalAgregarProducto">Agregar producto</a>
            </div>
        </div>
        <c:choose>
            <c:when test="${listaProductos != null && !listaProductos.isEmpty()}">
                <div class="row g-4 mt-3 row-cols-1 row-cols-sm-2 row-cols-lg-3 row-cols-xl-4 row-cols-xxl-5" data-masonry='{"percentPosition": true }' >
                    <jsp:include page="WEB-INF/pages/productos/partes/cardsProductos.jsp"/>
                </div>
            </c:when>
            <c:otherwise>
                <div class="row mt-4">
                    <div class="col-12">
                        <p class="display-5 text-danger">Ooops! Parece que no hay productos...</p>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</section>

<jsp:include page="WEB-INF/pages/productos/partes/modalAgregarProducto.jsp" />
<jsp:include page="WEB-INF/pages/grupos/partes/modalAgregarGrupo.jsp" />
<jsp:include page="WEB-INF/pages/grupos/partes/modalBorrarGrupo.jsp" />
<jsp:include page="WEB-INF/pages/grupos/partes/modalEditarGrupo.jsp" />
<script src="scripts/fotobase64.js"></script>

<jsp:include page="WEB-INF/pages/comunes/footer.jsp" />
<jsp:include page="WEB-INF/pages/comunes/finHtml.jsp" />