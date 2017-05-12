<%-- 
    Document   : likeCode
    Created on : 28-mar-2017, 17:33:54
    Author     : dam
--%>

<%@page import="java.util.Collection"%>
<%@page import="entities.Entry"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WikiCode</title>
    </head>
    <body>
        <h1>Codigos que me gustan</h1>        
        <% 
        Collection<Entry>codes = (Collection<Entry>) request.getAttribute("entries");
        if (codes.isEmpty() == false){
        for (Entry entry : codes) {
            %>
        <div class="code">
            <table border="1">
                <tr><td>Lenguage</td><td><%= entry.getLanguage() %></td></tr>
                <tr><td>Autor</td><td><form action="Perfil"><input type="submit" name="otroUsuario" value="<%= entry.getUsu() %>"/></form></td></tr>
                <tr><td>Titulo</td><td><form action="ShowCode"><input type="hidden" value="<%= entry.getId() %>" /><input type="submit" value="<%= entry.getTitle() %>"/></form></td></tr>
                <tr><td>Codigo</td><td><%= entry.getCode() %></td></tr>
            </table>
            </br>
        </div>
        <% }
        }else{
            
        }
        %>
    </body>
</html>
