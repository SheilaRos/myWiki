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
        <header>
            <h1>Bienvenido a My Wiki</h1>
            <form action="Validar" method="POST">
            <p>Usuario : <input type="text" required name="usu"></p><p>Password :<input type="password" required name="pass"></p>
            <p><input type="submit" value="Login" name="Login"></p>
        </form>
        </header>
        
        <form action="Registro" method="POST">
             <p>Nombre usuario : <input type="text" name="name"></p>
            <p>Password : <input type="password" name="pass"></p>
            <p>E-mail : <input type="text" name="email"></p>
            <p>Ciudad : <input type="text" name="city"></p> 
            <p><input type="submit" value="Registrar" name="Registrar"></p>
        </form>
    </body>
</html>
