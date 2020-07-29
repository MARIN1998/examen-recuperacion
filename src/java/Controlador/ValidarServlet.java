/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ValidarPromocion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class ValidarServlet extends HttpServlet {

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
     
        String destino;
        Integer cantidad = 0; //Inicializar
        Double descuento = 0.0; //Declarar
        //Object objeto = null;

        String producto = request.getParameter("caja1");
        String caja2 = request.getParameter("caja2");

        if (!caja2.isEmpty()) {
            cantidad = Integer.parseInt(request.getParameter("caja2")); //parse
        }

        String codigo = request.getParameter("caja3");

        if (producto.isEmpty() || cantidad == 0) {
            destino = "principal.jsp";
        } else {
            destino = "respuesta.jsp";
        }

        //Instanciamos el dao
        ValidarPromocion dao= new ValidarPromocion();
        Boolean respuesta = dao.buscarCodigo(codigo);

        Integer precio = dao.obtenerPrecio(producto);

        if (precio == 0) {

            destino = "principal.jsp";

        }
        Integer total = precio * cantidad;

        if (respuesta) {
            switch (codigo) {
                case "examen":
                    descuento = 0.4 * total;
                    break;
                case "recuperacion":
                    descuento = 0.75 * total;
                    break;
                case "pandemia":
                    descuento = 0.95 * total;
                    break;
            }
        } else {
            descuento = 0.0;
        }

      
        request.setAttribute("totalapagarjsp", total - descuento);

        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
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
