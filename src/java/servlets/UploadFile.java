/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author mfontana
 */
public class UploadFile extends HttpServlet {
    
     public static final String STATUS_OK = "fileOK";

    // Doc oficial: https://commons.apache.org/proper/commons-fileupload/using.html
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
            throws ServletException, IOException, Exception {
        int maxFileSize = 1000 * 1024;
        int maxMemSize = 1000 * 1024;

        String contentType = request.getContentType();
        // comprobamos que el request tiene un file subido.
        if ((contentType.contains("multipart/form-data"))) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Establecemos la memoria máxima que le permitimos utilizar
            factory.setSizeThreshold(maxMemSize);
            // Establece la ubicación temporal para almacenar archivos
            factory.setRepository(new File("."));
            ServletFileUpload upload = new ServletFileUpload(factory);
            // Establece el tamaño máximo del fichero que se sube
            upload.setSizeMax(maxFileSize);
            // construye la ruta del directorio para almacenar el archivo de carga
            // esta ruta es relativa al directorio de la aplicación
            String path = getServletContext().getRealPath("") + File.separator + "Files";
            System.out.println();
            // Crea el directorio si no existe
            File uploadDir = new File(path);
            
            try {
                // analiza el contenido de la solicitud para extraer datos de archivo
                List<FileItem> formItems = upload.parseRequest(request);
                if (formItems != null && formItems.size() > 0) {
                    // Recorremos los items del form
                    for (FileItem item : formItems) {
                        // processes only fields that are not form fields
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            String filePath = path + File.separator + fileName;
                            File storeFile = new File(filePath);

                            // guardamos el fichero en el disco
                            item.write(storeFile);
                            request.setAttribute("status", STATUS_OK);
                        }
                    }
                }
                request.getRequestDispatcher("/libreria.jsp").forward(request, response);
            } catch (FileUploadException ex) {
                Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
         }
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
         try {
             processRequest(request, response);
         } catch (Exception ex) {
             Logger.getLogger(UploadFile.class.getName()).log(Level.SEVERE, null, ex);
         }
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
