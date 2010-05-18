/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class ImpuestoPorProducto implements AlgoritmoImpuestos {

    public double calcularImpuestos(Venta venta) {
        double impuesto = 0;

		for(LineaVenta linea : venta.getLineasVenta())
		{
			Producto p = linea.getProducto();
			double total = linea.getPrecioLinea();// p.getPrecio() * linea.getCantidad();
			impuesto += (total - (total / ((100+p.getImpuesto())/100)));
		}

		return impuesto;
    }

}
