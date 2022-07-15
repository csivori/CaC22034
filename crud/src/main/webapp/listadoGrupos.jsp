<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/pages/comunes/inicioHtml.jsp" />
<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp" />
<title>Listado de Grupos</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp" />
<jsp:include page="WEB-INF/pages/comunes/nav.jsp" />

<div class="container mt-3">
    <h2>Grupos</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Descripcion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listaGrupos}" var="grupo">
                <tr class="table-success">
                    <td>${grupo.descGrupo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="WEB-INF/pages/grupos/partes/modalAgregarGrupo.jsp" />
<jsp:include page="WEB-INF/pages/grupos/partes/modalBorrarGrupo.jsp" />
<jsp:include page="WEB-INF/pages/grupos/partes/modalEditarGrupo.jsp" />

<jsp:include page="WEB-INF/pages/comunes/footer.jsp" />
<jsp:include page="WEB-INF/pages/comunes/finHtml.jsp" />