/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.WikiSession;
import entities.Follow;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dam
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {
@EJB WikiSession ejb;

public static final String STATUS_ERROR = "Usuario o contraseña erronea.";
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
            if("Login".equals(request.getParameter("Login"))){
                String nombre = request.getParameter("usu");
                String pass = request.getParameter("pass");
                User user = new User(nombre);
                user.setPass(pass);
            if(ejb.validarUser(user) != null){
                user = ejb.obtenerUser(nombre);
                List <Follow> follow = (List) ejb.follow(user);
                request.getSession(true).setAttribute("user", nombre);
                request.setAttribute("usuCompleto", user);
                request.setAttribute("follow", follow);
                request.setAttribute("followed", ejb.followed(user));
                request.setAttribute("entry", ejb.entryOfFollow(follow));
                request.getRequestDispatcher("/inicio.jsp").forward(request, response);
                
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
