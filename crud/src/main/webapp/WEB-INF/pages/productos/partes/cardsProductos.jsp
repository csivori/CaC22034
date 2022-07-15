<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${listaProductos}" var="producto">
    <div class="col">
        <div class="card h-100">
            <!-- Foto -->
           
                <img class="card-img-top img-fluid" src="${producto.foto}" alt="Foto de ${producto.descripcion}" />
           
            <!-- Detalles -->
            <div class="card-body p-4">
                <div class="text-center">
                    <h5 class="fw-bolder">${producto.descripcion}</h5>
                    <h6 class="fw-lighter">(${producto.grupoDesc})</h6>
                    <p class="mb-1">Cantidad: ${producto.stock}</p>
                </div>
            </div>
            <!-- Product actions-->
            <div class="card-footer border-top-0 bg-transparent">
                <div class="row justify-content-center">
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/app?accion=edit&id=${producto.id}" class="btn btn-warning btn-block w-100">Editar</a>
                    </div>
                    <div class="col-6">
                        <a href="${pageContext.request.contextPath}/app?accion=remove&id=${producto.id}" class="btn btn-danger btn-block w-100">Borrar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>