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
                boolean dis = false;
                User usu = (User) request.getAttribute("usuCompleto");
                List <Follow> follow = (List<Follow>) request.getAttribute("follow");
                List <Follow> followed = (List<Follow>) request.getAttribute("followed");
                List <Entry> entry = (List<Entry>) request.getAttribute("entry");
                if (user != null && usu != null){
                    %>
                    
                    <p>Bienvenido <%=user%></p>
                    <%
                    if(!user.equals(usu.getNameUsu())){
                        for(Follow f1 : followed){
                            if(f1.getUser().getNameUsu().equals(user)){
                                dis = true;
                                %>
                                <form action="Follows" method="POST"><input type="hidden" name="usuarioD" value="<%=usu.getNameUsu()%>">
                                    <input type="hidden" name="usuarioUF" value="<%=user%>"><input type="submit" value="Unfollow" name="Unfollow"></form>
                                <%
                            }
                        }
                         if (!dis){
                         %>
                            <form action="Follows" method="POST"><input type="hidden" name="usuarioD" value="<%=usu.getNameUsu()%>">
                            <input type="hidden" name="usuarioUF" value="<%=user%>"><input type="submit" value="Follow" name="Follow"></form>
                            <%
                        }   
                    }
            %>
            
            <form action="Inicio" method="POST"><input type="hidden" name="usu" value="<%=user%>"><input type="submit" value="Inicio"></form>
            <form action="AllUsers" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="All users"></form>
            <form action="Perfil" method="POST"><input type="hidden" name="user" value="<%=user%>"><input type="submit" value="Perfil"></form>
            <form action="libreria.jsp" method="POST"><input type="submit" value="Subir codigos"></form>
            <form action="AllCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="All codes"></form>
            <form action="LikeCodes" method="POST"><input type="hidden" name="user" value="<%=user %>"><input type="submit" value="Codigos que me gustan"></form>
                <form action="logOut" method="POST"><input type="submit" value="Log Out"></form>
                <h1>Siguiendo</h1>
                <% 
                if(!follow.isEmpty()){
                    for(Follow f : follow){
                    %>
                        <form action="Profiles" method="POST">
                            <input type="hidden" name="usu" value="<%=user%>">
                            <input type="hidden" name="otroUsuario" value="<%=f.getUser1().getNameUsu()%>">
                            <input type="submit" name="<%=f.getUser1().getNameUsu()%>" value="<%=f.getUser1().getNameUsu()%>">
                        </form>
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
                  <form action="Profiles" method="POST"><input type="hidden" name="usu" value="<%=user%>"><input type="submit" name="otroUsuario" value="<%=f2.getUser().getNameUsu()%>"></form>
                <%
                    }
                  }else{
                  %>
                  <p>No te sigue nadie.</p>
                  <%
                  }
                %>
                <h1>Codigos</h1>
                <%
                  if(!user.equals(usu.getNameUsu())){
                      List<Entry> entries = (List<Entry>) request.getAttribute("entryUser");                   
                      if(!entries.isEmpty()){
                          for(Entry en: entries){
                              %>
                              <form action="codeProfile" method="POST"><input type="hidden" name="id" value="<%=en.getId()%>"><input type="submit" name="unaEntry" value="<%=en.getTitle()%>"</form>
                              <p><%=en.getLanguage()%></p>
                              <p><%=en.getCode()%></p>
                            <%
                          }
                      }else{
                          %>
                          <p>No hay codigos.</p>
                        <%
                      }

                  }else{  
                    if(!entry.isEmpty()){
                       for(Entry e : entry){
                       %>
                       <form action="codeProfile" method="POST"><input type="hidden" name="id" value="<%=e.getId()%>"><input type="submit" name="unaEntry" value="<%=e.getTitle()%>"></form>
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
            }  else{
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
