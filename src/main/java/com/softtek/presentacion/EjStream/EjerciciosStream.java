package com.softtek.presentacion.EjStream;

import com.softtek.modelo.EjStream.OrderDetail;
import com.softtek.persistencia.EjStream.Conexion;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.softtek.persistencia.EjStream.AcessoOrdenes.obtenerDetalles;

public class EjerciciosStream  extends Conexion{
        public static void main(String[] args) {
            List<OrderDetail> orderDetails = new ArrayList<>();
            Conexion conexion = new Conexion();

            try {
                conexion.abrirConexion();
                orderDetails = obtenerDetalles(conexion.getMiConexion());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarConexion();
            }

            // a. Obtener los detalles de órdenes cuyo precio unitario sea mayor que 30.
            List<OrderDetail> expensiveOrders = orderDetails.stream()
                    .filter(od -> od.getUnitPrice() > 30)
                    .collect(Collectors.toList());

            // b. Ordenar los productos de forma descendente por unit_price.
            List<OrderDetail> sortedOrders = orderDetails.stream()
                    .sorted(Comparator.comparingDouble(OrderDetail::getUnitPrice).reversed())
                    .collect(Collectors.toList());

            // c. Obtener el detalle de órdenes cuyo precio es el mínimo.
            OrderDetail minPricedOrder = orderDetails.stream()
                    .min(Comparator.comparingDouble(OrderDetail::getUnitPrice))
                    .orElse(null);

            // d. Obtener las estadísticas de detalle de órdenes sobre el atributo quantity.
            IntSummaryStatistics quantityStats = orderDetails.stream()
                    .mapToInt(OrderDetail::getQuantity)
                    .summaryStatistics();

            // e. Obtener los productos y la suma de sus cantidades.
            Map<Integer, Integer> productQuantitySum = orderDetails.stream()
                    .collect(Collectors.groupingBy(OrderDetail::getProductId,
                            Collectors.summingInt(OrderDetail::getQuantity)));

            System.out.println("Ordenes con precio unitario > 30: " + expensiveOrders);
            System.out.println("Ordenes ordenadas por precio unitario descendente: " + sortedOrders);
            System.out.println("Orden con el precio mínimo: " + minPricedOrder);
            System.out.println("Estadísticas de cantidad: " + quantityStats);
            System.out.println("Suma de cantidades por producto: " + productQuantitySum);

        }

    }



