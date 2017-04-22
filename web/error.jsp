<%-- 
    Document   : error
    Created on : 04-abr-2017, 18:12:41
    Author     : dam
--%>
<%@page import='servlets.Registro'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
          if (status.equals(Registro.STATUS_ERROR)) { %>
        <p>Register already exists.</p>
        <% } %>
        <a href="index.jsp">Return</a>
    </body>
</html>
