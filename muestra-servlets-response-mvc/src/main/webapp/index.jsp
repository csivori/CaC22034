<%-- 
    Document   : index
    Created on : 19 jun. 2022, 22:55:08
    Author     : Fer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="STYLESHEET" href="./css/estilos.css" />
        <title>Formulario Servlet (JSP)</title>
    </head>
    <body>
        <h1>Prueba de Formulario con MVC (Método POST)</h1>
        <form name="form1" action="${pageContext.request.contextPath}/servlet-controlador" method="POST">
            <input type="text" id="usuario" name="usuario" placeholder="Usuario"><br><br>
            <input type="password" id="clave" name="clave" placeholder="Clave"><br><br>
            <input type="submit" class="btn btnOk"><input type="reset" class="btn btnCancel">
        </form>
    </body>
</html>
