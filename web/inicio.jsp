 <%@page import="entities.Entry"%>
<%@page import="java.util.List"%>
<%@page import="entities.Follow"%>
<%@page import="java.util.Collection"%>
<%-- 
    Document   : perfil
    Created on : 27-mar-2017, 19:13:47
    Author     : dam
--%>

<%@page import="entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Wiki</title>
    </head>
    <body>
        <h1>My Wiki</h1>
        <div>
            <div>
            <%
                String user = (String) session.getAttribute("user");
                User usu = (User) request.getAttribute("usuCompleto");
                List <Follow> follow = (List<Follow>) request.getAttribute("follow");
                List <Follow> followed = (List<Follow>) request.getAttribute("followed");
                List <Entry> entry = (List<Entry>) request.getAttribute("entry");
                if (user != null && usu != null){
            %>
            
                <form action="inicio.jsp"><input type="submit" value="Inicio"></form>
                <form action="new.jsp"><input type="submit" value="Nueva entrada"></form>
                <form action="Perfil"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Perfil"></form>
                <form action="libreria.jsp"><input type="submit" value="Mis codigos"></form>
                <form action="likeCode.jsp"><input type="submit" value="Codigos que me gustan"></form>
                <form action="logOut"><input type="submit" value="Log Out"></form>
                <h1>Siguiendo</h1>
                <% 
                if(!follow.isEmpty()){
                    for(Follow f : follow){
                    %>
                        <form action="Profiles" method="GET"><input type="submit" name="otroUsuario" value="<%=f.getUser1()%>"></form>
                    <%
                    }
                }else{
                %>
                 <p>No sigues a nadie todavia.</p>
                <%    
               }
                %>
                <h1>Seguidores</h1>
                 <%
                 if(!followed.isEmpty()){
                    for(Follow f2 : followed){
                  %>
                 <form action="Profiles" method="GET"><input type="submit" name="otroUsuario" value="<%=f2.getUser1()%>"></form>
                <%
                    }
                  }else{
                  %>
                  <p>No te sigue nadie.</p>
                  <%
                  }
                %>
                <h1>Novedades</h1>
                <%
                 if(!entry.isEmpty()){
                    for(Entry e : entry){
                    %>
                    <form action="Entry" method="POST"><input type="submit" name="unaEntry" value="<%=e.getTitle()%>"></form>
                    <p><%=e.getLanguage()%></p>
                    <p><%=e.getCode()%></p>
                    <%  
                    }  
                 }else{
                 %>
                   <p>No hay novedades.</p> 
                 <%
                }
            }
            else{
                   request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
             %>    
            </div>
            <div>

            </div>
        </div>
        <div>
            
        </div>
    </body>
</html>
