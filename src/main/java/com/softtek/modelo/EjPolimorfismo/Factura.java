package com.softtek.modelo.EjPolimorfismo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Factura {
    private Impuesto impuesto;
    private List<Producto> productos;

    public double calcularTotalFactura() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio() + impuesto.calcularImpuesto(p);
        }
        return total;
    }


}
