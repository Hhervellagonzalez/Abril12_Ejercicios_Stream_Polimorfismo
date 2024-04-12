package com.softtek.persistencia.EjStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection miConexion;

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        // Asumiendo que estás usando PostgreSQL
        Class.forName("org.postgresql.Driver");
        miConexion = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/northwind",
                "postgres",
                "1234"
        );
        System.out.println("Éxito al abrir la conexión");
    }

    public void cerrarConexion() {
        if (miConexion != null) {
            try {
                miConexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
                e.printStackTrace();
            }
        }
    }

    public Connection getMiConexion() {
        return miConexion;
    }
}
