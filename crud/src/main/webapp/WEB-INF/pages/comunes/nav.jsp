
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid px-4 px-lg-5">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <!--<img class="d-inline-block align-text-center" src="" alt=""/>-->
            CRUD Productos
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/app">App</a>       
                </li>
                <li class="nav-item dropdown">
                    <a ${accesoTablas} class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Grupos
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#modalAgregarGrupo">Agregar</a></li>
                        <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#modalEditarGrupo">Editar</a></li>
                        <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#modalBorrarGrupo">Borrar</a></li>
                         <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/grupo">Listar</a></li>
                    </ul>                        
                </li>
            </ul>
            <form id="formBuscarProducto" action="${pageContext.request.contextPath}/app?accion=buscar"
                  method="post">
                <div class="d-flex">
                    <input ${accesoTablas} class="form-control me-2" minlength="3" id="buscar" name="buscar" type="search" placeholder="Producto" aria-label="Search">
                    <button ${accesoTablas} class="btn btn-outline-success" type="submit">Buscar</button>
                </div>
            </form>
        </div>
    </div>
</nav>