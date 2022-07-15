<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<jsp:include page="WEB-INF/pages/comunes/inicioHtml.jsp" />
<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp" />
<title>Home</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp" />
<c:set var="accesoTablas" scope="session" value="hidden"/>
<jsp:include page="WEB-INF/pages/comunes/nav.jsp" />

<div class="p-5 mb-4 bg-light rounded-3">
    <div class="container-fluid py-5 col-8">
        <h1 class="display-5 fw-bold">Sistema Web de Productos</h1>

        <a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath}/app">Ir a la app</a>
    </div>
</div>

<jsp:include page="WEB-INF/pages/comunes/footer.jsp" />
<jsp:include page="WEB-INF/pages/comunes/finHtml.jsp" />

