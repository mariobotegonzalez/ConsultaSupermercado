package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletContext;

public class ListadoVentasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        Connection conexion = (Connection) contexto.getAttribute("dbConexion");

        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM pedido");
            
            request.setAttribute("ventas", rs);
            request.getRequestDispatcher("/listadoVentas.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error al obtener listado de ventas", e);
        }
    }
}
