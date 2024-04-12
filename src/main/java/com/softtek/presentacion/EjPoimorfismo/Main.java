package com.softtek.presentacion.EjPoimorfismo;
import com.softtek.modelo.EjPolimorfismo.Factura;
import com.softtek.modelo.EjPolimorfismo.Producto;
import com.softtek.persistencia.EjPolimorfismo.ivaGeneral;
import com.softtek.persistencia.EjPolimorfismo.ivaSuperReducido;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("Manzana", 0.50);
        Producto p2 = new Producto("Plantano", 0.60);

        Factura facturaGeneral = new Factura(new ivaGeneral(), Arrays.asList(p1, p2));
        System.out.println("Factura IVA General: " + facturaGeneral.calcularTotalFactura());

        Factura facturaReducida = new Factura(new ivaSuperReducido(), Arrays.asList(p1, p2));
        System.out.println("Factura IVA Reducido: " + facturaReducida.calcularTotalFactura());
    }
}

