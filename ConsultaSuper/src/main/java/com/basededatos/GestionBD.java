package com.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBD {
    private Connection conexion;

    public GestionBD() throws SQLException {
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Asegúrate de usar el nombre correcto del driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el driver JDBC de MySQL", e);
        }

        String url = "jdbc:mysql://localhost:3306/supermercado"; // Cambia por tu configuración
        String user = "root"; // Cambia por tu usuario
        String password = "curso"; // Cambia por tu contraseña
        conexion = DriverManager.getConnection(url, user, password);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
