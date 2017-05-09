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
        
        <form action="inicio.jsp"><input type="submit" value="Inicio"></form>
        <% 
        Collection<Entry>codes = (Collection<Entry>) request.getAttribute("entries");
        if (codes.isEmpty() == false){
        for (Entry entry : codes) {
            %>
        <div class="code">
        <%= entry.getLanguage() %>
        <%= entry.getTitle() %>
        <%= entry.getCode() %>
        </div>
        <% }
        }else{
            
        }
        %>
    </body>
</html>
