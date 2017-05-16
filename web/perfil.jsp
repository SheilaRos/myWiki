<%-- 
    Document   : perfil
    Created on : 28-mar-2017, 17:33:09
    Author     : dam
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <%
        User datos = (User) request.getAttribute("usuario");
        if (datos != null){
        %>
        <h1>Perfil</h1>
        <form action="Modificar" method="POST">
            <p>Nombre: <input type="text" name="name" value="<%= datos.getName()%>"></p>
            <input type="hidden" name="nombreUsu" value="<%=datos.getNameUsu()%>"/>
            <p>E-mail : <input type="text" name="email" value="<%= datos.getEmail()%>"></p>
            <p>Ciudad : <input type="text" name="city" value="<%= datos.getLocation()%>"></p>
            <p>Bio : </p>
            <textarea cols="100" rows="10" name="bio" value="<%= datos.getBio()%>">
            </textarea>
            <p><input type="submit" value="Modificar" name="Modificar"></p>
        </form>
            <h1>Modificar Contraseña</h1>
        <form action="ModificarPass" method="POST">
            <input type="hidden" name="nombreUsu" value="<%=datos.getNameUsu()%>">
           <p>Password Old: <input type="password" name="passOld"></p>
           <p>Password New: <input type="password" name="passNew"></p>
           <p>Password Confirm: <input type="password" name="passConfirm"></p>
           <p><input type="submit" value="ModificarPass" name="ModificarPass"></p>
        </form>
        <%
        }else{
           request.getRequestDispatcher("/inicio.jsp").forward(request, response);
         }
        %>
    </body>
</html>
