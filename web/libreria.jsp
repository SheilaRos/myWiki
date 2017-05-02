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
        <h1>Mis codigos</h1>
        <form method="post" action="UploadFile" enctype="multipart/form-data">
            Sube un archivo con tu codigo!</br></br>
            <input type="file" name="Archivo" />
            <input type="submit" value="Subir" />   
        </form></br>
        <form method="POST" action="UploadCode">
            O pega directamente aquí tu codigo!</br></br>
            <textarea cols="60" rows="30"></textarea></br></br>
            <input type="submit" value="Subir" />
        </form>
        
    </body>
</html>
