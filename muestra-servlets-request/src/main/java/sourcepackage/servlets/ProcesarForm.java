/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package sourcepackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 *
 * @author Fer
 */
@WebServlet(name="ProcesarForm", urlPatterns={"/procesar-form"})
public class ProcesarForm extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesarForm</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesarForm para ver una petición de un form at " + request.getContextPath () + "</h1>");
            out.print("<p>Observá la información recibida en el objeto 'request' de tipo 'HttpServletRequest' </p>");
            
            prtlnClaveValor(out, "getProtocol", request.getProtocol());
            prtlnClaveValor(out, "getMethod", request.getMethod());
            out.print("<hr>");
            prtlnClaveValor(out, "getLocalAddr", request.getLocalAddr());
            prtlnClaveValor(out, "getLocalName", request.getLocalName());
            prtlnClaveValor(out, "getLocalPort", request.getLocalPort());            
            out.print("<hr>");
            
            out.print("<strong>getServerName</strong>: " + request.getServerName());
            out.print("<br>");
            out.print("<strong>getServerPort</strong>: " + request.getServerPort());

            out.print("<hr>");
            
            out.print("<strong>getRequestURL</strong>: " + request.getRequestURL());
            out.print("<br>");
            out.print("<strong>getRequestURI</strong>: " + request.getRequestURI());
            out.print("<br>");
            out.print("<strong>getContextPath</strong>: " + request.getContextPath());             
            out.print("<br>");
            out.print("<strong>getServletPath</strong>: " + request.getServletPath());
            out.print("<br>");
            out.print("<strong>getPathInfo</strong>: " + request.getPathInfo()); 
            out.print("<br>");
            out.print("<strong>getQueryString:</strong> " + request.getQueryString());
            
            out.print("<h2>Parámetros</h2>");
            Enumeration params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String nombreDelParametro = (String) params.nextElement();
                out.print("<strong>" + nombreDelParametro + "</strong>: ");
                out.print(request.getParameter(nombreDelParametro));
                out.print("<br>");
            }
            
            out.print("<h2>Headers HTTP</h2>");
            Enumeration cabeceros = request.getHeaderNames();
            while (cabeceros.hasMoreElements()) {
                String nombreDelHeader = (String) cabeceros.nextElement();
                out.print("<strong>" + nombreDelHeader + "</strong>: ");
                out.print(request.getHeader(nombreDelHeader));
                out.print("<br>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void prtClaveValor(PrintWriter out, String clave, int valor) {
        prtClaveValor(out, clave, String.valueOf(valor));    
    }

    private void prtClaveValor(PrintWriter out, String clave, String valor) {
        out.print(getHTMLClaveValor(clave, valor));    
    }
    
    private void prtlnClaveValor(PrintWriter out, String clave, int valor) {
        prtlnClaveValor(out, clave, String.valueOf(valor));    
    }

    private void prtlnClaveValor(PrintWriter out, String clave, String valor) {
        out.print(getHTMLClaveValor(clave, valor) + "<br>");    
    }
    
    private String getHTMLClaveValor(String clave, String valor) {
        return "<strong>" + clave + "</strong>: " + valor; 
    }
}
