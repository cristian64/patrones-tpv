/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class DescuentoCliente implements Descuento {

    public double calcularDescuento(Venta venta) {
        double acumulado = 0.0;

        int porcentaje = venta.getTipoCliente().getDescuento();

        for(LineaVenta linea : venta.getLineasVenta())
        {
            double precioLinea = linea.getCantidad()*linea.getProducto().getPrecio();
            acumulado += (precioLinea*porcentaje)/100.0;
        }

        return acumulado;
    }

}
