package com.softtek.modelo.EjStream;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetail {
    private int orderId;
    private int productId;
    private double unitPrice;
    private int quantity;
    private double discount;
}
