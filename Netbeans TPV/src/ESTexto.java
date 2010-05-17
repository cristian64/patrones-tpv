/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class ESTexto implements EntradaSalida {

	public void LeerCatalogo(CatalogoProducto catalogo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void LeerCatalogoIVA(CatalogoProducto catalogo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void LeerReglasPrecios(TiposCliente tiposCliente) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void LeerDescuentoVolumen(CatalogoProducto catalogo) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void LeerVenta(Venta venta) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void EscribirVenta(Venta venta)
	{
		String salida = "";
		for (LineaVenta i : venta.getLineasVenta())
		{
			salida += i.getProducto().getDescripcion() + " " + i.getCantidad() + " " + i.getProducto().getPrecio() + "E " + i.getPrecioLinea() + "E\n";
		}
		salida += "Total: " + venta.getPrecioTotal();
		salida += "Dcto:" + (venta.getPrecioTotal() - venta.getPrecioFinal()) + "E";
		salida += "Precio final: " + venta.getPrecioFinal() + "E";
		salida += "Impuestos: " + (venta.getPrecioFinal() - venta.getPrecioNeto()) + "E";

		System.out.println(salida);
	}
}
