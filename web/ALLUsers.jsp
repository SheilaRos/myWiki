<%-- 
    Document   : ALLUsers
    Created on : 15-may-2017, 20:55:43
    Author     : dam
--%>

<%@page import="java.util.List"%>
<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Wiki</title>
    </head>
    <body>
        <h1>All Users</h1>
        <%
                String user = (String) session.getAttribute("user");
                List<User> users = (List) request.getAttribute("users");
          if(user != null){
              
        %>
            <form action="Inicio" method="POST"><input type="hidden" name="usu" value="<%=user%>"><input type="submit" value="Inicio"></form>
            <form action="AllUsers" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="All users"></form>
            <form action="Perfil" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="Perfil"></form>
            <form action="libreria.jsp" method="POST"><input type="submit" value="Subir codigos"></form>
            <form action="AllCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="All codes"></form>
            <form action="LikeCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Codigos que me gustan"></form>
            <form action="logOut" method="POST"><input type="submit" value="Log Out"></form>
        <%
            if( users.isEmpty()){
                %>
            <p>No hay usuarios registrados.</p>
                <%
            }else{
                for (User u : users){
                %>
                <div>
                <form action="Profiles" method="POST"><input type="submit" name="" value="<%=u.getNameUsu()%>"></form>
                </div>
                <%
                }
            }
           }else{
                 request.getRequestDispatcher("/index.jsp").forward(request, response);
            } 
         %>
    </body>
</html>
