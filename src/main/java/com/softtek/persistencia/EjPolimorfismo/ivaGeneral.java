package com.softtek.persistencia.EjPolimorfismo;

import com.softtek.modelo.EjPolimorfismo.Impuesto;
import com.softtek.modelo.EjPolimorfismo.Producto;

public class ivaGeneral implements Impuesto {
    public double calcularImpuesto(Producto p1) {
        return p1.getPrecio() * 0.21;
    }
}
