<%-- 
    Document   : registro
    Created on : 28-mar-2017, 17:37:52
    Author     : dam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>¡Registrate en My Wiki!</h1>
        <form action="Registro" method="POST">
            <p>Nombre usuario : <input type="text" name="name"></p>
            <p>Password : <input type="password" name="pass"></p>
            <p>E-mail : <input type="text" name="email"></p>
            <p>Ciudad : <input type="text" name="city"></p>
            
            <p><input type="submit" value="New" name="Registrar"></p>
        </form>
    </body>
</html>
