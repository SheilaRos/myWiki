<%-- 
    Document   : AllCodes
    Created on : 14-may-2017, 19:33:00
    Author     : Gulir
--%>
<%@page import="java.util.Collection"%>
<%@page import="entities.Entry"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Codes</title>
    </head>
    <body>
        <h1>All Codes</h1>        
        <% 
        Collection<Entry>codes = (Collection<Entry>) request.getAttribute("entries");
        if (codes.isEmpty() == false){
        for (Entry entry : codes) {
            %>
        <div class="code">
            <table border="1">
                <tr><td>Lenguage</td><td><%= entry.getLanguage() %></td></tr>
                <tr><td>Autor</td><td><form action="Profiles" method="POST"><input type="submit" name="otroUsuario" value="<%= entry.getUsu() %>"/></form></td></tr>
                <tr><td>Titulo</td><td><form action="ShowCode" method="POST"><input type="hidden" name="id" value="<%= entry.getId() %>" /><input type="submit" value="<%= entry.getTitle() %>"/></form></td></tr>
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
