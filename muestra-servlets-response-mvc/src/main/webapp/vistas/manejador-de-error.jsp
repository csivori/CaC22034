<%-- 
    Document   : ingreso
    Created on : 19 jun. 2022, 23:17:22
    Author     : Fer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="STYLESHEET" href="../css/estilos.css" />
        <title>Error</title>
    </head>
    <body>
        <h1>Error en la clase ${clase}</h1>
        <p>${msgError}</p>
        <p>Clause: ${excepcion}</p>
        <a href="${pageContext.request.contextPath}"><button class="btn btnHome">Reintentar</button></a>
    </body>
</html>
