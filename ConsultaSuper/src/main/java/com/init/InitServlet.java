package com.init;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.sql.SQLException;

import com.basededatos.GestionBD;

public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            GestionBD gestionBD = new GestionBD();
            ServletContext contexto = getServletContext();
            contexto.setAttribute("dbConexion", gestionBD.getConexion());
        } catch (SQLException e) {
            throw new ServletException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void destroy() {
        try {
            GestionBD gestionBD = new GestionBD();
            gestionBD.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
