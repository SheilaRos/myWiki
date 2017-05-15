<%-- 
    Document   : codeProfile
    Created on : 14-may-2017, 20:33:36
    Author     : Gulir
--%>

<%@page import="entities.Entry"%>
<%@page import="entities.Answer"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code Profile</title>
    </head>
    <body>
        <% 
        Entry entry = (Entry) request.getAttribute("entry");
        Collection<Answer>answers = (Collection<Answer>) request.getAttribute("answers");
            %>
        <div class="code">
            <table border="1">
                <tr><td>Lenguage</td><td><%= entry.getLanguage() %></td></tr>
                <tr><td>Autor</td><td><form action="Perfil"><input type="submit" name="otroUsuario" value="<%= entry.getUsu() %>"/></form></td></tr>
                <tr><td>Titulo</td><td><form action="ShowCode"><input type="hidden" value="<%= entry.getId() %>" /><input type="submit" value="<%= entry.getTitle() %>"/></form></td></tr>
                <tr><td>Codigo</td><td><%= entry.getCode() %></td></tr>
            </table>
            </br>
            <% for(Answer ans : answers){ %>
            <table border="1">
                <tr><td>Usuario</td><td><%= ans.getUsu() %></td></tr>
                <tr><td>Respuesta</td><td><%= ans.getTextAnswer() %></td></tr>
            </table>
            </br>
                <% } %>
        </div>
    </body>
</html>
