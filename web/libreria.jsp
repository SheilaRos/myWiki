<%-- 
    Document   : libreria
    Created on : 28-mar-2017, 17:33:44
    Author     : dam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WikiCode</title>
    </head>
    <body>
            <%
               String user = (String) session.getAttribute("user");
               if( user != null){
            %> 
             <form action="Inicio" method="POST"><input type="hidden" name="usu" value="<%=user%>"><input type="submit" value="Inicio"></form>
            <form action="AllUsers" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="All users"></form>
            <form action="Perfil" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="Perfil"></form>
            <form action="libreria.jsp" method="POST"><input type="submit" value="Subir codigos"></form>
            <form action="AllCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="All codes"></form>
            <form action="LikeCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Codigos que me gustan"></form>
            <form action="logOut" method="POST"><input type="submit" value="Log Out"></form>
            
        <h1>Mis codigos</h1>
        <form method="post" action="UploadFile" enctype="multipart/form-data">
            Sube un archivo con tu codigo!</br></br>
            <input type="file" name="Archivo" />
            <input type="submit" value="Subir" />   
        </form></br>
        <form method="POST" action="UploadCode">
            O pega directamente aquí tu codigo!</br></br>
            Titulo:  <input type="text" required name="Title" /></br></br>
            Lenguage:   <input type="text" required name="Lenguage" /></br></br>
            Codigo: </br>
            <textarea cols="60" rows="30" name="Code" required></textarea></br></br>
            <input type="hidden" name="user" value="<%=user %>" />
            <input type="submit" value="Subir" />
        </form>
            <%
            }else{
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }    
            %>
    </body>
</html>
