/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import bean.WikiSession;
import entities.Entry;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.Registro.STATUS_ERROR;
import static servlets.Registro.STATUS_OK;

/**
 *
 * @author dam
 */
@WebServlet(name = "UploadCode", urlPatterns = {"/UploadCode"})
public class UploadCode extends HttpServlet {
@EJB WikiSession ejb;
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
           String code = request.getParameter("Code");
           Entry entry = new Entry();
           entry.setCode(code);
           String nombre = request.getParameter("user");
           User usuario = ejb.obtenerUser(nombre);
           entry.setUsu(usuario);
           entry.setTitle(request.getParameter("Title"));            
           entry.setLanguage(request.getParameter("Lenguage"));
           System.out.println(entry);
           if(ejb.insertCode(entry)){
               System.out.println("funca");
               request.setAttribute("status", STATUS_OK);
               request.getSession(true).setAttribute("user", nombre);
               request.setAttribute("usuCompleto", usuario);
               request.setAttribute("follow", ejb.follow(usuario));
                request.setAttribute("followed", ejb.followed(usuario));
                request.setAttribute("entry", ejb.entryOfFollow(usuario));
               request.getRequestDispatcher("/inicio.jsp").forward(request, response);
           }else{
              request.setAttribute("status", STATUS_ERROR);
              request.getRequestDispatcher("/error.jsp").forward(request, response);
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
