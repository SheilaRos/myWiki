<%-- 
    Document   : perfil
    Created on : 27-mar-2017, 19:13:47
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
        <h1>My Wiki</h1>
        <div>
            <div>
            <%
                String user = (String) session.getAttribute("user");
                if (user != null){
            %>
            
                <form action="inicio.jsp"><input type="submit" value="Inicio"></form>
                <form action="new.jsp"><input type="submit" value="Nueva entrada"></form>
                <form action="Perfil"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Perfil"></form>
                <form action="libreria.jsp"><input type="submit" value="Mis codigos"></form>
                <form action="LikeCodes"><input type="hidden" name="nombre" value="<%=user%>"><input type="submit" value="Codigos que me gustan"></form>
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
