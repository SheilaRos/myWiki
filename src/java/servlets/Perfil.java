/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.WikiSession;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.Validar.STATUS_ERROR;

/**
 *
 * @author dam
 */
@WebServlet(name = "Perfil", urlPatterns = {"/Perfil"})
public class Perfil extends HttpServlet {
@EJB WikiSession ejb;
    public static final String STATUS_ERROR = "Error al obtener los datos del usuario.";
    public static final String STATUS_ERROR2 = "Error al modificar los datos.";
    public static final String STATUS_ERROR3 = "Error al modificar la contraseña.";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            if("Modificar".equals(request.getParameter("Modificar"))){
                String nombreReal = (String) request.getAttribute("name");
                String email = (String) request.getAttribute("email");
                String ciudad = (String) request.getAttribute("ciudad");
                String bio = (String) request.getAttribute("bio");
                String nameUsu = (String) request.getAttribute("nombreUsu");
                User usu = ejb.obtenerUser(nameUsu);
                usu.setBio(bio);
                usu.setName(nombreReal);
                usu.setEmail(email);
                usu.setLocation(ciudad);
                if(ejb.modificarUsuario(usu)){
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                }else{
                    request.setAttribute("status", STATUS_ERROR);
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
                
            }else if("ModificarPass".equals(request.getParameter("ModificarPass"))){
               String old = (String) request.getAttribute("passOld");
               String usuario = (String) request.getAttribute("nombreUsu");
               String newP = (String) request.getAttribute("passNew");
               String confirm = (String) request.getAttribute("passConfirm");
               User usu = new User ();
               usu.setNameUsu(usuario);
               usu.setPass(old);
               if(ejb.validarUser(usu) != null){
                   if(newP.equals(confirm)){
                    usu = ejb.obtenerUser(usuario);
                    usu.setPass(newP);
                    if(ejb.modificarUsuario(usu)){
                        request.setAttribute("usuario", usuario);
                        request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                    }else{
                       request.setAttribute("status", STATUS_ERROR);
                       request.getRequestDispatcher("/error.jsp").forward(request, response); 
                    }
                   }
               }else{
                   request.setAttribute("status", STATUS_ERROR);
                   request.getRequestDispatcher("/error.jsp").forward(request, response);
               }
            }else{
                String nombre = request.getParameter("user");
                User usuario = ejb.obtenerUser(nombre);
                if(usuario != null){
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("/perfil.jsp").forward(request, response);
                }else{
                    request.setAttribute("status", STATUS_ERROR);
                    
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
