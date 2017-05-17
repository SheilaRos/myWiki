<%-- 
    Document   : codeProfile
    Created on : 14-may-2017, 20:33:36
    Author     : Gulir
--%>

<%@page import="java.util.List"%>
<%@page import="entities.VoteEntry"%>
<%@page import="entities.Entry"%>
<%@page import="entities.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Profile</title>
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("user");
            Entry entry = (Entry) request.getAttribute("entry");
            List<Answer> answers = (List<Answer>) request.getAttribute("answers");
            Boolean existeVote = (Boolean) request.getAttribute("vote");
            if(user != null){
        %>
         <form action="Inicio" method="POST"><input type="hidden" name="usu" value="<%=user%>"><input type="submit" value="Inicio"></form>
            <form action="AllUsers" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="All users"></form>
            <form action="Perfil" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="Perfil"></form>
            <form action="libreria.jsp" method="POST"><input type="submit" value="Subir codigos"></form>
            <form action="AllCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="All codes"></form>
            <form action="LikeCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Codigos que me gustan"></form>
            <form action="logOut" method="POST"><input type="submit" value="Log Out"></form>
            
        <h1>Code Profile</h1>
        <h2><%= user %></h2>
        <div class="code">
            <table border="1">
                <tr><td>Lenguage</td><td><%= entry.getLanguage() %></td></tr>
                <tr><td>Autor</td><td><%= entry.getUsu() %></td></tr>
                <tr><td>Titulo</td><td><%= entry.getTitle() %></td></tr>
                <tr><td>Codigo</td><td><%= entry.getCode() %></td></tr>
            </table>
            </br>
            <% if (existeVote) { %>
            <form action="Dislike"><input type="hidden" name="user" value="<%= user %>"><input type="hidden" name="id" value="<%= entry.getId() %>" /><input type="submit" value="Dislike"></form>
                <% } else { %>
            <form action="Like"><input type="hidden" name="user" value="<%= user %>"><input type="hidden" name="id" value="<%= entry.getId() %>" /><input type="submit" value="Like"></form>
                <% }
                for (Answer ans : answers) { %>
            <table border="1">
                <tr><td>Usuario</td><td><%= ans.getUsu()%></td></tr>
                <tr><td>Respuesta</td><td><%= ans.getTextAnswer()%></td></tr>
            </table>
            </br>
            <% } %>
            <form action="CrearRespuesta"><input type="hidden" name="user" value="<%= user %>"><input type="hidden" name="id" value="<%= entry.getId() %>" />
                <textarea cols="60" rows="30" name="Respuesta" required></textarea>
                <input type="submit" value="Responder">
            </form>
        </div>
            <% 
           } else{
                request.getRequestDispatcher("/index.jsp").forward(request, response);
              } 
            %>
    </body>
</html>
