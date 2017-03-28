<%-- 
    Document   : index
    Created on : 27-mar-2017, 19:12:10
    Author     : dam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Wiki</title>
    </head>
    <body>
        <h1>Bienvenido a My Wiki</h1>
        <form action="inicio.jsp">
            <p>Usuario : <input type="text" required name="usu"></p>
            <p>Password :<input type="password" required name="pass"></p>
            <input type="submit" value="Entrar">
        </form>
        <form action="registro.jsp">
            <input type="submit" value="Registrate">
        </form>
    </body>
</html>
