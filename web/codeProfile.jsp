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
        %>
        <h1>Code Profile</h1>
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
    </body>
</html>
