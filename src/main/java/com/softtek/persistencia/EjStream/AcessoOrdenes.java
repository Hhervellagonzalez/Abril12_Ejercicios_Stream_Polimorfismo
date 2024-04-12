package com.softtek.persistencia.EjStream;

import com.softtek.modelo.EjStream.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcessoOrdenes {
    public static List<OrderDetail> obtenerDetalles(Connection conexion) {
        List<OrderDetail> pedidos = new ArrayList<>();
        String query = "SELECT order_id, product_id, unit_price, quantity, discount FROM order_details";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                int productId = rs.getInt("product_id");
                double unitPrice = rs.getDouble("unit_price");
                int quantity = rs.getInt("quantity");
                double discount = rs.getDouble("discount");
                pedidos.add(new OrderDetail(orderId, productId, unitPrice, quantity, discount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}
