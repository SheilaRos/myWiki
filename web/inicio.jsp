<%-- 
    Document   : perfil
    Created on : 27-mar-2017, 19:13:47
    Author     : dam
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Wiki</title>
    </head>
    <body>
        <h1>My Wiki</h1>
        <div>
            <div>
            <%
                String user = (String) session.getAttribute("user");
                User usu = (User) request.getAttribute("usuCompleto");
                if (user != null && usu != null){
            %>
            
                <form action="inicio.jsp"><input type="submit" value="Inicio"></form>
                <form action="new.jsp"><input type="submit" value="Nueva entrada"></form>
                <form action="Perfil"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Perfil"></form>
                <form action="libreria.jsp"><input type="submit" value="Mis codigos"></form>
                <form action="likeCode.jsp"><input type="submit" value="Codigos que me gustan"></form>
                <form action="logOut"><input type="submit" value="Log Out"></form>
                <h1>Siguiendo</h1>
            <% 
          
            %>
                   <form method="GET" action="Profiles">
                       <h1>Hola</h1>
                       <input type="submit" value="hola" name="u">
                   </form>
            <%    
               
            %>
                <h1>Seguidores</h1>
                
                <h1>Novedades</h1>
                <%
                    
                 }
            else{
                   request.getRequestDispatcher("/inicio.jsp").forward(request, response);
                }
             %>    
            </div>
            <div>

            </div>
        </div>
        <div>
            
        </div>
    </body>
</html>
